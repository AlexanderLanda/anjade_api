package com.anjade.controller;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anjade.entity.DsOrderIdAfiliacionDto;
import com.anjade.repository.DsOrderIdAfiliacionRepository;
import com.anjade.service.DsOrderIdAfiliacionService;

@RestController
@RequestMapping("/api/v1/payments/")
public class RedsysController {
	
	@Autowired
	private DsOrderIdAfiliacionRepository repository;
	
	@Autowired
	private DsOrderIdAfiliacionService dsOrderIdAfiliacionService;
	
	@Value("${frontend.url}") // Inyecta el valor de frontend.url
    private String frontendUrl;
	
	@Value("${MERCHANT_SECRET_KEY}")
	private  String MERCHANT_SECRET_KEY;

	@Value("${REDSYS_URL}")
	private  String REDSYS_URL;
	
	@Value("${Ds_Merchant_UrlOK}")
	private  String Ds_Merchant_UrlOK;

	@Value("${Ds_Merchant_UrlKO}")
	private  String Ds_Merchant_UrlKO;
	
	@Value("${Ds_Merchant_MerchantURL}")
	private  String Ds_Merchant_MerchantURL;
	

	private static final String MERCHANT_CODE = "363273228"; // Código del comercio de pruebas
    private static final String TERMINAL = "1"; // Número de terminal de pruebas
    private static final String CURRENCY = "978"; // EUR
    private static final String TRANSACTION_TYPE = "0"; // Tipo de transacción por defecto
    private static final int BIZUM = 2; // Tipo de transacción por defecto

    @PostMapping("/create-payment")
    public Map<String, String> createPayment(@RequestParam("tipoPago") int tipoPago,@RequestParam("idAfiliacion") String idAfiliacion) throws Exception {
    	// Crear un formato para la fecha y hora actual
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

        // Obtener la fecha y hora actual como una cadena
        String timestamp = LocalDateTime.now().format(formatter);
        
        String order =dsOrderIdAfiliacionService.generateNextDsOrder();
        String amount = "2500"; // Monto en céntimos (10 euros)
        
        DsOrderIdAfiliacionDto dsOrderIDafiliado;
        Optional<DsOrderIdAfiliacionDto> ds_order = repository.findByIdAfiliacion(idAfiliacion);
		 if (ds_order.isPresent()) {
			 dsOrderIDafiliado= ds_order.get();
			 dsOrderIDafiliado.setDs_order(order);
			 dsOrderIDafiliado.setFecha_de_pago(new Date() );
		 }
		 else {
			 dsOrderIDafiliado = new DsOrderIdAfiliacionDto(idAfiliacion,order,"0",new Date() );
		 }
         
		 dsOrderIDafiliado= dsOrderIdAfiliacionService.saveOrUpdate(dsOrderIDafiliado);
        
        System.out.println(order);
        Map<String, String> params = new HashMap<>();
        params.put("Ds_Merchant_Amount", amount);
        params.put("Ds_Merchant_Order", order);
        params.put("Ds_Merchant_MerchantCode", MERCHANT_CODE);
        params.put("Ds_Merchant_Currency", CURRENCY);
        params.put("Ds_Merchant_TransactionType", TRANSACTION_TYPE);
        params.put("Ds_Merchant_Terminal", TERMINAL);
        params.put("Ds_Merchant_MerchantURL", Ds_Merchant_MerchantURL);
        params.put("Ds_Merchant_UrlOK", Ds_Merchant_UrlOK);
        params.put("Ds_Merchant_UrlKO",  Ds_Merchant_UrlKO);
        if (tipoPago==BIZUM) {
        	params.put("Ds_Merchant_PayMethods",  "z");
		}
        

        String paramsJson = Base64.getEncoder().encodeToString(new com.fasterxml.jackson.databind.ObjectMapper().writeValueAsBytes(params));
        System.out.println("paramsJson:"+paramsJson);
        String signature = createSignature(order, paramsJson);

        Map<String, String> response = new HashMap<>();
        response.put("Ds_SignatureVersion", "HMAC_SHA256_V1");
        response.put("Ds_MerchantParameters", paramsJson);
        response.put("Ds_Signature", signature);
        response.put("RedsysUrl", REDSYS_URL);
        System.out.println("params: "+params);
        System.out.println("response: "+response);

        return response;
    }

    private String createSignature(String order, String data) throws Exception {
        // Decodifica la clave secreta
        byte[] keyBytes = Base64.getDecoder().decode(MERCHANT_SECRET_KEY);//MERCHANT_SECRET_KEY_TEST  MERCHANT_SECRET_KEY
        
        // Asegura que el número de pedido tiene una longitud múltiplo de 8 bytes
        byte[] orderBytes = padOrder(order.getBytes(StandardCharsets.UTF_8), 8);

        // Diversifica la clave con 3DES
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, 0, 24, "DESede");
        Cipher cipher = Cipher.getInstance("DESede/ECB/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] diversifiedKey = cipher.doFinal(orderBytes);

        // Calcula el HMAC-SHA256
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(diversifiedKey, "HmacSHA256"));
        byte[] rawHmac = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));

        // Codifica el resultado en Base64
        return Base64.getEncoder().encodeToString(rawHmac);
    }

    private byte[] padOrder(byte[] orderBytes, int blockSize) {
        int paddedSize = ((orderBytes.length + blockSize - 1) / blockSize) * blockSize;
        byte[] paddedOrder = new byte[paddedSize];
        System.arraycopy(orderBytes, 0, paddedOrder, 0, orderBytes.length);
        return paddedOrder;
    }
 }

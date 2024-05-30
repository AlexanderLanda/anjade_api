package com.anjade.controller;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "${frontend.url}")
public class RedsysController {
	
	@Value("${frontend.url}") // Inyecta el valor de frontend.url
    private String frontendUrl;
	
	private static final String MERCHANT_CODE = "363273228"; // Código del comercio de pruebas
    private static final String TERMINAL = "1"; // Número de terminal de pruebas
    private static final String CURRENCY = "978"; // EUR
    private static final String TRANSACTION_TYPE = "0"; // Tipo de transacción por defecto
    private static final String MERCHANT_SECRET_KEY = "sq7HjrUOBfKmC576ILgskD5srU870gJ7"; // Clave del comercio de pruebas, Base64
    private static final String REDSYS_URL = "https://sis-t.redsys.es:25443/sis/realizarPago";
    private static final int BIZUM = 2; // Tipo de transacción por defecto

    @PostMapping("/create-payment")
    public Map<String, String> createPayment(@RequestParam("tipoPago") int tipoPago) throws Exception {
    	// Crear un formato para la fecha y hora actual
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

        // Obtener la fecha y hora actual como una cadena
        String timestamp = LocalDateTime.now().format(formatter);

        String order = "AF"+timestamp.substring(timestamp.length()-6, timestamp.length()); // ID único del pedido
        String amount = "1000"; // Monto en céntimos (10 euros)

        System.out.println("OR_" +order);
        Map<String, String> params = new HashMap<>();
        params.put("Ds_Merchant_Amount", amount);
        params.put("Ds_Merchant_Order", order);
        params.put("Ds_Merchant_MerchantCode", MERCHANT_CODE);
        params.put("Ds_Merchant_Currency", CURRENCY);
        params.put("Ds_Merchant_TransactionType", TRANSACTION_TYPE);
        params.put("Ds_Merchant_Terminal", TERMINAL);
        params.put("Ds_Merchant_MerchantURL", "http://localhost:8080/api/payment/response");
        params.put("Ds_Merchant_UrlOK", "http://localhost:4200/success");
        params.put("Ds_Merchant_UrlKO",  "http://localhost:4200/failure");
        if (tipoPago==BIZUM) {
        	params.put("Ds_Merchant_PayMethods",  "z");
		}
        

        String paramsJson = Base64.getEncoder().encodeToString(new com.fasterxml.jackson.databind.ObjectMapper().writeValueAsBytes(params));
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
        byte[] keyBytes = Base64.getDecoder().decode(MERCHANT_SECRET_KEY);
        
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

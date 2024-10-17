package com.anjade.serviceImpl;

import java.io.UnsupportedEncodingException;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anjade.entity.DsMerchantParametersDto;
import com.anjade.entity.DsOrderIdAfiliacionDto;
import com.anjade.entity.EstadosUsuariosDto;
import com.anjade.entity.UsuariosDto;
import com.anjade.redsys.ApiMacSha256;
import com.anjade.repository.DsOrderIdAfiliacionRepository;
import com.anjade.repository.UsuariosRepository;
import com.anjade.service.DsOrderIdAfiliacionService;
import com.anjade.service.EmailService;
import com.anjade.service.RedsysResponseNotification;
import com.anjade.service.UsuariosService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class RedsysResponseNotificationImpl implements RedsysResponseNotification {

	public static final String RESPUESTA_PAGO_APROBADO = "0000";
	public static final String PAGO_APROBADO = "pendiente de revision";
	public static final Long PAGO_APROBADO_ID = 4L;
	public static final String PAGO_RECHAZADO = "pago rechazado";
	public static final Long PAGO_RECHAZADO_ID = 5L;
	
	@Autowired
	private DsOrderIdAfiliacionRepository repository;
	
	@Autowired
	private DsOrderIdAfiliacionService dsOrderIdAfiliacionService;
	
	@Autowired
	private final UsuariosService usuariosService;
	
	@Autowired
    private EmailService emailService;
	
	@Autowired
	private UsuariosRepository userRepository;
	
	public RedsysResponseNotificationImpl(UsuariosService usuariosService) {
		this.usuariosService = usuariosService;
	}
	
	@Override
	public void readNotificatinoRedsysResponse(String response) throws JsonMappingException, JsonProcessingException {

		ObjectMapper objectMapper = new ObjectMapper();
		DsMerchantParametersDto merchantParams = objectMapper.readValue(response, DsMerchantParametersDto.class);

		System.out.println("DsMerchantParametersDto: " + merchantParams);
		String codigoRespuesta = merchantParams.getDs_Response();
		String ds_order = merchantParams.getDs_Order();
		DsOrderIdAfiliacionDto orderAfiliacion = repository.findByDsOrder(ds_order);
		orderAfiliacion.setCod_response_redsys(codigoRespuesta);
		orderAfiliacion.setFecha_de_pago(new Date());
		orderAfiliacion= dsOrderIdAfiliacionService.saveOrUpdate(orderAfiliacion);
		//Restaurar id afiliacion y borrar seteo de email
		UsuariosDto user = userRepository.findByIdAfiliacion(orderAfiliacion.getIdAfiliacion());//orderAfiliacion.getIdAfiliacion();
		System.out.println("codigoRespuesta: " + codigoRespuesta);
		if (codigoRespuesta.equals(RESPUESTA_PAGO_APROBADO)) {
			EstadosUsuariosDto estado = new EstadosUsuariosDto(PAGO_APROBADO_ID,PAGO_APROBADO); 
			user.setEstadoCuenta(estado);
			usuariosService.saveOrUpdate(user);
			emailService.sendEmailConfirmacionPago(user.getCorreo(), orderAfiliacion.getIdAfiliacion());
		}
		else {
			EstadosUsuariosDto estado = new EstadosUsuariosDto(PAGO_APROBADO_ID,PAGO_RECHAZADO); 
			user.setEstadoCuenta(estado);
			usuariosService.saveOrUpdate(user);
			emailService.sendEmailDePagoRechazado(user.getCorreo(), orderAfiliacion.getIdAfiliacion());
			emailService.sendPaymentReminderEmail(user.getCorreo(), orderAfiliacion.getIdAfiliacion());
		}
	}

	@Override
	public Map<String, String> parseParameters(String input) {
		Map<String, String> paramMap = new HashMap<>();

		// Dividir la cadena por "&"
		String[] pairs = input.split("&");
		for (String pair : pairs) {
			// Dividir cada par por "="
			String[] keyValue = pair.split("=", 2);
			if (keyValue.length == 2) {
				paramMap.put(keyValue[0], keyValue[1]);
			}
		}

		// Decodificar el valor de Ds_MerchantParameters si existe
		String merchantParams = paramMap.get("Ds_MerchantParameters");
		ApiMacSha256 apiMacSha256 = new ApiMacSha256(); 
		if (merchantParams != null && !merchantParams.isEmpty()) {
			try {
				String decodec = apiMacSha256.decodeMerchantParameters(merchantParams);
				 String codigoRespuesta = apiMacSha256.getParameter("Ds_Response"); 
				 System.out.println("codigoRespuesta"+codigoRespuesta);
				paramMap.put("Ds_MerchantParameters", decodec);
			} catch (IllegalArgumentException e) {
				// Manejar la excepción de cadena Base64 no válida
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// Manejar la excepción de codificación de caracteres no soportada
				e.printStackTrace();
			}
			
		}
		return paramMap;
	}
}
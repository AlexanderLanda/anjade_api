package com.anjade.service;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface RedsysResponseNotification {

	
	 void readNotificatinoRedsysResponse(String response) throws JsonMappingException, JsonProcessingException;
	
	 Map<String, String> parseParameters(String input);
}

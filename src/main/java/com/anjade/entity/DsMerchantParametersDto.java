package com.anjade.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DsMerchantParametersDto {

	@JsonProperty("Ds_Order")
    private String Ds_Order; 
    @JsonProperty("Ds_TransactionType")
	private String Ds_TransactionType;
    @JsonProperty("Ds_SecurePayment")
    private String Ds_SecurePayment;
    @JsonProperty("Ds_Card_Country")
    private String Ds_Card_Country; 
    @JsonProperty("Ds_Amount")
    private String Ds_Amount; 
    @JsonProperty("Ds_Response")
    private String Ds_Response; 
    @JsonProperty("Ds_MerchantData")
    private String Ds_MerchantData; 
    @JsonProperty("Ds_ConsumerLanguage")
    private String Ds_ConsumerLanguage; 
    @JsonProperty("Ds_AuthorisationCode")
    private String Ds_AuthorisationCode; 
    @JsonProperty("Ds_Card_Brand")
    private String Ds_Card_Brand; 
    @JsonProperty("Ds_ProcessedPayMethod")
    private String Ds_ProcessedPayMethod; 
    
    
    
	public DsMerchantParametersDto() {
		super();
	}
	public DsMerchantParametersDto(String ds_TransactionType, String ds_Bizum_IdOper, String ds_ProcessedPayMethod,
			String ds_Bizum_CuentaTruncada, String ds_Order, Date ds_Date, String ds_SecurePayment, String ds_Hour,
			String ds_Response, String ds_AuthorisationCode, String ds_Currency, String ds_ConsumerLanguage,
			String ds_MerchantCode, String ds_Terminal, String ds_Amount, String ds_Bizum_MobileNumber) {
		super();
		Ds_TransactionType = ds_TransactionType;
		Ds_ProcessedPayMethod = ds_ProcessedPayMethod;
		Ds_Order = ds_Order;
		Ds_SecurePayment = ds_SecurePayment;
		Ds_Response = ds_Response;
		Ds_AuthorisationCode = ds_AuthorisationCode;
		Ds_ConsumerLanguage = ds_ConsumerLanguage;
		Ds_Amount = ds_Amount;
	}
	public String getDs_TransactionType() {
		return Ds_TransactionType;
	}
	public void setDs_TransactionType(String ds_TransactionType) {
		Ds_TransactionType = ds_TransactionType;
	}
	public String getDs_ProcessedPayMethod() {
		return Ds_ProcessedPayMethod;
	}
	public void setDs_ProcessedPayMethod(String ds_ProcessedPayMethod) {
		Ds_ProcessedPayMethod = ds_ProcessedPayMethod;
	}
	public String getDs_Order() {
		return Ds_Order;
	}
	public void setDs_Order(String ds_Order) {
		Ds_Order = ds_Order;
	}
	public String getDs_SecurePayment() {
		return Ds_SecurePayment;
	}
	public void setDs_SecurePayment(String ds_SecurePayment) {
		Ds_SecurePayment = ds_SecurePayment;
	}
	public String getDs_Response() {
		return Ds_Response;
	}
	public void setDs_Response(String ds_Response) {
		Ds_Response = ds_Response;
	}
	public String getDs_AuthorisationCode() {
		return Ds_AuthorisationCode;
	}
	public void setDs_AuthorisationCode(String ds_AuthorisationCode) {
		Ds_AuthorisationCode = ds_AuthorisationCode;
	}
	public String getDs_ConsumerLanguage() {
		return Ds_ConsumerLanguage;
	}
	public void setDs_ConsumerLanguage(String ds_ConsumerLanguage) {
		Ds_ConsumerLanguage = ds_ConsumerLanguage;
	}
	public String getDs_Amount() {
		return Ds_Amount;
	}
	public void setDs_Amount(String ds_Amount) {
		Ds_Amount = ds_Amount;
	}
    
    
}

package com.anjade.entity;

public class EmailRequest {
	  private String toEmail;
	    private String idAfiliacion;
		
	    
	    
	    
	    public EmailRequest() {
			super();
		}
		public EmailRequest(String toEmail, String idAfiliacion) {
			super();
			this.toEmail = toEmail;
			this.idAfiliacion = idAfiliacion;
		}
		public String getToEmail() {
			return toEmail;
		}
		public void setToEmail(String toEmail) {
			this.toEmail = toEmail;
		}
		public String getIdAfiliacion() {
			return idAfiliacion;
		}
		public void setIdAfiliacion(String idAfiliacion) {
			this.idAfiliacion = idAfiliacion;
		}
	    
	    
}

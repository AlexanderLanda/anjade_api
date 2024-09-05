package com.anjade.service;

public interface EmailService {

	 public default void sendWelcomeEmail(String toEmail, String idAfiliacion) {}

}

package com.theimitation.webservice.service;

public interface PaymentService {
	public String paymentRedirect(String orderId, String custId, String mobileNo, String email, String txnAmount) throws Exception;

}

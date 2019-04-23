package com.theimitation.webservice.util;

import com.theimitation.webservice.service.PaymentService;
import com.theimitation.webservice.service.PaymentServiceImpl;

public class Test {

	/**
	 * Outgoing Mail (SMTP) Server requires TLS or SSL: smtp.gmail.com (use
	 * authentication) Use Authentication: Yes Port for TLS/STARTTLS: 587
	 */
	public static void main(String[] args) {
		EmailUtil eu=new EmailUtil();
		//eu.sendEmail(null, "rupeshnegi83@gmail.com", "TLSEmail Testing Subject", "TLSEmail Testing Body");
		CipherHelper ch=new CipherHelper();
		try {
			PaymentService ps=new PaymentServiceImpl();
			System.out.println(ps.paymentRedirect("1","2","9827217123","rohit.lalwani@outlook.com","200.00"));
			System.out.println(ch.decipher(null, ch.cipher(null, "Rohit Lalwani")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
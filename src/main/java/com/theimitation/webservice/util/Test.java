package com.theimitation.webservice.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class Test {

	/**
	 * Outgoing Mail (SMTP) Server requires TLS or SSL: smtp.gmail.com (use
	 * authentication) Use Authentication: Yes Port for TLS/STARTTLS: 587
	 */
	public static void main(String[] args) {
		EmailUtil eu=new EmailUtil();
		eu.sendEmail(null, "rohit.lalwani@outlook.com", "TLSEmail Testing Subject", "TLSEmail Testing Body");

	}

}
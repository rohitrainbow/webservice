package com.theimitation.webservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.theimitation.webservice.dto.PaymentDto;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {

	@RequestMapping(method = RequestMethod.POST, value = "/payment")
	public String paymentRedirect(@RequestBody PaymentDto payment) {
		System.out.println("called");
		System.out.println(payment.getCustId());
		return "sdfdsf";
	}
}

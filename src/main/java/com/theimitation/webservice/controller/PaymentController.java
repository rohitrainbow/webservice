package com.theimitation.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.theimitation.webservice.dto.PaymentDto;
import com.theimitation.webservice.service.PaymentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;

	@RequestMapping(method = RequestMethod.POST, value = "/api/payment")
	public String paymentRedirect(@RequestBody PaymentDto payment) {
		return paymentService.paymentRedirect("1","2","9827217123","rohit.lalwani@outlook.com","200.00");
	}
}

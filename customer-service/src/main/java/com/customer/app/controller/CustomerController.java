package com.customer.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;	
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.customer.app.model.Customer;
import com.customer.app.service.CustomerService;

@RestController
@ComponentScan("com.customer.app.model")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@RequestMapping(value="/customers",method=RequestMethod.GET)
	public ResponseEntity<List<Customer>> findAllCustomers() throws Exception{
		List<Customer> customers = customerService.findAll();
		if(customers.size()==0) {
			return new ResponseEntity<List<Customer>>(customers,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
	}

}

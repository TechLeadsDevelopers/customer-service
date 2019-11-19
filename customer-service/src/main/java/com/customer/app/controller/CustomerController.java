package com.customer.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> findAllCustomers() {
		List<Customer> customers = null;
		try {
			customers = customerService.findAll();
			if (customers.size() == 0) {
				return new ResponseEntity<List<Customer>>(customers, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}

	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		try {
			customer = customerService.save(customer);
			if (customer == null) {
				return new ResponseEntity<Customer>(customer, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
	public ResponseEntity<Customer> findCustomerById(@PathVariable("id") Long id) {
		Customer customer = null;
		try {
			customer = customerService.findById(id);
			if (customer == null) {
				return new ResponseEntity<Customer>(customer, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

}

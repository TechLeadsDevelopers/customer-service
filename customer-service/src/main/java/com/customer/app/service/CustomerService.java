package com.customer.app.service;

import java.util.List;

import com.customer.app.model.Customer;

public interface CustomerService {
	public Customer save(Customer customer) throws Exception;
	public Customer findById(Long id) throws Exception;
	public Customer findByName(String name) throws Exception;
	public List<Customer> findAll() throws Exception;
	public Customer updateById(Long id) throws Exception;
	public List<Customer> deleteById(Long id) throws Exception;

}

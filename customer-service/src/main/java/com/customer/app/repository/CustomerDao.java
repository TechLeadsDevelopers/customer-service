package com.customer.app.repository;

import java.util.List;

import com.customer.app.model.Customer;

public interface CustomerDao {
	public int save(Customer customer) throws Exception;
	public Customer findById(Long id) throws Exception;
	public Customer findByName(String name) throws Exception;
	public List<Customer> findAll() throws Exception;
	public int updateById(Long id) throws Exception;
	public int deleteById(Long id) throws Exception;
	public Customer getCSMTRByMaxId() throws Exception;
}

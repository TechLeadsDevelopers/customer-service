package com.customer.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.app.model.Customer;
import com.customer.app.repository.CustomerDao;
@Service
public class CustomerServiceImpl implements CustomerService {
@Autowired
	private CustomerDao customerDao;
	@Override
	public Customer save(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findAll() throws Exception {
	try {
		List<Customer> customers = customerDao.findAll();
			return customers;
	} catch (Exception e) {
		throw e;
	}
	}

	@Override
	public Customer updateById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

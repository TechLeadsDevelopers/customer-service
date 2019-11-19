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
		int count=customerDao.save(customer);
		if(count>0) {
			return customerDao.getCSMTRByMaxId();
		}
		return customer;
	}

	@Override
	public Customer findById(Long id) throws Exception {
		try {
			Customer customer = customerDao.findById(id);
			return customer;
		} catch (Exception e) {
			throw e;
		}
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
	public Customer updateById(Long id,Customer customer) throws Exception {
		try {
			int count=customerDao.updateById(id, customer);
			if(count>0) {
				return findById(id);
			}
			
			return new Customer();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Customer> deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

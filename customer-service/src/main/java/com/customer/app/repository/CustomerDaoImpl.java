package com.customer.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.customer.app.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int save(Customer customer) throws Exception {
		//jdbcTemplate.update(sql, args, argTypes)
		return 0;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	

}

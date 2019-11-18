package com.customer.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.customer.app.commons.DBQueries;
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
		try {
			List<Customer> customers=new ArrayList<Customer>();
			jdbcTemplate.query(DBQueries.SELECT_ALL_CUSTMR, new ResultSetExtractor<List<Customer>>() {

				@Override
				public List<Customer> extractData(ResultSet rs) throws SQLException, DataAccessException {
					while(rs.next()) {
						Customer customer=new Customer();
						customer.setId(rs.getLong("ID"));
						customer.setName(rs.getString("NAME"));
						customer.setDescription(rs.getString("DESCRIPTION"));
						customer.setCreatedate(rs.getTimestamp("CREATEDATE"));
						customer.setCreatedUser(rs.getString("CREATEDUSER"));
						customer.setLastmodified(rs.getTimestamp("LASTMODIFIED"));
						customer.setUpdatedUser(rs.getString("UPDATEDUSER"));
						customers.add(customer);
					}
					return customers;
				}
			} );
			return customers;
		} catch (Exception e) {
			throw e;
		}
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

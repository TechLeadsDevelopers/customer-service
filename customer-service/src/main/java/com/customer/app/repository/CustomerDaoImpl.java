package com.customer.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.customer.app.commons.DBQueries;
import com.customer.app.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public int save(Customer customer) throws Exception {

		try {
			SqlParameterSource paramSource = new MapSqlParameterSource().addValue("name", customer.getName())
					.addValue("description", customer.getDescription())
					.addValue("createdate", new Timestamp(new Date().getTime()))
					.addValue("createduser", customer.getCreatedUser())
					.addValue("lastmodified", new Timestamp(new Date().getTime()))
					.addValue("updateduser", customer.getUpdatedUser());
			return namedParameterJdbcTemplate.update(DBQueries.INSERT_CUSTMR, paramSource);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Customer findById(Long id) throws Exception {
		Customer customer = new Customer();

		SqlParameterSource paramSource = new MapSqlParameterSource().addValue("id", id);
		try {
			namedParameterJdbcTemplate.query(DBQueries.SELECT_CUSTMR_BY_ID, paramSource,
					new ResultSetExtractor<Customer>() {

						@Override
						public Customer extractData(ResultSet rs) throws SQLException, DataAccessException {
							while (rs.next()) {

								customer.setId(rs.getLong("ID"));
								customer.setName(rs.getString("NAME"));
								customer.setDescription(rs.getString("DESCRIPTION"));
								customer.setCreatedate(rs.getTimestamp("CREATEDATE"));
								customer.setCreatedUser(rs.getString("CREATEDUSER"));
								customer.setLastmodified(rs.getTimestamp("LASTMODIFIED"));
								customer.setUpdatedUser(rs.getString("UPDATEDUSER"));
							}
							return customer;
						}
					});

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
			List<Customer> customers=new ArrayList<Customer>();
			namedParameterJdbcTemplate.query(DBQueries.SELECT_ALL_CUSTMR, new ResultSetExtractor<List<Customer>>() {

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
	public int updateById(Long id, Customer customer) throws Exception {

		try {
			SqlParameterSource paramSource = new MapSqlParameterSource()
					.addValue("name", customer.getName())
					.addValue("description", customer.getDescription())
					.addValue("lastmodified", new Timestamp(new Date().getTime()))
					.addValue("updateduser", customer.getUpdatedUser())
					.addValue("id", id);
			return namedParameterJdbcTemplate.update(DBQueries.UPDTE_CUSTMR_BY_ID, paramSource);
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public int deleteById(Long id) throws Exception {
		try {
			SqlParameterSource paramSource = new MapSqlParameterSource().addValue("id", id);
			return namedParameterJdbcTemplate.update(DBQueries.DELTE_CUSTMR_BY_ID, paramSource);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Customer getCSMTRByMaxId() throws Exception {
		Customer customer = new Customer();
		try {
			namedParameterJdbcTemplate.query(DBQueries.GET_CUSTR_WITH_MAX_ID, new ResultSetExtractor<Customer>() {

				@Override
				public Customer extractData(ResultSet rs) throws SQLException, DataAccessException {
					while (rs.next()) {

						customer.setId(rs.getLong("ID"));
						customer.setName(rs.getString("NAME"));
						customer.setDescription(rs.getString("DESCRIPTION"));
						customer.setCreatedate(rs.getTimestamp("CREATEDATE"));
						customer.setCreatedUser(rs.getString("CREATEDUSER"));
						customer.setLastmodified(rs.getTimestamp("LASTMODIFIED"));
						customer.setUpdatedUser(rs.getString("UPDATEDUSER"));
					}
					return customer;
				}
			});
			return customer;
		} catch (Exception e) {
			throw e;
		}
	}

	

}

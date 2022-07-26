package com.varxyz.banking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.banking.domain.Customer;

public class CustomerDao {
	private JdbcTemplate jdbcTemplate;
	
	public CustomerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer (email, passwd, name, ssn, phone)"
				+ " VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql,customer.getEmail(), customer.getPasswd(),
				customer.getName(), customer.getSsn(), customer.getPhone());
	}
	
	public Customer getCustomerByUserId(String userId){
		String sql = "SELECT * FROM Customer WHERE email=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Customer>() { //하나만 찾는 메소드 queryForObject

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = new Customer(rs.getLong("cid"),
						rs.getString("email"), rs.getString("passwd"), 
						rs.getString("name"), rs.getString("ssn"),
						rs.getString("phone"), rs.getTimestamp("regDate"));
				return customer;
			}
			
		}, userId);
	}
	
	public boolean isUser(String userId, String passwd) {
		String sql = "SELECT count(*) FROM Customer WHERE email=? AND passwd=?";
		boolean result = true;
		int ishere = jdbcTemplate.queryForObject(sql, Integer.class, userId, passwd);
		if(ishere == 0 ) {
			result = false; 
		}
		return result;
		
	}
}

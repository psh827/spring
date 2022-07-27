package com.varxyz.banking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.banking.domain.Account;
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
	
	public Customer getCustomerByAccountNum(String accountNum){
		try {
		    String sql = "SELECT * FROM Customer c INNER JOIN Account a ON a.customerId = c.cid"
					+ " WHERE a.accountNum=?";
		    return jdbcTemplate.queryForObject(sql, new RowMapper<Customer>() { //하나만 찾는 메소드 queryForObject

				@Override
				public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
					Customer customer = new Customer(rs.getLong("cid"),
							rs.getString("email"), rs.getString("passwd"), 
							rs.getString("name"), rs.getString("ssn"),
							rs.getString("phone"), rs.getTimestamp("regDate"));
					return customer;
				}
				
			}, accountNum);
		} catch (IncorrectResultSizeDataAccessException error) { // 쿼리문에 해당하는 결과가 없거나 2개 이상일 때
		    return null;
		}
	}
	
	public long countAccountOnCustomer(String userId) {
		String sql = "SELECT count(*) FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE c.email=?";
		return jdbcTemplate.queryForObject(sql, Long.class, userId);
	}
	
}



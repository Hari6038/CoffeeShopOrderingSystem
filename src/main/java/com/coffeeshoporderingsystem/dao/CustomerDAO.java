package com.coffeeshoporderingsystem.dao;

import java.util.List;

import com.coffeeshoporderingsystem.entities.Customer;

public interface CustomerDAO {
	Customer getCustomerById(int customerId);

	void updateCustomer(Customer customer);

	void deleteCustomer(Customer customer);

	List<Customer> getAllCustomers();

	void save(Customer customer);

	Customer findByUsername(String username);
}

package com.coffeeshoporderingsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.coffeeshoporderingsystem.entities.Customer;
import com.coffeeshoporderingsystem.utilities.JPAUtility;

@Transactional
public class CustomerDAOImpl implements CustomerDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Customer getCustomerById(int customerId) {
		return entityManager.find(Customer.class, customerId);

	}

	@Override
	public void deleteCustomer(Customer customer) {
		Transaction transaction = null;

		try (Session session = JPAUtility.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.delete(customer);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Customer> getAllCustomers() {

		List<Customer> customerList = null;
		Transaction transaction = null;

		try (Session session = JPAUtility.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			customerList = session.createNamedQuery("SELECT c FROM Customer c", Customer.class).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			transaction.commit();
		}
		return customerList;

	}

	@Override
	public void updateCustomer(Customer customer) {

		Transaction transaction = null;

		try (Session session = JPAUtility.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(customer);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void save(Customer customer) {

		Transaction transaction = null;

		try (Session session = JPAUtility.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(customer);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Customer findByUsername(String username) {

		Customer customer = null;
		Transaction transaction = null;

		try (Session session = JPAUtility.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query<Customer> query = session.createQuery("FROM Customer where firstname = :firstname", Customer.class);
			query.setParameter("firstname", username);
			customer = query.getResultList().getFirst();
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

}

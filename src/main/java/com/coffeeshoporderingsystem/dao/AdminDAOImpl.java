package com.coffeeshoporderingsystem.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.coffeeshoporderingsystem.entities.Admin;
import com.coffeeshoporderingsystem.utilities.JPAUtility;

@Transactional
public class AdminDAOImpl implements AdminDAO {

	@Override
	public Admin getAdminById(int adminId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAdmin(Admin admin) {
		Transaction transaction = null;

		try (Session session = JPAUtility.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(admin);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAdmin(int adminId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin findByAdminName(String adminName) {
		Admin admin = null;
		Transaction transaction = null;

		try (Session session = JPAUtility.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query<Admin> query = session.createQuery("FROM Admin where adminName = :adminName", Admin.class);
			query.setParameter("adminName", adminName);
			admin = query.getResultList().getFirst();
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}

}

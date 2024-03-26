package com.coffeeshoporderingsystem.dao;

import java.util.List;

import com.coffeeshoporderingsystem.entities.Admin;

public interface AdminDAO {

	Admin getAdminById(int adminId);

	void addAdmin(Admin admin);

	void updateAdmin(Admin admin);

	void deleteAdmin(int adminId);

	List<Admin> getAllAdmins();

	Admin findByAdminName(String username);

}

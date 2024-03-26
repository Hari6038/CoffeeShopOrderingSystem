package com.coffeeshoporderingsystem.entities;
	import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.coffeeshoporderingsystem.dao.AdminDAO;
import com.coffeeshoporderingsystem.dao.Coffee;

	@Entity
	@Table(name = "Admin")
	public class Admin {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "Admin_id")
	    public int adminId;

		/*
		 * @OneToOne
		 * 
		 * @JoinColumn(name = "Registration_id", referencedColumnName =
		 * "Registration_id") private Registration registration;
		 */

	    @Column(name = "adminName")
	    public String adminName;
	    
	    @Column(name = "email_id")
	    public String email_id;
	    
	    @Column(name = "password")
	    public String password;

		public String getAdminName() {
			return adminName;
		}

		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}

		public String getEmail_id() {
			return email_id;
		}

		public void setEmail_id(String email_id) {
			this.email_id = email_id;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Admin(String adminName, String email_id, String password) {
			super();
			this.adminName = adminName;
			this.email_id = email_id;
			this.password = password;
		}

		public Admin() {
			super();
		}
	    
	    
	    

	}

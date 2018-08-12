package org.web.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.web.modal.Admin;

public class AdminService {

	public boolean insert(String adminId, String password) {
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		Admin admin = new Admin();
		admin.setAdminId(adminId);
		admin.setPassword(password);
		session.save(admin);
		session.beginTransaction().commit();
		return true;

	}

	public boolean check(String adminId, String password) {
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		Admin adm = session.get(Admin.class, adminId);
		if (adm.getPassword().equals(adm.getPassword())) {
			return true;
		} else {
			return false;
		}

	}

}

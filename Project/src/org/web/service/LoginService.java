package org.web.service;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.web.modal.Customer;
import org.web.modal.Movie;
import org.web.modal.util.UserReply;

public class LoginService  {

	public UserReply create(String emailId, String password, String firstname, String lastname, String phone,
			String city, String age,String date) {
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		if (session == null)
			System.out.println("1");
		session.beginTransaction();
		Customer credential = session.get(Customer.class, emailId);
		UserReply reply = new UserReply();
		if (credential == null) {
			credential = new Customer();
			credential.setEmail(emailId);
			credential.setPassword(password);
			credential.setFirstname(firstname);
			credential.setLastname(lastname);
			int ag=Integer.parseInt(age);
			credential.setAge(ag);
			credential.setCity(city);
			credential.setPhone(phone);
			credential.setDate(date);
			session.save(credential);

			session.getTransaction().commit();
		}
		reply.setCredential(credential);
		session.close();
		return reply;
	}

	public boolean validate(String emailId, String password) {
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		Customer customer = session.get(Customer.class, emailId);
		if (customer != null) {
			if (password.equals(customer.getPassword())) {
				return true;
			} else
				return false;
		}
		return false;
	}

	public boolean modify(String password) {
		String emailId=EmailService.email;
		System.out.println(emailId);
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Customer credential = session.get(Customer.class, emailId);
		Customer customer = session.get(Customer.class, emailId);
		if (customer != null) {
			credential.setPassword(password);
			session.update(credential);
			session.getTransaction().commit();
			return true;
		} else {
			return false;
		}
	}
		
	public boolean check(String key)
	{
		String s=RandomService.i;
		if(key.equals(s))
		{
		return true;
		}
		else
		{
			return false;
		}
	}
	public boolean valid(String email)
	{
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		Customer customer = session.get(Customer.class, email);
		if(customer==null)
			return false;
		else
			return true;
	}
	
	
	public List<Customer> reterive(String email)
	{
		SessionFactory sessionfactory;
		sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		String customer="FROM Customer where email='"+email+"'";
		Query query=session.createQuery(customer);
		List<Customer> res= (List<Customer>) ((org.hibernate.query.Query) query).list();
		return  res ;
	}

}

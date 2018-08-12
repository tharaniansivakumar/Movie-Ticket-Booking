package org.web.service;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.web.modal.Screen;

public class CustomerMovieService {
	
	public Screen retrive(String email)
	{
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
	
		
		Criteria cr = session.createCriteria(Screen.class);
		cr.add(Restrictions.eq("customer.email", email));
		 Screen results =  (Screen) cr.uniqueResult();
		 results.setCustomer(null);
		return  results ;

	}

}

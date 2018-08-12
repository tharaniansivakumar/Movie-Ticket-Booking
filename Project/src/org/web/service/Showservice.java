package org.web.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.web.modal.Customer;
import org.web.modal.Screen;
import org.web.modal.Show;

public class Showservice {
		public static boolean insert(String user,String date,String time)
		{
			SessionFactory sessionFactory;
			sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();

			
			Show show=new Show();
			show.setDate(date);
			show.setShowTime(time);
			LoginService cust=new LoginService();
			List<Customer> customer=cust.reterive(user);
			for(Customer each1 : customer)
			{	
			if(each1.getEmail().equals(user))
			{
				show.setCustomer(each1);
			}
			}
			session.save(show);
			session.beginTransaction().commit();
			session.close();
			return true;
			
		}
		public Show retrive(String email)
		{
			SessionFactory sessionFactory;
			sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
		
			
			Criteria cr = session.createCriteria(Show.class);
			cr.add(Restrictions.eq("customer.email", email));
			 Show results =  (Show) cr.uniqueResult();
			 results.setCustomer(null);
			return  results ;

		}


	}






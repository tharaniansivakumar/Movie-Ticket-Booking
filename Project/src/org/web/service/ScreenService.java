package org.web.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.web.modal.Customer;
import org.web.modal.Movie;
import org.web.modal.Screen;
import org.web.modal.ScreenStatus;
import org.web.modal.Show;

public class ScreenService {

	public static boolean insert(String Scr,String user)
	{
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		
		MovieService mov=new MovieService();
		List<Movie> movie= mov.reterive();
		String check=Scr;
		LoginService cust=new LoginService();
		List<Customer> customer=cust.reterive(user);
				
		int flag=0;
		for (Movie each : movie)
		{
			if(each.getScreen().equals(ScreenStatus.valueOf(check)))
			{
				Screen screen=new Screen();
				screen.setMovieName(each.getMovieName());
				screen.setUrl(each.getUrl());
				screen.setDirector(each.getDirectorName());
				screen.setScreenNo(check);
				screen.setFirstClass(each.getFirstClass());
				screen.setSecondClass(each.getSecondClass());
				screen.setThirdClass(each.getThirdClass());
				
				for(Customer each1 : customer)
				{	
					if(each1.getEmail().equals(user))
					{
						screen.setCustomer(each1);
						System.out.println(user);
					}
				}
				session.save(screen);
				session.beginTransaction().commit();
				session.close();
				flag =1;
				break;
				}
			else
			{
				flag=0;
			}
		} 
		if(flag==1)
		{
			return true;
			
		}
		else
		{
			return false;
		}
				
	}
	public Screen retrive(String user)
	{
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		Criteria cr = session.createCriteria(Screen.class);
		cr.add(Restrictions.eq("customer.email", user));
		 Screen results =  (Screen) cr.uniqueResult();
		 return results;
	}

	private static Object valueOf(String check) {
		// TODO Auto-generated method stub
		return null;
	}
}

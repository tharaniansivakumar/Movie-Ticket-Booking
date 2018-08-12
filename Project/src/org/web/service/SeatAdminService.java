package org.web.service;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.web.modal.CustomerLog;
import org.web.modal.SeatCheck;
import org.web.modal.Show;

public class SeatAdminService {

	public boolean insert(String user, List value,String date,String time) {
		int i;
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();

		for (i = 0; i < value.size(); i++) {
			SeatCheck seat = new SeatCheck();
			Show show=new Show();
			seat.setSeatno((String) value.get(i));
			seat.setDate(date);
			seat.setTime(time);
			seat.setCustomer(user);

			session.save(seat);
		}
		tx.commit();
		session.close();
		return true;

	}
	public List retrive(String date,String time)
	{
	
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
	
		
		
		String mov="select seatno FROM SeatCheck where date='"+date+"' and time='"+time+"'";
		Query query=session.createQuery(mov);
		List<SeatCheck> res= ((org.hibernate.query.Query) query).list();
		return res ;

	}

}

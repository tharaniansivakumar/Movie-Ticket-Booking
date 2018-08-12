package org.web.service;


import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.web.modal.CustomerLog;
import org.web.modal.Movie;
import org.web.modal.Screen;
import org.web.modal.Seat;
import org.web.modal.Show;
import org.web.modal.Ticket;

public class CustomerLogService {

	public boolean insert(String user) {
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		CustomerLog customer=new CustomerLog();
		
		Criteria cr = session.createCriteria(Screen.class);
		cr.add(Restrictions.eq("customer.email", user));
		 Screen results =  (Screen) cr.uniqueResult();
		 int screenId=results.getMovieId();
		 customer.setScreenNo(results.getScreenNo());
		 customer.setMovieName(results.getMovieName());
		 
		 Criteria cret = session.createCriteria(Show.class);
			cret.add(Restrictions.eq("customer.email", user));
			 Show res =  (Show) cret.uniqueResult();
			 int showId=res.getShowId();
			 customer.setDate(res.getDate());
			 customer.setShowTime(res.getShowTime());
			 
			 Criteria create = session.createCriteria(Seat.class);
				create.add(Restrictions.eq("customer.email", user));
				 Seat resul =  (Seat) create.uniqueResult();
				 int seatId=resul.getSeat_id();
				 customer.setSeatNo(resul.getSeatNo());
				 customer.setNoOfSeat(resul.getNoOfSeat());
				 
				 Criteria creat = session.createCriteria(Ticket.class);
					creat.add(Restrictions.eq("customer.email", user));
					Ticket tick= (Ticket)creat.uniqueResult();
					customer.setPrice(tick.getPrice());
					int ticketId=tick.getTicketId();
					customer.setEmail(user);
					session.save(customer);
					
					
					Screen u=session.get(Screen.class,screenId);
					session.delete(u);

					
					Show un=session.get(Show.class,showId);
					session.delete(un);
					
					Seat uni=session.get(Seat.class,seatId);
					session.delete(uni);
		
					
					Ticket uniq=session.get(Ticket.class,ticketId);
					session.delete(uniq);
					
		
					tx.commit();
					session.close();
					
					EmailService.send(user, "TICKET","TICKET ID"+ tick.getTicketId()+" MOVIE NAME"+customer.getMovieName()+"Show Date:"+customer.getDate()+"Show Time:"+customer.getShowTime()+"Seat:"+customer.getSeatNo()+"No Of Seat:"+customer.getNoOfSeat()+
							"PRICE"+customer.getPrice());
					return true;
		 		 
	}
	
	public List retrive(String email)
	{
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
	
		
		
		String mov="FROM CustomerLog where email='"+email+"'";
		Query query=session.createQuery(mov);
		List<CustomerLog> res= ((org.hibernate.query.Query) query).list();
		return res ;
		/*Criteria trade = session.createCriteria(CustomerLog.class);
		trade.add(Restrictions.eq("email", email));
		 CustomerLog results =  (CustomerLog) trade.uniqueResult();
		return  results ;*/

	}
	
}


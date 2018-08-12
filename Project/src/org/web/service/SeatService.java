package org.web.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.web.modal.Customer;
import org.web.modal.Screen;
import org.web.modal.Seat;
import org.web.modal.Ticket;

public class SeatService {

	public boolean create(String user, String[] value) {
		int i, price = 0;
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		ScreenService ser =new ScreenService();
		Ticket ticket = new Ticket();
		int val=value.length;
		Screen screen=ser.retrive(user);
		int n=screen.getFirstClass();
		int n2=screen.getSecondClass();
		int n3=screen.getThirdClass();
		System.out.println(n);
		System.out.println(n2);
		System.out.println();
		//String[] arr = (String[]) value.toArray(new String[] {});
		for(String a : value )
		{	//System.out.println("hjjfsjdfjddddddddddddddddddddddddddddddddddddddddddddddddd");
			char p = a.charAt(1);
			if ((p=='A') ||(p=='B') ||(p=='c'))
			{
				System.out.println(price);
				price=price+n3;
			}
			else if((p=='D')||(p=='E')||(p=='F')||(p=='G'))
			{
				price=price+n2;
				System.out.println(price);

			}
			else
			{
				price=price+n;
			}
			//System.out.println(p);
		}

		
	//	int val=value.size();
		LoginService cust = new LoginService();
		List<Customer> customer = cust.reterive(user);
		for (Customer each1 : customer) {
			if (each1.getEmail().equals(user)) {
				ticket.setCustomer(each1);
			}
		}
		ticket.setPrice(price);
		session.save(ticket);
		tx.commit();
		session.close();
		return true;

	}

	public boolean seatadd(String user, List value) {
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Seat seat = new Seat();
		LoginService cust = new LoginService();
		List<Customer> customer = cust.reterive(user);

		String val = value.toString();
		int v = value.size();
		seat.setSeatNo(val);
		;
		seat.setNoOfSeat(v);
		for (Customer each1 : customer) {
			if (each1.getEmail().equals(user)) {
				seat.setCustomer(each1);
			}
		}

		session.save(seat);
		tx.commit();
		session.close();

		return true;
	}
}

package org.web.service;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.web.modal.Customer;
import org.web.modal.Movie;
import org.web.modal.ScreenStatus;


public class MovieService {
	
	public boolean insert(String movie,String actor,String actress,String date,String director,String Url,String screen,int s1,int s2,int s3)
	{
		int flag=0;
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		
		//String sql = "select movie_id where movie_name='"+movie+"'";
		//Query query = session.createSQLQuery(sql).addEntity(Movie.class);

		//Movie customer = session.get( Movie.class ,"select movie_id where movie_name='"+movie+"'");
		/*if(customer!=null)
		{
		String mov="delete from Movie where screenstatus='"+screen+"'";
		Query quer=session.createQuery(mov);
		session.update(quer);
		}
		else
		{*/
		Movie mv=new Movie();
		mv.setMovieName(movie);
		mv.setActorName(actor);
		mv.setActressName(actress);
		mv.setReleaseDate(date);
		mv.setDirectorName(director);
		mv.setUrl("upload/"+Url);
		mv.setScreen(ScreenStatus.valueOf(screen));
		mv.setFirstClass(s1);
		mv.setSecondClass(s2);
		mv.setThirdClass(s3);
		session.beginTransaction();
		session.save(mv);
		session.getTransaction().commit();
		return true;
		}
		/*if(flag==1)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}*/
	public List<Movie> reterive()
	{
		SessionFactory sessionfactory;
		sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		String mov="FROM Movie";
		Query query=session.createQuery(mov);
		List<Movie> res= ((org.hibernate.query.Query) query).list();
		return res ;
	}
	public boolean delele(int movie)
	{
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Movie u=session.get(Movie.class,movie);
		session.delete(u);
		session.beginTransaction().commit();
		return true;
		}
		
}


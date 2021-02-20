package com.demo123.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.demo123.dto.User;

public class UserDAO {

	private SessionFactory sessionFactory;

	public UserDAO() {
		super();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean saveUser(User ref) {
		boolean b=false;
		try {
			Session s = sessionFactory.getCurrentSession();
			s.save(ref);
			b = true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return b;
	}

	@Transactional
	public List<User> checkUser(User u) {
	List<User> l = null;
		
		try {
			Session s=sessionFactory.getCurrentSession();
			Query q=s.createQuery("FROM User");
			
		
		    l=q.list();
		  
		   
		   
		}
		catch (Exception e) {
			e.printStackTrace();
			
			// TODO: handle exception
		}
		
		return l;
	}

	@Transactional
	public List<User> UserList() {
		List<User> l = null;

			try {
				Session s=sessionFactory.getCurrentSession();
				Query q=s.createQuery("FROM User");
				
				
			    l=q.list();
			    System.out.println(l.isEmpty());
			   
			   
			}
			catch (Exception e) {
				e.printStackTrace();
				
				// TODO: handle exception
			}
			
			return l;
		}
	@Transactional
	public boolean deleteUser(long id) {
		boolean b=false;
		try {
			Session s = sessionFactory.getCurrentSession();
			Query q=s.createQuery("delete from User where userid= :uid");
			q.setParameter("uid", id);
			int x=q.executeUpdate();
			if(x>0) {
			b = true;
			}
			else {
				b=false;
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return b;
	}
	
@Transactional
	public boolean updateUser(User ref) {
	boolean b=false;
	try {
		Session s = sessionFactory.getCurrentSession();
		Query q=s.createQuery("update User set name = :name , mobile= :mob, city= :city where userid = :userid");
		q.setParameter("userid", ref.getUserid());
		q.setParameter("mob", ref.getMobile());
		q.setParameter("city", ref.getCity());
		q.setParameter("name", ref.getName());
		int x=q.executeUpdate();
		if(x>0) {
		b = true;
		}
		else {
			b=false;
		}
	} 
	catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	return b;
	}

@Transactional
public List<User> searchUser(String name) {
	// TODO Auto-generated method stub
	List<User> l=null;
	try {
		Session s = sessionFactory.getCurrentSession();
		Query q=s.createQuery("From User where name = :name");
		q.setParameter("name", name);
		l=q.list();
	return l;
	}
	catch (Exception e) {
		e.printStackTrace();
		return l;
	}
	
	
	
}
}










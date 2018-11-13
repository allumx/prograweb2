package ar.edu.uces.pw2.business.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uces.pw2.business.domain.Flavour;
import ar.edu.uces.pw2.business.domain.Product;
import ar.edu.uces.pw2.business.domain.User;

@Repository
public class UserDao {
	private SessionFactory sessionFactory;
	
	public UserDao (){
		super();
	}

	@Autowired
	public UserDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
		
	public User getUserByID(int id) {
		Session session = sessionFactory.getCurrentSession();
        return (User) session.get(User.class, id);
	}
		
	@Transactional(readOnly = true)
	public List<User> getUsers() {
		Session session = sessionFactory.getCurrentSession();
        List<User> users  = (List<User>) session.createQuery("from User").list();
		return users;
	}

	
}

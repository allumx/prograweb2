/*package ar.edu.uces.pw2.business.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
*/


 package ar.edu.uces.pw2.business.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uces.pw2.business.domain.User;

@Repository
public class UserDao {

	private SessionFactory sessionFactory;

	public UserDao() {
		super();
	}

	@Autowired
	public UserDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional(readOnly = true)
	public List<User> findAll(){
		Session session = sessionFactory.getCurrentSession();
        List<User> userList  = (List<User>) session.createQuery("from User").list();

        return userList;
	}

	@Transactional(readOnly = true)
	public User getUserByID(int id){

		Session session = sessionFactory.getCurrentSession();

        return (User) session.get(User.class, id);
	}

	@Transactional(readOnly = true)
	public User findByName(String name) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", name));
		Object result = criteria.uniqueResult();

		User user = null;
		if (result != null){
			user = (User) result;
		}

		return user;
	}

	@Transactional(readOnly = true)
	public User findByEmail(String email) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("email", email));

		Object result = criteria.uniqueResult();

		User user = null;
		if (result != null){
			user = (User) result;
		}

		return user;
	}

	@Transactional(readOnly = false)
	public User save(User newUser){

		Session session = sessionFactory.getCurrentSession();
		session.save(newUser);

		return newUser;
	}

	@Transactional(readOnly = false)
	public User update(User toUpdateUser){

		Session session = sessionFactory.getCurrentSession();
		session.update(toUpdateUser);

		return toUpdateUser;
	}

	@Transactional(readOnly = false)
	public boolean delete(int id){

		Session session = sessionFactory.getCurrentSession();
		User toDelete = new User();
		toDelete.setId(id);
		session.delete(toDelete);

        return true;
	}

}


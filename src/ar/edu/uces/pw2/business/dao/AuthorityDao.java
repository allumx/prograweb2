package ar.edu.uces.pw2.business.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uces.pw2.business.domain.Authority;

@Repository
public class AuthorityDao {

	private SessionFactory sessionFactory;

	public AuthorityDao() {
		super();
	}

	@Autowired
	public AuthorityDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional(readOnly = true)
	public List<Authority> findAll(){
		Session session = sessionFactory.getCurrentSession();
        List<Authority> authorityList  = (List<Authority>) session.createQuery("from Authority").list();

        return authorityList;
	}

	@Transactional(readOnly = true)
	public Authority findByID(int id){

		Session session = sessionFactory.getCurrentSession();

        return (Authority) session.get(Authority.class, id);
	}

	@Transactional(readOnly = false)
	public Authority save(Authority newAuthority){

		Session session = sessionFactory.getCurrentSession();
		session.save(newAuthority);

		return newAuthority;
	}

	@Transactional(readOnly = false)
	public Authority update(Authority toUpdateAuthority){

		Session session = sessionFactory.getCurrentSession();
		session.update(toUpdateAuthority);

		return toUpdateAuthority;
	}

	@Transactional(readOnly = false)
	public boolean delete(int id){

		Session session = sessionFactory.getCurrentSession();
		Authority toDelete = new Authority();
		toDelete.setId(id);
		session.delete(toDelete);

        return true;
	}

	@Transactional(readOnly = true)
	public Authority findByName(String authorityName) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Authority.class);
		criteria.add(Restrictions.eq("authority", authorityName));
		
		return (Authority) criteria.uniqueResult();
	}

}

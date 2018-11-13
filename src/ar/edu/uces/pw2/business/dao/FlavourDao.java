package ar.edu.uces.pw2.business.dao;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uces.pw2.business.domain.*;

@Repository
public class FlavourDao {
	private SessionFactory sessionFactory;
	
	public FlavourDao() {
		super();
	}
	
	
	@Autowired
	public FlavourDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional(readOnly = true)
	public List<Flavour> getFlavours() {
		Session session = sessionFactory.getCurrentSession();
        List<Flavour> falvours  = (List<Flavour>) session.createQuery("from Flavour").list();
		return falvours;
	}
	
	@Transactional(readOnly = true)
	public Flavour getFlavour(int id) {
		Session session = sessionFactory.getCurrentSession();
        return (Flavour) session.get(Flavour.class, id);
	}
	
	
	@Transactional(readOnly = false)
	public Flavour addFlavour(Flavour newFlavour){
		Session session = sessionFactory.getCurrentSession();
		session.save(newFlavour);
		return newFlavour;
	}
	
	@Transactional(readOnly = false)
	public boolean deleteFlavour(int id){
		Session session = sessionFactory.getCurrentSession();
		Flavour flavourtoDelete = new Flavour();
		flavourtoDelete.setId(id);
		session.delete(flavourtoDelete);
        
		return true;
	}
	

	@Transactional(readOnly = false)
	public Flavour editFlavour(Flavour flavourToEdit) {

		Session session = sessionFactory.getCurrentSession();
		session.update(flavourToEdit);
		return flavourToEdit;
	}

}

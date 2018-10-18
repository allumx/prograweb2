package ar.edu.uces.pw2.business.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import ar.edu.uces.pw2.business.domain.Functionality;

//@Transactional(readOnly = true)
@Repository
public class FunctionalityDao {

	//private SessionFactory sessionFactory;
	private List<Functionality> listaFuncionalidades = new ArrayList<>();

	public FunctionalityDao() {
		super();
		listaFuncionalidades.add(new Functionality(1, "Spring MVC"));
		listaFuncionalidades.add(new Functionality(2, "Spring Core"));
	}

//	@Transactional(readOnly = true)
	public List<Functionality> findAll(){
//		Session session = sessionFactory.getCurrentSession();
//        List<Functionality> listaFuncionalidades  = (List<Functionality>) session.createQuery("from Functionality").list();

        return listaFuncionalidades;
	}

//	@Autowired
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}


	public Functionality findByID(int id){

		Functionality foundFunctionality = findById(id);

		if (foundFunctionality != null){
			return foundFunctionality;
		}

        return null;
	}

	public Functionality save(Functionality newFunctionality){

		int lastIndex = (listaFuncionalidades.size() - 1);
		int lastID = listaFuncionalidades.get(lastIndex).getId();

		newFunctionality.setId(lastID++);

		listaFuncionalidades.add(newFunctionality);

		return newFunctionality;
	}

	public Functionality update(Functionality toUpdateFunctionality){

		Functionality updatedFunctionality = null;
		Functionality originalFunctionality = findById(toUpdateFunctionality.getId());

		if (originalFunctionality != null){
			originalFunctionality.setDescription(toUpdateFunctionality.getDescription());
			updatedFunctionality = originalFunctionality;
		}

		return updatedFunctionality;
	}

	public boolean delete(int id){

		Functionality foundFunctionality = findById(id);

		if (foundFunctionality != null){
			listaFuncionalidades.remove(foundFunctionality);
			return true;
		}

        return false;

	}

	private Functionality findById(int id) {

		for (Functionality functionality : listaFuncionalidades) {
			if (functionality.getId() == id){
				return functionality;
			}
		}

		return null;
	}
}

package ar.edu.uces.pw2.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.uces.pw2.business.dao.FunctionalityDao;
import ar.edu.uces.pw2.business.domain.Functionality;
import ar.edu.uces.pw2.business.model.FunctionalityDto;

@Service
public class FunctionalityService {

	private FunctionalityDao functionalityDao;

	public FunctionalityService() {
		super();
	}

	public List<FunctionalityDto> findFunctionalities(){

		List<FunctionalityDto> listFunctionalityModel = new ArrayList<FunctionalityDto>();
		List<Functionality> listFunctionalityDomain = functionalityDao.findAll();

		if (listFunctionalityDomain != null && !listFunctionalityDomain.isEmpty()){

			for (Functionality functionality : listFunctionalityDomain) {
				listFunctionalityModel.add(new FunctionalityDto(functionality.getDescription()));
			}
		}

		return listFunctionalityModel;
	}

	public FunctionalityDto save(FunctionalityDto functionalityToSave){

		Functionality functionality = new Functionality();
		functionality.setDescription(functionalityToSave.getDescription());
		functionality.setCategory(functionalityToSave.getCategory());
		functionality.setSprintApply(functionalityToSave.getSprintApply());

		this.functionalityDao.save(functionality);

		return functionalityToSave;
	}

	@Autowired
	public void setFunctionalityDao(FunctionalityDao functionalityDao) {
		this.functionalityDao = functionalityDao;
	}
}

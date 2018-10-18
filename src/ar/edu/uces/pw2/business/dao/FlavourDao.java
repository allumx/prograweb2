package ar.edu.uces.pw2.business.dao;
import java.util.*;

import org.springframework.stereotype.Repository;

import ar.edu.uces.pw2.business.domain.*;

@Repository
public class FlavourDao {
	private List <Flavour> availableFlavours = new ArrayList<Flavour>();
	
	Flavour f = new Flavour(1,"name",1,2);
	
	public FlavourDao() {
		availableFlavours.add(f); //esta hardcodeado para que funcione el add
	}
	
	public List<Flavour> getAvailableFlavours() {
		return availableFlavours;
	}
	
	public Flavour addFlavour(Flavour newFlavour){
		int lastIndex = (availableFlavours.size() - 1 );
		int lastID = availableFlavours.get(lastIndex).getId();
		newFlavour.setId(++lastID);
		availableFlavours.add(newFlavour);
		return newFlavour;
	}
	
}

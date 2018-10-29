package ar.edu.uces.pw2.business.dao;
import java.util.*;

import org.springframework.stereotype.Repository;

import ar.edu.uces.pw2.business.domain.*;

@Repository
public class FlavourDao {
	private List <Flavour> availableFlavours = new ArrayList<Flavour>();
	
	public Flavour f = new Flavour(1,"name",1,2);
	
	public FlavourDao() {
		availableFlavours.add(f); //esta hardcodeado para que funcione el add
	}
	
	public List<Flavour> getFlavours() {
		return availableFlavours;
	}
	
	public Flavour addFlavour(Flavour newFlavour){
		int lastIndex = (availableFlavours.size() - 1 );
		int lastID = availableFlavours.get(lastIndex).getId();
		newFlavour.setId(++lastID);
		availableFlavours.add(newFlavour);
		return newFlavour;
	}
	
	public void deleteFlavour(int id){
		for (Flavour flavour : this.availableFlavours) {
			if (flavour.getId()==id){
				int index = availableFlavours.indexOf(flavour);
				availableFlavours.remove(index);		
			}
		}	
	}
	
	public Flavour getFlavour(int id) {
		for (Flavour flavour : this.availableFlavours) {
			if (flavour.getId()==id){
				return flavour;
			}
		}		
		return null;
	}

	public Flavour editFlavour(Flavour flavourToEdit) {
		for (Flavour flavour : this.availableFlavours) {
			if (flavour.getId() == flavourToEdit.getId()){
				flavour.setCostPrice(flavourToEdit.getCostPrice());
				flavour.setSalePrice(flavourToEdit.getSalePrice());
				flavour.setName(flavourToEdit.getName());
				return flavour;
			}
		}
		return null;
	}

}

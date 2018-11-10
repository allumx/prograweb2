package ar.edu.uces.pw2.business.dao;
import java.util.*;

import org.springframework.stereotype.Repository;

import ar.edu.uces.pw2.business.domain.*;

@Repository
public class FlavourDao {
	private List <Flavour> availableFlavours = new ArrayList<Flavour>();
	
	
	
	
	public FlavourDao() {
		Flavour f1 = new Flavour(1,"Dulce de leche",1,2);
		Flavour f2 = new Flavour(2,"Chocolate",1,2);
		Flavour f3 = new Flavour(3,"Frutilla",1,2);
		Flavour f4 = new Flavour(4,"Sambayon",1,2);
		Flavour f5 = new Flavour(5,"Banana split",1,2);
		Flavour f6 = new Flavour(6,"Crema americana",1,2);
		availableFlavours.add(f1); //esta hardcodeado para que funcione el add
		availableFlavours.add(f2);
		availableFlavours.add(f3);
		availableFlavours.add(f4);
		availableFlavours.add(f5);
		availableFlavours.add(f6);
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

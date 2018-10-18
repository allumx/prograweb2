package ar.edu.uces.pw2.business.domain;

public class OrderState {
	private String name;
	
	public OrderState (String prmName){
		this.name=prmName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

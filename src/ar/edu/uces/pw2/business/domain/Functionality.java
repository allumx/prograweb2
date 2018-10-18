package ar.edu.uces.pw2.business.domain;

import java.io.Serializable;

public class Functionality implements Serializable{
	private static final long serialVersionUID = 5818048091493583563L;

	private int id;
	private String description;
	private String category;
	private String sprintApply;

	public Functionality() {
		super();
	}

	public Functionality(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSprintApply() {
		return sprintApply;
	}
	public void setSprintApply(String sprintApply) {
		this.sprintApply = sprintApply;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Functionality other = (Functionality) obj;
		if (id != other.id)
			return false;
		return true;
	}
}

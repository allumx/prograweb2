package ar.edu.uces.pw2.business.model;

public class FunctionalityDto {

	private String description;
	private String category;
	private String sprintApply;

	public FunctionalityDto() {
		super();
	}

	public FunctionalityDto(String description) {
		super();
		this.description = description;
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


}

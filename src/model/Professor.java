package model;

public class Professor extends Person{

	private String type;				// tipo de profesor coach o tecnico
	private String matter;				// materia del profesor
	private String expertiseArea;		// area de experticia
	private String position;			// cargo del profesor
	
	public Professor(){
		super();
		this.type 			= "none";
		this.matter			= "none";
		this.expertiseArea	= "none";
		this.position		= "none";
	}
	
	public Professor(String type, String matter, String expertiseArea, String position) {
		super();
		this.type = type;
		this.matter = matter;
		this.expertiseArea = expertiseArea;
		this.position = position;
	}
	

	public Professor(String ci, String name, String lastName, String email, String phone, String adress) {
		super(ci, name, lastName, email, phone, adress);
		// TODO Auto-generated constructor stub
		this.type 			= "none";
		this.matter			= "none";
		this.expertiseArea	= "none";
		this.position		= "none";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMatter() {
		return matter;
	}

	public void setMatter(String matter) {
		this.matter = matter;
	}

	public String getExpertiseArea() {
		return expertiseArea;
	}

	public void setExpertiseArea(String expertiseArea) {
		this.expertiseArea = expertiseArea;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return super.toString() +"Type: " + "Professor [type=" + type + ", matter=" + matter 
				+ ", expertiseArea=" + expertiseArea 
				+ ", position="+ position + "]";
	}
	
}

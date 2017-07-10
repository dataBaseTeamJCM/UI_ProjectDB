package model;

public class Activity {

	private String id;				// identificador de la actividad
	private String idCompetencia;	// indentificador de la competencia
	private String name;			// nombre de la actividad
	private String place;			// lugar de la actividad
	private String date;			// fecha de la actividad
	
	public Activity() {
		super();
		// TODO Auto-generated constructor stub
		this.id	 			= "none";
		this.idCompetencia 	= "none";
		this.name			= "none";
		this.place			= "none";
		this.date			= "none";
	}

	public Activity(String id, String idCompetencia, String name, String place, String date) {
		super();
		this.id 			= id;
		this.idCompetencia 	= idCompetencia;
		this.name 			= name;
		this.place 			= place;
		this.date 			= date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdCompetencia() {
		return idCompetencia;
	}

	public void setIdCompetencia(String idCompetencia) {
		this.idCompetencia = idCompetencia;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Activity [id=" 			+ id 
				+ ", idCompetencia=" 	+ idCompetencia 
				+ ", name=" 			+ name 
				+ ", place=" 			+ place
				+ ", date=" 			+ date 
				+ "]";
	}
	
	
}

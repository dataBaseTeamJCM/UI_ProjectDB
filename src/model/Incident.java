package model;

public class Incident {

	private String idTeam;		// identificador del equipo
	private String idActivity;	// identificador de la actividad
	private String Incident;	// incidente
	
	public Incident() {
		super();
		// TODO Auto-generated constructor stub
		this.idTeam		= "none";
		this.idActivity	= "none";
		this.Incident	= "none";
	}

	public Incident(String idTeam, String idActivity, String incident) {
		super();
		this.idTeam 		= idTeam;
		this.idActivity 	= idActivity;
		Incident 			= incident;
	}

	public String getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(String idTeam) {
		this.idTeam = idTeam;
	}

	public String getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(String idActivity) {
		this.idActivity = idActivity;
	}

	public String getIncident() {
		return Incident;
	}

	public void setIncident(String incident) {
		Incident = incident;
	}

	@Override
	public String toString() {
		return "Incident [idTeam="	+ idTeam 
				+ ", idActivity=" 	+ idActivity 
				+ ", Incident=" 	+ Incident 
				+ "]";
	}
	
	
	
}

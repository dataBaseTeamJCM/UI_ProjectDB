package model;

public class Competition {

	private String id;								// indetificador de la competencia
	private String name;							// nombre de la competencia
	private String place;							// lugar de la competencia
	private String level;							// nivel de la competencia
	private String date;							// fecha de la competencia
	private TeamCompetitorList	teamsCompetitors;	// equipos participantes de la competencia
	private ActivityList		activitys;			// actividades realizadas por la competencia
	private ProblemsList		problems;			// problemas propuestos
	
	public Competition() {
		super();
		// TODO Auto-generated constructor stub
		this.id 	= "none";
		this.name	= "none";
		this.place	= "none";
		this.level	= "none";
		this.date 	= "none";
		
		this.teamsCompetitors 	= new TeamCompetitorList();
		this.activitys			= new ActivityList();
		this.problems			= new ProblemsList();
	}

	public Competition(String id, String name, String place, String level, String date,
			TeamCompetitorList teamsCompetitors, ActivityList activitys, ProblemsList problems) {
		super();
		this.id = id;
		this.name = name;
		this.place = place;
		this.level = level;
		this.date = date;
		this.teamsCompetitors = teamsCompetitors;
		this.activitys = activitys;
		this.problems = problems;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public TeamCompetitorList getTeamsCompetitors() {
		return teamsCompetitors;
	}

	public void setTeamsCompetitors(TeamCompetitorList teamsCompetitors) {
		this.teamsCompetitors = teamsCompetitors;
	}

	public ActivityList getActivitys() {
		return activitys;
	}

	public void setActivitys(ActivityList activitys) {
		this.activitys = activitys;
	}

	public ProblemsList getProblems() {
		return problems;
	}

	public void setProblems(ProblemsList problems) {
		this.problems = problems;
	}

	@Override
	public String toString() {
		return "Competition [id=" + id + ", name=" + name 
				+ ", place=" + place + ", level=" + level 
				+ ", date=" + date + "]";
	}
	
	
	
	
}


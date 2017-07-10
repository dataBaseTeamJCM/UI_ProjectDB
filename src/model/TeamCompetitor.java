package model;

public class TeamCompetitor extends Team{
	private String 	performance;			// rendimiento del equipo participante 
	private String 	incentive;				// incentivo por la participacion del equipo
	private String 	site;					// sitio de alojamiento de los problemas del equipo 
	private int 	daysTravel;				// dias de viaje
	private String 	hosting;				// hospedaje del equipo en el viaje
	private String 	financier;				// financista del equipo en el viaje
	
	
	public TeamCompetitor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TeamCompetitor(String id, String name, String university, String school, int year, ProfessorList professors,
			StudentList students, ProblemSolvedList problemsSolved) {
		super(id, name, university, school, year, professors, students, problemsSolved);
		// TODO Auto-generated constructor stub
	}
	
	public TeamCompetitor(String performance, String incentive, String site, int daysTravel, String hosting,
			String financier) {
		super();
		this.performance = performance;
		this.incentive = incentive;
		this.site = site;
		this.daysTravel = daysTravel;
		this.hosting = hosting;
		this.financier = financier;
	}
	
	public String getPerformance() {
		return performance;
	}
	public void setPerformance(String performance) {
		this.performance = performance;
	}
	public String getIncentive() {
		return incentive;
	}
	public void setIncentive(String incentive) {
		this.incentive = incentive;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public int getDaysTravel() {
		return daysTravel;
	}
	public void setDaysTravel(int daysTravel) {
		this.daysTravel = daysTravel;
	}
	public String getHosting() {
		return hosting;
	}
	public void setHosting(String hosting) {
		this.hosting = hosting;
	}
	public String getFinancier() {
		return financier;
	}
	public void setFinancier(String financier) {
		this.financier = financier;
	}
	@Override
	public String toString() {
		return super.toString() + "type: " +"TeamCompetitor [performance=" + performance 
				+ ", incentive=" + incentive + ", site=" + site + ", daysTravel=" + daysTravel + ", hosting=" 
				+ hosting + ", financier=" + financier + "]";
	}
	
	
	

}

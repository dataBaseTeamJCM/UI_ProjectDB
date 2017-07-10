package model;

public class Lesson {

	private String lesson;			// clase impartida por el profesor al equipo
	private String ciProfessor;		// cedula del profesor que la impartio
	private String idTeam;			// indentificacion del equipo a la que fue impartido
	
	public Lesson() {
		super();
		// TODO Auto-generated constructor stub
		this.lesson			= "none";
		this.ciProfessor	= "none";
		this.idTeam			= "none";
	}

	public Lesson(String lesson, String ciProfessor, String idTeam) {
		super();
		this.lesson 		= lesson;
		this.ciProfessor 	= ciProfessor;
		this.idTeam 		= idTeam;
	}

	public String getLesson() {
		return lesson;
	}

	public void setLesson(String lesson) {
		this.lesson = lesson;
	}

	public String getCiProfessor() {
		return ciProfessor;
	}

	public void setCiProfessor(String ciProfessor) {
		this.ciProfessor = ciProfessor;
	}

	public String getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(String idTeam) {
		this.idTeam = idTeam;
	}

	@Override
	public String toString() {
		return "Lesson [lesson=" 	+ lesson 
				+ ", ciProfessor=" 	+ ciProfessor 
				+ ", idTeam=" 		+ idTeam 
				+ "]";
	}
	
	
	
	
}

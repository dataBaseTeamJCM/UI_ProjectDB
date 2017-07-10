package model;

public class Lesson {

	private String lesson;			// clase impartida por el profesor al equipo
	private String ciProfessor;		// cedula del profesor que la impartio
	private String idEquipo;		// indentificacion del equipo a la que fue impartido
	
	public Lesson() {
		super();
		// TODO Auto-generated constructor stub
		this.lesson			= "none";
		this.ciProfessor	= "none";
		this.idEquipo		= "none";
	}

	public Lesson(String lesson, String ciProfessor, String idEquipo) {
		super();
		this.lesson = lesson;
		this.ciProfessor = ciProfessor;
		this.idEquipo = idEquipo;
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

	public String getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(String idEquipo) {
		this.idEquipo = idEquipo;
	}

	@Override
	public String toString() {
		return "Lesson [lesson=" + lesson + ", ciProfessor=" + ciProfessor 
				+ ", idEquipo=" + idEquipo + "]";
	}
	
	
	
	
}

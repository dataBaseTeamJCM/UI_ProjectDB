package model;

public class ProblemSolved extends Problem{

	private String timeSolved;		// tiempo de solucion del problema
	private String language;		// lenguaje de programacion usado para resolver el problema
	
	public ProblemSolved() {
		super();
		// TODO Auto-generated constructor stub
		this.timeSolved = "none";
		this.language	= "none";
	}
	
	public ProblemSolved(String id, String title, String enunciate, String difficulty) {
		super(id, title, enunciate, difficulty);
		// TODO Auto-generated constructor stub
		this.timeSolved = "none";
		this.language	= "none";
	}
	
	public ProblemSolved(String timeSolved, String language) {
		super();
		this.timeSolved = timeSolved;
		this.language = language;
	}

	public String getTimeSolved() {
		return timeSolved;
	}

	public void setTimeSolved(String timeSolved) {
		this.timeSolved = timeSolved;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return super.toString() + "Type: "+ "ProblemSolved [timeSolved=" + timeSolved + ", language=" + language + "]";
	}
	
	
}

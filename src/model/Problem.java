package model;

public class Problem {

	private String id;			// identificador del problema
	private String title;		// titulo del problema
	private String enunciate;	// enunciado del problema
	private String difficulty;	// dificultad del problema
	
	public Problem() {
		super();
		// TODO Auto-generated constructor stub
		this.id 		= "none";
		this.title		= "none";
		this.enunciate	= "none";
		this.difficulty	= "none";
	}

	public Problem(String id, String title, String enunciate, String difficulty) {
		super();
		this.id 			= id;
		this.title 			= title;
		this.enunciate 		= enunciate;
		this.difficulty 	= difficulty;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEnunciate() {
		return enunciate;
	}

	public void setEnunciate(String enunciate) {
		this.enunciate = enunciate;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	@Override
	public String toString() {
		return "Problem [id=" 		+ id 
				+ ", title=" 		+ title 
				+ ", enunciate=" 	+ enunciate 
				+ ", difficulty=" 	+ difficulty 
				+ "]";
	}
	
	
}

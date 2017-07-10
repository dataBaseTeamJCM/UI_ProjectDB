package model;

import java.util.ArrayList;

public class Team {
	private String 				id;				// identificador unico del equipo		
	private String 				name;			// nombre del equipo
	private String 				university;		// universidad a la que pertenece el equipo
	private String 				school;			// escuela o facultad 
	private int					year;			// año del equipo ej: 2005
	private ProfessorList	  	professors;		// lista de profesores del equipo (coach y tecnico)
	private StudentList		  	students;		// lista de estudiantes del equipo 		
	private ProblemSolvedList 	problemsSolved;	// lista de problemas solucionados
	
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Team(String id, String name, String university, String school, 
			int year, ProfessorList professors,StudentList students, 
			ArrayList<ProblemSolved> problemsSolved) {
		super();
		this.id = id;
		this.name = name;
		this.university = university;
		this.school = school;
		this.year = year;
		this.professors = professors;
		this.students = students;
		this.problemsSolved = problemsSolved;
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

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public ProfessorList getProfessors() {
		return professors;
	}

	public void setProfessors(ProfessorList professors) {
		this.professors = professors;
	}

	public StudentList getStudents() {
		return students;
	}

	public void setStudents(StudentList students) {
		this.students = students;
	}

	public ArrayList<ProblemSolved> getProblemsSolved() {
		return problemsSolved;
	}

	public void setProblemsSolved(ArrayList<ProblemSolved> problemsSolved) {
		this.problemsSolved = problemsSolved;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", university=" + university 
				+ ", school=" + school + ", year=" + year + "]";
	}
	
	
}

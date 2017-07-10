package model;

import java.util.ArrayList;

public class Team {
	private String 					id;				// identificador unico del equipo		
	private String 					name;			// nombre del equipo
	private String 					university;		// universidad a la que pertenece el equipo
	private String 					school;			// escuela o facultad 
	private int						year;			// año del equipo ej: 2005
	private ArrayList<Professor> 	professors;		// lista de profesores del equipo (coach y tecnico)
	private ArrayList<Student> 		students;		// lista de estudiantes del equipo 		
	private ArrayList<Problem> 		problemsSolved;	// lista de problemas solucionados
	
	
}

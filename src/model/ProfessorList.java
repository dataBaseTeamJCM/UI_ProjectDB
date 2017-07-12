package model;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class ProfessorList extends ArrayList<Professor> implements ICustomList{
	
	private ProfessorList instance;
	
	public ProfessorList (){
		
	}

	public ProfessorList getInstance() {
		return instance;
	}

	public void setInstance(ProfessorList instance) {
		this.instance = instance;
	}

	// que devuelva una sublista de los profesores que son coach
	
	public ProfessorList getCoachs()
	{
		ProfessorList professorList = new ProfessorList();
		for (Professor professor : this) {
			if(professor.getType().equals("Coach") )
				professorList.add(professor);
		}
		return professorList;
	}
	
	// que devuelva una sublista de los profesores que son tecnicos
	
		public ProfessorList getTechnicals()
		{
			ProfessorList professorList = new ProfessorList();
			for (Professor professor : this) {
				if(professor.getType().equals("Tecnico") )
					professorList.add(professor);
			}
			return professorList;
		}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		String print = ""; 
		for (Professor professor : this) {
			print += professor.toString() + "\n";
		}
		System.out.println(print);
	}

	@Override
	public DefaultListModel<String> toListModel() {
		// TODO Auto-generated method stub
		return null;
	}
}

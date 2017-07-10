package model;

import java.util.ArrayList;

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

	@Override
	public void print() {
		// TODO Auto-generated method stub
		String print = ""; 
		for (Professor professor : this) {
			print += professor.toString() + "\n";
		}
		System.out.println(print);
	}
}

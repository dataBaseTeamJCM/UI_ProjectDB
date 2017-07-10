package model;

import java.util.ArrayList;

public class ProblemsList extends ArrayList<Problem> implements ICustomList{

	
	private ProblemsList instance;
	
	public ProblemsList() {
		// TODO Auto-generated constructor stub
	}
	
	public ProblemsList getInstance() {
		return instance;
	}


	public void setInstance(ProblemsList instance) {
		this.instance = instance;
	}
	
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		String print = "";
		for (Problem problem : this) {
			print += problem.toString() + "\n";
		}
		System.out.println(print);
	}




}

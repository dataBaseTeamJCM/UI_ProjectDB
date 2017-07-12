package model;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class ProblemSolvedList extends ArrayList<ProblemSolved> implements ICustomList{

	private ProblemSolved instance;
	
	public ProblemSolvedList() {
		// TODO Auto-generated constructor stub
	}
		
	public ProblemSolved getInstance() {
		return instance;
	}

	public void setInstance(ProblemSolved instance) {
		this.instance = instance;
	}

	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		String print = ""; 
		for (ProblemSolved problemSolved : this) {
			print += problemSolved.toString() + "\n";
		}
		System.out.println(print);
	}

	@Override
	public DefaultListModel<String> toListModel() {
		// TODO Auto-generated method stub
		return null;
	}

}

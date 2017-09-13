package model;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class CompetitionList extends ArrayList<Competition> implements ICustomList {

	private CompetitionList instance;
	
	
	
	
	public CompetitionList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompetitionList getInstance() {
		return instance;
	}

	public void setInstance(CompetitionList instance) {
		this.instance = instance;
	}

	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		String print = "";
		for (Competition competition: this) {
			print += competition.toString() + "\n";
		}
		System.out.println(print);
	}

	@Override
	public DefaultListModel toListModel() {
		// TODO Auto-generated method stub
		return null;
	}

}

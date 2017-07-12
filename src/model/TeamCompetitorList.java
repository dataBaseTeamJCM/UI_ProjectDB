package model;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class TeamCompetitorList extends ArrayList<TeamCompetitor> implements ICustomList{

	
	private TeamCompetitor instance;
	
	public TeamCompetitorList() {
		// TODO Auto-generated constructor stub
	}
	
	
	public TeamCompetitor getInstance() {
		return instance;
	}


	public void setInstance(TeamCompetitor instance) {
		this.instance = instance;
	}


	@Override
	public void print() {
		// TODO Auto-generated method stub
		String print = "";
		for (TeamCompetitor teamCompetitor: this) {
			print += teamCompetitor.toString() + "\n";
		}
		System.out.println(print);
	}


	@Override
	public DefaultListModel<String> toListModel() {
		// TODO Auto-generated method stub
		return null;
	}

}

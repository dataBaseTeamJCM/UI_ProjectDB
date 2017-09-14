package model;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

@SuppressWarnings("serial")
public class IncidentList extends ArrayList<Incident> implements ICustomList{

	private IncidentList instance;
		
	public IncidentList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IncidentList getInstance() {
		return instance;
	}

	public void setInstance(IncidentList instance) {
		this.instance = instance;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DefaultListModel toListModel() {
		// TODO Auto-generated method stub
		return null;
	}

}

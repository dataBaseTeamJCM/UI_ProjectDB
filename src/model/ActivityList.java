package model;

import java.util.ArrayList;

public class ActivityList extends ArrayList<Activity> implements ICustomList{

	private ActivityList instance;
	
	public ActivityList() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ActivityList getInstance() {
		return instance;
	}



	public void setInstance(ActivityList instance) {
		this.instance = instance;
	}



	@Override
	public void print() {
		// TODO Auto-generated method stub
		String print = "";
		for (Activity activity: this) {
			print += activity.toString() + "\n";
		}
		System.out.println(print);
	}

}

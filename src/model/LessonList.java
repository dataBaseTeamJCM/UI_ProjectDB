package model;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

@SuppressWarnings("serial")
public class LessonList extends ArrayList<Lesson> implements ICustomList {

	private LessonList instance;
	
	public LessonList() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public LessonList getInstance() {
		return instance;
	}


	public void setInstance(LessonList instance) {
		this.instance = instance;
	}


	@Override
	public void print() {
		// TODO Auto-generated method stub
		String print = "";
		for (Lesson lesson : this) {
			print += lesson.toString() + "\n";
		}
		System.out.println(print);
	}


	@Override
	public DefaultListModel toListModel() {
		// TODO Auto-generated method stub
		return null;
	}

}

package model;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class StudentList extends ArrayList<Student> implements ICustomList{

	
	private StudentList instance;
	
	public StudentList() {
		// TODO Auto-generated constructor stub
	}
	
	
	public StudentList getInstance() {
		return instance;
	}

	public void setInstance(StudentList instance) {
		this.instance = instance;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		String print = "";
		for (Student student : this) {
			print += student.toString() + "\n";
		}
		System.out.println(print);
	}

	@Override
	public DefaultListModel<String> toListModel() {
		// TODO Auto-generated method stub
		
		DefaultListModel<String> defaultListModel = new DefaultListModel<>();
		for (Student student : this) {
			String data = student.getName() + " " + student.getLastName();
			defaultListModel.addElement(data);
		}
		return defaultListModel;
	}

}

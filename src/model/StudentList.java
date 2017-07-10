package model;

import java.util.ArrayList;

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
	

}

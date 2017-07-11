package db;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Student;
import model.StudentList;

public class DatabaseQueries {
	
	private Conexion conexion;
	
	public DatabaseQueries() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DatabaseQueries(Conexion conexion) {
		super();
		this.conexion = conexion;
	}

	public StudentList buildStudentList() {
		// TODO Auto-generated method stub
		StudentList studentList = new StudentList();
		String sql = 	"SELECT * FROM " + DatabaseConstants.TABLE_STUDENT 
						+ " ORDER BY " + DatabaseConstants.KEY_CI_STUDENTS
						+ " ASC";
		
		if(conexion != null){
			conexion.createQuery(sql);
			ResultSet resultSet = conexion.getRs();
			
			try {
				while(resultSet.next()){
					String 	ci 			= resultSet.getString(1);
					String 	name		= resultSet.getString(2);
					String	lastName 	= resultSet.getString(3);
					String 	phone		= resultSet.getString(4);
					String 	email		= resultSet.getString(5);
					String 	adress		= resultSet.getString(6);
					int 	year		= resultSet.getInt(7);
					String	carrer		= resultSet.getString(8);
					
					Student student = new Student(ci, name, lastName, email, phone, adress);
					student.setYear(year);
					student.setCarrer(carrer);
					
					studentList.add(student);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		return studentList;
	}
	
	

}

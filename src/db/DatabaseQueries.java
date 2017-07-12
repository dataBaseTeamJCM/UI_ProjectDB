package db;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Competition;
import model.CompetitionList;
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

	public CompetitionList buildCompetitionList() {
		// TODO Auto-generated method stub
		
		CompetitionList competitionList = new CompetitionList();
		
		String sql = 	"SELECT * FROM " 	+ DatabaseConstants.TABLE_COMPETITION 
						+ " ORDER BY " 		+ DatabaseConstants.KEY_ID_COMPETITION
						+ " ASC";
		
		
		if(conexion != null){
			conexion.createQuery(sql);
			ResultSet resultSet = conexion.getRs();
			
			try {
				while(resultSet.next()){
					String 	id 			= resultSet.getString(1);
					String 	name		= resultSet.getString(2);
					String	level 		= resultSet.getString(3);
					String 	place		= resultSet.getString(4);
					String 	date		= resultSet.getString(5);
					
					Competition competition = new Competition(id,name,level,place,date);
					//competition.setYear(year);
					//competition.setCarrer(carrer);
					
					competitionList.add(competition);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return competitionList;
	}
	
	

}

package db;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.crypto.Data;

import model.Competition;
import model.CompetitionList;
import model.Student;
import model.StudentList;
import model.TeamCompetitor;
import model.TeamCompetitorList;

public class DatabaseQueries {
	 
	private static final String SELECT			= "SELECT ";
	private static final String SELECT_ALL		= "SELECT *";
	private static final String FROM 			= " FROM ";
	private static final String ORDER_BY 		= " ORDER BY ";
	private static final String ASC 			= " ASC";
	private static final String AS 				= " AS ";
	private static final String WHERE 			= " WHERE ";
	private static final String JOIN 			= " JOIN ";
	private static final String ON 				= " ON ";
	
	private static final String TAG_COMPETITOR 	= "pa";
	private static final String TAG_TEAM 		= "eq";
	private static final String TAG_UNIVERSITY 	= "ue";
	private static final String IN 				= " IN ";
	

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
		String sql = 	SELECT_ALL 
						+ FROM 		+ DatabaseConstants.TABLE_STUDENT 
						+ ORDER_BY 	+ DatabaseConstants.KEY_CI_STUDENTS
						+ ASC;
		
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
		
		String sql = 	SELECT_ALL 
						+ FROM 		+ DatabaseConstants.TABLE_COMPETITION 
						+ ORDER_BY 	+ DatabaseConstants.KEY_ID_COMPETITION
						+ ASC;
		
		
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

	public TeamCompetitorList buildCompetitionList(String idCompetition) {
		// TODO Auto-generated method stub
		TeamCompetitorList teamCompetitorList = new TeamCompetitorList();

		String idTeamLeft 	= TAG_COMPETITOR 	+"."+ DatabaseConstants.KEY_ID_TEAM;
		String idTeamRight	= TAG_TEAM 			+"."+ DatabaseConstants.KEY_ID_TEAM;
		
		String schoolLeft	= TAG_UNIVERSITY	+"."+ DatabaseConstants.KEY_SCHOOL;
		String schoolRight	= TAG_TEAM	 		+"."+ DatabaseConstants.KEY_SCHOOL;

		String whereValue	= TAG_COMPETITOR 	+"."+ DatabaseConstants.KEY_ID_COMPETITION;
		
		String sql = 	SELECT	+ TAG_COMPETITOR +"."+ 	DatabaseConstants.KEY_ID_TEAM			+ ","
								+ TAG_TEAM 		 +"."+	DatabaseConstants.TEAM_NAME			 	+ ","
								+ TAG_COMPETITOR +"."+ 	DatabaseConstants.COMPETITOR_INCENTIVE 	+ ","
								+ TAG_COMPETITOR +"."+ 	DatabaseConstants.COMPETITOR_PERFOMANCE + ","
								+ TAG_COMPETITOR +"."+ 	DatabaseConstants.COMPETITOR_SITE		+ ","
								+ TAG_TEAM		 +"."+  DatabaseConstants.KEY_SCHOOL			+ ","
								+ TAG_UNIVERSITY +"."+  DatabaseConstants.UNIVERSITY_NAME		+ ","
								+ TAG_TEAM		 +"."+ 	DatabaseConstants.TEAM_YEAR
						+ FROM	+ DatabaseConstants.TABLE_COMPETITOR 	+ AS + TAG_COMPETITOR
						+ JOIN	+ DatabaseConstants.TABLE_TEAM			+ AS + TAG_TEAM 
								+ ON + idTeamLeft + " = " + idTeamRight
						+ JOIN	+ DatabaseConstants.TABLE_UNIVERSITY 	+ AS + TAG_UNIVERSITY
								+ ON + schoolLeft + " = " + schoolRight
 						+ WHERE + whereValue + IN + "('"+ idCompetition +"')"
						+ ORDER_BY + TAG_TEAM +"."+ DatabaseConstants.KEY_ID_TEAM
						+ ASC + ";";
		
	
		if(conexion != null){
			conexion.createQuery(sql);
			ResultSet resultSet = conexion.getRs();
			
			try {
				while(resultSet.next()){
					String 	id				= resultSet.getString(1);
					String	name 			= resultSet.getString(2);
					String 	incentive		= resultSet.getString(3);
					String 	performance		= resultSet.getString(4);
					String 	site			= resultSet.getString(5);
					String 	school			= resultSet.getString(6);
					String 	university		= resultSet.getString(7);
					int		year			= resultSet.getInt(8);
					
					TeamCompetitor competitor = new TeamCompetitor(id,name,university,school,year, incentive, performance, site);
					//competition.setYear(year);
					//competition.setCarrer(carrer);
					
					teamCompetitorList.add(competitor);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return teamCompetitorList;
	}
	
	

}

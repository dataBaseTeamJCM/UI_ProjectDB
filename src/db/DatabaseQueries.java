package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sound.midi.SysexMessage;
import javax.swing.table.TableModel;
import javax.xml.crypto.Data;

import model.ActivityList;
import model.Competition;
import model.CompetitionList;
import model.Student;
import model.StudentList;
import model.TeamCompetitor;
import model.TeamCompetitorList;
import net.proteanit.sql.DbUtils;

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
	
	private Connection conn;
	
	public DatabaseQueries() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DatabaseQueries(Connection conn) {
		super();
		this.conn = conn;
	}

	public StudentList buildStudentList() {
		// TODO Auto-generated method stub
		
		Connection connection = conn;
		
		Statement st = null;
		
		ResultSet rs = null;
		
		StudentList studentList = new StudentList();
		String sql = 	SELECT_ALL 
						+ FROM 		+ DatabaseConstants.TABLE_STUDENT 
						+ ORDER_BY 	+ DatabaseConstants.KEY_CI_STUDENTS
						+ ASC;
			
			try {
				// Establecemos la comunicación entre nuestra aplicación java y la base de datos
				st = connection.createStatement();
				
				 // Le pasamos al objeto de ResultSet el resultado de ejecutar la sentencia "query"
                // Con "executeQuery" realizamos una consulta a la base de datos
				rs = st.executeQuery(sql) ;
				
				// En este bucle vamos recorriendo valores mientras existan
				while(rs.next()){
					String 	ci 					= rs.getString(1);
					String 	name				= rs.getString(2);
					String	lastName 	= rs.getString(3);
					String 	phone			= rs.getString(4);
					String 	email				= rs.getString(5);
					String 	adress			= rs.getString(6);
					int 	year						= rs.getInt(7);
					String	carrer			= rs.getString(8);
					
					Student student = new Student(ci, name, lastName, email, phone, adress, year, carrer);
					studentList.add(student);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				 // Cerramos las conexiones, en orden inverso a su apertura
				try
				{
					rs.close();
				}
				catch (Exception e2)
				{
					// TODO: handle exception
				}
				
				try
				{
					st.close();
				}
				catch (Exception e2)
				{
					// TODO: handle exception
				}
		
			}
		return studentList;
	}

	public CompetitionList buildCompetitionList() {
		// TODO Auto-generated method stub
		
		Connection connection = conn;
		
		Statement st = null;
		
		ResultSet rs = null;
		
		CompetitionList competitionList = new CompetitionList();
		
		String sql = 	SELECT_ALL 
						+ FROM 		+ DatabaseConstants.TABLE_COMPETITION 
						+ ORDER_BY 	+ DatabaseConstants.KEY_ID_COMPETITION
						+ ASC;
		
		
		try {
			// Establecemos la comunicación entre nuestra aplicación java y la base de datos
			st = connection.createStatement();
			
			 // Le pasamos al objeto de ResultSet el resultado de ejecutar la sentencia "query"
            // Con "executeQuery" realizamos una consulta a la base de datos
			rs = st.executeQuery(sql) ;
			
			// En este bucle vamos recorriendo valores mientras existan
			while(rs.next()){
					String 	id 			= rs.getString(1);
					String 	name		= rs.getString(2);
					String	level 		= rs.getString(3);
					String 	place		= rs.getString(4);
					String 	date		= rs.getString(5);
					
					Competition competition = new Competition(id,name,level,place,date);
					//competition.setYear(year);
					//competition.setCarrer(carrer);
					
					competitionList.add(competition);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				 // Cerramos las conexiones, en orden inverso a su apertura
				try
				{
					rs.close();
				}
				catch (Exception e2)
				{
					// TODO: handle exception
				}
				
				try
				{
					st.close();
				}
				catch (Exception e2)
				{
					// TODO: handle exception
				}
		
			}
		
		return competitionList;
	}

	public TeamCompetitorList buildCompetitionList(String idCompetition) {
		// TODO Auto-generated method stub
		
		Connection connection = conn;
		
		Statement st = null;
		
		ResultSet rs = null;
		
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
		
	
		try {
			// Establecemos la comunicación entre nuestra aplicación java y la base de datos
			st = connection.createStatement();
			
			 // Le pasamos al objeto de ResultSet el resultado de ejecutar la sentencia "query"
            // Con "executeQuery" realizamos una consulta a la base de datos
			rs = st.executeQuery(sql) ;
			
			// En este bucle vamos recorriendo valores mientras existan
			while(rs.next()){
					
					String 	id								= rs.getString(1);
					String	name 					= rs.getString(2);
					String 	incentive				= rs.getString(3);
					String 	performance		= rs.getString(4);
					String 	site							= rs.getString(5);
					String 	school					= rs.getString(6);
					String 	university			= rs.getString(7);
					int		year							= rs.getInt(8);
					
					TeamCompetitor competitor = new TeamCompetitor(id,name,university,school,year, incentive, performance, site);
					//competition.setYear(year);
					//competition.setCarrer(carrer);
					
					teamCompetitorList.add(competitor);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				 // Cerramos las conexiones, en orden inverso a su apertura
				try
				{
					rs.close();
				}
				catch (Exception e2)
				{
					// TODO: handle exception
				}
				
				try
				{
					st.close();
				}
				catch (Exception e2)
				{
					// TODO: handle exception
				}
			
			}
		return teamCompetitorList;
	}

	/**
	 * este metodo colsulta en la base de datso toda la informacion
	 * personal del programador y la devuelve como un estudiante
	 * @param cedulaEstudiante
	 * @return
	 */
	public Student buildStudentByCi(String cedulaEstudiante)
	{
		
		Connection connection = conn;
		
		Statement st = null;
		
		ResultSet rs = null;
		
		Student student = null;
		// TODO Auto-generated method stub
		String sql = "select * from mtn.estudiante AS e \n" +
								"where (e.ci_estudiante = '" + cedulaEstudiante +"');" ;
		
		try {
			// Establecemos la comunicación entre nuestra aplicación java y la base de datos
			st = connection.createStatement();
			
			 // Le pasamos al objeto de ResultSet el resultado de ejecutar la sentencia "query"
            // Con "executeQuery" realizamos una consulta a la base de datos
			rs = st.executeQuery(sql) ;
			
			// En este bucle vamos recorriendo valores mientras existan
			while(rs.next()){
					// extrae la informacion de las columnas al objeto
					String 	ci						= rs.getString(DatabaseConstants.KEY_CI_STUDENTS);
					String	name 			= rs.getString(DatabaseConstants.STUDENT_NAME);
					String 	lastName		= rs.getString(DatabaseConstants.STUDENT_LASTNAME);
					String 	phone			= rs.getString(DatabaseConstants.STUDENT_PHONE);
					String 	email				= rs.getString(DatabaseConstants.STUDENT_EMAIL);
					String 	adress			= rs.getString(DatabaseConstants.STUDENT_ADRESS);
					int year							= rs.getInt(DatabaseConstants.STUDENT_YEAR);
					String carrer				= rs.getString(DatabaseConstants.STUDENT_CARRER);
					
					student = new Student(ci,name,lastName,email, phone, adress,  year, carrer);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				 // Cerramos las conexiones, en orden inverso a su apertura
				try
				{
					rs.close();
				}
				catch (Exception e2)
				{
					// TODO: handle exception
				}
				
				try
				{
					st.close();
				}
				catch (Exception e2)
				{
					// TODO: handle exception
				}
			}
		return student;
	}

	/** 
	 * este metodo actualiza la informacion
	 * del estudiante en la base de datos
	 * @param student
	 * @return
	 */
	public int updateStudent(Student student)
	{
		// TODO Auto-generated method stub
		Connection connection = conn;
		
		PreparedStatement pst = null;
		
		int result = 0;
		
		String sql = "update mtn.estudiante " +
								"set nombre_estudiante = ?, "
								+ "apellido_estudiante = ?,"
								+ "telefono_estudiante = ?, "
								+ "email_estudiante = ?, "
								+ "direccion_estudiante = ?, "
								+ "aÑo_estudiante = ?, "
								+ "carrera = ? "
								+ "where ci_estudiante = ?";
		
		try {
			// Establecemos la comunicación entre nuestra aplicación java y la base de datos
			pst = connection.prepareStatement(sql);
			
			 //  agregamos los datos a prepared statement
			pst.setString(1, student.getName());
			pst.setString(2, student.getLastName());
			pst.setString(3, student.getPhone());
			pst.setString(4, student.getEmail());
			pst.setString(5, student.getAdress());
			pst.setInt(6, student.getYear());
			pst.setString(7, student.getCarrer());
			pst.setString(8, student.getCi());
			
			result = pst.executeUpdate();  //valida si se guardaron los datos; si pst>0 entonces se guardaron
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(sql);
		} finally {
			 // Cerramos las conexiones, en orden inverso a su apertura
			try
			{
				pst.close();
			}
			catch (Exception e2)
			{
				// TODO: handle exception
			}
			
		}
		return result;
	}

	/**
	 * este metodo consulta la informacion personal de los 
	 * viajes del programador
	 * @param ci
	 * @return
	 */
	public TeamCompetitorList buildListTravelFromStudent(String ci)
	{
		// TODO Auto-generated method stub
		
		Connection connection = conn;
		
		Statement st = null;
		
		ResultSet rs = null;
		
		TeamCompetitorList  competitorList = new TeamCompetitorList();
		
		String sql = "select v.id_equipo, v.dias, v.financista, v.hospedaje "
				+ "from mtn.estudiante as e "
				+ "join mtn.constituye_estudiante as ce on e.ci_estudiante = ce.ci_estudiante "
				+ "join mtn.viaja  as v on v.id_equipo = ce.id_equipo "
				+ "where e.ci_estudiante = '" + ci + "';" ;
		
		try {
			// Establecemos la comunicación entre nuestra aplicación java y la base de datos
			st = connection.createStatement();
			
			 // Le pasamos al objeto de ResultSet el resultado de ejecutar la sentencia "query"
            // Con "executeQuery" realizamos una consulta a la base de datos
			rs = st.executeQuery(sql) ;
			
			// En este bucle vamos recorriendo valores mientras existan
			while(rs.next()){
					// extrae la informacion de las columnas al objeto
					String id_equipo 		= rs.getString(DatabaseConstants.KEY_ID_TEAM);
					int 	dias						= rs.getInt(DatabaseConstants.TRAVEL_DAYS);
					String	financista 	= rs.getString(DatabaseConstants.TRAVEL_FINANCER);
					String 	hospedaje	= rs.getString(DatabaseConstants.TRAVEL_HOSTAGE);
					TeamCompetitor  teamCompetitor = new TeamCompetitor(id_equipo,dias, financista, hospedaje);
					competitorList.add(teamCompetitor);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(sql);
			} finally {
				 // Cerramos las conexiones, en orden inverso a su apertura
				try
				{
					rs.close();
				}
				catch (Exception e2)
				{
					// TODO: handle exception
				}
				
				try
				{
					st.close();
				}
				catch (Exception e2)
				{
					// TODO: handle exception
				}
			}
		return competitorList;
	}

	/**
	 * este metodo se encarga de actualizar los viajes del programador
	 * en la base de datos
	 * @param teamCompetitor
	 * @return
	 */
	public int updateTravel(TeamCompetitor teamCompetitor)
	{
		// TODO Auto-generated method stub
				Connection connection = conn;
				
				PreparedStatement pst = null;
				
				int result = 0;
				
				String sql = "update mtn.viaja " +
										"set dias = ?, "
										+ "financista = ?,"
										+ "hospedaje = ? "
										+ "where id_equipo = ?";
				
				try {
					// Establecemos la comunicación entre nuestra aplicación java y la base de datos
					pst = connection.prepareStatement(sql);
					
					 //  agregamos los datos a prepared statement
					pst.setInt(1, teamCompetitor.getDaysTravel());
					pst.setString(2, teamCompetitor.getFinancier());
					pst.setString(3, teamCompetitor.getHosting());
					pst.setString(4, teamCompetitor.getId());
					
					result = pst.executeUpdate();  //valida si se guardaron los datos; si pst>0 entonces se guardaron
						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(sql);
				} finally {
					 // Cerramos las conexiones, en orden inverso a su apertura
					try
					{
						pst.close();
					}
					catch (Exception e2)
					{
						// TODO: handle exception
					}
					
				}
				return result;
	}

	/**
	 * este metodo construye un table model con la data de
	 * la consulta 1
	 * @return
	 */
	public TableModel buildTableModelConsulta1()
	{
		// TODO Auto-generated method stub
		
		Connection connection = conn;
		
		Statement st = null;
		
		ResultSet rs = null;
		
		TableModel  tableModel = null;
		
		String sql = "SELECT  distinct "
				+ "PARTICIPACIONES, "
				+ "NOMBRE, "
				+ "CI, "
				+ "DIRECCION "
				+ "FROM    (SELECT RANK() OVER( ORDER BY PARTICIPACIONES DESC) AS RANKING, "
				+ "PARTICIPACIONES, "
				+ "NOMBRE, "
				+ "CI, "
				+ "DIRECCION "
				+ "FROM    (SELECT e.nombre_estudiante AS NOMBRE, "
				+ "e.ci_estudiante         AS CI, "
				+ "e.direccion_estudiante  AS DIRECCION, "
				+ "COUNT (e.ci_estudiante) OVER (PARTITION BY e.ci_estudiante) AS PARTICIPACIONES "
				+ "FROM    mtn.estudiante                  AS e "
				+ "JOIN mtn.constituye_estudiante  AS ce   ON e.ci_estudiante  = ce.ci_estudiante "
				+ "JOIN mtn.equipo                 AS eq   ON eq.id_equipo     = ce.id_equipo "
				+ "JOIN mtn.participa              AS p    ON p.id_equipo      = eq.id_equipo "
				+ "WHERE  eq.facultad IN ('FACYT-EC-UC') "
				+ "ORDER BY PARTICIPACIONES DESC) FINAL "
				+ ") FINAL2 "
				+ "WHERE RANKING = 1;" ;
		
		try {
			// Establecemos la comunicación entre nuestra aplicación java y la base de datos
			st = connection.createStatement();
			
			 // Le pasamos al objeto de ResultSet el resultado de ejecutar la sentencia "query"
            // Con "executeQuery" realizamos una consulta a la base de datos
			rs = st.executeQuery(sql) ;
				// convierte el resultset a table model
			tableModel = DbUtils.resultSetToTableModel(rs);
			DbUtils.resultSetToTableModel(rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(sql);
			} finally {
				 // Cerramos las conexiones, en orden inverso a su apertura
				try
				{
					rs.close();
				}
				catch (Exception e2)
				{
					// TODO: handle exception
				}
				
				try
				{
					st.close();
				}
				catch (Exception e2)
				{
					// TODO: handle exception
				}
			}
		return tableModel;
	}

	/**
	 * este metodo construye un table model con la data de
	 * la consulta 2
	 * @return
	 */
	public TableModel buildTableModelConsulta2()
	{
Connection connection = conn;
		
		Statement st = null;
		
		ResultSet rs = null;
		
		TableModel  tableModel = null;
		
		String sql = "SELECT  co.nombre_competencia as COMPETENCIA, "
				+ "pro.titulo as PROBLEMA, "
				+ "eq.nombre_equipo as EQUIPO, "
				+ "e.nombre_estudiante AS Estudiante, "
				+ "e.ci_estudiante "
				+ "FROM    (SELECT ID_COMPETENCIA, "
				+ "ID_EQUIPO, "
				+ "ID_PROBLEMA "
				+ "FROM    (SELECT RANK() OVER(PARTITION BY ID_COMPETENCIA ORDER BY CUENTA DESC) AS RANK, "
				+ "ID_COMPETENCIA, "
				+ "ID_EQUIPO, "
				+ "ID_PROBLEMA, "
				+ "CUENTA "
				+ "FROM    (SELECT re.id_equipo        AS ID_EQUIPO, "
				+ "re.id_problema      AS ID_PROBLEMA, "
				+ "pr.id_competencia   AS ID_COMPETENCIA, "
				+ "COUNT (re.id_problema) OVER (PARTITION BY re.id_problema) AS CUENTA "
				+ "FROM    mtn.resuelve AS re "
				+ "JOIN mtn.propone    AS pr ON re.id_problema = pr.id_problema "
				+ "ORDER BY CUENTA DESC) AS A "
				+ ") AS B "
				+ "WHERE RANK = 1 "
				+ "order by ID_COMPETENCIA "
				+ ") AS C "
				+ "JOIN mtn.equipo AS eq ON eq.id_equipo = C.ID_EQUIPO "
				+ "JOIN mtn.problema as pro On pro.id_problema = C.ID_PROBLEMA "
				+ "JOIN mtn.competencia as co on co.id_competencia = C.ID_COMPETENCIA "
				+ "JOIN mtn.constituye_estudiante AS ce ON ce.id_equipo = eq.id_equipo "
				+ "JOIN mtn.estudiante AS e ON e.ci_estudiante = ce.ci_estudiante;" ;
		
		try {
			// Establecemos la comunicación entre nuestra aplicación java y la base de datos
			st = connection.createStatement();
			
			 // Le pasamos al objeto de ResultSet el resultado de ejecutar la sentencia "query"
            // Con "executeQuery" realizamos una consulta a la base de datos
			rs = st.executeQuery(sql) ;
				// convierte el resultset a table model
			tableModel = DbUtils.resultSetToTableModel(rs);
			DbUtils.resultSetToTableModel(rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(sql);
			} finally {
				 // Cerramos las conexiones, en orden inverso a su apertura
				try
				{
					rs.close();
				}
				catch (Exception e2)
				{
					// TODO: handle exception
				}
				
				try
				{
					st.close();
				}
				catch (Exception e2)
				{
					// TODO: handle exception
				}
			}
		return tableModel;
	}

	/**
	 * este metodo construye un table model con la data de
	 * la consulta 3
	 * @return
	 */
	public TableModel buildTableModelConsulta3()
	{
		// TODO Auto-generated method stub
Connection connection = conn;
		
		Statement st = null;
		
		ResultSet rs = null;
		
		TableModel  tableModel = null;
		
		String sql = "SELECT  prof.ci_profesor	  	as CEDULA, "
				+ "prof.nombre_profesor  	AS Nombre, "
				+ "prof.apellido_profesor	as Apellido "
				+ "FROM    mtn.profesor  	  		AS prof "
				+ "WHERE   prof.tipo_profesor = 'Tecnico'  "
				+ "AND prof.ci_profesor  "
				+ "IN (select ci "
				+ "from mtn.constituye_estudiante as ce "
				+ "join  (SELECT e.ci_estudiante as ci "
				+ "FROM  mtn.estudiante AS  e "
				+ "JOIN  (SELECT DISTINCT  "
				+ "pra.ci_profesor "
				+ "FROM    mtn.prepara_a  AS pra "
				+ "JOIN  (SELECT DISTINCT "
				+ "eq.id_equipo "
				+ "FROM    mtn.equipo  AS eq "
				+ "JOIN  mtn.participa AS pat ON  eq.id_equipo  = pat.id_equipo "
				+ ") AS a "
				+ "ON a.id_equipo = pra.id_equipo "
				+ ") AS b "
				+ "ON  b.ci_profesor = e.ci_estudiante  "
				+ ") as c "
				+ "on c.ci = ce.ci_estudiante "
				+ ");" ;
		
		try {
			// Establecemos la comunicación entre nuestra aplicación java y la base de datos
			st = connection.createStatement();
			
			 // Le pasamos al objeto de ResultSet el resultado de ejecutar la sentencia "query"
            // Con "executeQuery" realizamos una consulta a la base de datos
			rs = st.executeQuery(sql) ;
				// convierte el resultset a table model
			tableModel = DbUtils.resultSetToTableModel(rs);
			DbUtils.resultSetToTableModel(rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(sql);
			} finally {
				 // Cerramos las conexiones, en orden inverso a su apertura
				try
				{
					rs.close();
				}
				catch (Exception e2)
				{
					// TODO: handle exception
				}
				
				try
				{
					st.close();
				}
				catch (Exception e2)
				{
					// TODO: handle exception
				}
			}
		return tableModel;
	}

}

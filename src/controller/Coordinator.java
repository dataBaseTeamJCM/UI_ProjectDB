package controller;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import org.eclipse.jface.viewers.ViewerDropAdapter;

import db.Conexion;
import db.DatabaseConstants;
import db.DatabaseQueries;
import model.Competition;
import model.CompetitionList;
import model.Student;
import model.StudentList;
import model.TeamCompetitor;
import model.TeamCompetitorList;
import net.proteanit.sql.DbUtils;
import resources.values.Strings;
import views.*;

public class Coordinator {
	

	//private	ViewPrincipal myWindowPrincipal;
	private ViewLogin myWindowLogin;
	private ViewCoordinador myWindowQueryCoordinator;
	private ViewProgrammer myWindowQueryProgrammer;
	private ViewAd myViewAd;
	private SearchByCi	mySearchByCi;
	private ViewProgrammerForm myProgrammerForm;
	private Connection conect;
	//private Conexion conn;
	
	// getters y setters de las ventanas
	
	public Coordinator(){
		this.myWindowLogin = new ViewLogin(this);
		showWindowLogin();
	}
	public Connection getConect() {
		return conect;
	}

	public void setConect(Connection conect) {
		this.conect = conect;
	}

	public ViewLogin getMyWindowLogin() {
		return myWindowLogin;
	}
	public void setMyWindowLogin(ViewLogin myWindowLogin) {
		this.myWindowLogin = myWindowLogin;
	}

	public void setMyWindowQueryCoordinator(ViewCoordinador myWindowQueryCoordinator) {
		this.myWindowQueryCoordinator = myWindowQueryCoordinator;
	}
	
	public ViewCoordinador getMyWindowQueryCoordinator() {
		return myWindowQueryCoordinator;
	}

	public ViewProgrammer getMyWindowQueryProgrammer() {
		return myWindowQueryProgrammer;
	}
	public void setMyWindowQueryProgrammer(ViewProgrammer myWindowQueryProgrammer) {
		this.myWindowQueryProgrammer = myWindowQueryProgrammer;
	}
	
	public SearchByCi getMySearchByCi() {
		return mySearchByCi;
	}

	public void setMySearchByCi(SearchByCi mySearchByCi) {
		this.mySearchByCi = mySearchByCi;
	}
	/*metodos para mostrar y cerrar las ventanas*/
	
	
	public void showWindowSearch(){
		mySearchByCi.setVisible(true);
	}
	
	public void hideWindowSearch(){
		mySearchByCi.dispose();
	}

	public void showWindowLogin(){
		myWindowLogin.setVisible(true);
	}
	
	public void hideWindowLogin(){
		myWindowLogin.dispose();
	}
	
	public void showWindowQueryCoordinator(){
		myWindowQueryCoordinator.setVisible(true);
	}
	
	public void hideWindowQueryCoordinator(){
		myWindowQueryCoordinator.dispose();
	}
	
	public void showWindowQueryProgrammer(){
		myWindowQueryProgrammer.setVisible(true);
	}
	
	public void hideWindowQueryProgrammer(){
		myWindowQueryProgrammer.dispose();
	}
	
	/**
	 * Este metodo cierra la ventana de aviso
	 */
	public void hideWindowAd()
	{
		myViewAd.dispose();
		// TODO Auto-generated method stub
	}
	
	/**
	 * metodo que invoca una ventana de programador nueva
	 * @param name
	 */
	public void invokerWindowProgrammer(String name){
		this.setMyWindowQueryProgrammer(new ViewProgrammer(this));
		this.getMyWindowQueryProgrammer().setTitle("Hola " + name);
		this.showWindowQueryProgrammer();
	}
	
	public void invokerWindowCoordinator(String name){
		setMyWindowQueryCoordinator(new ViewCoordinador(this));
		getMyWindowQueryCoordinator().setTitle("Hola "+ name);
		
		
		//-- prueba---
		
		//StudentList studentList = listAllStudents();
		CompetitionList competitionList = listAllCompetitions(); 
		JTree jTree = buildJTree(competitionList);
		//DefaultListModel<String> defaultListModel = studentList.toListModel();
		//JList<String> jList = new JList<>(defaultListModel);
		//jTree.setR(jList);
		myWindowQueryCoordinator.getScrollPaneJtree().setViewportView(jTree);
		//---end prueba---
		this.showWindowQueryCoordinator();
	}
	
	private CompetitionList listAllCompetitions() {
		// TODO Auto-generated method stub
		Conexion conn = new Conexion(this.getConect());
		//String sql;
		DatabaseQueries queries = new DatabaseQueries(conn);
		CompetitionList competitionList;
		
		competitionList = queries.buildCompetitionList();
		
		return competitionList;
		
	}

	// construye en Jtree principal con la lista de competencias
	private JTree buildJTree(CompetitionList competitionList) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(DatabaseConstants.DATABASE_NAME);
		
		
		
		for (Competition competition : competitionList) {
			String name 			= competition.getName() +" "+ competition.getDate();
			String idCompetition	= competition.getId();
			DefaultMutableTreeNode competitionNode 	= new DefaultMutableTreeNode(name);
			DefaultMutableTreeNode teamNode 		= new DefaultMutableTreeNode(Strings.TEAMS);
			DefaultMutableTreeNode problemNode		= new DefaultMutableTreeNode(Strings.PROBLEMS);
			DefaultMutableTreeNode activityNode		= new DefaultMutableTreeNode(Strings.ACTIVITYS);

			TeamCompetitorList competitorList = listAllTeamsByCompetition(idCompetition);
			for (TeamCompetitor teamCompetitor : competitorList) {
				String nameTeam 	= teamCompetitor.getName() + " " + teamCompetitor.getSchool();
				DefaultMutableTreeNode subTeamNode = new DefaultMutableTreeNode(nameTeam);
				teamNode.add(subTeamNode);
			}
			competitionNode.add(teamNode);
			competitionNode.add(problemNode);
			competitionNode.add(activityNode);
		
			root.add(competitionNode);
		}
		
		
		
		JTree jTree = new JTree(root);
		return jTree;
	}

	private TeamCompetitorList listAllTeamsByCompetition(String idCompetition) {
		// TODO Auto-generated method stub
		Conexion conn = new Conexion(this.getConect());
		//String sql;
		DatabaseQueries queries = new DatabaseQueries(conn);
		TeamCompetitorList teamCompetitorList;
		
		teamCompetitorList = queries.buildCompetitionList(idCompetition);
		
		return teamCompetitorList;
	}

	// contruye el jTree principal con la lsita de estudiantes
	private JTree buildJTree(StudentList studentList) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(DatabaseConstants.DATABASE_NAME);
		
		for (Student student : studentList) {
			String name = student.getName() +" "+ student.getLastName();
			DefaultMutableTreeNode studentNode = new DefaultMutableTreeNode(name);
			root.add(studentNode);
		}
		JTree jTree = new JTree(root);
		return jTree;
	}

	public void invokerWindowLogin(){
		this.setMyWindowLogin(new ViewLogin(this));
		this.showWindowLogin();
	}
	
	public void invokerWindowSearch(){
		this.setMySearchByCi(new SearchByCi(this));
		this.showWindowSearch();
	}
	
	/**
	 *  Esta funcion se encarga de controlar el inicio de los usuarios 
	 *  a la bd para los usuarios coordinador y programador
	 */
	public void connect(String userName, char[] password){
		this.conect = (new Conexion (userName,password)).Conectar();
		
		if(this.getConect() == null)
		{	
			
			/*
			 *  Invocar ventana de aviso para indicar que se ingreso un
			 *  usuario o una contraseña incorrecta.
			 */
			
			this.myViewAd = new ViewAd(Strings.INVALID_USER, this);
			System.out.println("Usuario y "
					+ "Contraseña invalidos");
		}
		
		else
		{
			System.out.println(userName);
			if(userName.equals("coordinador"))
			{
				invokerWindowCoordinator(userName);	
				System.out.println("Conexion exitosa");
				//invokerWindowCoordinator(userName);
				hideWindowLogin();
				
			}
			else if(userName.equals("programador"))
			{
				System.out.println("Conexion exitosa");
				invokerWindowProgrammer(userName);
				hideWindowLogin();
			}
		}
	}
	
	// metodos para obtener datos de la bd y actualizarlos
	
	public StudentList listAllStudents(){
		Conexion conn = new Conexion(this.getConect());
		//String sql;
		DatabaseQueries queries = new DatabaseQueries(conn);
		StudentList studentList;
		
		studentList = queries.buildStudentList();
		
		return studentList;
		//studentList.print();
		//sql = ModelStudent.queryAllEstudents();
		//conn.createQuery(sql);
		//return (new JTable(DbUtils.resultSetToTableModel(conn.getRs())));
	}
	
/*	public void anStudent(String ci){
		Conexion conn = new Conexion(this.getConect());
		String sql;
		//String carrer;
		int year;
		
		sql = ModelStudent.queryAnStudentByCi(ci);
		conn.createQuery(sql);
		try {
			if(conn.getRs().next()){
					year = Integer.parseInt(conn.getRs().getString(2));
					this.setStudent(new ModelStudent(ci, year, "no"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/
	//metodos para validaciones campos de texto etc
	public void onlyNumbers(JTextField text){
		text.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e){
				char c = e.getKeyChar();
				if(Character.isLetter(c)){
					e.consume();
				}
			}
		
		});
	}
	
	/**
	 * este metodo busca la informacion de un estudiante 
	 * por su cedula de identidad
	 */
	public void SearchStudentByCi()
	{
		// TODO Auto-generated method stub
		Student student = null;
		String cedulaEstudiante = mySearchByCi.getTextFieldCi().getText();
		
		student = getStudentByCi(cedulaEstudiante);
		
		if(student != null)
		{
			// procesamiento de datos del estudiante
			myProgrammerForm  = new ViewProgrammerForm(this, student.getName());
			System.out.println( student.toString());
		}else{
			myViewAd = new ViewAd(Strings.CI_NO_EXISTS, this);
		}
	}
	/**
	 * este metodo obtiene la informacion del estudiante en un objeto
	 * de tipo estudiante
	 * @param cedulaEstudiante
	 * @return
	 */
	private Student getStudentByCi(String cedulaEstudiante)
	{
		// TODO Auto-generated method stub
		Student student = null;
		Conexion conn = new Conexion(this.getConect());
		DatabaseQueries queries = new DatabaseQueries(conn);
		student = queries.buildStudentByCi(cedulaEstudiante);
		return student;
	}

}

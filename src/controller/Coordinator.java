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
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
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
import resources.values.Events;
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
	private int varEvent = -1;
	//private Conexion conn;
	private DialogCheckSave myDialogCheckSave = null;
	
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
	
	public void showWindowCheckSave()
	{
		// TODO Auto-generated method stub
		myDialogCheckSave.setVisible(true);
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
	 * Este metodo se encarga de cerrar la ventana de
	 * formulario del programador
	 */
	public void hideWindowProgrammerForm()
	{
		// TODO Auto-generated method stub
		myProgrammerForm.dispose();
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
	

	public void invokerWindowLogin(){
		this.setMyWindowLogin(new ViewLogin(this));
		this.showWindowLogin();
	}
	
	public void invokerWindowSearch(){
		this.setMySearchByCi(new SearchByCi(this));
		this.showWindowSearch();
	}
	
	public void invokerWindowCheckSave()
	{
		// TODO Auto-generated method stub
		if(myDialogCheckSave ==null)
			myDialogCheckSave = new DialogCheckSave(this);
		else
			myDialogCheckSave.setVisible(true);
	}
	
	private CompetitionList listAllCompetitions() {
		// TODO Auto-generated method stub
		Conexion conn = new Conexion(this.getConect());
		//String sql;
		//DatabaseQueries queries = new DatabaseQueries(conn);
		CompetitionList competitionList = null;
		
		//competitionList = queries.buildCompetitionList();
		
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
		//DatabaseQueries queries = new DatabaseQueries(conn);
		TeamCompetitorList teamCompetitorList = null;
		
		//teamCompetitorList = queries.buildCompetitionList(idCompetition);
		
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
		//atabaseQueries queries = new DatabaseQueries(conn);
		StudentList studentList = null;
		
		//studentList = queries.buildStudentList();
		
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
			hideWindowSearch();
			// procesamiento de datos del estudiante
			// invocacion de la ventana de formulario del programador
			myProgrammerForm  = new ViewProgrammerForm(this, student.getName());
			String ci 						= student.getCi();
			String name 				= student.getName();
			String lastName 		= student.getLastName();
			String phone				= student.getPhone();
			String email				= student.getEmail();
			String adress				= student.getAdress();
			int year							= student.getYear();
			String carrer				= student.getCarrer();
			
			myProgrammerForm.getTextFieldCi().setText(ci);
			myProgrammerForm.getTextFieldName().setText(name);
			myProgrammerForm.getTextFieldLastName().setText(lastName);
			myProgrammerForm.getTextFieldPhone().setText(phone);
			myProgrammerForm.getTextFieldEmail().setText(email);
			myProgrammerForm.getTextFieldAdress().setText(adress);
			myProgrammerForm.getSpinnerYear().setValue(year);
			myProgrammerForm.getTextFieldCarrer().setText(carrer);
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
		DatabaseQueries queries = new DatabaseQueries(conect);
		student = queries.buildStudentByCi(cedulaEstudiante);
		return student;
	}
	
	/**
	 * este metodo cierra la conexion con la base de datos
	 */
	public void closeConnect()
	{
		// TODO Auto-generated method stub
		try
		{
			conect.close();
			System.out.println("Conexion Cerrada");
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * este metodo se encarga de manejar el evento de 
	 * boton de edicion en el formulario del programador
	 */
	public void editToggleFormProgrammer()
	{
		// TODO Auto-generated method stub
		if(myProgrammerForm.getTglbtnEdit().isSelected())
			setEnableFieldsFormProgrammer(true);
		else
			setEnableFieldsFormProgrammer(false);
	}
	/**
	 * este metodo se encarga de activar o desactivar
	 * los campos del formulario del programador
	 * @param b
	 */
	private void setEnableFieldsFormProgrammer(boolean b)
	{
		// TODO Auto-generated method stub
		myProgrammerForm.getTextFieldName().setEditable(b);
		myProgrammerForm.getTextFieldAdress().setEditable(b);
		myProgrammerForm.getTextFieldLastName().setEditable(b);
		myProgrammerForm.getTextFieldEmail().setEditable(b);
		myProgrammerForm.getTextFieldPhone().setEditable(b);
		myProgrammerForm.getTextFieldCarrer().setEditable(b);
		myProgrammerForm.getSpinnerYear().setEnabled(b);
		myProgrammerForm.getBtnSave().setEnabled(b);
	}
	
	/**
	 * este metodo se encarga de controlar el evento
	 * creado por el boton no de la ventana de confirmacion
	 */
	public void EventNot()
	{
		// TODO Auto-generated method stub
		switch (varEvent )
		{
			case Events.I_PERSONAL:
				/*
				 * cierra la ventana de de dialogo y
				 * muestra la ventana anterior del
				 * formulario del programador 
				 */
				myDialogCheckSave.dispose();
				break;

			default:
				break;
		}
	}
	/**
	 *  este metodo se encargar de controlar el evento creado 
	 *  por el boton yes de la ventana de confirmacion
	 */
	public void EventYes()
	{
		// TODO Auto-generated method stub
		switch (varEvent)
		{
			case Events.I_PERSONAL:
				saveDataStudent();
				break;

			default:
				break;
		}
	}
	
	/**
	 * este metodo se encarga de guardar la informacion del 
	 * estudiante en la base de datos
	 */
	private void saveDataStudent()
	{
		// TODO Auto-generated method stub
		int result;
		DatabaseQueries databaseQueries = new DatabaseQueries(conect);
		SpinnerModel numberModel = myProgrammerForm.getSpinnerYear().getModel();
		Student student;
		String ci 						= myProgrammerForm.getTextFieldCi().getText();
		String name 				= myProgrammerForm.getTextFieldName().getText();
		String lastName 		= myProgrammerForm.getTextFieldLastName().getText();
		String phone				= myProgrammerForm.getTextFieldPhone().getText();	
		String email				= myProgrammerForm.getTextFieldEmail().getText();
		String adress				= myProgrammerForm.getTextFieldAdress().getText();
		int year							= (int) numberModel.getValue();
		String carrer				= myProgrammerForm.getTextFieldCarrer().getText();
	
		student = new Student(ci, name, lastName, email, phone, adress, year, carrer);
		
		result = databaseQueries.updateStudent(student);
		
		if(result > 0){
			// ventana de guardado satisfactorio
			System.out.println("actualizacion correcta");
		}else{
			// ventana de guardado incorrecto
			System.out.println("actualizacion incorrecta");
		}
	}
	/**
	 * este metodo modifica la variable global
	 * var event que es importante para 
	 * las operaciones de las acciones 
	 * @param iPersonal
	 */
	public void setVarEvent(int event)
	{
		varEvent = event;
		// TODO Auto-generated method stub
		
	}
	
	


}

package controller;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import db.Conexion;
import db.DatabaseQueries;
import model.StudentList;
import net.proteanit.sql.DbUtils;
import views.*;

public class Coordinator {
	private	WindowPrincipal myWindowPrincipal;
	private Login myWindowLogin;
	private WindowQueryCoordinator myWindowQueryCoordinator;
	private WinQueryProgrammer myWindowQueryProgrammer;
	private SearchByCi	mySearchByCi;
	private Connection conect;
	//private Conexion conn;
	
	// getters y setters de las ventanas
	
	
	public Connection getConect() {
		return conect;
	}

	public void setConect(Connection conect) {
		this.conect = conect;
	}

	public WindowPrincipal getMyWindowPrincipal() {
		return myWindowPrincipal;
	}
	public void setMyWindowPrincipal(WindowPrincipal myWindowPrincipal) {
		this.myWindowPrincipal = myWindowPrincipal;
	}
	public Login getMyWindowLogin() {
		return myWindowLogin;
	}
	public void setMyWindowLogin(Login myWindowLogin) {
		this.myWindowLogin = myWindowLogin;
	}

	public void setMyWindowQueryCoordinator(WindowQueryCoordinator myWindowQueryCoordinator) {
		this.myWindowQueryCoordinator = myWindowQueryCoordinator;
	}
	
	public WindowQueryCoordinator getMyWindowQueryCoordinator() {
		return myWindowQueryCoordinator;
	}

	public WinQueryProgrammer getMyWindowQueryProgrammer() {
		return myWindowQueryProgrammer;
	}
	public void setMyWindowQueryProgrammer(WinQueryProgrammer myWindowQueryProgrammer) {
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
	
	public void showWindowPrincipal(){
		myWindowPrincipal.setVisible(true);
	}
	
	public void hideWindowPrincipal(){
		myWindowPrincipal.dispose();
	}
	
	//** metodos para invokar ventanas desde otras ventanas
	public void invokerWindowProgrammer(String name){
		this.setMyWindowQueryProgrammer(new WinQueryProgrammer(this));
		this.getMyWindowQueryProgrammer().setTitle("Hola " + name);
		this.showWindowQueryProgrammer();
	}
	
	public void invokerWindowCoordinator(String name){
		this.setMyWindowQueryCoordinator(new WindowQueryCoordinator(this));
		this.getMyWindowQueryCoordinator().setTitle("Hola "+ name);
		this.showWindowQueryCoordinator();
	}
	
	public void invokerWindowLogin(){
		this.setMyWindowLogin(new Login(this));
		this.showWindowLogin();
	}
	
	public void invokerWindowSearch(){
		this.setMySearchByCi(new SearchByCi(this));
		this.showWindowSearch();
	}
	
	
	public void connect(String userName, char[] password){
		this.conect = (new Conexion (userName,password)).Conectar();
		
		if(this.getConect() == null)
		{	
			/*
			 * lblError.setVisible(true);
			 */
			System.out.println("Usuario y "
					+ "Contraseña invalidos");
		}
		
		else
		{
			System.out.println(userName);
			if(userName.equals("coordinador"))
			{
				listAllStudents(); // prueba de la base de datos
				System.out.println("Conexion exitosa");
				//invokerWindowCoordinator(userName);
				//hideWindowLogin();
				
			}
			else if(userName.equals("programador"))
			{
				System.out.println("Conexion exitosa");
				//invokerWindowProgrammer(userName);
				//hideWindowLogin();
			}
		}
	}
	
	// metodos para obtener datos de la bd y actualizarlos
	
	public void listAllStudents(){
		Conexion conn = new Conexion(this.getConect());
		//String sql;
		DatabaseQueries queries = new DatabaseQueries(conn);
		StudentList studentList;
		
		studentList = queries.buildStudentList();
		studentList.print();
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
}

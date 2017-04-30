package controller;
import java.sql.Connection;

import javax.swing.JTable;

import model.ModelTableEstudiante;
import model.connection.Conexion;
import net.proteanit.sql.DbUtils;
import views.*;

public class Coordinator {
	private	WindowPrincipal myWindowPrincipal;
	private Login myWindowLogin;
	private WindowQueryCoordinator myWindowQueryCoordinator;
	private WinQueryProgrammer myWindowQueryProgrammer;
	private SearchByCi	mySearchByCi;
	private ModelTableEstudiante members;
	private Connection conect;
	//private Conexion conn;
	
	// getters y setters de las ventanas
	
	public void connect(String userName, char[] password){
		this.conect = (new Conexion (userName,password)).Conectar();
	}
	
	public ModelTableEstudiante getMembers() {
		return members;
	}

	public void setMembers(ModelTableEstudiante members) {
		this.members = members;
	}

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
	
	// metodos para obtener datos de la bd y actualizarlos
	
	public JTable listMembers(){
		Conexion conn = new Conexion(this.getConect());
		String sql;
		this.setMembers(new ModelTableEstudiante(this));
		sql = this.getMembers().queryAllEstudents();
		conn.createQuery(sql);
		return (new JTable(DbUtils.resultSetToTableModel(conn.getRs())));
	}
	
	/*public JTable listStudents(){
		
		this.setMembers(new ModelTableIntegrate(this));
		this.getMembers().showListStudents();
		return (this.getMembers().getJtable());
	}*/
}

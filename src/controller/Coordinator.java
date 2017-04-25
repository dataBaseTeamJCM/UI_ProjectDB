package controller;
import java.sql.Connection;

import javax.swing.JTable;

import model.MembersRegister;
import model.connection.Conexion;
import views.*;

public class Coordinator {
	private	WindowPrincipal myWindowPrincipal;
	private Login myWindowLogin;
	private WindowQueryCoordinator myWindowQueryCoordinator;
	private WindowQueryProgrammer myWindowQueryProgrammer;
	private MembersRegister members;
	private Connection conect;
	
	// getters y setters de las ventanas
	
	public void connect(String userName, char[] password){
		this.conect = (new Conexion (userName,password)).Conectar();
	}
	
	public MembersRegister getMembers() {
		return members;
	}

	public void setMembers(MembersRegister members) {
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

	public WindowQueryProgrammer getMyWindowQueryProgrammer() {
		return myWindowQueryProgrammer;
	}
	public void setMyWindowQueryProgrammer(WindowQueryProgrammer myWindowQueryProgrammer) {
		this.myWindowQueryProgrammer = myWindowQueryProgrammer;
	}
	

	/*metodos para mostrar y cerrar las ventanas*/
	
	
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
		this.setMyWindowQueryProgrammer(new WindowQueryProgrammer(this));
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
	
	// metodos para obtener datos de la bd y actualizarlos
	
	public JTable listMembers(){
		this.setMembers(new MembersRegister(this));
		this.getMembers().showListMembers();
		return (this.getMembers().getJtable());
	}
}

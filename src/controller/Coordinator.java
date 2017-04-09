package controller;
import views.*;

public class Coordinator {
	private	WindowPrincipal myWindowPrincipal;
	private Login myWindowLogin;
	private WindowQuery myWindowQuery;
	
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
	public WindowQuery getMyWindowQuery() {
		return myWindowQuery;
	}
	public void setMyWindowQuery(WindowQuery myWindowQuery) {
		this.myWindowQuery = myWindowQuery;
	}
	
	/*metodos para mostrar las ventanas*/
	
	public void showWindowLogin(){
		myWindowLogin.setVisible(true);
	}
	
	public void showWindowQuery(){
		myWindowQuery.setVisible(true);
	}
	
	
	

}

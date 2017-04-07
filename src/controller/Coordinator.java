package controller;
import views.*;

public class Coordinator {
	private	WindowPrincipal myWindowPrincipal;
	private Login myWindowLogin;
	
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
	
	/*metodos para mostrar las ventanas*/
	
	public void showWindowLogin(){
		myWindowLogin.setVisible(true);
	}
	
	

}

package controller;

import java.awt.EventQueue;
import javax.swing.UIManager;

import views.Login;
import views.WindowPrincipal;

class Principal{

		Login myWindowLogin;
		WindowPrincipal myWindowPrincipal;
		Coordinator myCoordinator;
		
		public static void main(String[] args){
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				Principal myPrincipal= new Principal();
				myPrincipal.init();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		private void init()
		{
			/*se instancian las clases
			 */
			myWindowPrincipal = new WindowPrincipal();
			myWindowLogin = new Login();
			myCoordinator = new Coordinator();
			
			/*
			 * se establecen las relaciones con las clases
			 */
			myWindowPrincipal.setCoordinator(myCoordinator);
			myWindowLogin.setCoordinator(myCoordinator);
			
			
			/*
			 * Se establecen relaciones con la clase coordinador
			 */
			
			myCoordinator.setMyWindowPrincipal(myWindowPrincipal);
			myCoordinator.setMyWindowLogin(myWindowLogin);
			
			myWindowPrincipal.setVisible(true);
		}
}
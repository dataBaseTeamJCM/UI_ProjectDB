package controller;

import java.awt.EventQueue;
import javax.swing.UIManager;

import views.Login;
import views.WindowPrincipal;
import views.WindowQuery;

class Principal{

		Login myWindowLogin;
		WindowPrincipal myWindowPrincipal;
		WindowQuery myWindowQuery;
		Coordinator myCoordinator;
		
		public static void main(String[] args){
			EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						Principal myPrincipal= new Principal();
						myPrincipal.init();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		private void init()
		{
			/*se instancian las clases
			 */
			myWindowPrincipal = new WindowPrincipal();
			myWindowLogin = new Login();
			myCoordinator = new Coordinator();
			myWindowQuery = new WindowQuery();
			
			/*
			 * se establecen las relaciones con las clases
			 */
			myWindowPrincipal.setCoordinator(myCoordinator);
			myWindowLogin.setCoordinator(myCoordinator);
			myWindowQuery.setCoordinator(myCoordinator);
			
			
			/*
			 * Se establecen relaciones con la clase coordinador
			 */
			
			myCoordinator.setMyWindowPrincipal(myWindowPrincipal);
			myCoordinator.setMyWindowLogin(myWindowLogin);
			myCoordinator.setMyWindowQuery(myWindowQuery);
			
			myWindowPrincipal.setVisible(true);
		}
}
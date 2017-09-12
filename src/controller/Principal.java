package controller;

import java.awt.EventQueue;
import javax.swing.UIManager;

import views.ViewLogin;
import views.ViewPrincipal;
import views.ViewCoordinador;

class Principal{

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
			myCoordinator = new Coordinator();
			//myCoordinator.setMyWindowPrincipal(new ViewPrincipal(myCoordinator));
			//myCoordinator.showWindowPrincipal();
			
		}
}
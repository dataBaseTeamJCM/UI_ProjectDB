package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Coordinator;

import javax.swing.JButton;

public class WindowQueryProgrammer extends JFrame implements ActionListener {

	private JButton btnSalir, btnConsultar, btnInsertar;
	private Coordinator myCoordinator;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public WindowQueryProgrammer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(93, 155, 117, 25);
		getContentPane().add(btnConsultar);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(242, 155, 117, 25);
		getContentPane().add(btnInsertar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(311, 233, 117, 25);
		
		btnSalir.addActionListener(this);
		getContentPane().add(btnSalir);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnSalir) {
			myCoordinator.setMyWindowLogin(new Login());
			myCoordinator.getMyWindowLogin().setCoordinator(myCoordinator);
			myCoordinator.hideWindowQueryProgrammer();
			myCoordinator.showWindowLogin();
		}
		// TODO Auto-generated method stub
		
	}
}

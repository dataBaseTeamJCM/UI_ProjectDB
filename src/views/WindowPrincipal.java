package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controller.Coordinator;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WindowPrincipal extends JFrame implements ActionListener{

	private Coordinator myCoordinator;
	private JTextArea txtpAreaInfo;
	private JLabel lblDataComp;
	private JButton btnInitSession;

	/**
	 * Launch the application.
	 */
	String textInfo="";

	public void setCoordinator(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
	}

	/**
	 * Create the frame.
	 */
	public WindowPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		textInfo="Esta aplicacion presenta una herramienta para"
				+ " la gestion de la base de datos del maraton de la competencia.\n\n"
				+ "La aplicacion permite registrar,actualizar, buscar y eliminar registros"
				+ "de la base de datos de la compentencia";
		
		txtpAreaInfo = new JTextArea();
		txtpAreaInfo.setBounds(32, 63, 380, 140);
		txtpAreaInfo.setEditable(false);
		txtpAreaInfo.setFont(new java.awt.Font("Verdana", 0, 14));
		txtpAreaInfo.setLineWrap(true);
		txtpAreaInfo.setText(textInfo);
		txtpAreaInfo.setWrapStyleWord(true);
		txtpAreaInfo.setBorder(javax.swing.BorderFactory.createBevelBorder(
				javax.swing.border.BevelBorder.LOWERED, null, null, null,
				new java.awt.Color(0, 0, 0)));
		
		lblDataComp = new JLabel("BASE DE DATOS DE LA COMPETENCIA");
		lblDataComp.setBounds(89, 31, 260, 15);
		
		btnInitSession = new JButton("Iniciar sesion");
		btnInitSession.setBounds(142, 212, 140, 25);
		
		btnInitSession.addActionListener(this);
		add(btnInitSession);
		add(lblDataComp);
		add(txtpAreaInfo);
		
		setSize(480, 350);
		setTitle("BIENVENIDO");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnInitSession){
			myCoordinator.setMyWindowLogin(new Login());
			myCoordinator.getMyWindowLogin().setCoordinator(myCoordinator);
			myCoordinator.showWindowLogin();
			myCoordinator.hideWindowPrincipal();
		}
	}
}

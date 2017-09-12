package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controller.Coordinator;
import views.colorMD.MaterialDesignColor;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewPrincipal extends JFrame implements ActionListener{

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
	public ViewPrincipal(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setBackground(new MaterialDesignColor("03A9F4"));
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
		btnInitSession.setToolTipText("Acces");
		btnInitSession.setBounds(131, 219, 140, 25);
		btnInitSession.setForeground(new MaterialDesignColor("212121"));
		btnInitSession.setBackground(new MaterialDesignColor("CDDC39"));
		
		btnInitSession.addActionListener(this);
		getContentPane().add(btnInitSession);
		getContentPane().add(lblDataComp);
		getContentPane().add(txtpAreaInfo);
		
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
			myCoordinator.invokerWindowLogin();
		//	myCoordinator.hideWindowPrincipal();
		}
	}
}

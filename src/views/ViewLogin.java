package views;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.Coordinator;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class ViewLogin extends JFrame implements ActionListener {

	private Coordinator myCoordinator;
	private JLabel lblError, lblUser, lblPass, lblVersion;
	private JButton btnAccess;
	private JTextField userField;
	private JPasswordField passwordField;
	private String textError=""; 
	public void setCoordinator(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
	}

	/**
	 * Create the application.
	 */
	public ViewLogin(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;

		setBounds(0, 0, 450, 300);
		
		/*
		 * colocar la ventana  en el centro de la pantalla
		 */
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//obtenemos el tamaño de la ventana
		Dimension ventana = getSize();
		//para centrar la ventana lo hacemos con el siguiente calculo
		setLocation((screenSize.width - ventana.width) / 2, (screenSize.height - ventana.height) / 2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textError="Error "
				+ "contraseña o "
				+ "Usuario invalidos";
		
		userField = new JTextField();
		userField.setBounds(159, 56, 114, 25);
		userField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(159, 107, 117, 25);
		passwordField.setColumns(10);
		
		lblError = new JLabel(textError);
		lblError.setForeground(Color.RED);
		lblError.setBounds(91, 175, 278, 15);
		lblError.setVisible(false);
		
		btnAccess = new JButton("Acceso");
		btnAccess.setBounds(159, 138, 117, 25);
		
		lblUser = new JLabel("Usuario");
		lblUser.setBounds(159, 43, 70, 15);
		
		lblPass = new JLabel("Contraseña");
		lblPass.setBounds(159, 93, 99, 15);
		
		lblVersion = new JLabel("Version b0.1");
		lblVersion.setBounds(0, 255, 114, 15);
		btnAccess.addActionListener(this);
		getContentPane().add(userField);
		getContentPane().add(passwordField);
		getContentPane().add(lblError);
		getContentPane().add(lblUser);
		getContentPane().add(lblPass);
		getContentPane().add(btnAccess);
		getContentPane().add(lblVersion);
		setTitle("Login");
		setResizable(false);
		getContentPane().setLayout(null);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnAccess){
			myCoordinator.connect(userField.getText(), passwordField.getPassword());
		}
	}	
}

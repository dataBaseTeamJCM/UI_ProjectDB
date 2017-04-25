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

public class Login extends JFrame implements ActionListener {

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
	public Login(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;

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
		setBounds(100, 100, 450, 300);
		setResizable(false);
		getContentPane().setLayout(null);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnAccess){	
			myCoordinator.connect(userField.getText(), passwordField.getPassword());
			if(myCoordinator.getConect() == null)
			{	
				lblError.setVisible(true);
				System.out.println("Usuario y "
						+ "Contraseña invalidos");
			}
			
			else
			{
				System.out.println(userField.getText());
				if(userField.getText().equals("coordinador")){
					System.out.println("Conexion exitosa");
					myCoordinator.invokerWindowCoordinator(userField.getText());
					myCoordinator.hideWindowLogin();
					
				}else if(userField.getText().equals("programador")){
					System.out.println("Conexion exitosa");
					myCoordinator.invokerWindowProgrammer(userField.getText());
					myCoordinator.hideWindowLogin();
				}
			}
		}
	}	
}

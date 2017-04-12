package views;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.Coordinator;
import model.connection.Conexion;

import java.awt.Label;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login extends JFrame implements ActionListener {

	private Coordinator myCoordinator;
	private JLabel lblError, lblUser, lblPass, lblVersion;
	private JButton btnAccess;
	private JTextField userField;
	private JPasswordField passwordField;
	private Connection conect;
	
	private String textError=""; 
	public void setCoordinator(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
	}

	/**
	 * Create the application.
	 */
	public Login() {
		
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
			this.conect = (new Conexion
						  (userField.getText(),
						  passwordField.getPassword())).
						  Conectar();
			
			if(conect == null)
			{	
				lblError.setVisible(true);
				System.out.println("Usuario y "
						+ "Contraseña invalidos");
			}
			
			else
			{
				if(myCoordinator.checkLogin(userField.getText())==1){
					System.out.println("Conexion exitosa");
					myCoordinator.setMyWindowQueryCoordinator(new WindowQueryCoordinator());
					myCoordinator.getMyWindowQueryCoordinador().setCoordinator(myCoordinator);
					myCoordinator.getMyWindowQueryCoordinador().setTitle("Hola "+ userField.getText());
					myCoordinator.showWindowQueryCoordinator();
					myCoordinator.hideWindowLogin();
					
				}else if(myCoordinator.checkLogin(userField.getText())==2){
					myCoordinator.setMyWindowQueryProgrammer(new WindowQueryProgrammer());
					myCoordinator.getMyWindowQueryCoordinador().setCoordinator(myCoordinator);
					myCoordinator.getMyWindowQueryProgrammer().setTitle("Hola " + userField.getText());
					myCoordinator.showWindowQueryProgrammer();
					myCoordinator.hideWindowLogin();
					
				}
				
			}
		}
	}
	
	public void logOut() throws SQLException
	{
		this.conect.close();
	}
		


	/*public void (ActionEvent e) {
		
		//frmBienvenido.setVisible(false);
		
		}

	/*
	   	private void PrimeraConsulta(){
		StringBuilder consulta = new StringBuilder();

  		consulta.append("SELECT * ");
  		consulta.append("FROM ERP.Empresa;");
	

  		consulta.append("SELECT CH.NOMBRE ");
  		consulta.append("FROM BANK.CUENTA_HABIENTE AS CH");

		Statement st;

		try{
				st = this.conect.createStatement();
				ResultSet rs = st.executeQuery
						(consulta.toString());
				System.out.println();
				System.out.println();
				while(rs.next())
					System.out.println(rs.getString(1)
							+ "\t" +rs.getString(2));
		}catch(Exception e){

			System.out.println(e);
		}
		*/
	/*
	 ** Initialize the contents of the frame.
	 */
}

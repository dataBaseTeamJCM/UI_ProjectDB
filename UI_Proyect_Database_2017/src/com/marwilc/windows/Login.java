package com.marwilc.windows;
import com.marwilc.connection.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Label;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login {

	private JFrame frmBienvenido;
	private JTextField userField;
	private JPasswordField passwordField;
	private Connection conect;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmBienvenido.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}
	public void setVisible(boolean var){
		frmBienvenido.setVisible(var);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBienvenido = new JFrame();
		frmBienvenido.setTitle("Bienvenido");
		frmBienvenido.setBounds(100, 100, 450, 300);
		frmBienvenido.setResizable(false);
		frmBienvenido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBienvenido.getContentPane().setLayout(null);
		
		userField = new JTextField();
		userField.setBounds(159, 62, 114, 19);
		frmBienvenido.getContentPane().add(userField);
		userField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(159, 107, 117, 19);
		frmBienvenido.getContentPane().add(passwordField);
		
		final JLabel lblNewLabel_2 = new JLabel("Error contraseña o Usuario invalidos");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(91, 175, 278, 15);
		lblNewLabel_2.setVisible(false);
		frmBienvenido.getContentPane().add(lblNewLabel_2);
		
		
		final JButton btnNewButton = new JButton("Acceso");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//frmBienvenido.setVisible(false);
				if(e.getSource()==btnNewButton){
					conect = (new Conexion(userField.getText(),passwordField.getPassword())).Conectar();
					if(conect == null)
					{	
						lblNewLabel_2.setVisible(true);
						//UserInvalid.lanzar();
						//frmBienvenido.setVisible(true);
						System.out.println("Usuario y Contraseña invalidos");
					}
					else
					{
						System.out.println("Conexion exitosa");
						//correr ventana de consultas;
					}
				}
			}
		});
		btnNewButton.setBounds(159, 138, 117, 25);
		frmBienvenido.getContentPane().add(btnNewButton);
		
		JLabel LabelField = new JLabel("Usuario");
		LabelField.setBounds(159, 43, 70, 15);
		frmBienvenido.getContentPane().add(LabelField);
		
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setBounds(159, 93, 99, 15);
		frmBienvenido.getContentPane().add(lblNewLabel_1);
		
		Label linkRegistro = new Label("Registro de usuario");
		linkRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		linkRegistro.setBounds(283, 224, 157, 21);
		frmBienvenido.getContentPane().add(linkRegistro);
		
		JLabel lblNewLabel = new JLabel("Version b0.1");
		lblNewLabel.setBounds(0, 255, 114, 15);
		frmBienvenido.getContentPane().add(lblNewLabel);
		
	}
}

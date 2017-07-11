package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Coordinator;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class WindowQueryCoordinator extends JFrame implements ActionListener{

	private Coordinator myCoordinator;
	private JLabel lblFecha;
	private JButton btnEdit;
	private JButton btnSalir;
	private Calendar date = Calendar.getInstance();
	private String hour,minutes,seconds, day , month, year;
	//private Date fecha;
	
	private String textTime="";
	private String textFecha="";
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu_3;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	
	public void setCoordinator(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
	}

	/**
	 * Create the frame.
	 */
	public WindowQueryCoordinator(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		hour = String.valueOf(date.get(Calendar.HOUR_OF_DAY));
		minutes = String.valueOf(date.get(Calendar.MINUTE));
		seconds = String.valueOf(date.get(Calendar.SECOND));
		day = String.valueOf(date.get(Calendar.DAY_OF_MONTH));
		month= String.valueOf(date.get(Calendar.MONTH));
		year = String.valueOf(date.get(Calendar.YEAR));
		
		textTime = hour+":"+minutes+":"+seconds;
		textFecha = day+"/"+month+"/"+year;
			
		lblFecha = new JLabel(textFecha);
		lblFecha.setBounds(368, 0, 70, 15);
		
		btnEdit = new JButton("Modificar");
		btnEdit.setBounds(157, 190, 117, 25);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(302, 218, 117, 25);
		
		btnEdit.addActionListener(this);
		btnSalir.addActionListener(this);
		getContentPane().add(lblFecha);
		getContentPane().add(btnEdit);
		getContentPane().add(btnSalir);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.setBounds(302, 190, 117, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Guardar");
		btnNewButton_1.setBounds(11, 190, 117, 25);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.setBounds(157, 218, 117, 25);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("CI");
		lblNewLabel.setBounds(25, 54, 70, 15);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(53, 52, 114, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(25, 100, 70, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Profesion");
		lblNewLabel_2.setBounds(25, 143, 70, 15);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_3 = new JButton("Ok");
		btnNewButton_3.setBounds(188, 49, 53, 25);
		getContentPane().add(btnNewButton_3);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(272, 100, 70, 15);
		getContentPane().add(lblEdad);
		
		JLabel lblNewLabel_3 = new JLabel("Telefono");
		lblNewLabel_3.setBounds(272, 143, 70, 15);
		getContentPane().add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(336, 98, 53, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(336, 141, 89, 19);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(109, 98, 114, 19);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(109, 141, 114, 19);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Menu1");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("guardar");
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("editar");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("salir");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mnNewMenu_1 = new JMenu("Menu2");
		menuBar.add(mnNewMenu_1);
		
		mnNewMenu_2 = new JMenu("Menu3");
		menuBar.add(mnNewMenu_2);
		
		mnNewMenu_3 = new JMenu("menu4");
		menuBar.add(mnNewMenu_3);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnEdit){
			System.out.println("holis");
		}
		
		if(e.getSource()==btnSalir){
			myCoordinator.invokerWindowLogin();
			myCoordinator.hideWindowQueryCoordinator();
			try {
				myCoordinator.getConect().close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}

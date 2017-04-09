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

public class WindowQuery extends JFrame implements ActionListener{

	private Coordinator myCoordinator;
	private JLabel lblTime, lblFecha;
	private JButton btnEdit;
	private JButton btnSalir;
	private Calendar date = Calendar.getInstance();
	private String hour,minutes,seconds, day , month, year;
	//private Date fecha;
	
	private String textTime="";
	private String textFecha="";
	
	
	public void setCoordinator(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
	}

	/**
	 * Create the frame.
	 */
	public WindowQuery() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		hour = String.valueOf(date.get(Calendar.HOUR_OF_DAY));
		minutes = String.valueOf(date.get(Calendar.MINUTE));
		seconds = String.valueOf(date.get(Calendar.SECOND));
		day = String.valueOf(date.get(Calendar.DAY_OF_MONTH));
		month= String.valueOf(date.get(Calendar.MONTH));
		year = String.valueOf(date.get(Calendar.YEAR));
		
		textTime = hour+":"+minutes+":"+seconds;
		textFecha = day+"/"+month+"/"+year;
		lblTime = new JLabel(textTime);
		lblTime.setBounds(348, 27, 70, 15);
			
		lblFecha = new JLabel(textFecha);
		lblFecha.setBounds(348, 11, 70, 15);
		
		btnEdit = new JButton("Editar");
		btnEdit.setBounds(140, 190, 117, 25);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(307, 233, 117, 25);
		
		btnEdit.addActionListener(this);
		btnSalir.addActionListener(this);
		getContentPane().add(lblTime);
		getContentPane().add(lblFecha);
		getContentPane().add(btnEdit);
		getContentPane().add(btnSalir);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnEdit){
			System.out.println("holis");
		}
		
		if(e.getSource()==btnSalir){
			try {
				myCoordinator.getMyWindowLogin().logOut();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			myCoordinator.getMyWindowQuery().dispose();
			myCoordinator.setMyWindowLogin(new Login());
			myCoordinator.showWindowLogin();
			
		}
	}
	
}

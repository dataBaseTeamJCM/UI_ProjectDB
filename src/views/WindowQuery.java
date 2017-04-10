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

public class WindowQuery extends JFrame implements ActionListener{

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
			
		lblFecha = new JLabel(textFecha);
		lblFecha.setBounds(368, 0, 70, 15);
		
		btnEdit = new JButton("Editar");
		btnEdit.setBounds(140, 190, 117, 25);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(302, 218, 117, 25);
		
		btnEdit.addActionListener(this);
		btnSalir.addActionListener(this);
		getContentPane().add(lblFecha);
		getContentPane().add(btnEdit);
		getContentPane().add(btnSalir);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
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
			try {
				myCoordinator.getMyWindowLogin().logOut();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			myCoordinator.setMyWindowLogin(new Login());
			myCoordinator.getMyWindowLogin().setCoordinator(myCoordinator);
			myCoordinator.hideWindowQuery();
			myCoordinator.showWindowLogin();
			
		}
	}
}

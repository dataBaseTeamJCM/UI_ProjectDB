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

import controller.ActionConstants;
import controller.Coordinator;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class ViewCoordinador extends JFrame implements ActionListener, IViews{

	private Coordinator myCoordinator;
	private JPanel contentPane;
	private JButton btnUp;
	private JButton btnDown;
	private JButton btnEdit;
	private JButton btnInsert;
	private JButton btnDelete;
	private JButton btnExit;

	public void setCoordinator(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
	}

	/**
	 * Create the frame.
	 */
	public ViewCoordinador(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(600, 100, 550, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		
		addPanelButtons();
		
		
		
		setVisible(true);
	
	}
	
	
	@Override
	public void addPanelButtons() {
		// TODO Auto-generated method stub
		JPanel panelButtons = new JPanel();
		contentPane.add(panelButtons, BorderLayout.SOUTH);
		panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnUp = new JButton("<");
		panelButtons.add(btnUp);
		
		btnDown = new JButton(">");
		panelButtons.add(btnDown);
		
		btnEdit = new JButton("Editar");
		panelButtons.add(btnEdit);
		
		btnInsert = new JButton("Insertar");
		panelButtons.add(btnInsert);
		
		btnDelete = new JButton("Eliminar");
		panelButtons.add(btnDelete);
		
		btnExit = new JButton("Salir");
		panelButtons.add(btnExit);
		
		btnUp.addActionListener(this);
		btnDown.addActionListener(this);
		btnDelete.addActionListener(this);
		btnEdit.addActionListener(this);
		btnInsert.addActionListener(this);
		btnExit.addActionListener(this);
		
		btnUp.setActionCommand(ActionConstants.KEY_UP);
		btnDown.setActionCommand(ActionConstants.KEY_DOWN);
		btnDelete.setActionCommand(ActionConstants.KEY_DELETE);
		btnEdit.setActionCommand(ActionConstants.KEY_EDIT);
		btnInsert.setActionCommand(ActionConstants.KEY_INSERT);
		btnExit.setActionCommand(ActionConstants.KEY_EXIT);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		
			case ActionConstants.KEY_UP:
			
				break;
			case ActionConstants.KEY_DOWN:
			
				break;
			case ActionConstants.KEY_DELETE:
			
				break;
			case ActionConstants.KEY_INSERT:
	
				break;
			case ActionConstants.KEY_EDIT:
	
				break;
			case ActionConstants.KEY_EXIT:
	
				break;
			default:
				break;
		}
	}

}

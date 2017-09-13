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
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;

public class ViewCoordinador extends JFrame implements ActionListener, IViews{

	private Coordinator myCoordinator;
	private JPanel contentPane;
	private JButton btnUp;
	private JButton btnDown;
	private JButton btnEdit;
	private JButton btnInsert;
	private JButton btnDelete;
	private JButton btnExit;
	private JPanel panelList;
	private JScrollPane scrollPaneJtree;
	private JTree tree;

	public void setCoordinator(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
	}

	/**
	 * Create the frame.
	 **/
	public ViewCoordinador(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(600, 100, 550, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		
		addPanelButtons();
		addPanelList();
		
		
		setVisible(true);
	
	}
	
	
	public Coordinator getMyCoordinator() {
		return myCoordinator;
	}

	public void setMyCoordinator(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
	}

	public JButton getBtnUp() {
		return btnUp;
	}

	public void setBtnUp(JButton btnUp) {
		this.btnUp = btnUp;
	}

	public JButton getBtnDown() {
		return btnDown;
	}

	public void setBtnDown(JButton btnDown) {
		this.btnDown = btnDown;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public void setBtnEdit(JButton btnEdit) {
		this.btnEdit = btnEdit;
	}

	public JButton getBtnInsert() {
		return btnInsert;
	}

	public void setBtnInsert(JButton btnInsert) {
		this.btnInsert = btnInsert;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	public void setBtnExit(JButton btnExit) {
		this.btnExit = btnExit;
	}

	public JPanel getPanelList() {
		return panelList;
	}

	public void setPanelList(JPanel panelList) {
		this.panelList = panelList;
	}

	public JScrollPane getScrollPaneJtree() {
		return scrollPaneJtree;
	}

	public void setScrollPaneJtree(JScrollPane scrollPane) {
		this.scrollPaneJtree = scrollPane;
	}

	public JTree getTree() {
		return tree;
	}

	public void setTree(JTree tree) {
		this.tree = tree;
	}

	@Override
	public void addPanelButtons() {
		// TODO Auto-generated method stub
		JPanel panelButtons = new JPanel();
		
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
		contentPane.add(panelButtons, BorderLayout.SOUTH);
		
	}
	
	@Override
	public void addPanelList() {
		// TODO Auto-generated method stub
		panelList = new JPanel();
		contentPane.add(panelList, BorderLayout.WEST);
		panelList.setLayout(new BoxLayout(panelList, BoxLayout.Y_AXIS));
		
		scrollPaneJtree = new JScrollPane();
		panelList.add(scrollPaneJtree);
		
		tree = new JTree();
		scrollPaneJtree.setViewportView(tree);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnUp){
			
		}
	}
}

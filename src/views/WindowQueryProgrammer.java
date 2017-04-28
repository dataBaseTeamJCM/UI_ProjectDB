package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import controller.Coordinator;
import model.QueryBD;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import views.colorMD.MaterialDesignColor;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;

public class WindowQueryProgrammer extends JFrame implements ActionListener {
	private Coordinator myCoordinator;
	private JTable table;
	private JTable table_1;
	private JMenuItem intemSalir;
	
	public void setCoordinator(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
	}

	/**
	 * Create the frame.
	 */
	public WindowQueryProgrammer(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setBackground(new MaterialDesignColor("0288D1"));
		// arreglo con los titulos de las columnas
		String[] columnNames = 
		{"titulo 1", "titulo 2", "titulo 3"};
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, "name_83473617679216");
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Integrante",new ImageIcon(WindowQueryProgrammer.class.getResource("/views/icons/ic_person_black_18dp.png")),
				scrollPane, null);
		
		table = new JTable();
		table = myCoordinator.listStudents();
		scrollPane.setViewportView(table);
		
		JSplitPane splitPane = new JSplitPane();
		scrollPane.setViewportView(splitPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane_1, null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane_2, null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane_3, null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("Menu");
		menuBar.add(menu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		menu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		menu.add(mntmNewMenuItem_2);
		
		intemSalir = new JMenuItem("Salir");
		intemSalir.setIcon(new ImageIcon(WindowQueryProgrammer.class.getResource("/views/icons/ic_close_black_16dp.png")));
		menu.add(intemSalir);
		
		intemSalir.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==intemSalir) {
			myCoordinator.invokerWindowLogin();
			myCoordinator.hideWindowQueryProgrammer();
			try {
				myCoordinator.getConect().close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
}

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
import model.MembersRegister;

import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class WindowQueryProgrammer extends JFrame implements ActionListener {
	private Coordinator myCoordinator;
	private JTable table;
	
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
		getContentPane().setLayout(new CardLayout(0, 0));
		
		// arreglo con los titulos de las columnas
		String[] columnNames = 
		{"titulo 1", "titulo 2", "titulo 3"};
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, "name_97981333999461");
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Integrante", null, panel, null);
		
		table = myCoordinator.listMembers();
		panel.add(table);
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Problema Resuelto", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Competencia", null, panel_2, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

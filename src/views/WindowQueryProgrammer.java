package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Coordinator;

import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;

public class WindowQueryProgrammer extends JFrame implements ActionListener {
	private Coordinator myCoordinator;
	
	public void setCoordinator(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
	}

	/**
	 * Create the frame.
	 */
	public WindowQueryProgrammer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, "name_97981333999461");
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Integrante", null, panel, null);
		
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

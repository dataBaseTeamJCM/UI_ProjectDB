package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Coordinator;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class SearchByCi extends JDialog implements ActionListener {
	private JTextField textFieldCi;
	private Coordinator myCoordinator;
	private JButton btnCancel;
	private JButton btnSearch;
	
	public Coordinator getMyCoordinator() {
		return myCoordinator;
	}

	public void setMyCoordinator(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
	}

	/**
	 * Create the dialog.
	 * @param coordinator 
	 */
	public SearchByCi(Coordinator coordinator) {
		this.setMyCoordinator(coordinator);
		setResizable(false);
		setBounds(100, 100, 400, 200);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel panelButton = new JPanel();
			getContentPane().add(panelButton, BorderLayout.SOUTH);
			panelButton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				btnSearch = new JButton("Buscar");
				btnSearch.setToolTipText("Buscar un estudiante");
				panelButton.add(btnSearch);
			}
			{
				btnCancel = new JButton("Cancelar");
				btnCancel.setToolTipText("Cancelar busqueda");
				panelButton.add(btnCancel);
			}
		}
		{
			JPanel panelSearch = new JPanel();
			getContentPane().add(panelSearch, BorderLayout.CENTER);
			panelSearch.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 50));
			{
				JLabel lblCi = new JLabel("Ci");
				panelSearch.add(lblCi);
			}
			{
				textFieldCi = new JTextField();
				textFieldCi.setToolTipText("ejemplo:7206537");
				panelSearch.add(textFieldCi);
				textFieldCi.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JLabel lblHeader = new JLabel("Introduzca su cédula de indentidad");
				panel.add(lblHeader);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

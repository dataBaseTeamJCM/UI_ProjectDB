package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.Coordinator;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.GridLayout;

public class SearchByCi extends JDialog implements ActionListener {
	private Coordinator myCoordinator;
	private JButton btnCancel;
	private JButton btnSearch;
	private JTextField textFieldCi;
	private JPanel panelButton;
	private JPanel panelSearch;
	private JLabel lblCi;
	private JPanel panel;
	private JLabel lblHeader;
	private JLabel lblError;
	
	public Coordinator getMyCoordinator() {
		return myCoordinator;
	}

	public void setMyCoordinator(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
	}

	public JTextField getTextFieldCi() {
		return textFieldCi;
	}

	public void setTextFieldCi(JFormattedTextField textFieldCi) {
		this.textFieldCi = textFieldCi;
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
			panelButton = new JPanel();
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
			panelSearch = new JPanel();
			getContentPane().add(panelSearch, BorderLayout.CENTER);
			panelSearch.setLayout(null);
			{
				lblCi = new JLabel("Ci");
				lblCi.setBounds(94, 43, 24, 24);
				panelSearch.add(lblCi);
			}
			{
				textFieldCi = new JTextField();
				textFieldCi.setBounds(123, 44, 133, 24);
				getMyCoordinator().onlyNumbers(textFieldCi);
				panelSearch.add(textFieldCi);
				textFieldCi.setColumns(10);
			}
			{
				//errorLabel();
				/*lblError = new JLabel("No Existe En la base de datos");
				lblError.setVisible(false);
				lblError.setBounds(104, 74, 241, 24);
				lblError.setForeground(Color.RED);
				panelSearch.add(lblError);*/
			}
		}
		{
			panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				lblHeader = new JLabel("Introduzca su cédula de indentidad");
				panel.add(lblHeader);
			}
		}
		btnCancel.addActionListener(this);
		btnSearch.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.btnSearch){
		/*
		 *  getMyCoordinator().anStudent(getTextFieldCi().getText());
			if( getMyCoordinator().getStudents() != null ){
				getMyCoordinator().getMyWindowQueryProgrammer().buildTabInformacionPersonal();
				getMyCoordinator().hideWindowSearch();
			}
			else
				errorLabel();
		*/
		}
		
	}
	public void errorLabel()
	{
		lblError = new JLabel("No Existe En la base de datos");
		lblError.setBounds(104, 74, 241, 24);
		lblError.setForeground(Color.RED);
		panelSearch.add(lblError);
	}
	
}

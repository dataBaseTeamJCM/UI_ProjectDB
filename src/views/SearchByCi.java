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
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

public class SearchByCi extends JDialog implements ActionListener {
	private Coordinator myCoordinator;
	private JButton btnCancel;
	private JButton btnSearch;
	private JTextField textFieldCi;
	private JPanel panelButton;
	private JPanel panelSearch;
	private JLabel lblCi;
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
		setBounds(0, 0, 400, 200);

		/*
		 * colocar la ventana  en el centro de la pantalla
		 */
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//obtenemos el tamaño de la ventana
		Dimension ventana = getSize();
		//para centrar la ventana lo hacemos con el siguiente calculo
		setLocation((screenSize.width - ventana.width) / 2, (screenSize.height - ventana.height) / 2);
		
		setTitle("Busqueda");
		
		getContentPane().setLayout(new BorderLayout());
		panelButton = new JPanel();
		getContentPane().add(panelButton, BorderLayout.SOUTH);
		panelButton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
		btnSearch = new JButton("Buscar");
		btnSearch.setToolTipText("Buscar un estudiante");
		panelButton.add(btnSearch);
			
		btnCancel = new JButton("Cancelar");
		btnCancel.setToolTipText("Cancelar busqueda");
		panelButton.add(btnCancel);
		
		panelSearch = new JPanel();
		getContentPane().add(panelSearch, BorderLayout.CENTER);
		panelSearch.setLayout(null);
		
		lblCi = new JLabel("Ingrese su cedula de Indentidad");
		lblCi.setBounds(76, 41, 253, 24);
		panelSearch.add(lblCi);
		
		textFieldCi = new JTextField();
		textFieldCi.setBounds(123, 73, 133, 24);
		getMyCoordinator().onlyNumbers(textFieldCi);
		panelSearch.add(textFieldCi);
		textFieldCi.setColumns(10);
	
	
		btnCancel.addActionListener(this);
		btnSearch.addActionListener(this);
	
		setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnSearch){
			myCoordinator.SearchStudentByCi();
		}
		
		if (e.getSource()== btnCancel){
			myCoordinator.invokerWindowProgrammer("Programador");
			myCoordinator.hideWindowSearch();
		}
		
	}
}

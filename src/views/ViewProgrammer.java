package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import controller.Coordinator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import views.colorMD.MaterialDesignColor;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToolBar;
import java.awt.Button;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

public class ViewProgrammer extends JFrame implements ActionListener, ViewsAddons {
	private Coordinator myCoordinator;
	private JMenuItem intemIPVer;
	private JTextField textFieldCi;
	private JTextField textFieldName;
	private JTextField textFieldLastName;
	private JTextField textFieldAdress;
	private JMenuItem mntmProblemaR;
	private JMenuItem mntmCompetencia;
	private JMenuItem mntmMiCoach;
	private JComboBox comboBoxYear;
	private JMenu mnViajes;
	private JMenuItem mntmVerViajes;
	private JPanel panelButtons;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JButton btnSalir;
	
	public void setCoordinator(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
	}

	public Coordinator getMyCoordinator() {
		return myCoordinator;
	}

	/**
	 * Create the frame.
	 */
	public ViewProgrammer(Coordinator myCoordinator) {
		
		this.myCoordinator = myCoordinator;
		setBounds(0, 0, 800, 400);
		
		/*
		 * colocar la ventana  en el centro de la pantalla
		 */
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//obtenemos el tamaño de la ventana
		Dimension ventana = getSize();
		//para centrar la ventana lo hacemos con el siguiente calculo
		setLocation((screenSize.width - ventana.width) / 2, (screenSize.height - ventana.height) / 2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		addJmenuBar();
		addPanelButtons();
	}

	@Override
	/**
	 * se agrega el panel del menu de la vista
	 */
	public void addJmenuBar()
	{
		// TODO Auto-generated method stub
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(192, 192, 192));
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Mi Informacion Personal");
		menuBar.add(mnMenu);
		
		intemIPVer = new JMenuItem("Ver Mi informacion Personal");
		intemIPVer.setIcon(new ImageIcon(ViewProgrammer.class.getResource("/views/icons/ic_close_black_16dp.png")));
		mnMenu.add(intemIPVer);
		
		mnViajes = new JMenu("Mis Viajes");
		menuBar.add(mnViajes);
		
		mntmVerViajes = new JMenuItem("Ver Mis Viajes");
		mnViajes.add(mntmVerViajes);
		
		JMenu mnViewGlobal = new JMenu("Vista General");
		menuBar.add(mnViewGlobal);
		
		mntmProblemaR = new JMenuItem("Problemas Resueltos");
		mnViewGlobal.add(mntmProblemaR);
		
		mntmCompetencia = new JMenuItem("Competencia");
		mnViewGlobal.add(mntmCompetencia);
		
		mntmMiCoach = new JMenuItem("Mi Coach y Representante");
		mnViewGlobal.add(mntmMiCoach);
		intemIPVer.addActionListener(this);
		mntmProblemaR.addActionListener(this);
		mntmCompetencia.addActionListener(this);
		mntmMiCoach.addActionListener(this);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
	}
	@Override
	/**
	 * Se agrega el panel de los botones de la vista
	 */
	public void addPanelButtons()
	{
		panelButtons = new JPanel();
		getContentPane().add(panelButtons, BorderLayout.SOUTH);
		panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnGuardar = new JButton("Cuardar");
		panelButtons.add(btnGuardar);
		btnGuardar.setEnabled(false);
		btnGuardar.addActionListener(this);
		
		btnCancelar = new JButton("Cancelar");
		panelButtons.add(btnCancelar);
		btnCancelar.setEnabled(false);
		btnCancelar.addActionListener(this);
		
		btnSalir = new JButton("Salir");
		panelButtons.add(btnSalir);
		btnSalir.addActionListener(this);
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==btnSalir) {
			myCoordinator.invokerWindowLogin();
			myCoordinator.hideWindowQueryProgrammer();
			myCoordinator.closeConnect();
		}
		if (e.getSource() == intemIPVer){
			myCoordinator.invokerWindowSearch();	
			System.out.println("fuck you");
			myCoordinator.hideWindowQueryProgrammer();
		}
		if (e.getSource() == mntmCompetencia) {
			
		}
		if (e.getSource() == mntmProblemaR) {
			
		}
		if (e.getSource() == mntmMiCoach) {
			
		}
	}

	@Override
	public void addPanelForm()
	{
		// TODO Auto-generated method stub
		
	}



	
}

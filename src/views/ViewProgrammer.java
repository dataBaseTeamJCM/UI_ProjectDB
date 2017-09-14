package views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.Coordinator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import java.awt.Component;

@SuppressWarnings("serial")
public class ViewProgrammer extends JFrame implements ActionListener, ViewsAddons {
	private Coordinator myCoordinator;
	private JMenuItem intemIPVer;
	private JMenuItem mntmProblemaR;
	private JMenuItem mntmCompetencia;
	private JMenuItem mntmMiCoach;
	private JMenu mnViajes;
	private JMenuItem mntmVerViajes;
	private JPanel panelButtons;
	private JButton btnSalir;
	private JPanel panelConsultas;
	private JButton btnConsulta1;
	private JButton btnConsulta2;
	private JButton btnConsulta3;
	
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
		
		mntmCompetencia = new JMenuItem("Competencias");
		mnViewGlobal.add(mntmCompetencia);
		
		mntmMiCoach = new JMenuItem("Mi Coach y Representante");
		mnViewGlobal.add(mntmMiCoach);
		intemIPVer.addActionListener(this);
		mntmProblemaR.addActionListener(this);
		mntmCompetencia.addActionListener(this);
		mntmMiCoach.addActionListener(this);
		mntmVerViajes.addActionListener(this);
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
		
		btnSalir = new JButton("Salir");
		panelButtons.add(btnSalir);
		
		panelConsultas = new JPanel();
		getContentPane().add(panelConsultas, BorderLayout.CENTER);
		panelConsultas.setLayout(new FlowLayout(FlowLayout.CENTER, 5,getHeight()/3));
		
		btnConsulta1 = new JButton("Consulta 1");
		panelConsultas.add(btnConsulta1);
		btnConsulta1.addActionListener(this);
		
		btnConsulta2 = new JButton("Consulta 2");
		btnConsulta2.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelConsultas.add(btnConsulta2);
		btnConsulta2.addActionListener(this);
		
		btnConsulta3 = new JButton("Consulta 3");
		panelConsultas.add(btnConsulta3);
		btnConsulta3.addActionListener(this);
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
			myCoordinator.invokerWindowProgrammerForm();
		}
		if(e.getSource() == mntmVerViajes){
			// activa la ventana de viajes
			myCoordinator.invokerWindowViajesForm();
		}
		
		if (e.getSource()== btnConsulta1){
			myCoordinator.invokerWindowConsulta1();
		}
		if (e.getSource()== btnConsulta2){
			myCoordinator.invokerWindowConsulta2();
		}
		if (e.getSource()== btnConsulta3){
			myCoordinator.invokerWindowConsulta3();
		}
		if (e.getSource() == mntmCompetencia) {
			myCoordinator.invokerWindowConsultaCompetencias();
		}
		if (e.getSource() == mntmProblemaR) {
			myCoordinator.invokerWindowConsultaProblemasResueltos();
		}
		if (e.getSource() == mntmMiCoach) {
			myCoordinator.invokerWindowConsultaProfesores();
		}
	}

	@Override
	public void addPanelForm()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPanelList()
	{
		// TODO Auto-generated method stub
		
	}



	
}

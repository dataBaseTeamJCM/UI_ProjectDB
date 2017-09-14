package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;

public class ViewCoordinador extends JFrame implements ActionListener, ViewsAddons{

	private Coordinator myCoordinator;
	private JPanel contentPane;
	private JPanel panelList;
	private JButton btnSalir;
	private JMenuItem mntmVerEquipos;
	private JMenuItem mntmVerCompetencias;
	private JMenuItem mntmVerProblema;
	private JMenuItem mntmVerViajes;
	private JMenuItem mntmVerProgramador;
	private JMenuItem mntmVerProfesor;
	private JPanel panelButtons;
	private JScrollPane scrollPane;
	private JButton btnEliminar;
	private JButton btnInsertar;
	private JButton btnEditar;

	public void setCoordinator(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
	}

	/**
	 * Create the frame.
	 **/
	public ViewCoordinador(Coordinator myCoordinator) {
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
		getContentPane().setLayout(new BorderLayout(0, 0));
	
		setVisible(true);
		
		addJmenuBar();
		addPanelButtons();
	
	}
	
	
	public Coordinator getMyCoordinator() {
		return myCoordinator;
	}

	public void setMyCoordinator(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
	}



	public JPanel getPanelList() {
		return panelList;
	}

	public void setPanelList(JPanel panelList) {
		this.panelList = panelList;
	}

	public JButton getBtnSalir()
	{
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir)
	{
		this.btnSalir = btnSalir;
	}

	public JMenuItem getMntmVerEquipos()
	{
		return mntmVerEquipos;
	}

	public void setMntmVerEquipos(JMenuItem mntmVerEquipos)
	{
		this.mntmVerEquipos = mntmVerEquipos;
	}

	public JMenuItem getMntmVerCompetencias()
	{
		return mntmVerCompetencias;
	}

	public void setMntmVerCompetencias(JMenuItem mntmVerCompetencias)
	{
		this.mntmVerCompetencias = mntmVerCompetencias;
	}

	public JMenuItem getMntmVerProblema()
	{
		return mntmVerProblema;
	}

	public void setMntmVerProblema(JMenuItem mntmVerProblema)
	{
		this.mntmVerProblema = mntmVerProblema;
	}

	public JMenuItem getMntmVerViajes()
	{
		return mntmVerViajes;
	}

	public void setMntmVerViajes(JMenuItem mntmVerViajes)
	{
		this.mntmVerViajes = mntmVerViajes;
	}

	public JMenuItem getMntmVerProgramador()
	{
		return mntmVerProgramador;
	}

	public void setMntmVerProgramador(JMenuItem mntmVerProgramador)
	{
		this.mntmVerProgramador = mntmVerProgramador;
	}

	public JMenuItem getMntmVerProfesor()
	{
		return mntmVerProfesor;
	}

	public void setMntmVerProfesor(JMenuItem mntmVerProfesor)
	{
		this.mntmVerProfesor = mntmVerProfesor;
	}

	public JScrollPane getScrollPane()
	{
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane)
	{
		this.scrollPane = scrollPane;
	}

	@Override
	public void addPanelButtons() {
		// TODO Auto-generated method stub
		panelButtons = new JPanel();
		getContentPane().add(panelButtons, BorderLayout.SOUTH);
		panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(this);
		panelButtons.add(btnInsertar);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(this);
		panelButtons.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		panelButtons.add(btnEliminar);
		btnEliminar.addActionListener(this);
		panelButtons.add(btnSalir);
		
		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
	}
	
	
	@Override
	public void addPanelList() {
		// TODO Auto-generated method stub
		panelList = new JPanel();
		contentPane.add(panelList, BorderLayout.WEST);
		panelList.setLayout(new BoxLayout(panelList, BoxLayout.Y_AXIS));
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== btnSalir){
			myCoordinator.invokerWindowLogin();
			myCoordinator.hideWindowQueryCoordinator();
			myCoordinator.closeConnect();
		}
		if(e.getSource() == mntmVerCompetencias){
			myCoordinator.invokerWindowVerCompetencias();
		}
		if(e.getSource() == mntmVerEquipos){
			myCoordinator.invokerWindowVerEquipos();
		}
		if(e.getSource() == mntmVerProblema){
			//myCoordinator.invokerWindowVerProblemas();
		}
		if(e.getSource() == mntmVerProfesor){
			//myCoordinator.invokerWindowVerProfesor();
		}
		if(e.getSource() == mntmVerProgramador){
			//myCoordinator.invokerWindowVerProgramador();
		}
		if(e.getSource() == mntmVerViajes){
			//myCoordinator.invokerWindowVerViajes();
		}
		if(e.getSource()==btnEditar){
			
		}
		if(e.getSource()==btnInsertar){
			
		}
		if(e.getSource()==btnEliminar){
			myCoordinator.EventoEliminar();
		}
		
	}

	@Override
	public void addJmenuBar()
	{
		// TODO Auto-generated method stub
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnEquipos = new JMenu("Equipos");
		menuBar.add(mnEquipos);
		mntmVerEquipos = new JMenuItem("Ver");
		
		mnEquipos.add(mntmVerEquipos);
		
		JMenu mnCompetencias = new JMenu("Competencias");
		menuBar.add(mnCompetencias);
		
		mntmVerCompetencias = new JMenuItem("Ver");
		mnCompetencias.add(mntmVerCompetencias);
		
		JMenu mnProblemasResuelto = new JMenu("Problemas Resueltos");
		menuBar.add(mnProblemasResuelto);
		
		mntmVerProblema = new JMenuItem("Ver");
		mnProblemasResuelto.add(mntmVerProblema);
		
		JMenu mnViajes = new JMenu("Viajes");
		menuBar.add(mnViajes);
		
		mntmVerViajes = new JMenuItem("Ver");
		mnViajes.add(mntmVerViajes);
		
		JMenu mnProgramador = new JMenu("Programador");
		menuBar.add(mnProgramador);
		
		mntmVerProgramador = new JMenuItem("Ver");
		mnProgramador.add(mntmVerProgramador);
		
		JMenu mnProfesor = new JMenu("Profesor");
		menuBar.add(mnProfesor);
		
		mntmVerProfesor = new JMenuItem("Ver");
		mnProfesor.add(mntmVerProfesor);
		mntmVerCompetencias.addActionListener(this);
		mntmVerEquipos.addActionListener(this);
		mntmVerProblema.addActionListener(this);
		mntmVerProfesor.addActionListener(this);
		mntmVerProgramador.addActionListener(this);
		mntmVerViajes.addActionListener(this);
		
	}

	@Override
	public void addPanelForm()
	{
		// TODO Auto-generated method stub
		
	}
}

package controller;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import db.Conexion;
import db.DatabaseQueries;
import model.CompetitionList;
import model.Student;
import model.StudentList;
import model.TeamCompetitor;
import model.TeamCompetitorList;
import resources.values.Events;
import resources.values.Strings;
import views.*;

public class Coordinator {
	

	//private	ViewPrincipal myWindowPrincipal;
	private ViewLogin myWindowLogin;
	private ViewCoordinador myWindowQueryCoordinator;
	private ViewProgrammer myWindowQueryProgrammer;
	private ViewAd myViewAd;
	private SearchByCi	mySearchByCi;
	private ViewProgrammerForm myProgrammerForm;
	private Connection conect;
	private int varEvent = -1;
	//private Conexion conn;
	private DialogCheckSave myDialogCheckSave = null;
	private Student student;
	private ViewTravelForm myTravelForm;
	private JList jListaTravel = null;
	private TeamCompetitorList competitorList;
	private TeamCompetitorList equipos;
	private JTable jTable;
	private CompetitionList competitionList;
	
	// getters y setters de las ventanas
	
	public Coordinator(){
		this.myWindowLogin = new ViewLogin(this);
		showWindowLogin();
	}
	public Connection getConect() {
		return conect;
	}

	public void setConect(Connection conect) {
		this.conect = conect;
	}

	public ViewLogin getMyWindowLogin() {
		return myWindowLogin;
	}
	public void setMyWindowLogin(ViewLogin myWindowLogin) {
		this.myWindowLogin = myWindowLogin;
	}

	public void setMyWindowQueryCoordinator(ViewCoordinador myWindowQueryCoordinator) {
		this.myWindowQueryCoordinator = myWindowQueryCoordinator;
	}
	
	public ViewCoordinador getMyWindowQueryCoordinator() {
		return myWindowQueryCoordinator;
	}

	public ViewProgrammer getMyWindowQueryProgrammer() {
		return myWindowQueryProgrammer;
	}
	public void setMyWindowQueryProgrammer(ViewProgrammer myWindowQueryProgrammer) {
		this.myWindowQueryProgrammer = myWindowQueryProgrammer;
	}
	
	public SearchByCi getMySearchByCi() {
		return mySearchByCi;
	}

	public void setMySearchByCi(SearchByCi mySearchByCi) {
		this.mySearchByCi = mySearchByCi;
	}
	/*metodos para mostrar y cerrar las ventanas*/
	
	
	public void showWindowSearch(){
		mySearchByCi.setVisible(true);
	}
	
	public void hideWindowSearch(){
		mySearchByCi.dispose();
	}

	public void showWindowLogin(){
		myWindowLogin.setVisible(true);
	}
	
	public void hideWindowLogin(){
		myWindowLogin.dispose();
	}
	
	public void showWindowQueryCoordinator(){
		myWindowQueryCoordinator.setVisible(true);
	}
	
	public void hideWindowQueryCoordinator(){
		myWindowQueryCoordinator.dispose();
	}
	
	public void showWindowQueryProgrammer(){
		myWindowQueryProgrammer.setVisible(true);
	}
	
	public void showWindowCheckSave()
	{
		// TODO Auto-generated method stub
		myDialogCheckSave.setVisible(true);
	}
	public void hideWindowQueryProgrammer(){
		myWindowQueryProgrammer.dispose();
		
	}
	
	/**
	 * Este metodo cierra la ventana de aviso
	 */
	public void hideWindowAd()
	{
		myViewAd.dispose();
		// TODO Auto-generated method stub
	}
	
	/**
	 * Este metodo se encarga de cerrar la ventana de
	 * formulario del programador
	 */
	public void hideWindowProgrammerForm()
	{
		// TODO Auto-generated method stub
		myProgrammerForm.dispose();
	}
	
	/**
	 * este metodo se encargar de cerra la ventana de formulario
	 * de los viajes de programador 
	 */
	public void hideWindowViewTravelForm()
	{
		// TODO Auto-generated method stub
		myTravelForm.dispose();
	}
	
	/**
	 * metodo que invoca una ventana de programador nueva
	 * @param name
	 */
	public void invokerWindowProgrammer(String name){
		this.setMyWindowQueryProgrammer(new ViewProgrammer(this));
		this.getMyWindowQueryProgrammer().setTitle("Hola " + name);
		this.showWindowQueryProgrammer();
	}
	
	public void invokerWindowCoordinator(String name){
		setMyWindowQueryCoordinator(new ViewCoordinador(this));
		getMyWindowQueryCoordinator().setTitle("Hola "+ name);
		this.showWindowQueryCoordinator();
	}
	

	public void invokerWindowLogin(){
		this.setMyWindowLogin(new ViewLogin(this));
		this.showWindowLogin();
	}
	
	public void invokerWindowSearch(){
		this.setMySearchByCi(new SearchByCi(this));
		this.showWindowSearch();
	}
	
	public void invokerWindowCheckSave()
	{
		// TODO Auto-generated method stub
		if(myDialogCheckSave ==null)
			myDialogCheckSave = new DialogCheckSave(this);
		else
			myDialogCheckSave.setVisible(true);
	}
	
	/**
	 *  Esta funcion se encarga de controlar el inicio de los usuarios 
	 *  a la bd para los usuarios coordinador y programador
	 */
	public void connect(String userName, char[] password){
		this.conect = (new Conexion (userName,password)).Conectar();
		
		if(this.getConect() == null)
		{	
			
			/*
			 *  Invocar ventana de aviso para indicar que se ingreso un
			 *  usuario o una contraseña incorrecta.
			 */
			
			this.myViewAd = new ViewAd(Strings.INVALID_USER);
			System.out.println("Usuario y "
					+ "Contraseña invalidos");
		}
		
		else
		{
			System.out.println(userName);
			if(userName.equals("coordinador"))
			{
				invokerWindowCoordinator(userName);	
				System.out.println("Conexion exitosa");
				hideWindowLogin();
				
			}
			else if(userName.equals("programador"))
			{
				System.out.println("Conexion exitosa");
				invokerWindowSearch();
				hideWindowLogin();
			}
		}
	}
	
	// metodos para obtener datos de la bd y actualizarlos
	
	public StudentList listAllStudents(){
		new Conexion(this.getConect());
		//String sql;
		//atabaseQueries queries = new DatabaseQueries(conn);
		StudentList studentList = null;
		
		//studentList = queries.buildStudentList();
		
		return studentList;
		//studentList.print();
		//sql = ModelStudent.queryAllEstudents();
		//conn.createQuery(sql);
		//return (new JTable(DbUtils.resultSetToTableModel(conn.getRs())));
	}

	//metodos para validaciones campos de texto etc
	public void onlyNumbers(JTextField text){
		text.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e){
				char c = e.getKeyChar();
				if(Character.isLetter(c)){
					e.consume();
				}
			}
		
		});
	}
	
	/**
	 * este metodo busca la informacion de un estudiante 
	 * por su cedula de identidad
	 */
	public void SearchStudentByCi()
	{
		// TODO Auto-generated method stub
		
		student = null;
		String cedulaEstudiante = mySearchByCi.getTextFieldCi().getText();
		
		student = getStudentByCi(cedulaEstudiante);
		
		if(student != null)
		{
			hideWindowSearch();
			// procesamiento de datos del estudiante
			// invocacion de la ventana de formulario del programador
			myWindowQueryProgrammer = new ViewProgrammer(this);	
			System.out.println( student.toString());
		}else{
			myViewAd = new ViewAd(Strings.CI_NO_EXISTS);
		}
	}
	/**
	 * este metodo obtiene la informacion del estudiante en un objeto
	 * de tipo estudiante
	 * @param cedulaEstudiante
	 * @return
	 */
	private Student getStudentByCi(String cedulaEstudiante)
	{
		// TODO Auto-generated method stub
		Student student = null;
		DatabaseQueries queries = new DatabaseQueries(conect);
		student = queries.buildStudentByCi(cedulaEstudiante);
		return student;
	}
	
	/**
	 * este metodo cierra la conexion con la base de datos
	 */
	public void closeConnect()
	{
		// TODO Auto-generated method stub
		try
		{
			conect.close();
			System.out.println("Conexion Cerrada");
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * este metodo se encarga de manejar el evento de 
	 * boton de edicion en el formulario del programador
	 */
	public void editToggleFormProgrammer()
	{
		// TODO Auto-generated method stub
		if(myProgrammerForm.getTglbtnEdit().isSelected())
			setEnableFieldsFormProgrammer(true);
		else
			setEnableFieldsFormProgrammer(false);
	}
	/**
	 * este metodo se encarga de activar o desactivar
	 * los campos del formulario del programador
	 * @param b
	 */
	private void setEnableFieldsFormProgrammer(boolean b)
	{
		// TODO Auto-generated method stub
		myProgrammerForm.getTextFieldName().setEditable(b);
		myProgrammerForm.getTextFieldAdress().setEditable(b);
		myProgrammerForm.getTextFieldLastName().setEditable(b);
		myProgrammerForm.getTextFieldEmail().setEditable(b);
		myProgrammerForm.getTextFieldPhone().setEditable(b);
		myProgrammerForm.getTextFieldCarrer().setEditable(b);
		myProgrammerForm.getSpinnerYear().setEnabled(b);
		myProgrammerForm.getBtnSave().setEnabled(b);
	}
	
	/**
	 * este metodo se encarga de controlar el evento
	 * creado por el boton no de la ventana de confirmacion
	 */
	public void EventNot()
	{
		// TODO Auto-generated method stub
	
		myDialogCheckSave.dispose();

	}
	/**
	 *  este metodo se encargar de controlar el evento creado 
	 *  por el boton yes de la ventana de confirmacion
	 */
	public void EventYes()
	{
		// TODO Auto-generated method stub
		switch (varEvent)
		{
			case Events.I_PERSONAL:
				saveDataStudent();
				break;

			case Events.I_VIAJES:
				saveDataTravel();
				break;
			default:
				break;
		}
	}
	/**
	 * este metodo se encarga de guardar la informacion
	 * de los viajes en la base de datos
	 */
	private void saveDataTravel()
	{
		// TODO Auto-generated method stub
				int result;
				DatabaseQueries databaseQueries = new DatabaseQueries(conect);
				
				int days 					= Integer.parseInt(myTravelForm.getTextFieldDays().getText());
				String hostage 		= myTravelForm.getTextFieldHostage().getText();
				String financer 		= myTravelForm.getTextFieldFinancer().getText();
				
				int indexTravel 		= jListaTravel.getSelectedIndex(); 
				String id_equipo	= competitorList.get(indexTravel).getId();
				TeamCompetitor teamCompetitor= new TeamCompetitor(id_equipo,days,financer, hostage);
				
				result = databaseQueries.updateTravel(teamCompetitor);
				
				if(result > 0){
					myDialogCheckSave.dispose();
					myTravelForm.dispose();
					new DialogSaveSucces("Cambios efectuados correctamente");
					invokerWindowProgrammer("Programador");
					System.out.println("actualizacion correcta");
				}else{
					new DialogSaveSucces("Error al efectuar los cambios \n "
							+ "revise la conexion con el servidor");
					myDialogCheckSave.dispose();
					myTravelForm.dispose();
					invokerWindowProgrammer("Programador");
					System.out.println("actualizacion incorrecta");
				}
		
	}
	/**
	 * este metodo se encarga de guardar la informacion del 
	 * estudiante en la base de datos
	 */
	private void saveDataStudent()
	{
		// TODO Auto-generated method stub
		int result;
		DatabaseQueries databaseQueries = new DatabaseQueries(conect);
		SpinnerModel numberModel = myProgrammerForm.getSpinnerYear().getModel();
		String ci 						= myProgrammerForm.getTextFieldCi().getText();
		String name 				= myProgrammerForm.getTextFieldName().getText();
		String lastName 		= myProgrammerForm.getTextFieldLastName().getText();
		String phone				= myProgrammerForm.getTextFieldPhone().getText();	
		String email				= myProgrammerForm.getTextFieldEmail().getText();
		String adress				= myProgrammerForm.getTextFieldAdress().getText();
		int year							= Integer.parseInt(numberModel.getValue().toString());
		String carrer				= myProgrammerForm.getTextFieldCarrer().getText();
	
		student = new Student(ci, name, lastName, email, phone, adress, year, carrer);
		
		result = databaseQueries.updateStudent(student);
		
		if(result > 0){
			myDialogCheckSave.dispose();
			myProgrammerForm.dispose();
			new DialogSaveSucces("Cambios efectuados correctamente");
			invokerWindowProgrammer("Programador");
			System.out.println("actualizacion correcta");
		}else{
			new DialogSaveSucces("Error al efectuar los cambios \n "
					+ "revise la conexion con el servidor");
			myDialogCheckSave.dispose();
			myProgrammerForm.dispose();
			invokerWindowProgrammer("Programador");
			System.out.println("actualizacion incorrecta");
		}
	}
	/**
	 * este metodo modifica la variable global
	 * var event que es importante para 
	 * las operaciones de las acciones 
	 * @param iPersonal
	 */
	public void setVarEvent(int event)
	{
		varEvent = event;
		// TODO Auto-generated method stub
		
	}
	/**
	 * este metodo invoca la ventana de formulario del 
	 * programador
	 */
	public void invokerWindowProgrammerForm()
	{
		// TODO Auto-generated method stub
		
		if(student!=null){
			hideWindowQueryProgrammer();
			setVarEvent(Events.I_PERSONAL);
			
			String ci 						= student.getCi();
			String name 				= student.getName();
			String lastName 		= student.getLastName();
			String phone				= student.getPhone();
			String email				= student.getEmail();
			String adress				= student.getAdress();
			int year							= student.getYear();
			String carrer				= student.getCarrer();
			
			myProgrammerForm = new ViewProgrammerForm(this, name);
			
			myProgrammerForm.getTextFieldCi().setText(ci);
			myProgrammerForm.getTextFieldName().setText(name);
			myProgrammerForm.getTextFieldLastName().setText(lastName);
			myProgrammerForm.getTextFieldPhone().setText(phone);
			myProgrammerForm.getTextFieldEmail().setText(email);
			myProgrammerForm.getTextFieldAdress().setText(adress);
			myProgrammerForm.getSpinnerYear().setValue(year);
			myProgrammerForm.getTextFieldCarrer().setText(carrer);

		}			
	}
	
	/**
	 * este metodo muestra una pantalla
	 * de formulario para los viajes del programador
	 */
	public void invokerWindowViajesForm()
	{
		// TODO Auto-generated method stub
		String ci = student.getCi();
		String[] datos = {""} ;
		competitorList = null;
		DatabaseQueries queries = new DatabaseQueries(conect);
		competitorList = queries.buildListTravelFromStudent(ci);
		
		if(!competitorList .isEmpty()){
			setVarEvent(Events.I_VIAJES);
			hideWindowQueryProgrammer();
			for (int i = 0; i < competitorList.size(); i++)
			{
				datos[i]= "Viaje "+ i+1;
			} 
			jListaTravel = new JList(datos);
			jListaTravel.addMouseListener(new MouseListener()
			{
				
				@Override
				public void mouseReleased(MouseEvent e)
				{
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e)
				{
					// TODO Auto-generated method stub
					fillFormTravel();
				}
				
				@Override
				public void mouseExited(MouseEvent e)
				{
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e)
				{
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e)
				{
					// TODO Auto-generated method stub
					
				}
			});
			myTravelForm = new ViewTravelForm(this, student.getName());
			myTravelForm.getScrollPane().setViewportView(jListaTravel);
			
			myTravelForm.getTextFieldCi().setText(student.getCi());
			myTravelForm.getTextFieldName().setText(student.getName());
			myTravelForm.getTextFieldLastName().setText(student.getLastName());
		}else{
			myViewAd = new ViewAd("Usted no posee Viajes");
		}
			
	}
	/**
	 * este metodo se encarga de rellenar
	 * el formulario de viajes cada vez que 
	 * se selecciona un nuevo item de la jList
	 */
	public void fillFormTravel()
	{
		// TODO Auto-generated method stub
		if(jListaTravel != null){
			int indexTravel = jListaTravel.getSelectedIndex();
			TeamCompetitor teamCompetitor = competitorList.get(indexTravel);
			int days = teamCompetitor.getDaysTravel();
			String hostage = teamCompetitor.getHosting();
			String  financer= teamCompetitor.getFinancier();
			
			myTravelForm.getTextFieldDays().setText(Integer.toString(days));
			myTravelForm.getTextFieldFinancer().setText(financer);
			myTravelForm.getTextFieldHostage().setText(hostage);
			
		}
	}
	
	/**
	 * este metodo se encarga de habilitar o deshabilitar
	 * la edicion del formilario de los viajes de programador
	 */
	public void editToggleFormTravelProgrammer()
	{
		// TODO Auto-generated method stub
		if(myTravelForm.getTglbtnEdit().isSelected())
			setEnableFieldsFormTravelProgrammer(true);
		else
			setEnableFieldsFormTravelProgrammer(false);
	}
	/**
	 * habilita o dehabilita la edicion del formulario
	 * @param b
	 */
	private void setEnableFieldsFormTravelProgrammer(boolean b)
	{
		// TODO Auto-generated method stub
		myTravelForm.getTextFieldDays().setEditable(b);
		myTravelForm.getTextFieldFinancer().setEditable(b);
		myTravelForm.getTextFieldHostage().setEditable(b);
		myTravelForm.getBtnSave().setEnabled(b);
	}
	
	/**
	 * este metodo es obtiene la informacion
	 * de la consulta 1
	 */
	public void invokerWindowConsulta1()
	{
		// TODO Auto-generated method stub
		TableModel tableModel = null;
		DatabaseQueries databaseQueries = new DatabaseQueries(conect);
		tableModel = databaseQueries.buildTableModelConsulta1();
		if(tableModel != null){
			JTable jTable = new JTable(tableModel);
			ViewConsultas viewConsultas = new ViewConsultas("Estudiante de facyt que ha participado en mas maratones de programacion en toda la historia");
			viewConsultas.getScrollPane().setViewportView(jTable);
		}else{
			new ViewAd("No existen Estudiantes de Facyt");
			System.out.println("no existen datos en  la bd");
		}
	}
	
	/**
	 * este metodo es obtiene la informacion
	 * de la consulta 2
	 */
	
	public void invokerWindowConsulta2()
	{
		// TODO Auto-generated method stub
		TableModel tableModel = null;
		DatabaseQueries databaseQueries = new DatabaseQueries(conect);
		tableModel = databaseQueries.buildTableModelConsulta2();
		if(tableModel != null){
			JTable jTable = new JTable(tableModel);
			jTable.setCellSelectionEnabled(false);
			ViewConsultas viewConsultas = new ViewConsultas("Los Mas Problemas Resueltos y sus integrantes");
			viewConsultas.getScrollPane().setViewportView(jTable);
		}else{
			new ViewAd("No existen problemas");
			System.out.println("no existen datos en  la bd");
		}
	}
	
	/**
	 * este metodo es obtiene la informacion
	 * de la consulta 3
	 */
	
	public void invokerWindowConsulta3()
	{
		// TODO Auto-generated method stub
				TableModel tableModel = null;
				DatabaseQueries databaseQueries = new DatabaseQueries(conect);
				tableModel = databaseQueries.buildTableModelConsulta3();
				if(tableModel != null){
					JTable jTable = new JTable(tableModel);
					jTable.setCellSelectionEnabled(false);
					ViewConsultas viewConsultas = new ViewConsultas("El profesor que ha entrenado a equipos y que en el pasado ha sido estudiante");
					viewConsultas.getScrollPane().setViewportView(jTable);
				}else{
					new ViewAd("No existen profesores");
					System.out.println("no existen datos en  la bd");
				}
	}
	
	/**
	 * este metodo obtiene la informacion de quienes son los
	 * profesores de programador
	 */
	public void invokerWindowConsultaProfesores()
	{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		TableModel tableModel = null;
		DatabaseQueries databaseQueries = new DatabaseQueries(conect);
		tableModel = databaseQueries.buildTableModelConsultaProfesores(student.getCi());
		if(tableModel != null){
			JTable jTable = new JTable(tableModel);
			jTable.setCellSelectionEnabled(false);
			ViewConsultas viewConsultas = new ViewConsultas("Mis profesores");
			viewConsultas.getScrollPane().setViewportView(jTable);
		}else{
			new ViewAd("No existen profesores");
			System.out.println("no existen datos en  la bd");
		}
	}
	/**
	 * este metodo obtiene la informacion de los problemas resueltos
	 * del programador
	 */
	public void invokerWindowConsultaProblemasResueltos()
	{
				// TODO Auto-generated method stub
				TableModel tableModel = null;
				DatabaseQueries databaseQueries = new DatabaseQueries(conect);
				tableModel = databaseQueries.buildTableModelConsultaProblemasResueltos(student.getCi());
				if(tableModel != null){
					JTable jTable = new JTable(tableModel);
					jTable.setCellSelectionEnabled(false);
					ViewConsultas viewConsultas = new ViewConsultas("Mis problemas resueltos");
					viewConsultas.getScrollPane().setViewportView(jTable);
				}else{
					new ViewAd("No tienes problemas resueltos");
					System.out.println("no existen datos en  la bd");
				}
	}
	/**
	 * este metodo obtiene la informacion de las competencias
	 * del programador
	 */
	public void invokerWindowConsultaCompetencias()
	{
		// TODO Auto-generated method stub
		TableModel tableModel = null;
		DatabaseQueries databaseQueries = new DatabaseQueries(conect);
		tableModel = databaseQueries.buildTableModelConsultaCompetencias(student.getCi());
		if(tableModel != null){
			JTable jTable = new JTable(tableModel);
			jTable.setCellSelectionEnabled(false);
			ViewConsultas viewConsultas = new ViewConsultas("Mis participaciones en competencias");
			viewConsultas.getScrollPane().setViewportView(jTable);
		}else{
			new ViewAd("No tienes participaciones en competencias");
			System.out.println("no existen datos en  la bd");
		}
	}
	
	
	/**
	 * este metodo se encargara de editar los equipos
	 * agregar o quitar informacion
	 */
	public void invokerWindowVerEquipos()
	{
				equipos = null;
				DatabaseQueries databaseQueries = new DatabaseQueries(conect);
				equipos = databaseQueries.buildListEquipos();
				varEvent = Events.EQUIPO;
				if(!equipos.isEmpty()){
					TableModel tableModel = equipos.toTableModel(); 
					jTable = new JTable(tableModel);
					
					myWindowQueryCoordinator.getScrollPane().setViewportView(jTable);
					//ViewFrameEditor viewFrame = new ViewFrameEditor("Editor de Equipos");
					//jTable.setCellSelectionEnabled(false);
					
					//viewConsultas.getScrollPane().setViewportView(jTable);
				}else{
					new ViewAd("No tienes participaciones en competencias");
					System.out.println("no existen datos en  la bd");
				}
	}
	
	/**
	 * este metodo controla todas
	 * las acciones de eliminar de
	 * la ventana del coordinador
	 */
	public void EventoEliminar()
	{
		// TODO Auto-generated method stub
		switch (varEvent)
		{
			case Events.EQUIPO:
				eliminarEquipo();
				break;
				
			case Events.COMPETENCIA:
				eliminarCompetencia();
				break;
			case Events.PROBLEMA_RESUELTO:
				//eliminarProblemaResuelto();
				break;
			case Events.VIAJE:
				//eliminarViaje();
				break;
			case Events.PROGRAMADOR:
				//eliminarProgramador();
				break;
			case Events.PROFESOR:
				//eliminarProfesor();
				break;

			default:
				break;
		}
	}
	
	/** 
	 * este metodo se encarga de eliminar una 
	 * competencia selecionada
	 */
	private void eliminarCompetencia()
	{
		// TODO Auto-generated method stub
				int index = jTable.getSelectedRow();
				if(index >= 0 && index <= competitionList.size()){
					String id = competitionList.get(index).getId();
					competitionList.remove(index);
					DatabaseQueries databaseQueries = new DatabaseQueries(conect);
					DefaultTableModel tableModel = competitionList.toTableModel();
					jTable.setModel(tableModel);
					tableModel.fireTableDataChanged();
					int result = databaseQueries.eliminarCompetenciaById(id);
					if(result > 0){
						new ViewAd("Se ha Borrado La competencia correctamente");
					}else{
						new ViewAd("No se ha borrado el equipo consulte su conexion");
					}
				}
	}
	/**
	 * elimina el equipo seleccionado 
	 * del jtable
	 */
	private void eliminarEquipo()
	{
		// TODO Auto-generated method stub
		int index = jTable.getSelectedRow();
		if(index >= 0 && index <= equipos.size()){
			String id = equipos.get(index).getId();
			equipos.remove(index);
			DatabaseQueries databaseQueries = new DatabaseQueries(conect);
			DefaultTableModel tableModel = equipos.toTableModel();
			jTable.setModel(tableModel);
			tableModel.fireTableDataChanged();
			int result = databaseQueries.eliminarEquipoById(id);
			if(result > 0){
				new ViewAd("Se ha Borrado el Equipo correctamente");
			}else{
				new ViewAd("No se ha borrado el equipo consulte su conexion");
			}
		}
	}
	
	/**
	 * construye el jtable de las competencias
	 */
	public void invokerWindowVerCompetencias()
	{
		competitionList = null;
		DatabaseQueries databaseQueries = new DatabaseQueries(conect);
		competitionList = databaseQueries.buildListCompetition();
		varEvent = Events.COMPETENCIA;
		if(!competitionList.isEmpty()){
			TableModel tableModel = competitionList.toTableModel(); 
			jTable = new JTable(tableModel);
			
			myWindowQueryCoordinator.getScrollPane().setViewportView(jTable);
			//ViewFrameEditor viewFrame = new ViewFrameEditor("Editor de Equipos");
			//jTable.setCellSelectionEnabled(false);
			
			//viewConsultas.getScrollPane().setViewportView(jTable);
		}else{
			new ViewAd("No tienes participaciones en competencias");
			System.out.println("no existen datos en  la bd");
		}
		
	}
}




























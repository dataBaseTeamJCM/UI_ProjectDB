package db;

import java.sql.*;

public class Conexion {

	private String user;
	private String url;
	private char[] password;
	private Connection connection = null;
	private ResultSet rs = null;
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	public Connection Conectar()
	{//
			try{
				System.out.println(url);
				Class.forName("org.postgresql.Driver");
				this.connection = DriverManager.getConnection
								(url,this.user,
								new String(this.password));
			}catch(Exception e){
				System.out.println("error en conectar a la base de datos");
			}
			return this.connection;
	}
	public Conexion(String usr, char[] password){
		this.url ="jdbc:postgresql://localhost:5432/" + DatabaseConstants.DATABASE_NAME;
		System.out.println(this.url);
		this.password =password;
		this.user = usr;
	}
	
	public Conexion(Connection conn)
	{
		this.setConnection(conn);
	}
	
	/*public void cerrarConexion() throws ConnectException {
		try {
			this.connection.close();
		}catch (SQLException e) {
			throw new ConnectException("Ha ocurrido un error al intentar "
					+ "cerrar la conexion con PSQL. Error: "+ e.getMessage());
		}
		
	}*/
	
	/*public void createQuery(String sql)
	{
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("error en la ejecucion de la consulta: " + sql);
			// TODO: handle exception
		}
	}
	*/
}

package com.marwilc.connection;

import java.sql.*;
import java.util.logging.*;

public class Conexion {

	String user;
	String url;
	char[] password;
	Connection connection = null;

	public Connection Conectar()
	{//
			try{
				System.out.println(url);
				Class.forName("org.postgresql.Driver");
				this.connection = DriverManager.getConnection(url,this.user,new String(this.password));
			}catch(Exception e){

			}
			return this.connection;
	}
	public Conexion(String usr, char[] password){
		this.url ="jdbc:postgresql://localhost:5432/bancobd22"+usr;
		System.out.println(this.url);
		this.password =password;
		this.user = usr;
	}
	
}

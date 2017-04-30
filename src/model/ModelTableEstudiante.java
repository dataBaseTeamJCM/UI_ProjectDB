package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import controller.Coordinator;

public class ModelTableEstudiante {
	
	private Coordinator myCoordinator;
		
	public void setCoordinator(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
	}


	public ModelTableEstudiante(Coordinator myCoordinator) {
		super();
		this.myCoordinator = myCoordinator;
	}

	public String queryAllEstudents(){
		String sql = "SELECT it.ci,"
					+ "it.nombre,"
					+ "it.direccion,"
					+ "est.año_e "
					+ "FROM mtn.integrante AS it "
					+ "JOIN mtn.es_un_estudiante AS est ON it.ci=est.ci_e "
					+ "ORDER BY ci ASC;";
		return(sql);
	}
	
	/*public String showListStudents(){
		String sql = "SELECT * "
					+ "FROM mtn.es_un_estudiante "
					+ "ORDER BY ci_e ASC;";
	}
	*/
}

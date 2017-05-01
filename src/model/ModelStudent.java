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

public class ModelStudent {
	private String ci;
	private int	year;
	private	String carrer;
	
	public String getCi() {
		return ci;
	}


	public void setCi(String ci) {
		this.ci = ci;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String getCarrer() {
		return carrer;
	}


	public void setCarrer(String carrer) {
		this.carrer = carrer;
	}

	public ModelStudent(String ci, int year, String carrer) {
		super();
		this.ci = ci;
		this.year = year;
		this.carrer = carrer;
	}


	public ModelStudent(String ci) {
		super();
		this.ci = ci;
	}

	public static String queryAllEstudents(){
		String sql = "SELECT it.ci,"
					+ "it.nombre,"
					+ "it.direccion,"
					+ "est.año_e "
					+ "FROM mtn.integrante AS it "
					+ "JOIN mtn.es_un_estudiante AS est ON it.ci=est.ci_e "
					+ "ORDER BY ci ASC;";
		return(sql);
	}
	
	public static String queryAnStudentByCi(String ci){
		String sql = "SELECT est.ci_e, "
					+ "est.año_e "
					+ "FROM mtn.es_un_estudiante AS est "
					+ "WHERE est.ci_e = '" + ci +"';";
					
					
		return(sql);
	}
	
}

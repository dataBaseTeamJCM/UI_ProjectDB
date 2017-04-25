package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controller.Coordinator;

public class Logic {
	
	private Coordinator myCoordinator;
	private Object tabel;
	private Object conn;

	public void setCoordinator(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
	}
	
	public Logic(){
		PreparedStatement pst=conn.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		tabel.setModel(DbUtils.resultSetToTableModel(rs)); 
	}
}

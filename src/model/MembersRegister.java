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

public class MembersRegister {
	
	private Coordinator myCoordinator;
	private JTable jtable;
	

		
	public void setCoordinator(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
	}
	

	public JTable getJtable() {
		return jtable;
	}

	public void setJtable(JTable jtable) {
		this.jtable = jtable;
	}

	public MembersRegister(Coordinator myCoordinator) {
		super();
		this.myCoordinator = myCoordinator;
	}

	public void showListMembers(){
		String sql = "SELECT * "
					+ "FROM mtn.integrante";
		Connection connect = myCoordinator.getConect();
		Statement st = null;
		ResultSet rs = null;
		System.out.println(connect);
		try {
			st = connect.createStatement();
			st.executeQuery(sql);
			rs = st.executeQuery(sql);
			this.setJtable(new JTable(DbUtils.resultSetToTableModel(rs)));
		} catch (SQLException e) {
			System.out.println("error en la ejecucion de la consulta");
			// TODO: handle exception
		}finally {
			try {
				rs.close();	
			} catch (SQLException e2) {
				// TODO: handle exception
			}
			try {
				st.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}

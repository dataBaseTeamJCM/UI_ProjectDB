package model;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class TeamCompetitorList extends ArrayList<TeamCompetitor> implements ICustomList{

	
	private TeamCompetitor instance;
	
	public TeamCompetitorList() {
		// TODO Auto-generated constructor stub
	}
	
	
	public TeamCompetitor getInstance() {
		return instance;
	}


	public void setInstance(TeamCompetitor instance) {
		this.instance = instance;
	}


	@Override
	public void print() {
		// TODO Auto-generated method stub
		String print = "";
		for (TeamCompetitor teamCompetitor: this) {
			print += teamCompetitor.toString() + "\n";
		}
		System.out.println(print);
	}


	@Override
	public DefaultListModel toListModel() {
		// TODO Auto-generated method stub
		return null;
	}


	public DefaultTableModel toTableModel()
	{
		// TODO Auto-generated method stub
				// create names for columns 
				String columnNames[] = { "ID","Equipo" }; 

				DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0)
				{
					@Override
					public boolean isCellEditable(int row, int column)
					{
						//* set editable false table model */
						return false;
					}
				};
			
				for (TeamCompetitor teamCompetitor: this )
				{
					String id = teamCompetitor.getId();
					String name = teamCompetitor.getName();

					//*build object with name Trips */
					Object[] data = { id,name }; 
					tableModel.addRow(data); //* add row to table model */
				}
				return tableModel;
	}

}

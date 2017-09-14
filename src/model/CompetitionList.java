package model;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class CompetitionList extends ArrayList<Competition> implements ICustomList {

	private CompetitionList instance;
	
	
	
	
	public CompetitionList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompetitionList getInstance() {
		return instance;
	}

	public void setInstance(CompetitionList instance) {
		this.instance = instance;
	}

	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		String print = "";
		for (Competition competition: this) {
			print += competition.toString() + "\n";
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
		String columnNames[] = { "ID","Competencia" }; 

		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0)
		{
			@Override
			public boolean isCellEditable(int row, int column)
			{
				//* set editable false table model */
				return false;
			}
		};
	
		for (Competition competition: this )
		{
			String id = competition.getId();
			String name = competition.getName();

			//*build object with name Trips */
			Object[] data = { id,name }; 
			tableModel.addRow(data); //* add row to table model */
		}
		return tableModel;
	}

}

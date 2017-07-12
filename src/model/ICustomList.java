package model;

import javax.swing.DefaultListModel;

public interface ICustomList {

	public void print();
	public DefaultListModel<String> toListModel();
}

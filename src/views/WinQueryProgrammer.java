package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import controller.Coordinator;
import model.ModelTableIntegrate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import views.colorMD.MaterialDesignColor;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToolBar;
import java.awt.Button;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;

public class WinQueryProgrammer extends JFrame implements ActionListener {
	private Coordinator myCoordinator;
	private JTable table;
	private JTable table_1;
	private JMenuItem intemSalir;
	
	public void setCoordinator(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
	}

	/**
	 * Create the frame.
	 */
	public WinQueryProgrammer(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
		setBounds(0, 0, 800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		getContentPane().setBackground(new MaterialDesignColor("0288D1"));
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(-566, -846, 800, 690);
		getContentPane().add(tabbedPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 800, 32);
		
		getContentPane().add(toolBar);
		
		JSeparator separator = new JSeparator();
		toolBar.add(separator);
		
		
		table = new JTable();
		table = myCoordinator.listStudents();
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu menu = new JMenu("Menu");
		menuBar.add(menu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		menu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		menu.add(mntmNewMenuItem_2);
		
		intemSalir = new JMenuItem("Salir");
		intemSalir.setIcon(new ImageIcon(WinQueryProgrammer.class.getResource("/views/icons/ic_close_black_16dp.png")));
		menu.add(intemSalir);
		
		intemSalir.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==intemSalir) {
			myCoordinator.invokerWindowLogin();
			myCoordinator.hideWindowQueryProgrammer();
			try {
				myCoordinator.getConect().close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}

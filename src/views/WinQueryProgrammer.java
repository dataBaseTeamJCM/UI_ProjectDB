package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import controller.Coordinator;
import model.ModelTableEstudiante;

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
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

public class WinQueryProgrammer extends JFrame implements ActionListener {
	private Coordinator myCoordinator;
	private JTable table;
	private JTable table_1;
	private JMenuItem intemSalir;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JMenuItem mntmInfoPersonal;
	private JMenuItem mntmProblemaR;
	private JMenuItem mntmCompetencia;
	private JMenuItem mntmMiCoach;
	
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
		getContentPane().setLayout(new CardLayout(0, 0));
		
		//this.buildTabInformacionPersonal(); // recuerda eliminar cuando se termine la edicion
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(192, 192, 192));
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		intemSalir = new JMenuItem("Salir");
		intemSalir.setIcon(new ImageIcon(WinQueryProgrammer.class.getResource("/views/icons/ic_close_black_16dp.png")));
		mnMenu.add(intemSalir);
		
		JMenu mnVer = new JMenu("Ver");
		menuBar.add(mnVer);
		
		mntmInfoPersonal = new JMenuItem("Mi Informacion Personal");
		mnVer.add(mntmInfoPersonal);
		
		mntmProblemaR = new JMenuItem("Problemas Resueltos");
		mnVer.add(mntmProblemaR);
		
		mntmCompetencia = new JMenuItem("Competencia");
		mnVer.add(mntmCompetencia);
		
		mntmMiCoach = new JMenuItem("Mi Coach y Representante");
		mnVer.add(mntmMiCoach);
		
		intemSalir.addActionListener(this);
		mntmInfoPersonal.addActionListener(this);
		mntmProblemaR.addActionListener(this);
		mntmCompetencia.addActionListener(this);
		mntmMiCoach.addActionListener(this);
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
		if (e.getSource() == mntmInfoPersonal){
			this.myCoordinator.invokerWindowSearch();
			this.buildTabInformacionPersonal();
			
		}
		if (e.getSource() == mntmCompetencia) {
			
		}
		if (e.getSource() == mntmProblemaR) {
			
		}
		if (e.getSource() == mntmMiCoach) {
			
		}
	}
	
	public void buildTabInformacionPersonal(){
		
		ImageIcon iconEstTab = new ImageIcon(WinQueryProgrammer.class.getResource("/views/icons/ic_person_black_18dp.png"));
		String arrayItems[] = new String[] { "1","2","3","4","5"}; 
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new MaterialDesignColor("03A9F4"));
		getContentPane().add(tabbedPane, "name_4333444589830");
		
		JPanel panel = new JPanel();
		panel.setBackground(new MaterialDesignColor("03A9F4"));
		tabbedPane.addTab("Informacion Personal",iconEstTab, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new MaterialDesignColor("03A9F4"));
		panel.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("Guardar");
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(WinQueryProgrammer.class.getResource("/views/icons/ic_archive_white_24dp.png")));
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpiar");
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel_2.add(btnNewButton_3);
		
		
		table = new JTable();
		table = myCoordinator.listMembers();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new MaterialDesignColor("03A9F4"));
		panel.add(panel_1, BorderLayout.EAST);
		
		JLabel lblNewLabel = new JLabel("CI");
		lblNewLabel.setForeground(Color.WHITE);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(Color.WHITE);
		
		JLabel lblAo = new JLabel("Direccion");
		lblAo.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_1 = new JLabel("Año");
		lblNewLabel_1.setForeground(Color.WHITE);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(arrayItems));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombre)
								.addComponent(lblApellido)
								.addComponent(lblAo)
								.addComponent(lblNewLabel_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
									.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
									.addGroup(gl_panel_1.createSequentialGroup()
										.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
											.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
											.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED))))))
					.addContainerGap(27, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNombre)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellido)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAo)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(442))
		);
		panel_1.setLayout(gl_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(table);
	}
}

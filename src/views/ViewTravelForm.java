package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import controller.Coordinator;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;

public class ViewTravelForm extends JFrame implements ActionListener, ViewsAddons
{

	private JPanel contentPane;
	private Coordinator myCoordinator;
	private JTextField textFieldHostage;
	private JTextField  textFieldCi;
	private JTextField  textFieldFinancer;
	private JTextField  textFieldLastName;
	private JTextField  textFieldDays;
	private JTextField  textFieldName;
	private JToggleButton tglbtnEdit;
	private JButton btnSave;
	private JButton btnCancel;
	private JList list;
	private JScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	public ViewTravelForm(Coordinator coordinator, String name)
	{
		this.myCoordinator =coordinator;
		setBounds(0, 0, 600, 350);
		
		/*
		 * colocar la ventana  en el centro de la pantalla
		 */
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//obtenemos el tamaño de la ventana
		Dimension ventana = getSize();
		//para centrar la ventana lo hacemos con el siguiente calculo
		setLocation((screenSize.width - ventana.width) / 2, (screenSize.height - ventana.height) / 2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		setTitle("Informacion De los viajes del programador: " + name);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		addPanelList();
		addPanelButtons();
		addPanelForm();
	}
	
	public JTextField getTextFieldHostage()
	{
		return textFieldHostage;
	}

	public void setTextFieldHostage(JTextField textFieldHostage)
	{
		this.textFieldHostage = textFieldHostage;
	}

	public JTextField getTextFieldCi()
	{
		return textFieldCi;
	}

	public void setTextFieldCi(JTextField textFieldCi)
	{
		this.textFieldCi = textFieldCi;
	}

	public JTextField getTextFieldFinancer()
	{
		return textFieldFinancer;
	}

	public void setTextFieldFinancer(JTextField textFieldFinancer)
	{
		this.textFieldFinancer = textFieldFinancer;
	}

	public JTextField getTextFieldLastName()
	{
		return textFieldLastName;
	}

	public void setTextFieldLastName(JTextField textFieldLastName)
	{
		this.textFieldLastName = textFieldLastName;
	}

	public JTextField getTextFieldDays()
	{
		return textFieldDays;
	}

	public void setTextFieldDays(JTextField textFieldDays)
	{
		this.textFieldDays = textFieldDays;
	}

	public JTextField getTextFieldName()
	{
		return textFieldName;
	}

	public void setTextFieldName(JTextField textFieldName)
	{
		this.textFieldName = textFieldName;
	}

	public JToggleButton getTglbtnEdit()
	{
		return tglbtnEdit;
	}

	public void setTglbtnEdit(JToggleButton tglbtnEdit)
	{
		this.tglbtnEdit = tglbtnEdit;
	}

	public JButton getBtnSave()
	{
		return btnSave;
	}

	public void setBtnSave(JButton btnSave)
	{
		this.btnSave = btnSave;
	}

	public JButton getBtnCancel()
	{
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel)
	{
		this.btnCancel = btnCancel;
	}

	public JList getList()
	{
		return list;
	}

	public void setList(JList list)
	{
		this.list = list;
	}

	public JScrollPane getScrollPane()
	{
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane)
	{
		this.scrollPane = scrollPane;
	}

	@Override
	public void addPanelButtons()
	{
		// TODO Auto-generated method stub
		JPanel panelButtons = new JPanel();
		getContentPane().add(panelButtons, BorderLayout.SOUTH);
		panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		tglbtnEdit = new JToggleButton("Editar");
		tglbtnEdit.addActionListener(this);
		panelButtons.add(tglbtnEdit);
		
		{
			btnSave = new JButton("Guardar");
			btnSave.addActionListener(this);
			
			btnSave.setEnabled(false);
			panelButtons.add(btnSave);
		}
		{
			btnCancel = new JButton("Cancelar");
			btnCancel.addActionListener(this);
			panelButtons.add(btnCancel);
		}
	}

	@Override
	public void addJmenuBar()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPanelForm()
	{
		JPanel panelForm = new JPanel();
		getContentPane().add(panelForm, BorderLayout.CENTER);
		panelForm.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblCI = new JLabel("CI");
		panelForm.add(lblCI, "4, 4");
		
		JLabel lblName = new JLabel("Nombre");
		panelForm.add(lblName, "8, 4");
		
		JLabel lblLastName = new JLabel("Apellido");
		panelForm.add(lblLastName, "16, 4");
		
		textFieldCi = new JTextField();
		panelForm.add(textFieldCi, "4, 6, fill, default");
		textFieldCi.setColumns(10);
		textFieldCi.setEditable(false);
		
		textFieldName = new JTextField();
		panelForm.add(textFieldName, "8, 6, 5, 1, fill, default");
		textFieldName.setColumns(10);
		textFieldName.setEditable(false);
		
		textFieldLastName = new JTextField();
		panelForm.add(textFieldLastName, "16, 6, 7, 1, fill, default");
		textFieldLastName.setColumns(10);
		textFieldLastName.setEditable(false);
		
		JLabel lblTitleDataTravel = DefaultComponentFactory.getInstance().createTitle("Informacion de los viajes");
		panelForm.add(lblTitleDataTravel, "4, 10");
		
		JSeparator separator = new JSeparator();
		panelForm.add(separator, "4, 12, 19, 1");
		
		JLabel lblDays = new JLabel("Dias de viaje");
		panelForm.add(lblDays, "4, 14");
		
		JLabel lblFinancer = new JLabel("Financista");
		panelForm.add(lblFinancer, "8, 14");
		
		textFieldDays = new JTextField();
		panelForm.add(textFieldDays, "4, 16, fill, default");
		textFieldDays.setColumns(10);
		textFieldDays.setEditable(false);
		
		textFieldFinancer = new JTextField();
		panelForm.add(textFieldFinancer, "8, 16, 15, 1, fill, default");
		textFieldFinancer.setColumns(10);
		textFieldFinancer.setEditable(false);
		
		JLabel lblHostage = new JLabel("Lugar de hospedaje ");
		panelForm.add(lblHostage, "4, 18");
		
		textFieldHostage = new JTextField();
		panelForm.add(textFieldHostage, "4, 20, 19, 1, fill, default");
		textFieldHostage.setColumns(10);
		textFieldHostage.setEditable(false);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource()== btnCancel){
			myCoordinator.showWindowQueryProgrammer();
			myCoordinator.hideWindowViewTravelForm();
		}
		
		if(e.getSource()==btnSave){
			myCoordinator.invokerWindowCheckSave();
		}
		
		if(e.getSource() == tglbtnEdit){
			myCoordinator.editToggleFormTravelProgrammer();
		}
		
	}

	@Override
	public void addPanelList()
	{
		// TODO Auto-generated method stub
		JPanel panelList = new JPanel();
		getContentPane().add(panelList, BorderLayout.WEST);
		scrollPane = new JScrollPane(list);
		panelList.add(scrollPane);
	
	}
	

}

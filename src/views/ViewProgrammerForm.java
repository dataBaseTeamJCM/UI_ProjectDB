package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Coordinator;
import java.awt.FlowLayout;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;

public class ViewProgrammerForm extends JFrame implements ActionListener, ViewsAddons
{
	private Coordinator myCoordinator;
	private JTextField textFieldCi;
	private JTextField textFieldName;
	private JTextField textFieldLastName;
	private JTextField textFieldPhone;
	private JTextField textFieldEmail;
	private JTextField textFieldAdress;
	private JTextField textFieldCarrer;
	private JToggleButton tglbtnEdit;
	private JButton btnSave;
	private JButton btnCancel;
	private JSpinner spinnerYear;

	/**
	 * Create the frame.
	 */
	public ViewProgrammerForm(Coordinator coordinator, String name)
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
		
		setTitle("Informacion Personal del Programador: " + name);
		getContentPane().setLayout(new BorderLayout(0, 0));
	
		addPanelButtons();
		addPanelForm();
	}
	
	public JTextField getTextFieldCi()
	{
		return textFieldCi;
	}
	public void setTextFieldCi(JTextField textFieldCi)
	{
		this.textFieldCi = textFieldCi;
	}
	public JTextField getTextFieldName()
	{
		return textFieldName;
	}
	public void setTextFieldName(JTextField textFieldName)
	{
		this.textFieldName = textFieldName;
	}
	public JTextField getTextFieldLastName()
	{
		return textFieldLastName;
	}
	public void setTextFieldLastName(JTextField textFieldLastName)
	{
		this.textFieldLastName = textFieldLastName;
	}
	public JTextField getTextFieldPhone()
	{
		return textFieldPhone;
	}
	public void setTextFieldPhone(JTextField textFieldPhone)
	{
		this.textFieldPhone = textFieldPhone;
	}
	public JTextField getTextFieldEmail()
	{
		return textFieldEmail;
	}
	public void setTextFieldEmail(JTextField textFieldEmail)
	{
		this.textFieldEmail = textFieldEmail;
	}
	public JTextField getTextFieldAdress()
	{
		return textFieldAdress;
	}
	public void setTextFieldAdress(JTextField textFieldAdress)
	{
		this.textFieldAdress = textFieldAdress;
	}
	public JTextField getTextFieldCarrer()
	{
		return textFieldCarrer;
	}
	public void setTextFieldCarrer(JTextField textFieldCarrer)
	{
		this.textFieldCarrer = textFieldCarrer;
	}

	public JSpinner getSpinnerYear()
	{
		return spinnerYear;
	}

	public void setSpinnerYear(JSpinner spinnerYear)
	{
		this.spinnerYear = spinnerYear;
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
		
		btnSave = new JButton("Guardar");
		btnSave.addActionListener(this);
		panelButtons.add(btnSave);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(this);
		btnSave.setEnabled(false);
		panelButtons.add(btnCancel);
		
		
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
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblCI = new JLabel("CI");
		panelForm.add(lblCI, "4, 4");
		
		JLabel lblName = new JLabel("Nombre");
		panelForm.add(lblName, "12, 4");
		
		JLabel lblLastName = new JLabel("Apellido");
		panelForm.add(lblLastName, "18, 4");
		
		textFieldCi = new JTextField();
		panelForm.add(textFieldCi, "4, 6, 6, 1, fill, default");
		textFieldCi.setColumns(10);
		
		textFieldName = new JTextField();
		panelForm.add(textFieldName, "12, 6, 4, 1, fill, default");
		textFieldName.setColumns(10);
		
		textFieldLastName = new JTextField();
		panelForm.add(textFieldLastName, "18, 6, 3, 1, fill, default");
		textFieldLastName.setColumns(10);
		
		JLabel lblPhone = new JLabel("Telefono");
		panelForm.add(lblPhone, "4, 8");
		
		JLabel lblEmail = new JLabel("Email");
		panelForm.add(lblEmail, "12, 8");
		
		textFieldPhone = new JTextField();
		panelForm.add(textFieldPhone, "4, 10, 6, 1, fill, default");
		textFieldPhone.setColumns(10);
		
		textFieldEmail = new JTextField();
		panelForm.add(textFieldEmail, "12, 10, 9, 1, fill, default");
		textFieldEmail.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion");
		panelForm.add(lblDireccion, "4, 12");
		
		textFieldAdress = new JTextField();
		panelForm.add(textFieldAdress, "4, 14, 17, 1, fill, default");
		textFieldAdress.setColumns(10);
		
		JLabel lblYear = new JLabel("Año Estudiante");
		panelForm.add(lblYear, "4, 16");
		
		JLabel lblCarrer = new JLabel("Carrera");
		panelForm.add(lblCarrer, "12, 16");
		
		SpinnerNumberModel numberModel = new SpinnerNumberModel();
		numberModel.setMaximum(5);
		numberModel.setMinimum(1);
		spinnerYear = new JSpinner(numberModel);
		panelForm.add(spinnerYear, "4, 18");
		
		textFieldCarrer = new JTextField();
		textFieldAdress.setEditable(false);
		textFieldCarrer.setEditable(false);
		textFieldCi.setEditable(false);
		textFieldEmail.setEditable(false);
		textFieldLastName.setEditable(false);
		textFieldPhone.setEditable(false);
		textFieldName.setEditable(false);
		spinnerYear.setEnabled(false);
		panelForm.add(textFieldCarrer, "12, 18, 9, 1, fill, default");
		textFieldCarrer.setColumns(10);
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
	
		if(e.getSource() == btnCancel){
			myCoordinator.showWindowSearch();
			myCoordinator.hideWindowProgrammerForm();
		}
		if (e.getSource() == tglbtnEdit){
			myCoordinator.editToggleFormProgrammer();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

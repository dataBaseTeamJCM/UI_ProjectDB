package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Coordinator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;

public class DialogSaveSucces extends JDialog implements ActionListener, ViewsAddons
{

	private final JPanel contentPanel = new JPanel();
	private JButton btnAcept;
	private JLabel lblNewLabel;


	/**
	 * Create the dialog.
	 */
	public DialogSaveSucces(String message)
	{
		setResizable(false);
		setBounds(0, 0, 450, 200);
		/*
		 * colocar la ventana  en el centro de la pantalla
		 */
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//obtenemos el tamaño de la ventana
		Dimension ventana = getSize();
		//para centrar la ventana lo hacemos con el siguiente calculo
		setLocation((screenSize.width - ventana.width) / 2, (screenSize.height - ventana.height) / 2);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		setTitle("Aviso");
	
		lblNewLabel = new JLabel(message);
		
		addPanelButtons();
		addPanelForm();
		setVisible(true);
		

}


	@Override
	public void addPanelButtons()
	{
		// TODO Auto-generated method stub
		JPanel panelButtons = new JPanel();
		getContentPane().add(panelButtons, BorderLayout.SOUTH);
		
		btnAcept = new JButton("Aceptar");
		btnAcept.addActionListener(this);
		panelButtons.add(btnAcept);
	}


	@Override
	public void addJmenuBar()
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addPanelForm()
	{
		// TODO Auto-generated method stub
		JPanel panelForm = new JPanel();
		getContentPane().add(panelForm, BorderLayout.CENTER);
		panelForm.setLayout(null);
		
		
		lblNewLabel.setBounds(80, 65, 252, 15);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblNewLabel);
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource()== btnAcept){
			this.dispose();
		}
	}


	@Override
	public void addPanelList()
	{
		// TODO Auto-generated method stub
		
	}
}


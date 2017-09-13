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

public class DialogCheckSave extends JDialog implements ActionListener, ViewsAddons
{


	private JButton btnYes;
	private JButton btnNot;
	private Coordinator myCoordinator;

	/**
	 * Create the dialog.
	 */
	public DialogCheckSave(Coordinator coordinator)
	{
		myCoordinator = coordinator;
		setResizable(false);
		setBounds(0, 0, 450, 300);
		/*
		 * colocar la ventana  en el centro de la pantalla
		 */
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//obtenemos el tamaño de la ventana
		Dimension ventana = getSize();
		//para centrar la ventana lo hacemos con el siguiente calculo
		setLocation((screenSize.width - ventana.width) / 2, (screenSize.height - ventana.height) / 2);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		addPanelButtons();
		addPanelForm();
		setVisible(true);
		
	}

	@Override
	public void addPanelButtons()
	{
		// TODO Auto-generated method stub
		{
			JPanel panelButtons = new JPanel();
			getContentPane().add(panelButtons, BorderLayout.SOUTH);
			panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				btnYes = new JButton("Si");
				panelButtons.add(btnYes);
			}
			{
				btnNot = new JButton("No");
				panelButtons.add(btnNot);
			}
		}
		
		btnNot.addActionListener(this);
		btnYes.addActionListener(this);
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
		{
			JPanel panelForm = new JPanel();
			getContentPane().add(panelForm, BorderLayout.CENTER);
			panelForm.setLayout(null);
			{
				JLabel lblCheckSave = new JLabel("¿ Desea Guardar los Cambios ?");
				lblCheckSave.setBounds(108, 126, 239, 15);
				panelForm.add(lblCheckSave);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource() == btnYes){
			myCoordinator.EventYes();
		}
		
		if (e.getSource() == btnNot){
			myCoordinator.EventNot();
		}
		
	}

}

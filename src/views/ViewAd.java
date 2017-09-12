package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;

import controller.Coordinator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;

public class ViewAd extends JDialog implements ActionListener {
	
	private JButton btnAcept;
	private Coordinator myCoordinator;
	public ViewAd(String message, Coordinator coordinator) {
	
		// asigna una instancia del controlador
		this.myCoordinator = coordinator; 		
		
		//  esta instruccion hace que la ventana no se pueda cambiar su tamaño
		setResizable(false);
		
		// configura las dimensiones de la ventana
		setBounds(0, 0, 400, 200);
		/*
		 * colocar la ventana  en el centro de la pantalla
		 */
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//obtenemos el tamaño de la ventana
		Dimension ventana = getSize();
		//para centrar la ventana lo hacemos con el siguiente calculo
		setLocation((screenSize.width - ventana.width) / 2, (screenSize.height - ventana.height) / 2);
		
		// asigna el layout null a la ventana
		getContentPane().setLayout(null);
		setTitle("Aviso");
		JLabel lblMessage = new JLabel(message);
	
		// fija la posicion del label y agg el label al contenedor
		lblMessage.setBounds(92, 68, 244, 15);
		getContentPane().add(lblMessage);
	
		btnAcept = new JButton("Aceptar");
		btnAcept.setBounds(125, 107, 117, 25);
		getContentPane().add(btnAcept);
		
		// coloca el boton para realizar una accion
		btnAcept.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource() == btnAcept ){
			myCoordinator.hideWindowAd();
		}
	}
}

package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ViewConsultas extends JFrame implements ActionListener, ViewsAddons
{

	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JLabel lblInfo;

	/**
	 * Create the frame.
	 */
	public ViewConsultas(String message)
	{
		setBounds(0, 0, 800, 400);
		
		/*
		 * colocar la ventana  en el centro de la pantalla
		 */
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//obtenemos el tamaño de la ventana
		Dimension ventana = getSize();
		//para centrar la ventana lo hacemos con el siguiente calculo
		setLocation((screenSize.width - ventana.width) / 2, (screenSize.height - ventana.height) / 2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		lblInfo = new JLabel(message);
		addPanelForm();
		addPanelButtons();
		setVisible(true);
	}

	@Override
	public void addPanelButtons()
	{
		// TODO Auto-generated method stub
		JPanel panelButtons = new JPanel();
		getContentPane().add(panelButtons, BorderLayout.SOUTH);
		panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		panelButtons.add(btnCerrar);
		
	}

	@Override
	public void addJmenuBar()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPanelForm()
	{
		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panelHeader = new JPanel();
		getContentPane().add(panelHeader, BorderLayout.NORTH);
		
		
		panelHeader.add(lblInfo);
	}

	@Override
	public void addPanelList()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource() == btnCerrar){
			this.dispose();
		}
	}

	public JScrollPane getScrollPane()
	{
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane)
	{
		this.scrollPane = scrollPane;
	}

}

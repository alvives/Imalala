package view;


import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;

import control.Model;

public class VistaAnadirTransporte extends JFrame {
	Model model;
	
	JButton jButton1 = new JButton("Añadir un avion");
	JButton jButton2 = new JButton("Añadir un barco");

	VistaAnadirAvion vistaAnadirAvion;
	VistaAnadirBarco vistaAnadirBarco;
	
	public VistaAnadirTransporte(Model model) 	{
		try {
			this.model = model;
			jbInit();
		}
		catch(Exception e) 	{
			e.printStackTrace();
		}
	}
	
	private void jbInit() throws Exception 	{
		setTitle("Anadir Transporte");
		setLocation(getX()+600, getY()+200);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		jButton1.setBounds(new Rectangle(42, 52, 300, 27));
		jButton2.setBounds(new Rectangle(42, 52, 300, 27));
			
		// Define the panel to hold the buttons 
		panel.setLayout(new FlowLayout());
		panel.add(jButton1);
		panel.add(jButton2);

		// Set the window to be visible as the default to be false
		this.add(panel);
		this.pack();
				
		jButton1.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton1_actionPerformed(e);
			}
		});
		jButton2.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton2_actionPerformed(e);
			}
		});
	}

	void jButton1_actionPerformed(ActionEvent e) {
		this.vistaAnadirAvion = new VistaAnadirAvion(this.model);
		this.vistaAnadirAvion.setSize(475,410);
		this.setVisible(false);
		this.vistaAnadirAvion.setVisible(true);
	}

	void jButton2_actionPerformed(ActionEvent e) {
		this.vistaAnadirBarco = new VistaAnadirBarco(this.model);
		this.vistaAnadirBarco.setSize(475,410);
		this.setVisible(false);
		this.vistaAnadirBarco.setVisible(true);
	}
	
}














/*
frame.add(panel);
frame.setSize(600, 600);
frame.setLocationRelativeTo(null);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);*/
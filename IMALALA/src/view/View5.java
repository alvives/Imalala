package view;


import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import control.Model;
import control.Observer;

public class View5 extends JFrame implements Observer {
	Model model;
	
	
	JScrollPane jScrollPane1 = new JScrollPane();	
	JLabel jLabel1 = new JLabel();
	JButton jButton1 = new JButton();
	JButton jButton2 = new JButton();
	JButton jButton3 = new JButton();
	JButton jButton4 = new JButton();
	JButton jButton5 = new JButton();
	
	
	public View5() 	{
	}
	
	public View5(Model model) 	{
	try 	{
		this.model = model;
		jbInit();
		}
		catch(Exception e) 	{
		e.printStackTrace();
		}
	}
	
	private void jbInit() throws Exception 	{
		this.getContentPane().setLayout(null);
		jScrollPane1.setBounds(new Rectangle(0, 0, 3, 3));
		
		jButton1.setBounds(new Rectangle(42, 52, 300, 27));
		jButton1.setText("Disenar viaje");
		jButton1.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton1_actionPerformed(e);
			}
		});
		jButton2.setBounds(new Rectangle(42, 100, 300, 27));
		jButton2.setText("Modificar viaje");
		jButton2.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton2_actionPerformed(e);
			}
		});
		jButton3.setBounds(new Rectangle(42, 152, 300, 27));
		jButton3.setText("Eliminar viaje");
		jButton3.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton3_actionPerformed(e);
			}
		});		
		
		
		jLabel1.setText("Bienvenido gestor, pulse la accion que desee realizar:");
		jLabel1.setBounds(new Rectangle(41, 15, 400, 23));
		
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jButton1, null);
		this.getContentPane().add(jButton2, null);
		this.getContentPane().add(jButton3, null);
	}

	void jButton1_actionPerformed(ActionEvent e) {
	
	}
	
	void jButton2_actionPerformed(ActionEvent e) {

	}
	
	void jButton3_actionPerformed(ActionEvent e) {

	}

	
	@Override
	public void dataUpdate(Model model) {
		// TODO Auto-generated method stub
		
	}
	

	
}
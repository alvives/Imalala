package view;


import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import control.Model;
import control.Observer;
import model.Usuario;

public class View1 extends JFrame implements Observer {
	Model model;
	Usuario u;
	
	View3 view3;
	View4 view4;
	View6 view6;
	View7 view7;
	
	JScrollPane jScrollPane1 = new JScrollPane();	
	JLabel jLabel1 = new JLabel();
	JButton jButton1 = new JButton();
	JButton jButton2 = new JButton();
	JButton jButton3 = new JButton();
	JButton jButton4 = new JButton();
	JButton jButton5 = new JButton();
	JButton jButton6 = new JButton();
	
	public View1() 	{
	}
	
	public View1(Model model, Usuario u) 	{
	try 	{
		this.model = model;
		this.u = u;
		jbInit();
		}
		catch(Exception e) 	{
		e.printStackTrace();
		}
	}
	
	private void jbInit() throws Exception 	{
		setLocation(getX()+600, getY()+200);
		this.getContentPane().setLayout(null);
		jScrollPane1.setBounds(new Rectangle(0, 0, 3, 3));
		
		jButton1.setBounds(new Rectangle(42, 52, 300, 27));
		jButton1.setText("Modificar mis datos");
		jButton1.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton1_actionPerformed(e);
			}
		});
		jButton2.setBounds(new Rectangle(42, 100, 300, 27));
		jButton2.setText("Consultar mis reservas");
		jButton2.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton2_actionPerformed(e);
			}
		});
		jButton3.setBounds(new Rectangle(42, 152, 300, 27));
		jButton3.setText("Reservar nuevo viaje");
		jButton3.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton3_actionPerformed(e);
			}
		});
		jButton4.setBounds(new Rectangle(42, 204, 300, 27));
		jButton4.setText("Cancelar alguna reserva");
		jButton4.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton4_actionPerformed(e);
			}
		});
		jButton5.setBounds(new Rectangle(42, 256, 300, 27));
		jButton5.setText("Darme de baja");
		jButton5.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton5_actionPerformed(e);
			}
		});
		
		jButton6.setBounds(new Rectangle(42, 308, 300, 27));
		jButton6.setText("Cerrar sesion");
		jButton6.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton6_actionPerformed(e);
			}
		});
		
		
		jLabel1.setText("Bienvenido " + this.u.getNombre() + " " + this.u.getApellido() + ", pulse la accion que desee realizar:");
		jLabel1.setBounds(new Rectangle(41, 15, 400, 23));
		
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jButton1, null);
		this.getContentPane().add(jButton2, null);
		this.getContentPane().add(jButton3, null);
		this.getContentPane().add(jButton4, null);
		this.getContentPane().add(jButton5, null);
		this.getContentPane().add(jButton6, null);
	}

	void jButton1_actionPerformed(ActionEvent e) {
		this.view3 = new View3(this.model, this.u);
		this.view3.setSize(475,410);
		this.view3.setVisible(true);
	}
	
	void jButton2_actionPerformed(ActionEvent e) {
		this.view4 = new View4(this.model, this.u);
		this.view4.setSize(475,410);
		this.view4.setVisible(true);
	}
	
	void jButton3_actionPerformed(ActionEvent e) {
		this.view6 = new View6(this.model, this.u);
		this.view6.setSize(475,410);
		this.view6.setVisible(true);
	}
	
	void jButton4_actionPerformed(ActionEvent e) {
		this.view7 = new View7(this.model, this.u);
		this.view7.setSize(475,410);
		this.view7.setVisible(true);
	}
	
	void jButton5_actionPerformed(ActionEvent e) {
		this.model.getListaUsuarios().darBajaUsuario(this.u.getId());
		this.setVisible(false);
	}

	void jButton6_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}
	
	
	@Override
	public void dataUpdate(Model model) {
		// TODO Auto-generated method stub
		
	}
	

	
}
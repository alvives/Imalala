package view;


import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import control.Model;
import control.Observer;
import model.Usuario;

public class View2 extends JFrame implements Observer {
	Model model;
	
	JScrollPane jScrollPane1 = new JScrollPane();	

	JTextField jTextField1 = new JTextField();
	JTextField jTextField2 = new JTextField();
	JTextField jTextField3 = new JTextField();
	JTextField jTextField4 = new JTextField();
	JTextField jTextField5 = new JTextField();
	JTextField jTextField6 = new JTextField();
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JLabel jLabel5 = new JLabel();
	JLabel jLabel6 = new JLabel();
	JLabel jLabel7 = new JLabel();
	JButton jButton1 = new JButton();
	

	
	
	public View2() 	{
	}
	
	public View2(Model model) 	{
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
		
		jButton1.setBounds(new Rectangle(300, 300, 100, 27));
		jButton1.setText("Registrarse");
		jButton1.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton1_actionPerformed(e);
			}
		});
	
		
		jLabel1.setText("Introduzca sus datos:");
		jLabel1.setBounds(new Rectangle(41, 15, 400, 23));
		
		jTextField1.setText("");
		jTextField1.setBounds(new Rectangle(150, 50, 100, 31));
		jTextField2.setText("");
		jTextField2.setBounds(new Rectangle(150, 100, 100, 31));
		jTextField3.setText("");
		jTextField3.setBounds(new Rectangle(150, 150, 100, 31));
		jTextField4.setText("");
		jTextField4.setBounds(new Rectangle(150, 200, 100, 31));
		jTextField5.setText("");
		jTextField5.setBounds(new Rectangle(150, 250, 100, 31));
		jTextField6.setText("");
		jTextField6.setBounds(new Rectangle(150, 300, 100, 31));
		
		jLabel2.setText("Id:");
		jLabel2.setBounds(new Rectangle(42, 50, 80, 32));
		jLabel3.setText("Contrasena:");
		jLabel3.setBounds(new Rectangle(42, 100, 80, 32));
		jLabel4.setText("Nombre:");
		jLabel4.setBounds(new Rectangle(42, 150, 80, 32));
		jLabel5.setText("Apellido:");
		jLabel5.setBounds(new Rectangle(42, 200, 80, 32));
		jLabel6.setText("tlf:");
		jLabel6.setBounds(new Rectangle(42, 250, 80, 32));
		jLabel7.setText("dni:");
		jLabel7.setBounds(new Rectangle(42, 300, 80, 32));
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jButton1, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(jLabel3, null);
		this.getContentPane().add(jLabel4, null);
		this.getContentPane().add(jLabel5, null);
		this.getContentPane().add(jLabel6, null);
		this.getContentPane().add(jLabel7, null);
		this.getContentPane().add(jTextField1, null);
		this.getContentPane().add(jTextField2, null);
		this.getContentPane().add(jTextField3, null);
		this.getContentPane().add(jTextField4, null);
		this.getContentPane().add(jTextField5, null);
		this.getContentPane().add(jTextField6, null);
		
	}

	void jButton1_actionPerformed(ActionEvent e) {
		if (!jTextField1.getText().isEmpty() && !jTextField2.getText().isEmpty() && !jTextField3.getText().isEmpty() && !jTextField4.getText().isEmpty() && 
				!jTextField5.getText().isEmpty() && !jTextField6.getText().isEmpty()) {
			String id = jTextField1.getText();
			String contrasena = jTextField2.getText();
			String nombre = jTextField3.getText();
			String apellido= jTextField4.getText();
			String tlf = jTextField5.getText();
			String dni= jTextField6.getText();
			
			this.model.getListaUsuarios().anadirUsuario(new Usuario(id,contrasena,nombre,apellido,tlf,dni));
			this.setVisible(false);
		}else {
			JOptionPane.showMessageDialog(new JFrame(), "Error, hay campos vacios", "ERROR", JOptionPane.ERROR_MESSAGE);		
		}
	}
		
	@Override
	public void dataUpdate(Model model) {
		// TODO Auto-generated method stub
		
	}
	

	
}
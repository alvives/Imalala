

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.border.*;

public class View4 extends JFrame implements Observer {
	Model model;
	Usuario u;
	
	
	JScrollPane jScrollPane1 = new JScrollPane();	
	JLabel jLabel1 = new JLabel();
	ArrayList<JLabel> listajLabel = new ArrayList<JLabel>();
	
	public View4() 	{
	}
	
	public View4(Model model, Usuario u) 	{
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
		this.getContentPane().setLayout(null);
		jScrollPane1.setBounds(new Rectangle(0, 0, 3, 3));
		
		
		
		
		
		jLabel1.setText("Aqui tienes un listado con tus reservas " + this.u.getNombre() + " " + this.u.getApellido() + ":");
		jLabel1.setBounds(new Rectangle(41, 15, 400, 23));
		
		
		
		this.getContentPane().add(jLabel1, null);
	}

	
	@Override
	public void dataUpdate(Model model) {
		// TODO Auto-generated method stub
		
	}
	

	
}
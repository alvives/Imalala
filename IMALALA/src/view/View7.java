package view;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import control.Model;
import control.Observer;
import model.Usuario;

public class View7 extends JFrame implements Observer {
	Model model;
	Usuario u;
	
	
	JScrollPane jScrollPane1 = new JScrollPane();	
	JLabel jLabel1 = new JLabel();
	ArrayList<JLabel> listajLabel = new ArrayList<JLabel>();
	
	public View7() 	{
	}
	
	public View7(Model model, Usuario u) 	{
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
		
        
		jLabel1.setText("Seleccione el viaje que quiere cancelar");
		jLabel1.setBounds(new Rectangle(41, 15, 400, 23));
		
        this.getContentPane().add(jLabel1, null);
        
	}

	
	@Override
	public void dataUpdate(Model model) {
		// TODO Auto-generated method stub
		
	}
	

	
}


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
		
		ArrayList<Reserva> listaReservas = model.listaReservas.getReservasUsuario(u);
		
				
		jLabel1.setText("Aqui tienes un listado con tus reservas " + this.u.getNombre() + " " + this.u.getApellido() + ":");
		jLabel1.setBounds(new Rectangle(41, 15, 400, 23));
		
		int y=0;
		for (int z=0;z<listaReservas.size();z++) {
			listajLabel.add(new JLabel());
			listajLabel.get(z).setText("Reserva: "+ listaReservas.get(z).getId() + " (" + listaReservas.get(z).getViaje().getAlojamiento().getCiudad() + ")");
			listajLabel.get(z).setBounds(new Rectangle(41, 65+y, 400, 23));
			y+=50;
			this.getContentPane().add(listajLabel.get(z), null);
		}
		
		
		
		this.getContentPane().add(jLabel1, null);
	}

	
	@Override
	public void dataUpdate(Model model) {
		// TODO Auto-generated method stub
		
	}
	

	
}
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
import model.Alojamiento;
import model.Transporte;


public class VistaModificarTransporte extends JFrame implements Observer {
	Model model;
	JScrollPane jScrollPane1 = new JScrollPane();	

	JTextField jTextField1 = new JTextField();
	JTextField jTextField2 = new JTextField();

	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();	
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JLabel jLabel5 = new JLabel();
	JLabel jLabel6 = new JLabel();

	JButton jButton1 = new JButton();
	

	
	
	public VistaModificarTransporte() 	{
	}
	
	public VistaModificarTransporte(Model model) 	{
	try 	{
		this.model = model;
		jbInit();
		}
		catch(Exception e) 	{
		e.printStackTrace();
		}
	}
	
	private void jbInit() throws Exception 	{
		setTitle("Modificar Transporte");
		setLocation(getX()+600, getY()+200);
		this.getContentPane().setLayout(null);
		jScrollPane1.setBounds(new Rectangle(0, 0, 3, 3));
		
		jButton1.setBounds(new Rectangle(250, 300, 200, 27));
		jButton1.setText("Confirmar cambios");
		jButton1.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton1_actionPerformed(e);
			}
		});
	
		
		jLabel1.setText("Introduzca las informaciones que desee modificar:");
		jLabel1.setBounds(new Rectangle(41, 15, 400, 23));
		
		jTextField1.setText("");
		jTextField1.setBounds(new Rectangle(150, 50, 100, 31));
		jTextField2.setText("");
		jTextField2.setBounds(new Rectangle(150, 100, 100, 31));

		
		jLabel2.setText("Id del transporte:");
		jLabel2.setBounds(new Rectangle(42, 50, 100, 32));
		jLabel3.setText("Capacidad:");
		jLabel3.setBounds(new Rectangle(42, 100, 100, 32));
		
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jButton1, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(jLabel3, null);
		this.getContentPane().add(jTextField1, null);
		this.getContentPane().add(jTextField2, null);
		
	}

	void jButton1_actionPerformed(ActionEvent e) {
		if (!jTextField1.getText().isEmpty()&&!jTextField2.getText().isEmpty()) {
			String id = jTextField1.getText();
			if(this.model.getListaTransportes().buscarTransporte(id)!=null){
				String capacidad=jTextField2.getText();

				Transporte transporte = model.getListaTransportes().buscarTransporte(id);

				//Actualizamos los datos del alojamiento en la lista de alojamientos
				this.model.getListaTransportes().modificarTransporte(transporte, id, capacidad); 

				//Actualizamos los datos del alojamiento en la lista de viajes
				//this.model.getListaViajes().modificarAlojamiento(alojamiento);

				this.setVisible(false);

			}else JOptionPane.showMessageDialog(new JFrame(), "Error, id del alojamiento incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
			
		}else {
			JOptionPane.showMessageDialog(new JFrame(), "Error, hay campos vacios", "ERROR", JOptionPane.ERROR_MESSAGE);		
		}
	}
		
	@Override
	public void dataUpdate(Model model) {
		// TODO Auto-generated method stub
		
	}
	

	
}
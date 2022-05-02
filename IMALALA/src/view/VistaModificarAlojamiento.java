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


public class VistaModificarAlojamiento extends JFrame implements Observer {
	Model model;
	JScrollPane jScrollPane1 = new JScrollPane();	

	JTextField jTextField1 = new JTextField();
	JTextField jTextField2 = new JTextField();
	JTextField jTextField3 = new JTextField();
	JTextField jTextField4 = new JTextField();
	JTextField jTextField5 = new JTextField();

	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();	
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JLabel jLabel5 = new JLabel();
	JLabel jLabel6 = new JLabel();

	JButton jButton1 = new JButton();
	

	
	
	public VistaModificarAlojamiento() 	{
	}
	
	public VistaModificarAlojamiento(Model model) 	{
	try 	{
		this.model = model;
		jbInit();
		}
		catch(Exception e) 	{
		e.printStackTrace();
		}
	}
	
	private void jbInit() throws Exception 	{
		setTitle("Modificar Alojamiento");
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
		jTextField3.setText("");
		jTextField3.setBounds(new Rectangle(150, 150, 100, 31));
		jTextField4.setText("");
		jTextField4.setBounds(new Rectangle(150, 200, 100, 31));
		jTextField5.setText("");
		jTextField5.setBounds(new Rectangle(150, 250, 100, 31));
		
		jLabel2.setText("Id del alojamiento:");
		jLabel2.setBounds(new Rectangle(42, 50, 100, 32));
		jLabel3.setText("Capacidad:");
		jLabel3.setBounds(new Rectangle(42, 100, 100, 32));
		jLabel4.setText("Direccion:");
		jLabel4.setBounds(new Rectangle(42, 150, 100, 32));
		jLabel5.setText("Hotel:");
		jLabel5.setBounds(new Rectangle(42, 200, 100, 32));
		jLabel6.setText("Ciudad:");
		jLabel6.setBounds(new Rectangle(42, 250, 100, 32));
		
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jButton1, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(jLabel3, null);
		this.getContentPane().add(jLabel4, null);
		this.getContentPane().add(jLabel5, null);
		this.getContentPane().add(jLabel6, null);
		this.getContentPane().add(jTextField1, null);
		this.getContentPane().add(jTextField2, null);
		this.getContentPane().add(jTextField3, null);
		this.getContentPane().add(jTextField4, null);
		this.getContentPane().add(jTextField5, null);
		
	}

	void jButton1_actionPerformed(ActionEvent e) {
		if (!jTextField1.getText().isEmpty()&&!jTextField2.getText().isEmpty()&&!jTextField3.getText().isEmpty()&&!jTextField4.getText().isEmpty()) {
			String id = jTextField1.getText();
			if(this.model.getListaAlojamientos().buscarAlojamiento(id)!=null){
				String capacidad=jTextField2.getText();
				String direccion=jTextField3.getText();
				String hotel=jTextField4.getText();
				String ciudad=jTextField5.getText();

				Alojamiento alojamiento = model.getListaAlojamientos().buscarAlojamiento(id);

				//Actualizamos los datos del alojamiento en la lista de alojamientos
				this.model.getListaAlojamientos().modificarAlojamiento(alojamiento, capacidad, direccion, hotel, ciudad); 

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
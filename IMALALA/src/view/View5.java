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
import model.Gestor;



//Ventana gestor
public class View5 extends JFrame implements Observer {
	Model model;
	Usuario u;
	Gestor g;
	
	JScrollPane jScrollPane1 = new JScrollPane();	
	JLabel jLabel1 = new JLabel();
	JButton jButton1 = new JButton();
	JButton jButton2 = new JButton();
	JButton jButton3 = new JButton();
	JButton jButton4 = new JButton();
	private GestionAlojamientos gestionAlojamiento;
	private GestionTransportes gestionTransporte;
	private GestionViajes gestionViajes;

	
	public View5() 	{
	}
	
	public View5(Model model, Gestor g) 	{
	try 	{
		this.model = model;
		this.g=g;
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

		jButton1.setBounds(new Rectangle(42, 50, 300, 27));
		jButton1.setText("Gestionar Viaje");
		jButton1.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton1_actionPerformed(e);
			}

		});
		
		jButton2.setBounds(new Rectangle(42, 100, 300, 27));
		jButton2.setText("Gestionar alojamientos");
		jButton2.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton2_actionPerformed(e);
			}
		});
		jButton3.setBounds(new Rectangle(42, 150, 300, 27));
		jButton3.setText("Gestionar transportes");
		jButton3.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton3_actionPerformed(e);
			}
		});

		jButton4.setBounds(new Rectangle(42, 200, 300, 27));
		jButton4.setText("Cerrar sesión");
		jButton4.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton4_actionPerformed(e);
			}
		});

		
		jLabel1.setText("Bienvenido gestor, pulse la accion que desee realizar:");
		jLabel1.setBounds(new Rectangle(41, 15, 400, 23));
		
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jButton1, null);
		this.getContentPane().add(jButton2, null);
		this.getContentPane().add(jButton3, null);
		this.getContentPane().add(jButton4, null);
	}

	private void jButton1_actionPerformed(ActionEvent e) {
		this.gestionViajes =new GestionViajes(this.model, this.g);
		this.gestionViajes.setSize(475,410);
		this.gestionViajes.setVisible(true);
		this.model.registerObserver(gestionViajes);

	}

	void jButton2_actionPerformed(ActionEvent e) {
		this.gestionAlojamiento = new GestionAlojamientos(this.model, this.g);
		this.gestionAlojamiento.setSize(475,410);
		this.gestionAlojamiento.setVisible(true);
		this.model.registerObserver(gestionAlojamiento);

	}

	void jButton3_actionPerformed(ActionEvent e) {
		this.gestionTransporte = new GestionTransportes(this.model, this.g);
		this.gestionTransporte.setSize(475,410);
		this.gestionTransporte.setVisible(true);
		this.model.registerObserver(gestionTransporte);

	}

	void jButton4_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}

	@Override
	public void dataUpdate(Model model) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
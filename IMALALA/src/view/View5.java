package view;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import control.Model;
import control.Observer;
import model.Usuario;
import model.Viaje;
import model.Alojamiento;
import model.Gestor;
import model.Transporte;

public class View5 extends JFrame implements Observer {
	Model model;
	Usuario u;
	Gestor g;
	ModificarViajeView1 viajeViewModificar1;
	View8 view8;
	GestionAlojamientos gestionAlojamiento;
	GestionTransportes gestionTransporte;

	
	JScrollPane jScrollPane1 = new JScrollPane();	
	JLabel jLabel1 = new JLabel();
	JButton jButton1 = new JButton();
	JButton jButton2 = new JButton();
	JButton jButton3 = new JButton();
	JButton jButton4 = new JButton();
	JButton jButton5 = new JButton();

	
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
		
		jButton1.setBounds(new Rectangle(42, 52, 300, 27));
		jButton1.setText("Disenar viaje");
		jButton1.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton1_actionPerformed(e);
			}
		});
		jButton2.setBounds(new Rectangle(42, 104, 300, 27));
		jButton2.setText("Modificar viaje");
		jButton2.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton2_actionPerformed(e);
			}
		});
		jButton3.setBounds(new Rectangle(42, 156, 300, 27));
		jButton3.setText("Eliminar viaje");
		jButton3.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton3_actionPerformed(e);
			}
		});		
		jButton4.setBounds(new Rectangle(42, 208, 300, 27));
		jButton4.setText("Gestionar alojamientos");
		jButton4.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton4_actionPerformed(e);
			}
		});
		jButton5.setBounds(new Rectangle(42, 260, 300, 27));
		jButton5.setText("Gestionar transportes");
		jButton5.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton5_actionPerformed(e);
			}
		});

		
		jLabel1.setText("Bienvenido gestor, pulse la accion que desee realizar:");
		jLabel1.setBounds(new Rectangle(41, 15, 400, 23));
		
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jButton1, null);
		this.getContentPane().add(jButton2, null);
		this.getContentPane().add(jButton3, null);
		this.getContentPane().add(jButton4, null);
		this.getContentPane().add(jButton5, null);
	}

	void jButton1_actionPerformed(ActionEvent e) {
		DesignTripDialog dialog= new DesignTripDialog(this);
		List<String> idAlojamientos=new ArrayList<>();
		List<String> idTransp=new ArrayList<>();
		
		for(Alojamiento a: model.getListaAlojamientos().getListaAlojamiento()){
			idAlojamientos.add(a.getId());
		}
		for(Transporte t: model.getListaTransportes().getListaTransp()){
			idTransp.add(t.getId());
		}

		int status=dialog.open(idTransp, idAlojamientos);

		while(status==1) {

			String idViaje=model.getListaViajes().buscarViaje(dialog.getIdViaje()).getId();
			String idViajeEleg=dialog.getIdViaje().toString();
			
			Transporte ida=model.getListaTransportes().buscarTransporte(dialog.getTranspIda());
			Transporte vuelta=model.getListaTransportes().buscarTransporte(dialog.getTranspVuelta());
			Alojamiento aloj=model.getListaAlojamientos().buscarAlojamiento(dialog.getAlojamiento());
		
			int Capacidad_Ida=Integer.parseInt(ida.getCapacidad());
			int Capacidad_Vuelta=Integer.parseInt(vuelta.getCapacidad());
			int Capacidad_Aloj=Integer.parseInt(aloj.getCapacidad());
			int Capacidad_Transp=Math.min(Capacidad_Ida, Capacidad_Vuelta);
			int maxReserva=Math.min(Capacidad_Transp, Capacidad_Aloj);

			if(idViaje.equals(idViajeEleg)){
				JOptionPane.showMessageDialog(null, "El id del viaje ya existe, ponga un id diferente");
				status=dialog.open(idTransp, idAlojamientos);
			}else if(dialog.getReservas()>maxReserva){
				JOptionPane.showMessageDialog(null, "El numero de reservas supera a la capacidad maxima de alojamientos y transportes, no debe superar de: "+String.valueOf(maxReserva)+" Reservas");
				status=dialog.open(idTransp, idAlojamientos);
			}else{
				Viaje viajeCreado=new Viaje(dialog.getIdViaje(),aloj, ida, vuelta, dialog.getReservas(), dialog.getPrecio());
				model.getListaViajes().insertarViaje(viajeCreado);
				status=0;
			}
		}
	
	}
	
	void jButton2_actionPerformed(ActionEvent e) {
		this.viajeViewModificar1 = new ModificarViajeView1(this.model, this.g);
		this.viajeViewModificar1.setSize(475,410);
		this.viajeViewModificar1.setVisible(true);
	}
	
	void jButton3_actionPerformed(ActionEvent e) {
		this.view8 = new View8(this.model, this.g);
		this.view8.setSize(800,410);
		this.view8.setVisible(true);
	}

	void jButton4_actionPerformed(ActionEvent e) {
		this.gestionAlojamiento = new GestionAlojamientos(this.model, this.g);
		this.gestionAlojamiento.setSize(475,410);
		this.gestionAlojamiento.setVisible(true);
	}

	void jButton5_actionPerformed(ActionEvent e) {
		this.gestionTransporte = new GestionTransportes(this.model, this.g);
		this.gestionTransporte.setSize(475,410);
		this.gestionTransporte.setVisible(true);
	}
	
	@Override
	public void dataUpdate(Model model) {
		// TODO Auto-generated method stub
		
	}
	

	
}
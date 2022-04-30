package view;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import control.Model;
import control.Observer;
import model.Alojamiento;
import model.Gestor;
import model.Transporte;
import model.Viaje;

public class GestionViajes extends JFrame implements Observer {
	Model model;
	Gestor g;

    ModificarViajeView1 viajeViewModificar1;
	View8 view8;
	GestionAlojamientos gestionAlojamiento;
	GestionTransportes gestionTransporte;
	
	JScrollPane jScrollPane1 = new JScrollPane();	
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JButton jButton1 = new JButton();
	JButton jButton2 = new JButton();
	JButton jButton3 = new JButton();
    JButton jButton4 = new JButton();
    
	public GestionViajes(Model model, Gestor g) 	{
		this.model = model;
        this.g=g;
		jbInit();
	}
	
	private void jbInit(){
        
        setLocation(getX()+600, getY()+200);
		this.getContentPane().setLayout(null);
		jScrollPane1.setBounds(new Rectangle(0, 0, 3, 3));
		
        jLabel1.setText("Elija la acción que desea realizar:");
        jLabel1.setBounds(new Rectangle(41, 15, 400, 23));
		jLabel2.setText("Viajes actuales: " + model.getListaViajes().getViajes().size());
		jLabel2.setBounds(new Rectangle(330, 5, 400, 23));

		jButton1.setBounds(new Rectangle(42, 52, 300, 27));
		jButton1.setText("Diseñar Viaje");
		jButton1.addActionListener(e->jButton1_actionPerformed(e));
		
        jButton2.setBounds(new Rectangle(42, 104, 300, 27));
		jButton2.setText("Modificar viaje");
		jButton2.addActionListener(e->jButton2_actionPerformed(e));
		
        jButton3.setBounds(new Rectangle(42, 156, 300, 27));
		jButton3.setText("Eliminar Viaje");
		jButton3.addActionListener(e->jButton3_actionPerformed(e));

		jButton4.setBounds(new Rectangle(42, 208, 300, 27));
		jButton4.setText("Volver");
		jButton4.addActionListener(e-> this.setVisible(false));
		
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(jButton1, null);
		this.getContentPane().add(jButton2, null);
		this.getContentPane().add(jButton3, null);
        this.getContentPane().add(jButton4, null);
		
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


    @Override
    public void dataUpdate(Model model) {
		jLabel2.setText("Viajes actuales: " + model.getListaViajes().getViajes().size());        
    }

}

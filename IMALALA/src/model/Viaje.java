
package model;
import java.util.ArrayList;


public class Viaje {
	
	private Alojamiento alojamiento;
	//private Gestor gestor;
	//private ArrayList<Transporte> listaTransportes;
	private Transporte transporteIda;
	private Transporte transporteVuelta;
	private int reservasDisponibles;
	private Double precio;
	private String id;
	
	public Viaje (String id,Alojamiento alojamiento, Transporte transporteIda, Transporte transporteVuelta,/*Gestor gestor, ArrayList<Transporte> listaTransportes,*/ int reservasDisponibles, double precio) {
		
		this.id = id;
		this.alojamiento=alojamiento;
		//this.gestor=gestor;
		//this.listaTransportes=listaTransportes;
		this.transporteIda = transporteIda;
		this.transporteVuelta = transporteVuelta;
		this.precio = precio;
		this.reservasDisponibles = reservasDisponibles;
	
	}

	//GET

	public int getReservasDisponibles() {
		return this.reservasDisponibles;
	}

	/*
	public Gestor getGestor() {
		return this.gestor;
	}*/
	
	public Alojamiento getAlojamiento() {
		return this.alojamiento;
	}

	/*
	public ArrayList<Transporte> getListaTransportes() {
		return this.listaTransportes;
	}*/

	
	public double getPrecio() {
		return precio;
	}

	public Transporte getTransporteIda() {
		return transporteIda;
	}

	public Transporte getTransporteVuelta() {
		return transporteVuelta;
	}

	
	public String getId() {
		return id;
	}


	//SET
	
	public void setReservasDisponibles(int r) {
		this.reservasDisponibles=r;
	}
	/*
	public void setGestor(Gestor g) {
		this.gestor=g;
	}*/
	public void setAlojamiento(Alojamiento a) {
		this.alojamiento=a;
	}
	/*
	public void setListaTransportes(ArrayList<Transporte> listaTransportes) {
		this.listaTransportes=listaTransportes;
	}*/
	

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setTransporteIda(Transporte transporteIda) {
		this.transporteIda = transporteIda;
	}

	public void setTransporteVuelta(Transporte transporteVuelta) {
		this.transporteVuelta = transporteVuelta;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	//MÉTODOS

	public void eliminarReserva() {
		this.reservasDisponibles--;
	}
}

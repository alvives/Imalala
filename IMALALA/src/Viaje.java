import java.util.ArrayList;


public class Viaje {
	private Alojamiento alojamiento;
	//private Gestor gestor;
	private ArrayList<Transporte> listaTransportes;
	private int reservasDisponibles;
	private double precio;
	
	public Viaje (Alojamiento alojamiento, /*Gestor gestor,*/ ArrayList<Transporte> listaTransportes, int reservasMax, double precio) {
		this.alojamiento=alojamiento;
		//this.gestor=gestor;
		this.listaTransportes=listaTransportes;
		this.reservasDisponibles=reservasMax;
		this.setPrecio(precio);
	}

	
	
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
	public ArrayList<Transporte> getListaTransportes() {
		return this.listaTransportes;
	}
	
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
	public void setListaTransportes(ArrayList<Transporte> listaTransportes) {
		this.listaTransportes=listaTransportes;
	}
	
	public void eliminarReserva() {
		this.reservasDisponibles--;
	}



	public double getPrecio() {
		return precio;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}

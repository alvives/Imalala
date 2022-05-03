package control;
import java.util.ArrayList;
import java.util.Iterator;

import list.ListaAlojamientos;
import list.ListaReservas;
import list.ListaTransportes;
import list.ListaUsuarios;
import list.ListaViajes;
import model.Alojamiento;
import model.Gestor;
import model.Reserva;
import model.Transporte;
import model.Usuario;
import model.Viaje;

public class Model implements Observable {
	static String rutaGlobal = "IMALALA";
	String ruta=rutaGlobal+"\\Base_Datos\\";
	Gestor gestor = Gestor.getSingletonInstance("gestor", "1");
	
	ListaUsuarios listaUsuarios = new ListaUsuarios();
	ListaReservas listaReservas = new ListaReservas();
	ListaViajes listaViajes = new ListaViajes();
	ListaTransportes listaTransportes = new ListaTransportes();
	ListaAlojamientos listaAlojamientos = new ListaAlojamientos();

	ArrayList <Observer> observer = new ArrayList();
	
	public Model() 	{ 
		super();
	}
	
	public static String getRutaGlobal(){
		return rutaGlobal;
	}

	public void anadirUsuario(Usuario u) {
		this.listaUsuarios.anadirUsuario(u);
	}
	
	public void asignaGestor(Gestor g) {
		this.gestor=g;
	}
	
	public boolean buscarUsuarioContrasena(String id,String cont) {
		return this.listaUsuarios.buscarUsuarioContrasena(id, cont);
	}
	
	
	//METODOS DE LLENAR LISTAS
	
	public void llenarListaViajes(ListaAlojamientos listaAlojamientos,ListaTransportes listaTransportes) {
		listaViajes.llenarViajes(listaAlojamientos,listaTransportes,ruta);
	}
	public void llenarListaReservas(ListaUsuarios listaUsuarios, ListaViajes listaViajes) {
		listaReservas.llenarReservas(listaUsuarios, listaViajes,ruta);
	}
	public void llenarListaUsuarios() {
		listaUsuarios.llenarUsuarios(ruta);
	}
	public void llenarListaTransportes() {
		listaTransportes.llenarTransportes(ruta);
	}
	public void llenarListaAlojamientos() {
		listaAlojamientos.llenarAlojamientos(ruta);
	}
	



	
	
	/*		MÉTODOS GETS	*/
	
	public ListaUsuarios getListaUsuarios() {
		return listaUsuarios;
	}


	public ListaReservas getListaReservas() {
		return listaReservas;
	}


	public ListaViajes getListaViajes() {
		return listaViajes;
	}


	public ListaTransportes getListaTransportes() {
		return listaTransportes;
	}


	public ListaAlojamientos getListaAlojamientos() {
		return listaAlojamientos;
	}



	/*			GET SIZE		*/
	public int getSizeListaAlojamientos(){
		return listaAlojamientos.getSize();
	}
	public int getSizeListaTransportes(){
		return listaTransportes.getSize();
	}
	public int getSizeListaViajes(){
		return listaViajes.getSize();
	}
	public int getSizeListaReservas(Usuario u){
		return listaReservas.getReservasUsuario(u).size();
	}


	/*		METODOS INTERFAZ OBSERVABLE		*/

	public void registerObserver(Observer o) 	{
		observer.add(o);
	}
	
	public void removeObserver(Observer o) 	{
		observer.remove(o);
	}

	public void notificar() {
		for (Iterator i = observer.iterator(); i.hasNext(); ) {
			Observer o = (Observer)(i.next());
			o.dataUpdate(this);
		}
	}





	
	/*			METODDOS EXPORTAR		*/

	public void exportarUsuarios() {
		listaUsuarios.exportarUsuarios(ruta);
	}

    public void exportarAlojamientos() {
		listaAlojamientos.exportarAlojamientos(ruta);
    }

	public void exportarTransportes() {
		listaTransportes.exportarTransportes(ruta);
	}

    public void exportarViajes() {
		listaViajes.exportarViajes(ruta);
    }

    public void exportarReservas() {
		listaReservas.exportarReservas(ruta);
    }
	




	/*		MÉTODOS MODIFICAR LISTAS	*/

	public void anadirAlojamiento(Alojamiento alojamiento) {
		listaAlojamientos.anadirAlojamiento(alojamiento);
		notificar();
	}
	public void eliminarAlojamiento(Alojamiento alojamiento) {
		listaAlojamientos.eliminarAlojamiento(alojamiento);
		notificar();
	}

	public void anadirTransporte(Transporte tpt) {
		listaTransportes.anadirTransporte(tpt);
		notificar();
	}
	public void eliminarTransporte(Transporte tpt) {
		listaTransportes.eliminarTransporte(tpt);
		notificar();
	}

	public void anadirViaje(Viaje viaje) {
		listaViajes.insertarViaje(viaje);
		notificar();
	}
	public void eliminarViaje(Viaje viaje) {
		listaViajes.eliminarViaje(viaje);
		notificar();
	}

	public void anadirReserva(Reserva reserva) {
		listaReservas.anadeReserva(reserva);
		notificar();
	}
	public void eliminarReserva(Reserva reserva) {
		listaReservas.eliminaReserva(reserva);
		notificar();
	}




}
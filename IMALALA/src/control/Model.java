package control;
import java.util.ArrayList;

import list.ListaAlojamientos;
import list.ListaReservas;
import list.ListaTransportes;
import list.ListaUsuarios;
import list.ListaViajes;
import model.Gestor;
import model.Usuario;

public class Model {
	String ruta="IMALALA\\Base_Datos\\";
	Gestor gestor = Gestor.getSingletonInstance("gestor", "1");
	
	ListaUsuarios listaUsuarios = new ListaUsuarios();
	ListaReservas listaReservas = new ListaReservas();
	ListaViajes listaViajes = new ListaViajes();
	ListaTransportes listaTransportes = new ListaTransportes();
	ListaAlojamientos listaAlojamientos = new ListaAlojamientos();

	ArrayList observer = new ArrayList();
	
	public Model() 	{ 
		super();
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


	// se utiliza para registrar observadores en el modelo.
	public void registerObserver(Observer o) 	{
		observer.add(o);
	}
	
	public void removeObserver(Observer o) 	{
		observer.remove(o);
	}

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
	
}
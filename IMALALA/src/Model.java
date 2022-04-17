import java.util.*;

public class Model {
	String ruta="IMALALA\\Base_Datos\\";
	Gestor gestor = Gestor.getSingletonInstance("gestor", "1");
	
	ListaUsuarios listaUsuarios = new ListaUsuarios(ruta);
	ListaReservas listaReservas = new ListaReservas(ruta);
	ListaViajes listaViajes = new ListaViajes(ruta);
	ListaTransportes listaTransportes = new ListaTransportes(ruta);
	ListaAlojamientos listaAlojamientos = new ListaAlojamientos(ruta);

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
		listaViajes.llenarViajes(listaAlojamientos,listaTransportes);
	}
	public void llenarListaReservas(ListaUsuarios listaUsuarios, ListaViajes listaViajes) {
		listaReservas.llenarReservas(listaUsuarios, listaViajes);
	}
	public void llenarListaUsuarios() {
		listaUsuarios.llenarUsuarios();
	}
	public void llenarListaTransportes() {
		listaTransportes.llenarTransportes();
	}
	public void llenarListaAlojamientos() {
		listaAlojamientos.llenarAlojamientos();
	}
	
	
	
	
	
	// se utiliza para registrar observadores en el modelo.
	public void registerObserver(Observer o) 	{
		observer.add(o);
	}
	
	public void removeObserver(Observer o) 	{
		observer.remove(o);
	}
	
}
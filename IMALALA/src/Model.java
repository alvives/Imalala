import java.util.*;

public class Model {
	
	String ruta="D:\\WorkspaceEclipse\\IMALALA";
	ListaUsuarios listaUsuarios = new ListaUsuarios(ruta);
	Gestor gestor = Gestor.getSingletonInstance("gestor", "1");
	ListaViajes listaViajes = new ListaViajes(ruta);
	ListaReservas listaReservas = new ListaReservas(ruta);
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
	
	public void llenarListaViajes(ListaAlojamientos listaAlojamientos2,ListaTransportes listaTransportes2) {
		listaViajes.llenarViajes(listaAlojamientos2,listaTransportes2);
	}
	public void llenarListaReservas() {
		listaReservas.llenarReservas();
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
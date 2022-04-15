import java.util.*;

public class Model {
	ListaUsuarios listaUsuarios = new ListaUsuarios();
	Gestor gestor;
	ListaViajes listaViajes;
	ArrayList observer = new ArrayList();
	
	public Model() 	{ 
		super();
	}
	
	public void anadirUsuario(Usuario u) {
		this.listaUsuarios.anadirUsuario(u);
	}
	
	public boolean buscarUsuarioContrasena(String id,String cont) {
		return this.listaUsuarios.buscarUsuarioContrasena(id, cont);
	}
	
	// se utiliza para registrar observadores en el modelo.
	public void registerObserver(Observer o) 	{
		observer.add(o);
	}
	
	public void removeObserver(Observer o) 	{
		observer.remove(o);
	}
	
}
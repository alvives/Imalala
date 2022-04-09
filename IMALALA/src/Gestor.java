
public class Gestor {
	private String nombre, contrasena;

	private static Gestor gestor;
	
	private Gestor (String nombre, String contrasena) {
		this nombre = nombre;
		this constrasena = constrasena;
	}
	
	public static Gestor getSingletonInstance(String nombre) {
		if (gestor == null) {
			gestor = new Gestor(nombre);
		}
		else {
			System.out.println("No se puede crear el objeto, porque ya existe uno.")
		}
	}
	
	public String getNombre (){
	    return this.nombre;
	}

	public void eliminarGestor() {
		this.gestor = null;
	}
	
	public void cambiarGestor (String nombre, String contrasena) {
		this.eliminarGestor();
		this.getSingletonInstance(nombre, constrasena);
	}
}

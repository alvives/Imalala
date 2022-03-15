import java.util.ArrayList;

public class ListaUsuarios {

	ArrayList<Usuario> listaUsuarios;

	public ListaUsuarios() {
		listaUsuarios = new ArrayList<Usuario>();

	}

	public boolean buscarUsuario(String id) {
		boolean b = false;
		int i = 0;

		while (!b && i < listaUsuarios.size()) {
			if (listaUsuarios.get(i).getId().equals(id)) {
				b = true;
			}
			i++;
		}
		return b;
	}

	public void darBajaUsuario(String id) {
		boolean b = false;
		int i = 0;
		while (!b && i < listaUsuarios.size()) {
			if (listaUsuarios.get(i).getId().equals(id)) {
				b = true;
				listaUsuarios.remove(i);
			}
			i++;
		}
	}

	public void anadirUsuario(Usuario u) {
		listaUsuarios.add(u);
	}

	public boolean buscarUsuarioContrasena(String id, String cont) {
		boolean b = false, encont = false;
		int i = 0;

		while (!encont && !b && i < listaUsuarios.size()) {
			if (listaUsuarios.get(i).getId().equals(id)) {
				encont=true;
				if(listaUsuarios.get(i).getContrasena().equals(cont))
					b = true;
			}
			i++;
		}
		return b;

	}
}

package tst.model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import list.ListaUsuarios;
import model.Usuario;

public class RegistrarUsuarioExisteTest {

	@Test
	public void test1() {
                Usuario usuario=new Usuario("usuario1", "1435", "nombre", "apellido", "123", "X123");
                ListaUsuarios listaUsuarios= new ListaUsuarios();
                listaUsuarios.anadirUsuario(usuario);
                listaUsuarios.anadirUsuario(usuario);
                assertEquals(listaUsuarios.size(), 1);
	}

}

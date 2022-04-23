package tst.model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import model.Usuario;

public class UsuarioTest {

	@Test
	public void test1() {
		
        Usuario usuario=new Usuario("usuario1", "1435", "nombre", "apellido", "123", "X123");
        
        assertTrue(usuario.comprobarContrasena("1435"));
        assertFalse(usuario.comprobarContrasena("13534"));
        assertEquals(usuario.getId(), "usuario1");
        assertEquals(usuario.getNombre(), "nombre");
        assertNotEquals(usuario.getApellido(), "error");
	}

}

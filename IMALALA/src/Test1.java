import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import model.Gestor;

public class Test1 {

	@Test
	public void test1() {
		
		assertEquals(Gestor.getSingletonInstance("gestor1", "1").getNombre(),"gestor1");
		assertEquals(Gestor.getSingletonInstance("gestor2", "2").getNombre(),"gestor1","No se deber�a de haber creado, porque ya exist�a un gestor");
		
	}

	@Test
	public void test2() {
		
		
		
	}
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Test1 {

	@Test
	public void test1() {
		
		assertEquals(Gestor.getSingletonInstance("gestor1", "1").getNombre(),"gestor1");
		assertEquals(Gestor.getSingletonInstance("gestor2", "2").getNombre(),"gestor1","No se debería de haber creado, porque ya existía un gestor");
		
	}

	@Test
	public void test2() {
		
		
		
	}
}

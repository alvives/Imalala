package tst.model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import list.ListaAlojamientos;
import model.Alojamiento;



public class AlojamientosConMismoIdTest  {

	@Test
	public void test1() {
                Alojamiento alojamiento = new Alojamiento("id", "capacidad", "direccion", "nombreHotel", "ciudad");
                Alojamiento alojamiento2 = new Alojamiento("id", "capacidad", "direccion", "nombreHotel", "ciudad");

                ListaAlojamientos listaAlojamientos=new ListaAlojamientos();
                listaAlojamientos.anadirAlojamiento(alojamiento);
                listaAlojamientos.anadirAlojamiento(alojamiento2);
                assertEquals(listaAlojamientos.getListaAlojamiento().size(), 1);
	}

}

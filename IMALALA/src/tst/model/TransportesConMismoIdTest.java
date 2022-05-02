package tst.model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import list.ListaTransportes;
import model.Avion;
import model.Barco;
import model.Transporte;
import model.Usuario;

public class TransportesConMismoIdTest {

	@Test
	public void test1() {
                Transporte transporte = new Barco("B1", "1100");
                Transporte transporte2 = new Avion("B1", "1100");

                ListaTransportes listaTransportes=new ListaTransportes();
                listaTransportes.anadirTransporte(transporte);
                listaTransportes.anadirTransporte(transporte2);
               
                assertEquals(listaTransportes.getListaTransportes().size(), 1);
	}

}

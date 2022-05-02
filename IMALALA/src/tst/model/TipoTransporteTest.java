package tst.model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import list.ListaTransportes;
import model.Barco;
import model.Transporte;
import model.Usuario;

public class TipoTransporteTest {

	@Test
	public void test1() {
                Transporte transporte = new Barco("B1", "1100");
                ListaTransportes listaTransportes=new ListaTransportes();
                listaTransportes.anadirTransporte(transporte);
               
                assertEquals(listaTransportes.getListaTransportes().get(0).getTipoTransporte(), "barco");
	}

}

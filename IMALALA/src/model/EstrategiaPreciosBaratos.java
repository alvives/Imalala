package model;

import java.util.ArrayList;

public class EstrategiaPreciosBaratos implements EstrategiaPrecios {
    private double precio=100;
    public EstrategiaPreciosBaratos(){
    }

    @Override
    public ArrayList<Viaje> mostrarViajes(ArrayList<Viaje> listaViajes) {
        ArrayList<Viaje> lista = new ArrayList<Viaje>();
		int i = 0;
		while (i < listaViajes.size()) {
            if (listaViajes.get(i).getPrecio()<precio)
			    lista.add(listaViajes.get(i));
			
			i++;
		}
		
        return lista;
    }

    
    
}

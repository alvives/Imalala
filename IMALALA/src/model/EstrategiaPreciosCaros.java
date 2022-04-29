package model;

import java.util.ArrayList;

public class EstrategiaPreciosCaros implements EstrategiaPrecios{
    private double precio=500;
    public EstrategiaPreciosCaros(){
    }

    @Override
    public ArrayList<Viaje> mostrarViajes(ArrayList<Viaje> listaViajes) {
        ArrayList<Viaje> lista = new ArrayList<Viaje>();
		int i = 0;
		while (i < listaViajes.size()) {
            if (listaViajes.get(i).getPrecio()>=precio)
			    lista.add(listaViajes.get(i));
			
			i++;
		}
		
        return lista;
    }

    
}

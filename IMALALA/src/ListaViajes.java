import java.util.ArrayList;


public class ListaViajes {
	private ArrayList<Viaje> listaViajes;
	
	
	public ListaViajes () {
		listaViajes = new ArrayList<Viaje>();
	}
	
	public void insertarViaje(Viaje v) {
		listaViajes.add(v);
	}
	
	public void eliminarViaje(Viaje v) {
		boolean b = false;
		int i = 0;
		while (!b && i < listaViajes.size()) {
			if (listaViajes.get(i).equals(v)) {
				b = true;
				listaViajes.remove(i);
			}
			i++;
		}
	}
	
	public void modificarViaje (Viaje v, Alojamiento alojammiento, ArrayList<Transporte> listaTransportes) {
		boolean b = false;
		int i = 0;
		while (!b && i < listaViajes.size()) {
			if (listaViajes.get(i).equals(v)) {
				b = true;
				listaViajes.get(i).setAlojamiento(alojammiento);
				listaViajes.get(i).setListaTransportes(listaTransportes);
			}
			i++;
		}
	}
	
	public void eliminarReserva (Viaje v, Reserva r) {
		boolean b = false;
		int i = 0;
		while (!b && i < listaViajes.size()) {
			if (listaViajes.get(i).equals(v)) {
				b = true;
				listaViajes.get(i).eliminarReserva(r);
			}
			i++;
		}
	}
	
	public ArrayList<Viaje> buscarViajes (String destino) {
		int i = 0;
		ArrayList<Viaje> lista=new ArrayList<Viaje>();
		while (i < listaViajes.size()) {
			if (listaViajes.get(i).getAlojamiento().getCiudad().equals(destino)) {
				lista.add(listaViajes.get(i));
			}
			i++;
		}
		return lista;
	}
	
}

import java.util.ArrayList;

public class ListaReservas {

	private ArrayList<Reserva> listaReservas;

	public ListaReservas() {
		listaReservas = new ArrayList<Reserva>();

	}

	public void eliminaReserva(Reserva r) {
		boolean b = false;
		int i = 0;
		while (!b && i < listaReservas.size()) {
			if (listaReservas.get(i).equals(r)) {
				b = true;
				listaReservas.remove(i);
			}
			i++;
		}
	}
	
	public void anadeReserva(Reserva r) {
		listaReservas.add(r);
	}
	
	public ArrayList<Reserva> mostrarReservas (Usuario u){
		ArrayList<Reserva> lista = new ArrayList<Reserva>();
		int i = 0;
		while (i < listaReservas.size()) {
			if (listaReservas.get(i).getUsuario().equals(u)) {
				lista.add(listaReservas.get(i));
			}
			i++;
		}
		
		return lista;
	}

	public void llenarReservas() {
		// TODO Auto-generated method stub
		
	}
	
	public void exportarReservas() {
		// TODO Auto-generated method stub
		
	}
	
}

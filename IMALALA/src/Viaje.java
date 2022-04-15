import java.util.ArrayList;


public class Viaje {
	private Alojamiento alojammiento;
	private Gestor gestor;
	private ArrayList<Transporte> listaTransportes;
	private ArrayList<Reserva> reservas;
	private int reservasDisponibles;
	
	public Viaje (Alojamiento alojammiento, Gestor gestor, ArrayList<Transporte> listaTransportes, int reservasMax) {
		this.alojammiento=alojammiento;
		this.gestor=gestor;
		this.listaTransportes=listaTransportes;
		this.reservasDisponibles=reservasMax;
		this.reservas = new ArrayList <Reserva>();
	}

	
	
	public int getReservasDisponibles() {
		return this.reservasDisponibles;
	}
	public Alojamiento getAlojamiento() {
		return this.alojammiento;
	}
	public ArrayList<Transporte> getListaTransportes() {
		return this.listaTransportes;
	}
	
	public void setReservasDisponibles(int r) {
		this.reservasDisponibles=r;
	}
	public void setAlojamiento(Alojamiento a) {
		this.alojammiento=a;
	}
	public void setListaTransportes(ArrayList<Transporte> listaTransportes) {
		this.listaTransportes=listaTransportes;
	}
	
	public void nuevaReserva(Reserva r) {
		this.reservasDisponibles--;
		reservas.add(r);
	}
	
	public void eliminarReserva(Reserva r) {
		this.reservasDisponibles++;
		boolean b = false;
		int i = 0;
		while (!b && i < reservas.size()) {
			if (reservas.get(i).equals(r)) {
				b = true;
				reservas.remove(i);
			}
			i++;
		}
	}
}

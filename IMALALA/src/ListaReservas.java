import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaReservas {

	private ArrayList<Reserva> listaReservas;
	private String ruta;
	public ListaReservas(String ruta) {
		listaReservas = new ArrayList<Reserva>();
		this.ruta=ruta;

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

	public void llenarReservas(ListaUsuarios listaUsuarios, ListaViajes listaViajes) {
		File doc = new File(ruta+"\\Viajes.txt");	
		Scanner obj;
		
		try {
			obj = new Scanner(doc);
			while (obj.hasNextLine()){
				String linea = obj.nextLine();
				String[] partes = linea.split("-");
				listaReservas.add(new Reserva(listaUsuarios.buscarUsuario(partes[0]), listaViajes.buscarViaje(partes[1]), Boolean.parseBoolean(partes[2])));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	public void exportarReservas() {
		// TODO Auto-generated method stub
		
	}
	
}

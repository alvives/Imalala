package list;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import model.Viaje;
import model.Alojamiento;
import model.Transporte;
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
	
	public void modificarViaje (Viaje v, Alojamiento alojammiento, Transporte transporteIda, Transporte transporteVuelta) {
		boolean b = false;
		int i = 0;
		while (!b && i < listaViajes.size()) {
			if (listaViajes.get(i).getId().equals(v.getId())) {
				b = true;
				listaViajes.get(i).setAlojamiento(alojammiento);
				listaViajes.get(i).setTransporteIda(transporteIda);
				listaViajes.get(i).setTransporteVuelta(transporteVuelta);				
			}
			i++;
		}
	}
	
	public void eliminarReserva (Viaje v) {
		boolean b = false;
		int i = 0;
		while (!b && i < listaViajes.size()) {
			if (listaViajes.get(i).equals(v)) {
				b = true;
				listaViajes.get(i).eliminarReserva();
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

	public ArrayList<Viaje> getViajes() {

		ArrayList<Viaje> lista = new ArrayList<Viaje>();
		int i = 0;
		while (i < listaViajes.size()) {

			lista.add(listaViajes.get(i));
			
			i++;
		}
		
		return lista;
	}

	public void llenarViajes(ListaAlojamientos listaAlojamientos,ListaTransportes listaTransportes, String ruta) {
		File doc = new File(ruta+"\\Viajes.txt");	
		Scanner obj;
		
		try {
			obj = new Scanner(doc);
			while (obj.hasNextLine()){
				String linea = obj.nextLine();
				String[] partes = linea.split("-");
				listaViajes.add(new Viaje(partes[0], listaAlojamientos.buscarAlojamiento(partes[1]),
						listaTransportes.buscarTransporte(partes[2]),listaTransportes.buscarTransporte(partes[3]),
						Integer.parseInt(partes[4]),Double.parseDouble(partes[5])));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}

	public void exportarViajes(String ruta) {

		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(ruta+"\\Viajes.txt");
			pw = new PrintWriter(fichero);
			
			//escribir con pw.println();
			for (int z=0;z<this.listaViajes.size();z++) {
				pw.println(listaViajes.get(z).getId()+"-"+listaViajes.get(z).getAlojamiento().getId()+"-"+
						listaViajes.get(z).getTransporteIda().getId()+"-"+listaViajes.get(z).getTransporteVuelta().getId()+"-"+
						listaViajes.get(z).getReservasDisponibles()+"-"+listaViajes.get(z).getPrecio());
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (null!=fichero)
					fichero.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	public Viaje buscarViaje(String id) {

		boolean encont = false;
		int i = 0;

		while (!encont && i < listaViajes.size()) {
			if (listaViajes.get(i).getId().equals(id)) {
				encont=true;
			}
			i++;
		}
		return (listaViajes.get(i-1));
	}

    public boolean contieneAlojamiento(Alojamiento alojamiento) {
		boolean encont = false;
		int i = 0;

		while (!encont && i < listaViajes.size()) {
			if (listaViajes.get(i).getAlojamiento().getId().equals(alojamiento.getId())) {
				encont=true;
			}
			i++;
		}
		return encont;
    }

	public void modificarAlojamiento (Alojamiento alojamiento) {
		int i = 0;

		while (i < listaViajes.size()) {
			if (listaViajes.get(i).getAlojamiento().getId().equals(alojamiento.getId())) {
				listaViajes.get(i).getAlojamiento().setCapacidad(alojamiento.getCapacidad());				
				listaViajes.get(i).getAlojamiento().setDireccion(alojamiento.getDireccion());				
				listaViajes.get(i).getAlojamiento().setNombreHotel(alojamiento.getNombreHotel());				
				listaViajes.get(i).getAlojamiento().setCiudad(alojamiento.getCiudad());		
			}
			i++;
		}
	}
	
}

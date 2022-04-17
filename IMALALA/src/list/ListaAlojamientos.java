package list;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import model.Alojamiento;

public class ListaAlojamientos {
	
	private ArrayList<Alojamiento> listaAlojamientos;
	private String ruta;
	public ListaAlojamientos(String ruta) {
		listaAlojamientos = new ArrayList<Alojamiento>();
		this.ruta=ruta;
	}
	

	public void llenarAlojamientos() {


		File doc = new File(ruta+"\\Alojamientos.txt");
		Scanner obj;
		try {
			obj = new Scanner(doc);
			while (obj.hasNextLine()){
				String linea = obj.nextLine();
				String[] partes = linea.split("-");
				listaAlojamientos.add(new Alojamiento(partes[0],partes[1],partes[2],partes[3],partes[4]));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void exportarAlojamientos() {


		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(ruta+"\\Alojamientos.txt");
			pw = new PrintWriter(fichero);
			
			//escribir con pw.println();
			for (int z=0;z<this.listaAlojamientos.size();z++) {
				pw.println(listaAlojamientos.get(z).getId()+"-"+listaAlojamientos.get(z).getCapacidad()+"-"+
						listaAlojamientos.get(z).getDireccion()+"-"+listaAlojamientos.get(z).getNombreHotel()+"-"+
						listaAlojamientos.get(z).getCiudad());
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


	public Alojamiento buscarAlojamiento(String id) {

		boolean encont = false;
		int i = 0;

		while (!encont && i < listaAlojamientos.size()) {
			if (listaAlojamientos.get(i).getId().equals(id)) {
				encont=true;
			}
			i++;
		}
		return (listaAlojamientos.get(i-1));
	}
}

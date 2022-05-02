package list;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Alojamiento;

public class ListaAlojamientos {
	
	private ArrayList<Alojamiento> listaAlojamientos;
	public ListaAlojamientos() {
		
		this.listaAlojamientos = new ArrayList<Alojamiento>();
	}

	public int getSize(){
		return listaAlojamientos.size();
	}
	

	public void llenarAlojamientos(String ruta) {


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
	
	public void exportarAlojamientos(String ruta) {


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
		if (encont){
			return (listaAlojamientos.get(i-1));

		}else{
			return null;
		}	}

	public ArrayList<Alojamiento> getListaAlojamiento(){
		return listaAlojamientos;
	}

	public void anadirAlojamiento (Alojamiento al) {
		boolean encontrado = false;
		int i = 0;
		
		while(!encontrado && i < listaAlojamientos.size()) {
			if(listaAlojamientos.get(i).getId().equals(al.getId()))
				encontrado = true;
			i++;
		}
		
		if(!encontrado) {
			listaAlojamientos.add(al);
		}
		else {
			JOptionPane.showMessageDialog(new JFrame(), "Error, ya existe un alojamiento con el mismo identificador", "ERROR", JOptionPane.ERROR_MESSAGE);		
		}		
	}


	public void eliminarAlojamiento(Alojamiento alojamiento) {
		boolean b = false;
		int i = 0;
		while (!b || i < listaAlojamientos.size()) {
			if (listaAlojamientos.get(i).getId().equals(alojamiento.getId())) {
				b = true;
				listaAlojamientos.remove(i);
			}
			i++;
		}

	}


	public void modificarAlojamiento (Alojamiento a, String capacidad, String direccion, String hotel, String ciudad) {
		boolean b = false;
		int i = 0;
		while (!b && i < listaAlojamientos.size()) {
			if (listaAlojamientos.get(i).getId().equals(a.getId())) {
				b = true;
				listaAlojamientos.get(i).setCapacidad(capacidad);
				listaAlojamientos.get(i).setDireccion(direccion);
				listaAlojamientos.get(i).setNombreHotel(hotel);		
				listaAlojamientos.get(i).setCiudad(ciudad);						
			}
			i++;
		}
	}
	
}

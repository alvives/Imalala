import java.io.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ListaUsuarios {

	private ArrayList<Usuario> listaUsuarios;
	private String ruta;

	public ListaUsuarios(String ruta) {
		listaUsuarios = new ArrayList<Usuario>();
		this.ruta=ruta;

	}

	public Usuario buscarUsuario(String id) {
		boolean encont = false;
		int i = 0;

		while (!encont && i < listaUsuarios.size()) {
			if (listaUsuarios.get(i).getId().equals(id)) {
				encont=true;
			}
			i++;
		}
		return (listaUsuarios.get(i-1));
	}

	public void darBajaUsuario(String id) {
		boolean b = false;
		int i = 0;
		while (!b && i < listaUsuarios.size()) {
			if (listaUsuarios.get(i).getId().equals(id)) {
				b = true;
				listaUsuarios.remove(i);
			}
			i++;
		}
	}

	public void anadirUsuario(Usuario u) {
		boolean encontrado = false;
		int i = 0;
		
		while(!encontrado && i < listaUsuarios.size()) {
			if(listaUsuarios.get(i).getId().equals(u.getId()))
				encontrado = true;
			i++;
		}
		
		if(!encontrado) {
			listaUsuarios.add(u);
		}
		else {
			JOptionPane.showMessageDialog(new JFrame(), "Error, ya existe un usuario con el mismo identificador", "ERROR", JOptionPane.ERROR_MESSAGE);		
		}		
	}

	public boolean buscarUsuarioContrasena(String id, String cont) {
		boolean b = false, encont = false;
		int i = 0;

		while (!encont && !b && i < listaUsuarios.size()) {
			if (listaUsuarios.get(i).getId().equals(id)) {
				encont=true;
				if(listaUsuarios.get(i).getContrasena().equals(cont))
					b = true;
			}
			i++;
		}
		return b;

	}

	public void modificarDatosUsuario (String id, String nuevoId, String contrasena, String tlf) {
		boolean b = false;
		int i = 0;
		while (!b && i < listaUsuarios.size()) {
			if (listaUsuarios.get(i).getId().equals(id)) {
				b = true;
				listaUsuarios.get(i).setContrasena(contrasena);
				listaUsuarios.get(i).setTelefono(tlf);
				listaUsuarios.get(i).setID(nuevoId);
			}
			i++;
		}
	}
	
	public Usuario devolverUsuario(String id, String cont) {
		boolean b = false, encont = false;
		int i = 0;

		while (!encont && !b && i < listaUsuarios.size()) {
			if (listaUsuarios.get(i).getId().equals(id)) {
				encont=true;
				if(listaUsuarios.get(i).getContrasena().equals(cont))
					b = true;
				
			}
			i++;
		}
		return listaUsuarios.get(i-1);

	}

	public void llenarUsuarios() {
		
		File doc = new File(ruta+"\\Usuarios.txt");
		Scanner obj;
		try {
			obj = new Scanner(doc);
			while (obj.hasNextLine()){
				String linea = obj.nextLine();
				String[] partes = linea.split("-");
				listaUsuarios.add(new Usuario(partes[0],partes[1],partes[2],partes[3],partes[4],partes[5]));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void exportarUsuarios() {

		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(ruta+"\\Usuarios.txt");
			pw = new PrintWriter(fichero);
			
			//escribir con pw.println();
			for (int z=0;z<this.listaUsuarios.size();z++) {
				pw.println(listaUsuarios.get(z).getId()+"-"+listaUsuarios.get(z).getContrasena()+"-"+
						listaUsuarios.get(z).getNombre()+"-"+listaUsuarios.get(z).getApellido()+"-"+
						listaUsuarios.get(z).getTlf()+"-"+listaUsuarios.get(z).getDni());
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
}

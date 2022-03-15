//import Usuario;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        System.out.println("Bienvenido a Imalala SA, la mejor agencia de viaje");
        ListaUsuarios listaUsuarios = new ListaUsuarios();
        listaUsuarios.anadirUsuario(new Usuario());
        
        System.out.println("Introduzca su id de usuario");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        if(listaUsuarios.buscarUsuario(s)) {
        	System.out.println("Id correcto, introduzca su contrase�a");
        	String c = in.nextLine();
        	if(listaUsuarios.buscarUsuarioContrasena(s, c)) {
            	System.out.println("Contrase�a correcta, bienvenido");
        	} else {
        		System.out.println("contrasena incorrecta");
        	}
        }
        else{
        	System.out.println("Id incorrecto, introduzca datos para registrarse");

        };
        

	}

}

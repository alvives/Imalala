//import Usuario;
import java.util.Scanner;
import java.sql.*;

public class Main {

	public static void main(String[] args) {
        System.out.println("Bienvenido a Imalala SA, la mejor agencia de viajes");
        ListaUsuarios listaUsuarios = new ListaUsuarios();
        listaUsuarios.anadirUsuario(new Usuario());
        /*
        System.out.println("Introduzca su id de usuario");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        if(listaUsuarios.buscarUsuario(s)) {
        	System.out.println("Id correcto, introduzca su password");
        	String c = in.nextLine();
        	if(listaUsuarios.buscarUsuarioContrasena(s, c)) {
            	System.out.println("Password correcta, bienvenido");
        	} else {
        		System.out.println("Password incorrecta");
        	}
        }
        else{
        	System.out.println("Id incorrecto, introduzca datos para registrarse");

        };*/
        

        try
        {
           Class.forName("com.mysql.jdbc.Driver");  
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");  
           Statement stmt=con.createStatement();  


        // create our mysql database connection
        //String myDriver = "com.mysql.jdbc.Driver"; //com.mysql.jdbc.Driver o org.gjt.mm.mysql.Driver
        //String myUrl = "jdbc:mysql://localhost:3306/test";
        //Class.forName(myDriver);
        //Connection conn = DriverManager.getConnection(myUrl, "root", "");
        
        /*
        // our SQL SELECT query. 
        // if you only need a few columns, specify them by name instead of using "*"
        String query = "SELECT * FROM usuarios";

        // create the java statement
        Statement st = conn.createStatement();
        
        // execute the query, and get a java resultset
        ResultSet rs = st.executeQuery(query);
        
        // iterate through the java resultset
        while (rs.next())
        {
                
                String id =  rs.getString("id");
                String contrasena =  rs.getString("contrasena");
                String nombre =  rs.getString("nombre");
                String apellido =  rs.getString("apellido");
                String tlf =  rs.getString("tlf");
                String dni =  rs.getString("dni");
                
                listaUsuarios.anadirUsuario(new Usuario(id, contrasena, nombre, apellido, tlf, dni));
       }
        st.close();*/
        }

        catch (Exception e)
        {
                System.err.println("Fail to connect database =( ! ");
                System.err.println(e.getMessage());
        }



	}

}

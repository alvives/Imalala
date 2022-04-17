package model;
public class Usuario {

	  //Variables
	  private String id;
	  private String contrasena;
	  private String nombre;
	  private String apellido;
	  private String tlf;
	  private String dni;


	  //Constructor
	  public Usuario(String id, String cont,String nom, String apell,String tlf, String dni){
	    this.id=id;
	    this.contrasena=cont;  
	    this.nombre=nom;
	    this.apellido=apell;
	    this.tlf=tlf;
	    this.dni=dni;
	  }

	  public Usuario(){
	    this.id="darodr";
	    this.contrasena="ajedrez";  
	    this.nombre="David";
	    this.apellido="Rodriguez";
	    this.tlf="667663377";
	    this.dni="38979838F";
	  }
	  

	  //gets
	  public String getId (){
	    return this.id;
	  }
	  public String getContrasena (){
	    return this.contrasena;
	  }
	  public String getNombre (){
	    return this.nombre;
	  }
	  public String getApellido (){
	    return this.apellido;
	  }
	  public String getTlf (){
	    return this.tlf;
	  }
	  public String getDni (){
	    return this.dni;
	  }

	  public void setContrasena(String cont){
	    this.contrasena=cont;
	  }
	  public void setTelefono(String tlf){
	    this.tlf=tlf;
	  }
	  public void setID(String id){
	    this.id=id;
	  }
	  
	  //prints
	   public void printID (){
	    System.out.println(this.id);
	  }
	  public void printNombre (){
	    System.out.println(this.nombre);
	  }
	   public void printApellido (){
	    System.out.println(this.apellido);
	  }
	  public void printContrasena (){
	    System.out.println(this.contrasena);
	  }
	   public void printTelefono (){
	    System.out.println(this.tlf);
	  }
	   public void printDNI (){
	    System.out.println(this.dni);
	  }

	  public boolean comprobarContrasena(String cont) {
		  return this.contrasena.equals(cont);
	  }

}

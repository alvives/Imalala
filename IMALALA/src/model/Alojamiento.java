package model;
public class Alojamiento {
	//Variables
	private String id;
	private String capacidad;
	private String direccion;
	private String nombreHotel;
	private String ciudad;

	//Constructor
	public Alojamiento(String id, String capacidad, String direccion, String nombreHotel, String ciudad){
	  this.id=id;
	  this.capacidad=capacidad;
	  this.ciudad=ciudad;
	  this.direccion=direccion;
	  this.nombreHotel=nombreHotel;
	}
	
	//GET
	  
	public String getId (){
		return this.id;
	}
	
	public String getNombreHotel() {
		return nombreHotel;
	}

	public String getCiudad (){
		return this.ciudad;
	}
	
	public String getCapacidad() {
		return capacidad;
	}

	public String getDireccion() {
		return direccion;
	}


	// SET

    public void setID(String id){
    	this.id=id;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}	

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setNombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}
}

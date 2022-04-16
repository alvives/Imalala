
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
	  

	  
	public String getId (){
		return this.id;
	}
	
	public String getCiudad (){
		return this.ciudad;
	}
	
    public void setID(String id){
    	this.id=id;
	}


	public String getCapacidad() {
		return capacidad;
	}


	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	





	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getNombreHotel() {
		return nombreHotel;
	}


	public void setNombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}
}

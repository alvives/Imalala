
public class Alojamiento {
	//Variables
	private String id;
	private String capacidad;
	private String numHabitacion;
	private String planta;
	private String direccion;
	private String nombreHotel;


	//Constructor
	public Alojamiento(String id, String capacidad,String numHabitacion, String planta,String direccion, String nombreHotel){
	  this.id=id;
	  this.capacidad=capacidad;
	  this.numHabitacion=numHabitacion;
	  this.planta=planta;
	  this.direccion=direccion;
	  this.nombreHotel=nombreHotel;
	}
	  

	  //gets
	public String getId (){
		return this.id;
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


	public String getNumHabitacion() {
		return numHabitacion;
	}


	public void setNumHabitacion(String numHabitacion) {
		this.numHabitacion = numHabitacion;
	}


	public String getPlanta() {
		return planta;
	}


	public void setPlanta(String planta) {
		this.planta = planta;
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

package model;
public abstract class Transporte {
	private String id, capacidad;
	private boolean disponibilidad;
	
	public Transporte (String id, String capacidad) {
		
		this.id = id;
		this.capacidad=capacidad;
		this.disponibilidad=true;

	}
	
	//GETS

	public String getId() {
		return id;
	}

	public boolean getDisponibilidad (){
		return this.disponibilidad;
	}

		
	public String getCapacidad (){
	    return this.capacidad;
	}

	public abstract String getTipoTransporte();
	
	//SET
	
	public void setDisponibilidad (boolean disponibilidad){
	    this.disponibilidad=disponibilidad;
	}

	public void setId(String id) {
		this.id = id;
	}

}

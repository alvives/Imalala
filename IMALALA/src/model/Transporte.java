package model;
public abstract class Transporte {
	private String id, capacidad;
	
	public Transporte (String id, String capacidad) {
		
		this.id = id;
		this.capacidad=capacidad;
	}
	
	//GETS

	public String getId() {
		return id;
	}


		
	public String getCapacidad (){
	    return this.capacidad;
	}

	public abstract String getTipoTransporte();
	
	//SET
	public void setId(String id) {
		this.id = id;
	}
	public void setCapacidad(String capacidad){
	    this.capacidad = capacidad;
	}

}

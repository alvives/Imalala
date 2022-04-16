
public abstract class Transporte {
	private String id, capacidad, origen, destino;
	private boolean disponibilidad;
	
	
	
	public Transporte (String id, String capacidad) {
		this.setId(id);
		this.capacidad=capacidad;
		this.disponibilidad=true;

	}
	
	
	public void setDisponibilidad (boolean disponibilidad){
	    this.disponibilidad=disponibilidad;
	}
	
	public boolean getDisponibilidad (){
		return this.disponibilidad;
	}
	
	public String getCapacidad (){
	    return this.capacidad;
	}
	
	public void setOrigen (String origen){
	    this.origen=origen;
	}
	
	public void setDestino (String destino){
	    this.destino=destino;
	}

	public abstract String getTipoTransporte();


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

}

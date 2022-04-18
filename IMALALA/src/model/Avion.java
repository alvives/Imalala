package model;
public class Avion extends Transporte{
	
	private	final String tipo = "avion";
	
	public Avion (String id, String capacidad) {
		super(id, capacidad);
	}

	@Override
	public String getTipoTransporte() {
		
		return this.tipo;
	}
	
}

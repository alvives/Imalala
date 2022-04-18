package model;
public class Barco extends Transporte{

	private	final String tipo = "barco";

    public Barco (String id, String capacidad) {
		super(id, capacidad);
	}

    @Override
	public String getTipoTransporte() {
		
		return this.tipo;
	}
    
}

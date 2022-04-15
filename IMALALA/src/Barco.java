
public class Barco extends Transporte{

    public Barco (String id, String capacidad) {
		super(id, capacidad);
	}

    @Override
	public String getTipoTransporte() {
		
		return "barco";
	}
    
}

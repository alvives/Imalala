
public class Avion extends Transporte{
	
	
	public Avion (String id, String capacidad) {
		super(id, capacidad);
	}

	@Override
	public String getTipoTransporte() {
		
		return "avion";
	}

	
	
}

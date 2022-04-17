
public class Reserva {
	private String id;
	private Usuario usuario;
	private Viaje viaje;
	private boolean extraPosibilidadCancelacion;
	
	public Reserva(String id, Usuario u, Viaje v, boolean b) {
		this.setId(id);
		this.setUsuario(u);
		this.setViaje(v);
		this.setExtraPosibilidadCancelacion(b);
	}

	
	//GETS
	public String getId() {
		return this.id;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public Viaje getViaje() {
		return this.viaje;
	}
	
	public boolean getExtraPosibilidadCancelacion() {
		return extraPosibilidadCancelacion;
	}
	
	//SETS
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}
	
	public void setExtraPosibilidadCancelacion(boolean extraPosibilidadCancelacion) {
		this.extraPosibilidadCancelacion = extraPosibilidadCancelacion;
	}
	
	//OTHERS
	public boolean isExtraPosibilidadCancelacion() {
		return extraPosibilidadCancelacion;
	}


	
	
	
	
	
}

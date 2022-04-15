
public class Reserva {
	private Usuario usuario;
	private Viaje viaje;
	private boolean extraPosibilidadCancelacion;
	
	public Reserva(Usuario u, Viaje v, boolean b) {
		this.setUsuario(u);
		this.setViaje(v);
		this.setExtraPosibilidadCancelacion(b);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}

	public boolean isExtraPosibilidadCancelacion() {
		return extraPosibilidadCancelacion;
	}

	public void setExtraPosibilidadCancelacion(boolean extraPosibilidadCancelacion) {
		this.extraPosibilidadCancelacion = extraPosibilidadCancelacion;
	}
	
	
	
	
	
}


public class ParticipanteExterno extends Participante {
	private String entidad;

	public ParticipanteExterno(String correo, String nombre, String entidad) {
		super(correo, nombre);
		this.entidad = entidad;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}
	
	
}

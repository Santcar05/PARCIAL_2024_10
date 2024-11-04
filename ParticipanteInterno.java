//Primer punto [5 pts]
public class ParticipanteInterno extends Participante{
	private String facultad;

	public ParticipanteInterno() {
		super();
	}
	public ParticipanteInterno(String correo, String nombre, String facultad) {
		super(correo, nombre);
		this.facultad = facultad;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	
	
}

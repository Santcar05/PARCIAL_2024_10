
public abstract class Participante {
	private String correo;
	private String nombre;
	
	public Participante() {
		
	}
	public Participante(String correo, String nombre) {
		super();
		this.correo = correo;
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}

import java.util.ArrayList;
import java.util.Date;

public abstract class Evento {
	private String nombre;
	private int capacidad;
	private Date fecha;
	private ArrayList<Participante> participantes;
	
	public Evento(String nombre, int capacidad, Date fecha) {
		super();
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}
	
	
	//Putno 2 [15pts]	
	public void registrarParticipante(Participante p) throws Exception{
		//Verificar las excepciones antes de agregar el participante
		//Lanzar excepcion si al insertar el particpante se supera su capacidad
		if(this.capacidad < this.participantes.size() + 1) {
			throw new Exception("Capacidad superada.");
		}
		//Lanzar excepcion si ya existe un participante con el mismo correo
		//Verificar en la lista de participantes
		for(Participante pAux: this.participantes) {
			if(pAux.getCorreo().equals(p.getCorreo()))
				throw new Exception("Correo ya registrado.");
		}
		//Si se intenta registrar un participante externo a un evento academico
		//para referirse al mismo objeto que llama al metodo se utiliza this
		//Entonces se comparara ese objeto que llama la clase (this) y saber si es un 
		//Evento academico 
		if(this instanceof EventoAcademico && p instanceof ParticipanteExterno) {
			throw new Exception("No se puede ingresar un foraneo en un evento academico");
		}
		
		//Si ninguno genera excepcion, entonces ya se podrá insertar el participante al evento
		this.participantes.add(p);
	}
	
}

import java.util.Date;

public class EventoAcademico extends Evento{
	private final int tarifa_fija;
	private String facultad;
	
	
	public EventoAcademico(String nombre, int capacidad, Date fecha, int tarifa_fija, String facultad) {
		super(nombre, capacidad, fecha);
		this.tarifa_fija = tarifa_fija;
		this.facultad = facultad;
	}
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	public int getTarifa_fija() {
		return tarifa_fija;
	}
	//Punto 4.1 [10pts]
	public int calcularCosto() {
		int sum = 0;
		for(Participante p: super.getParticipantes()) {
			ParticipanteInterno pAux = (ParticipanteInterno) p;
			if(!(pAux.getFacultad().equals(this.facultad))) {
				sum+=tarifa_fija;
			}
		}
		return sum;
	}
	
}

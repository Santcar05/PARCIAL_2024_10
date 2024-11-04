import java.util.Date;

public class EventoExterno extends Evento {
	private String patrocinador;
	private int tarifaPorParticipante;
	
	
	public EventoExterno(String nombre, int capacidad, Date fecha, String patrocinador, int tarifaPorParticipante) {
		super(nombre, capacidad, fecha);
		this.patrocinador = patrocinador;
		this.tarifaPorParticipante = tarifaPorParticipante;
	}
	public String getPatrocinador() {
		return patrocinador;
	}
	public void setPatrocinador(String patrocinador) {
		this.patrocinador = patrocinador;
	}
	public int getTarifaPorParticipante() {
		return tarifaPorParticipante;
	}
	public void setTarifaPorParticipante(int tarifaPorParticipante) {
		this.tarifaPorParticipante = tarifaPorParticipante;
	}
	//Punto 4.2 [10pts]
	public int calcularCosto() {
		int sum = 0;
		for(Participante p: super.getParticipantes()) {
			ParticipanteExterno pAux = (ParticipanteExterno) p;
			if(!(pAux.getEntidad().equals(this.patrocinador))) {
				sum+=tarifaPorParticipante;
			}else {
				sum+=tarifaPorParticipante*0.5;
			}
		}
		return sum;
	}
	
}

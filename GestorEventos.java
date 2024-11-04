import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class GestorEventos implements Serializable{
	private ArrayList<Evento> eventos = new ArrayList<Evento>();
	
	public GestorEventos() {
		
	}
	public GestorEventos(ArrayList<Evento> eventos) {
		super();
		this.eventos = eventos;
	}

	public ArrayList<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}
	
	public void agregarParticipante(String nombreEvento, Participante p) throws Exception{
		//Tomar en cuenta los casos de excepcion antes de insertar el participante
		//Con base a las anteriores metodos creados sabemos que el caso b,d y e
		//Se solucionan si se llama el metodo del punto 2
		//caso A: El evento no existe
		if(this.eventos.size() == 0)
			throw new Exception("No hay eventos.");
		//Caso c: El participante ya estaba registrado en otro evento en esa misma fecha
		//Recorrer todos los eventos y saber si tiene un evento a la misma hora
		//Primero hay que saber el evento al que quiere ingresar
		Evento evento = null;
		for(Evento e: this.eventos) {
			if(e.getNombre().equals(e.getNombre())) {
				evento = e;
				break;
			}
		}
		//ahora hay que recorrer todos los eventos(menos el que quiere ingresar)
		for(Evento e: this.eventos) {
			if(e.getFecha().equals(evento.getFecha()) && e != evento)
				throw new Exception("Fechas iguales en dos eventos en los que participaria el cliente");
		}
		
		//los demas casos se solucionan con el llamado al metodo de Evento 
		//y al mismo tiempo ese metodo agrega el participante si no genera excepcion
		evento.registrarParticipante(p);
		
	}
	//Punto 5 [5pts]
	public void serializar(String ruta) throws Exception{
		//no se va a hacer try-catch al abrir el archivo porque no quiero manejarlo en la funcion sino en el main
		ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ruta));
		salida.writeObject(this.eventos);
		salida.close();
	}
	//Punto 6 [5pts]
	public void deserializar(String ruta) throws Exception {
		//Vaciar todos los eventos antes de leerlos del archivo binario
		this.getEventos().clear();
		//no se va a hacer try-catch al abrir el archivo porque no quiero manejarlo en la funcion sino en el main
		ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(ruta));
		//Castear la lectura del archivo binario
		this.eventos = (ArrayList<Evento>)entrada.readObject();
		entrada.close();
		
	}
	//Punto 7 [20pts]
	//Trabajar todo con un String cadena, cada iteracion de evento, se insertará en el archivo de texto
	
	public void reporteEventos(String ruta)throws Exception {
		FileWriter salida = new FileWriter(ruta);
		String cadena;
		for(Evento e: this.eventos) {
			cadena = "";
			cadena.concat("Evento: " + e.getNombre()+"\nCapacidad: "+e.getCapacidad()+"participantes\nTipo:");
			if(e instanceof EventoExterno) {
				cadena.concat("Externo\n");
			}else
				cadena.concat("Academico\n");
			cadena.concat("Participantes:");
			for(Participante p: e.getParticipantes()) {
				cadena.concat(p.getNombre()+" - "+p.getCorreo()+" ");
				if(p instanceof ParticipanteInterno) {
					ParticipanteInterno pInterno = (ParticipanteInterno) p;
					cadena.concat(pInterno.getFacultad()+"\n");
				}else {
					ParticipanteExterno pExterno = (ParticipanteExterno) p;
					cadena.concat(pExterno.getEntidad()+"\n");
				}
					
			}
			salida.write(cadena);
		}
		salida.close();
	}
}

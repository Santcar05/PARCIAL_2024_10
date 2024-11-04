import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int opcion = 1;
		GestorEventos gestorEventos = new GestorEventos();
		Scanner sc = new Scanner(System.in);
		try {
			while(opcion != 0) {
			
					System.out.println("==== Sistema de Biblioteca ====");
					System.out.println("1. agregar participante (punto 3).");
					System.out.println("2. Calcular costo(punto 4).");
					System.out.println("3. serializar(punto 5).");
					System.out.println("4. Deserializar(punto 6).");
					System.out.println("5. Reporte Eventos(punto 7).");
					System.out.println("0. Salir.");					
					System.out.print("Seleccione una opcion: ");
					opcion = Integer.parseInt(sc.nextLine());
					switch(opcion) {
						case 1:{
							ParticipanteInterno p = new ParticipanteInterno();
							gestorEventos.agregarParticipante("Evento1", p);
							break;
						}
						case 2:{
							break;
						}
						case 3:{
							break;
						}
						case 4:{
							break;
						}
						case 5:{
							break;
						}
						case 0:{
							break;
						}
					}
		}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}

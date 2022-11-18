package Main;

import java.time.Instant;
import java.util.ArrayList;

import Hilos.HiloSuma;

public class MainApp {

	private static ArrayList<Integer> listaPrincipal = new ArrayList<Integer>();

	public static void main(String[] args) throws Exception {

		Instant tiempoInicial = Instant.now();
		
		long numero = 0;
		int hilos = 0;
		
		int contadorNombre = 1;
		int posInicial = 0;
		int posFinal = 0;
		int corte = 0;
		
		int sumaDeTodosLosHilos = 0;
		
		String nombre = null;

		try {
			numero = Long.parseLong(args[0]);

		} catch (Exception e) {
			numero = 100000000;

		}

		try {
			hilos = Integer.parseInt(args[1]);
		} catch (Exception e) {
			hilos = 1;
		}
		
		System.out.println("Cantidad de numeros a crear: " + numero);
		System.out.println("Numero de hilos a crear: " + hilos);
		System.out.println("Tiempo inicial: " + tiempoInicial);
		corte = (int) (numero / hilos);

		for (int i = 0; i < numero; i++) {
			
			listaPrincipal.add(i);

		}

		posInicial = 0;
		posFinal = corte;
		for (int i = 0; i < hilos; i++) {
			nombre = "Hilo" + contadorNombre;
			HiloSuma nuevoHilo = new HiloSuma(nombre, listaPrincipal, posInicial, posFinal);
			Thread nuevoThread = new Thread(nuevoHilo);
			nuevoThread.start();
			nuevoThread.join();
			int resultado = (int) nuevoHilo.getSumaTotal(); 
			contadorNombre++;
			posInicial = posFinal + 1;
			posFinal = posFinal + corte;
			sumaDeTodosLosHilos += resultado;
		}
		Instant tiempoFinal = Instant.now();
		
		System.out.println("LA SUMA DE TODOS LOS HILOS ES: " + sumaDeTodosLosHilos);
		System.out.println("Tiempo final: " + tiempoFinal);
	}	

	
}

package Main;


import Threads.ThreadObservador;

public class MainApp {

	

	public static void main(String[] args) throws Exception {
		// Ejecuta el hilo principal que activa el WatchService a la carpeta input
		ThreadObservador threadObserva = new ThreadObservador();
		threadObserva.start();
		
		
	}
}

package Main;


import Threads.ThreadObservador;

public class MainApp {

	

	public static void main(String[] args) throws Exception {

		ThreadObservador threadObserva = new ThreadObservador();
		threadObserva.start();

	}
}

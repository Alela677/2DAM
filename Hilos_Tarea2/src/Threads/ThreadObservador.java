package Threads;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;

import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import Properties.FicheroPropiedades;

public class ThreadObservador extends Thread {

	private String nombreImagen;
	
	// Constructor
	public ThreadObservador() {
		super();
	}

	/**
	 * Hilo que ejecuta la clase WatchService que monitorea una carpeta que
	 * indicamos Decteta los eventos que se realizan en la capeta CREATE, DELETE,
	 * MODIFY En esta caso utilizamos el evento create detecta si algun archivo
	 * entro en la carpeta Y lanza dos hilos tipo worker con el nombre del fichero
	 * que ha entrado
	 */
	@Override
	public void run() {

		try {

			WatchService service = FileSystems.getDefault().newWatchService();

			// Fichero que monitorea
			Path directorio = Paths.get(FicheroPropiedades.getEntrada());

			WatchKey key = directorio.register(service, ENTRY_CREATE);
			System.out.println("Observando " + directorio.toString());

			// Bucle que se activa cuando detecta que el servicio recibio un evento
			while ((key = service.take()) != null) {

				// Lista de eventos
				for (WatchEvent<?> event : key.pollEvents()) {

					System.out.println(event.kind());

					Kind<?> tipoevento = event.kind();
					Path fichero = directorio.resolve((Path) event.context());

					// Cogemos el nombre del fichero que entro
					nombreImagen = fichero.toString().split("\\\\")[1];

					// Si el evento es tipo create lanza los hilos workers
					if (tipoevento == ENTRY_CREATE) {
						for (int i = 0; i < event.count(); i++) {
							
							// Nuevo hilo 
							Thread nuevoHilo = new ThreadImagenes(nombreImagen);
							nuevoHilo.start();
						}

					}
				}
				// Cuando termina vuelve a hacer el ciclo en un bucle infinito
				key.reset();

			}
		} catch (Exception e) {
			System.out.println("ERROR: EL HILO OBSERVDOR NO SE PUEDE INICIAR");
		}

	}
}
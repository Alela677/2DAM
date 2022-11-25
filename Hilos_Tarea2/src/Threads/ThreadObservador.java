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
	private int contadorEventos = 0;

	public ThreadObservador() {
		super();
	}

	@Override
	public void run() {

		try {
			WatchService service = FileSystems.getDefault().newWatchService();
			Path directorio = Paths.get(FicheroPropiedades.getEntrada());

			WatchKey key = directorio.register(service, ENTRY_CREATE, ENTRY_DELETE);
			System.out.println("Observando " + directorio.toString());
			while (true) {

				for (WatchEvent<?> event : key.pollEvents()) {

					Kind<?> tipoevento = event.kind();
					Path fichero = directorio.resolve((Path) event.context());
					nombreImagen = fichero.toString().split("\\\\")[1];
					System.out.println(tipoevento + " - " + nombreImagen);
					if (tipoevento == ENTRY_CREATE) {

						Thread nuevoHilo = new ThreadImagenes(nombreImagen);
						nuevoHilo.start();

						sleep(2000);

					} else if (tipoevento == ENTRY_DELETE) {

					}
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
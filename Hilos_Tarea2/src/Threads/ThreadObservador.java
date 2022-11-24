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
import java.util.ArrayList;
import java.util.List;

import Properties.FicheroPropiedades;

public class ThreadObservador extends Thread {

	private int numeroImagen;
	private String nombreHilo;
	private String nombreImagen;
	private int contadorHilo = 1;

	public ThreadObservador() {
		super();
	}

	@Override
	public void run() {

		try {
			WatchService watcher = FileSystems.getDefault().newWatchService();

			Path dir = Paths.get(FicheroPropiedades.getEntrada());

			dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE);

			System.out.println("Iniciado observacion " + dir.getFileName());

			for (;;) {

				WatchKey key;
				key = watcher.take();

				List<WatchEvent<?>> listaEventos = key.pollEvents();

				for (WatchEvent<?> evento : listaEventos) {
					Kind<?> tipoEvento = evento.kind();
					Path filename = (Path) evento.context();
					System.out.println(tipoEvento.name() + " : " + filename);

					if (tipoEvento == OVERFLOW) {
						continue;
					} else if (tipoEvento == ENTRY_CREATE) {

						numeroImagen = listaEventos.size();
						nombreImagen = filename.toString();

						if (numeroImagen > 0) {
							for (int i = 0; i < numeroImagen; i++) {
								nombreHilo = "Hilo" + contadorHilo;
								Thread nuevo = new ThreadImagenes(nombreImagen, nombreHilo);
								nuevo.start();
								contadorHilo++;

							}

						}

					} else if (tipoEvento == ENTRY_DELETE) {
						contadorHilo = 1;
						numeroImagen = 0;
					}
				}

				listaEventos.clear();
				boolean valid = key.reset();
				if (!valid) {
					break;
				}

			}
		} catch (

		Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

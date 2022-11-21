package WatchService;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;

import static java.nio.file.StandardWatchEventKinds.*;
import java.nio.file.WatchService;
import java.util.List;

import Properties.FicheroPropiedades;

public class Observador {

	public static void observar() throws Exception {

		WatchService watcher = FileSystems.getDefault().newWatchService();

		Path dir = Paths.get(FicheroPropiedades.getEntrada());

		dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

		System.out.println("Iniciado observacion " + dir.getFileName());

		while (true) {
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

				} else if (tipoEvento == ENTRY_DELETE) {

				} else if (tipoEvento == ENTRY_MODIFY) {

				}
			}

			boolean valid = key.reset();
			if (!valid) {
				break;
			}

			

		}
	}

}

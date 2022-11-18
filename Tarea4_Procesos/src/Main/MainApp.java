package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Procesos.ProcesoCapicua;
import Procesos.ProcesoGenerar;
import Procesos.ProcesoInformacion;

public class MainApp {

	public static void main(String[] args) throws Exception {

		List<Process> procesos = procesos(args[0]);
		Process informacion = procesos.get(procesos.size() - 1);
		Scanner sc = new Scanner(informacion.getInputStream());
		while (sc.hasNext()) {
			String linea = sc.nextLine();
			System.out.println(linea);
		}
		sc.close();
	}

	public static List<Process> procesos(String cantidadNumeros) throws Exception {

		List<ProcessBuilder> builders = new ArrayList<ProcessBuilder>();
		builders.add(ProcesoGenerar.lanzadorGenerador(cantidadNumeros));
		builders.add(ProcesoCapicua.lanzadorCapicua());
		builders.add(ProcesoInformacion.lanzadorInformacion());
		return ProcessBuilder.startPipeline(builders);

	}

}

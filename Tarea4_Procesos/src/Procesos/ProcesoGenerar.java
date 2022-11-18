package Procesos;

public class ProcesoGenerar {

	public static void main(String[] args) {

		int cantidadNumeros = 0;
		int numeroGenerado = 0;

		try {
			cantidadNumeros = Integer.parseInt(args[0]);
		} catch (Exception e) {
			cantidadNumeros = 10000;

		}

		for (int i = 0; i < cantidadNumeros; i++) {
			numeroGenerado = (int) Math.round(Math.random() * 100000000 + 100000);
			System.out.println(numeroGenerado);
		}
	}

	public static ProcessBuilder lanzadorGenerador(String cantidad) throws Exception {

		ProcessBuilder builder = new ProcessBuilder("java", "Procesos.ProcesoGenerar" , cantidad);
		builder.start();
		return builder;

	}
}

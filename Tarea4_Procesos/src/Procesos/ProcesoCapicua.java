package Procesos;

import java.util.Scanner;

public class ProcesoCapicua {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		while (scan.hasNext()) {
			long numero = Long.parseLong(scan.next());

			if (esCapicua(numero)) {

				System.out.println(numero);
			}
		}

		scan.close();
	}

	public static ProcessBuilder lanzadorCapicua() throws Exception {

		ProcessBuilder builder = new ProcessBuilder("java", "Procesos.ProcesoCapicua");
		builder.start();
		return builder;

	}

	private static boolean esCapicua(long numero) {

		long inverso = invierteNumero(numero);

		return (numero == inverso);
	}

	private static long invierteNumero(long numero) {
		long inverso = 0;

		while (numero != 0) {
			int ultimoDigito = (int) (numero % 10);
			inverso = inverso * 10 + ultimoDigito;
			numero /= 10;
		}

		return inverso;
	}

}

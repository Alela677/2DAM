package Procesos;

import java.util.Scanner;

public class ProcesoInformacion {

	public static void main(String[] args) {
		int numero = 0;
		int suma = 0;
		double media = 0.0;
		int lineas = 0;
		int mayor = 0;
		int menor = 0;

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {

			numero = Integer.parseInt(sc.nextLine());
			System.out.println("NUMERO ENCOTRADO: " + numero);

			suma += numero;
			

			if (lineas == 0) {
				mayor = numero;
				menor = numero;
			}

			if (numero > mayor) {
				mayor = numero;
			}

			if (numero < menor) {
				menor = numero;
			}
			lineas++;
		}
		sc.close();

		media = numero / lineas;

		System.out.println("--------- INFORMACION------------");
		System.out.println("La lista contiene: " + lineas + " numeros");
		System.out.println("La media de los numeros es: " + media);
		System.out.println("El numero menor es: " + menor);
		System.out.println("El numero mayor es: " + mayor);

	}

	public static ProcessBuilder lanzadorInformacion() throws Exception {

		ProcessBuilder builder = new ProcessBuilder("java", "Procesos.ProcesoInformacion");
		builder.start();
		return builder;

	}
}

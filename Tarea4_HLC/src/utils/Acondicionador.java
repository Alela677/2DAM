package utils;

import java.util.StringJoiner;

public class Acondicionador {

	private static final String ESPACIO = " ";

	// Metodo acondicionamiento de los atributos de HTML reemplaza los cracteres
	// comillas doble y comillas simples
	public static String acondicionaAtributosHTML(String cadena) {
		cadena = cadena.replaceAll("&", "&amp;").replaceAll("\"", "&#34;").replaceAll("\'", "&#39;").replaceAll("<",
				"&lt;");
		return cadena;

	}

	// Metodo acondicionamiento de elemento HTML reemplaza 3 caracteres para su
	// salida por pantalla
	public static String acondicionaElementosHTML(String cadena) {

		return cadena.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}

	// Metodo aconticionamineto CSS recorre la cadena y comprueba letra por letra si
	// contien alguno de los carcteres de la lista
	public static String acondicionaContenidoCSS(String cadena) throws Exception {

		char[] simbolos = { '\\', '\"', '\'', '<', '&', '(', ')', '/', '>' };
		int posicionCaracter = 0;
		String caracterComprobr = null;
		String simboloEncontrado = null;

		for (int i = 0; i < cadena.length(); i++) {
			for (int j = 0; j < simbolos.length; j++) {
				// Posicion del caracter
				posicionCaracter = cadena.indexOf(simbolos[j]);

				// Coge el caracter siguiente
				caracterComprobr = String.valueOf(cadena.charAt(posicionCaracter + 1));
				// Comprueba si el caracter actual contien un simbolo de la lista

				if (cadena.contains(String.valueOf(simbolos[j]))) {
					// Cogemos el simbolo que ha encontrado en la cadena
					simboloEncontrado = String.valueOf(cadena.charAt(posicionCaracter));
					// Si es un numero o una letra que se utiliza en valores hexdecimales lo codifica con un espacio
					if (esUnNumero(caracterComprobr) || esLetraHexadecimal(caracterComprobr)) {
						
						cadena = cadena.replace(simboloEncontrado,
								charToHexadecimal(simboloEncontrado).toLowerCase() + ESPACIO);
					} else {
						// Si no es un numero o una letra que no use los valores hexadecimales sin espacio
						cadena = cadena.replace(simboloEncontrado, charToHexadecimal(simboloEncontrado).toLowerCase());
					}
				}
			}
		}
		return cadena.replaceAll("%", "\\\\");
	}

	// Metodo acondicionamiento URL con la clase URLEncoder
	public static String acondicionaURL(String cadena) throws Exception {
		String[] simbolos = { "\\", "/", "Ω", ";", ":", "&", " ", "\"", "}", "{", "(", ")" };
		String simboloEncontrado = null;
		int simboloPos = 0;

		// Recorre la cadena y comprueba si hay algun simbolo de la lista
		for (int i = 0; i < cadena.length(); i++) {
			for (int j = 0; j < simbolos.length; j++) {
				// Si contiene algun simbolo
				if (cadena.contains(simbolos[j])) {
					// Cogemos la posicion del simbolo en la cadena
					simboloPos = cadena.indexOf(simbolos[j]);
					// Sacamos el simbolo de la cadena
					simboloEncontrado = String.valueOf(cadena.charAt(simboloPos));
					// Y reemplazamos el simbolo por su valor hexadecimal
					cadena = cadena.replace(simboloEncontrado, charToHexadecimal(simboloEncontrado));
				}
			}
		}
		return cadena;
	}

	// Metodo acondicionamiento SQL precede con una barra algunos caracteres usados
	// en SQL
	public static String acondicionaLiteralSQL(String cadena) {

		return cadena.replaceAll("\\\\", "\\\\\\\\").replaceAll("\"", "\\\\\"").replaceAll("'", "\\\\\'")
				.replaceAll("%", "\\\\\\%").replaceAll("_", "\\\\_");
	}

	// Metodo que comprueba si lo que se le pasa es un numero o no
	private static boolean esUnNumero(String valor) {
		try {
			Integer.parseInt(valor);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// Comprueba si la letra se usa para valores hexadecimales sin importat
	// mayusculas y minisculaas
	private static boolean esLetraHexadecimal(String caracter) {

		String[] lista = { "A", "B", "C", "D", "E", "F" };
		for (int i = 0; i < lista.length; i++) {
			if (caracter.equalsIgnoreCase(lista[i])) {
				return true;
			}
		}
		return false;
	}

	// Metodo que convierte un valor string en codigo hexadecimal en este caso la
	// utilizamos para comprobar simbolos
	private static String charToHexadecimal(String valor) throws Exception {

		String resultado = null;
		// Pasamos la cadena que le pasamos a byte
		byte[] simboloByte = valor.getBytes("UTF-8");
		StringJoiner finals = new StringJoiner("");

		// Recorremos la el array de bytes
		for (int i = 0; i < simboloByte.length; i++) {
			// Pasamos los bytes a hexadecimal
			resultado = Integer.toHexString(simboloByte[i]);

			// Si el byte es negativo le preceden 6 f que cortamos para coger los valores
			// que buscamos
			if (resultado.contains("ffffff")) {
				resultado = resultado.split("ffffff")[1];
			}
			// Uso StringJoiner para concatenar un string completo de los valores
			finals = finals.add("%" + resultado.toUpperCase());
		}

		return finals.toString();
	}

}

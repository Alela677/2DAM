package utils;

public class Acondicionador {

	private static final String CSSBARRAIZQ = "\\";
	private static final String CSSCOMILLASIZQ = "\"";
	private static final String CSSCOMILLAIZQ = "\'";
	private static final String CSSMENOR = "<";
	private static final String CSSMAYOR = ">";
	private static final String CSSASPERSAN = "&";
	private static final String CSSPARENTESISDRCH = ")";
	private static final String CSSPARENTESISIZQ = "(";
	private static final String CSSBARRADERCH = "/";

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
	public static String acondicionaContenidoCSS(String cadena) {

		String[] simbolos = { "\\", "\"", "\'", "<", "&", "(", ")", "/", ">" };
		int posicionCaracter = 0;
		String caracterComprobr = null;

		for (int i = 0; i < cadena.length(); i++) {
			for (int j = 0; j < simbolos.length; j++) {
				// Posicion del caracter
				posicionCaracter = cadena.indexOf(simbolos[j]);
				// Coge el caracter siguiente
				caracterComprobr = String.valueOf(cadena.charAt(posicionCaracter + 1));
				// Comprueba si el caracter actual contien un simbolo de la lista
				if (cadena.contains(simbolos[j])) {
					// Si es un numero lo codifica con un espacio
					if (esUnNumero(caracterComprobr) || esLetraHexadecimal(caracterComprobr)) {
						// Coge el caracter actual donde encontro el simbolo

						switch (String.valueOf(cadena.charAt(posicionCaracter))) {
//						case CSSBARRAIZQ:
//							cadena = cadena.replace("\\", "\\\\\\\\");
//							break;
						case CSSMENOR:
							cadena = cadena.replace(CSSMENOR, "\\\\3C ");
							break;

						case CSSMAYOR:
							cadena = cadena.replace(CSSMAYOR, "\\\\3E ");
							break;
						case CSSASPERSAN:
							cadena = cadena.replace(CSSASPERSAN, "\\\\26 ");
							break;
						case CSSCOMILLAIZQ:
							cadena = cadena.replace(CSSCOMILLAIZQ, "\\\\27 ");
							break;
						case CSSCOMILLASIZQ:
							cadena = cadena.replace(CSSCOMILLASIZQ, "\\\\22 ");
							break;
						case CSSPARENTESISDRCH:
							cadena = cadena.replace(CSSPARENTESISDRCH, "\\\\29 ");
							break;
						case CSSPARENTESISIZQ:
							cadena = cadena.replace(CSSPARENTESISIZQ, "\\\\28 ");
							break;
						case CSSBARRADERCH:
							cadena = cadena.replace(CSSBARRADERCH, "\\\\2F ");
							break;

						default:
							break;
						}

					} else {
						// Si no es un numero sin espacio

						switch (String.valueOf(cadena.charAt(posicionCaracter))) {

//						case CSSBARRAIZQ:
//							cadena = cadena.replace("\\", "\\\\\\");
//							break;
						case CSSMAYOR:
							cadena = cadena.replace(CSSMAYOR, "\\\\3E");
							break;
						case CSSMENOR:
							cadena = cadena.replace(CSSMENOR, "\\\\3C");
							break;
						case CSSASPERSAN:
							cadena = cadena.replace(CSSASPERSAN, "\\\\26");
							break;
						case CSSCOMILLAIZQ:
							cadena = cadena.replace(CSSCOMILLAIZQ, "\\\\27");
							break;
						case CSSCOMILLASIZQ:
							cadena = cadena.replace(CSSCOMILLASIZQ, "\\\\22");
							break;
						case CSSPARENTESISDRCH:
							cadena = cadena.replace(CSSPARENTESISDRCH, "\\\\29");
							break;
						case CSSPARENTESISIZQ:
							cadena = cadena.replace(CSSPARENTESISIZQ, "\\\\28");
							break;
						case CSSBARRADERCH:
							cadena = cadena.replace(CSSBARRADERCH, "\\\\2F");
							break;

						default:
							break;
						}
					}
				}
			}
		}
		return cadena;
	}

	// Metodo acondicionamiento URL con la clase URLEncoder
	public static String acondicionaURL(String cadena) throws Exception {
		String[] simbolos = { "\\", "/", "Ω", ";", ":", "&", " ", "\"", "}", "{", "(", ")" };
		String simboloEncontrado = null;
		int simboloPos = 0;
		String codigoHexadecimal = null;
		byte[] byteSimbolo = null;

		for (int i = 0; i < cadena.length(); i++) {
			for (int j = 0; j < simbolos.length; j++) {

				if (cadena.contains(simbolos[j])) {

					simboloPos = cadena.indexOf(simbolos[j]);
					simboloEncontrado = String.valueOf(cadena.charAt(simboloPos));
					byteSimbolo = simboloEncontrado.getBytes("UTF-8");

					for (int b = 0; b < byteSimbolo.length; b++) {
						codigoHexadecimal = Integer.toHexString(byteSimbolo[b]);

						if (codigoHexadecimal.contains("ffffff")) {
							codigoHexadecimal = codigoHexadecimal.split("ffffff")[1];
						}

						System.out.println(simboloEncontrado + " " + codigoHexadecimal);

						cadena = cadena.replace(simboloEncontrado, "%" + codigoHexadecimal.toUpperCase());
					}
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

	private static boolean esLetraHexadecimal(String caracter) {

		String[] lista = { "A", "B", "C", "D", "E", "F" };
		for (int i = 0; i < lista.length; i++) {
			if (caracter.equalsIgnoreCase(lista[i])) {
				return true;
			}
		}
		return false;
	}

}

package utils;

import java.net.URLEncoder;

public class Acondicionador {

	private static final String CSSBARRAIZQ = "\\\\";
	private static final String CSSCOMILLASIZQ = "\\“";
	private static final String CSSCOMILLAIZQ = "\\‘";
	private static final String CSSMENOR = "<";
	private static final String CSSMAYOR = ">";
	private static final String CSSASPERSAN = "&";
	private static final String CSSPARENTESISDRCH = "\\)";
	private static final String CSSPARENTESISIZQ = "\\(";

	private static String cssbarraizq = "\\\\005C";
	private static String csscomillasizq = "\\\\201C";
	private static String csscomillasdrch = "\\\\2018";
	private static String cssmenor = null;
	private static String cssamyor = null;
	private static String cssaspersan = "\\\\0026";
	private static String cssparentesisdrch = "\\\\0029";
	private static String cssparentesisizq = "\\\\0028";

	private static final String ESPACIO = " ";

	public static String acondicionaAtributosHTML(String cadena) {

		return cadena.replaceAll("\"", "&#34").replaceAll("\'", "&#32");

	}

	public static String acondicionaElementosHTML(String cadena) {

		return cadena.replaceAll("&", "&amp").replaceAll("<", "&lt").replaceAll(">", "&gt");
	}

	public static String acondicionaContenidoCSS(String cadena) {

		String[] simbolos = { "\\", "“", "‘", "<", "&", "(", ")", "/", ">" };
		int posicionCaracter = 0;
		String caracterComprobr = null;
		for (int i = 0; i < cadena.length(); i++) {
			for (int j = 0; j < simbolos.length; j++) {
				if (cadena.contains(simbolos[j])) {
					posicionCaracter = cadena.indexOf(simbolos[j]);
					caracterComprobr = String.valueOf(cadena.charAt(posicionCaracter) + 1);

					if(esUnNumero(caracterComprobr)) {
						cssmenor = "\\\\003C" + ESPACIO;
						cssamyor = "\\\\003E" + ESPACIO;
					} else if (!esUnNumero(caracterComprobr)) {
						cssamyor = "\\\\003E";
						cssmenor = "\\\\003C";
					}
				}

			}

		}

		return cadena.replace("<", cssmenor).replace(">", cssamyor);
	}

	public static String acondicionaURL(String cadena) throws Exception {
		String cadeanCodificada = URLEncoder.encode(cadena, "UTF-8");
		return cadeanCodificada;
	}

	public static String acondicionaLiteralSQL(String cadena) {

		return cadena.replaceAll("\\\\", "\\\\\\\\").replaceAll("“", "\\\\“").replaceAll("‘", "\\\\‘")
				.replaceAll("%", "\\\\%").replaceAll("_", "\\\\_");
	}

	private static boolean esUnNumero(String valor) {
		try {
			Integer.parseInt(valor);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}

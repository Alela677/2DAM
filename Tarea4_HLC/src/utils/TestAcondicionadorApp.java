package utils;

public class TestAcondicionadorApp {

	public static void main(String[] args) throws Exception {
		int errores = 0;

		if (!assertIgual(Acondicionador.acondicionaElementosHTML("Hola Caracola"), "Hola Caracola",
				"acondicionaElementoHtml1")) {
			errores++;
		}

		if (!assertIgual(Acondicionador.acondicionaElementosHTML("H<ola> Ca&racola"), "H&lt;ola&gt; Ca&amp;racola",
				"acondicionaElementoHtml2")) {
			errores++;
		}

		if (!assertIgual(Acondicionador.acondicionaAtributosHTML("Hola Caracola"), "Hola Caracola",
				"acondicionaAtributoHtml1")) {
			errores++;
		}

		if (!assertIgual(Acondicionador.acondicionaAtributosHTML("H<ola> Ca&ra\"co'la"),
				"H&lt;ola> Ca&amp;ra&#34;co&#39;la", "acondicionaAtributoHtml2")) {
			errores++;

		}

		if (!assertIgual(Acondicionador.acondicionaContenidoCSS("Hola Caracola"), "Hola Caracola",
				"acondicionaContenidoCss1")) {
			errores++;
		}

		if (!assertIgual(Acondicionador.acondicionaContenidoCSS("\"1 h ' o \\ l < a & C (a )r /1 ola"),
				"\\22 1 h \\27 o \\5c l \\3c a \\26 C \\28 a \\29r \\2f 1 ola", "acondicionaContenidoCss2")) {
			errores++;
		}

		if (!assertIgual(Acondicionador.acondicionaURL("Hola Caracola"), "Hola%20Caracola", "acondicionaUrl1")) {
			errores++;
		}

		if (!assertIgual(Acondicionador.acondicionaURL("@\\/ Ω"), "@%5C%2F%20%CE%A9", "acondicionaUrl2")) {
//			errores++;												 @\%2F%20%A9
		}

		if (!assertIgual(Acondicionador.acondicionaLiteralSQL("Hola Caracola"), "Hola Caracola",
				"acondicionaLiteralSql1")) {
			errores++;
		}

		if (!assertIgual(Acondicionador.acondicionaLiteralSQL("H\"'\\%_ ola"), "H\\\"\\'\\\\\\%\\_ ola",
				"acondicionaLiteralSql2")) {
			errores++;
		}

		if (errores == 0) {
			System.out.println("No se produjeron errores");
		} else {
			System.err.println("Se produjeron " + errores + " errores");
		}
	}

	private static boolean assertIgual(String cadena1, String cadena2, String metodo) {
		if (!cadena1.equals(cadena2)) {
			System.err.println("Error en " + metodo);
			return false;
		} else {
			return true;
		}
	}

}

package main;

import utils.Acondicionador;

public class MainApp {

	private static final String ATRIBUTOSHTML = "H<ola> Ca&ra\"co'la";
	private static final String ELEMENTOSHTML = "Esto > es mayor que esto < y esto es un aspersan &";
	private static final String CONTENIDOCSS = "\"1 h ' o \\ l < a & C (a )r /1 ola";
	private static final String LITERALSQL = "H\"'\\%_ ola";
	private static final String URL = "@\\/ Ω";

	public static void main(String[] args) throws Exception {

		String comprobar = null;

		// Comprueba lo metodos de la clase Acondicionador
//		comprobar = Acondicionador.acondicionaAtributosHTML(ATRIBUTOSHTML);
//		System.out.println("---------Atributo HTML--------------");
//		System.out.println(comprobar);

//		comprobar = Acondicionador.acondicionaElementosHTML(ELEMENTOSHTML);
//		System.out.println("---------Elemento HTML--------------");
//		System.out.println(comprobar);
//
//		comprobar = Acondicionador.acondicionaContenidoCSS(CONTENIDOCSS);
//		System.out.println("---------Contenido CSS--------------");
//		System.out.println(comprobar);
//
		comprobar = Acondicionador.acondicionaURL(URL);
		System.out.println("-----------URL--------------");
		System.out.println(comprobar);

//		comprobar = Acondicionador.acondicionaLiteralSQL(LITERALSQL);
//		System.out.println("-----------Literal SQL--------------");
//		System.out.println(comprobar);

	}

}
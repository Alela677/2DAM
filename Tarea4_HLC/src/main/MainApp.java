package main;

import utils.Acondicionador;

public class MainApp {

	private static final String ATRIBUTOSHTML = "Hola\" como \' estas";
	private static final String ELEMENTOSHTML = "Esto > es mayor que esto < y esto es un aspersan &";
	private static final String CONTENIDOCSS = "La cadena contiene comillas izquierda“ comilla simple izq‘ barra lateral izquierda\\  menor que< mayor que> un aspersan& un parentesis izq( y uno derecho ) y un barr lateral derecha/ ";
	private static final String LITERALSQL = "Comillas izquierda“  comilla simple izq‘  barra lateral izquierda\\ un tanto porciento% y una barra baja_";
	private static final String URL = "www.google.com/search?q=";
	private static final String PRUEBACSS = "Prueba <6 y >j";

	public static void main(String[] args) throws Exception {

		String comprobar = null;

//		comprobar = Acondicionador.acondicionaAtributosHTML(ATRIBUTOSHTML);
//		System.out.println("---------Atributo HTML--------------");
//		System.out.println(comprobar);

//		comprobar = Acondicionador.acondicionaElementosHTML(ELEMENTOSHTML);
//		System.out.println("---------Elemento HTML--------------");
//		System.out.println(comprobar);

		comprobar = Acondicionador.acondicionaContenidoCSS(PRUEBACSS);
		System.out.println("---------Contenido CSS--------------");
		System.out.println(comprobar);

//		comprobar = Acondicionador.acondicionaURL(URL);
//		System.out.println("---------URL--------------");
//		System.out.println(comprobar);

//		comprobar = Acondicionador.acondicionaLiteralSQL(LITERALSQL);
//		System.out.println("---------Literal SQL--------------");
//		System.out.println(comprobar);

	}

}
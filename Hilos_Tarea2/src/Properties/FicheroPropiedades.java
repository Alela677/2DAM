package Properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FicheroPropiedades {

	private static final String FICHERO = "config.properties";
	private static final String KEYENTRADA = "inputfolder";
	private static final String KEYSALIDA = "outputfolder";
	private static final String KEYWMAXIMO = "maxwidth";
	private static final String KEYHMAXIMO = "maxheight";

	private static Properties propiedades = new Properties();
	private static InputStream leerFichero;

	public static void main(String[] args) {
		
	}
	
	public static String getEntrada() {
		try {
			
			leerFichero = new FileInputStream(FICHERO);
			propiedades.load(leerFichero);
			String entrada = propiedades.getProperty(KEYENTRADA);
			return entrada;

		} catch (FileNotFoundException e) {
			System.out.println("ERROR: NO ENCUENTRO EL ARCHIVO");

		} catch (IOException e) {
			System.out.println("ERROR: EN LA ENTRADA O EN LA SALIDA");
		}
		return null;
	}

	public static String getSalida() {
		try {
			leerFichero = new FileInputStream(FICHERO);
			propiedades.load(leerFichero);
			String salida = propiedades.getProperty(KEYSALIDA);
			return salida;

		} catch (FileNotFoundException e) {
			System.out.println("ERROR: NO ENCUENTRO EL ARCHIVO");

		} catch (IOException e) {
			System.out.println("ERROR: EN LA ENTRADA O EN LA SALIDA");
		}
		return null;
	}
	
	
	public static String getWMaximo() {
		try {
			leerFichero = new FileInputStream(FICHERO);
			propiedades.load(leerFichero);
			String wMaximo = propiedades.getProperty(KEYWMAXIMO);
			return wMaximo;

		} catch (FileNotFoundException e) {
			System.out.println("ERROR: NO ENCUENTRO EL ARCHIVO");

		} catch (IOException e) {
			System.out.println("ERROR: EN LA ENTRADA O EN LA SALIDA");
		}
		return null;
	}
	
	
	public static String getWHaximo() {
		try {
			leerFichero = new FileInputStream(FICHERO);
			propiedades.load(leerFichero);
			String wHaximo = propiedades.getProperty(KEYHMAXIMO);
			return wHaximo;

		} catch (FileNotFoundException e) {
			System.out.println("ERROR: NO ENCUENTRO EL ARCHIVO");

		} catch (IOException e) {
			System.out.println("ERROR: EN LA ENTRADA O EN LA SALIDA");
		}
		return null;
	}

}

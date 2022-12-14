package Properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FicheroPropiedades {
	
	// Valores estaticos claves del fichero propiedades
	private static final String FICHERO = "config.properties";
	private static final String KEYENTRADA = "inputfolder";
	private static final String KEYSALIDA = "outputfolder";
	private static final String KEYWMAXIMO = "maxwidth";
	private static final String KEYHMAXIMO = "maxheight";
	
	// Atributos globales para leer la propiedades del fichero 
	private static Properties propiedades = new Properties();
	private static InputStream leerFichero;

	
	/**
	 * Metodo que devuelve el valor de la clave inputfolder del fichero de properties
	 * @return valor inputfolder
	 */
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
	
	
	/**
	 * Metodo que devuelve el valor de la clave outputfolder del fichero de properties
	 * @return valor ouputfolder
	 */
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
	
	/**
	 * Metodo que devuelve el valor de la clave maxwidth del fichero de properties
	 * @return valor maxwidth
	 */
	public static int getWMaximo() {
		try {
			leerFichero = new FileInputStream(FICHERO);
			propiedades.load(leerFichero);
			int wMaximo = Integer.parseInt(propiedades.getProperty(KEYWMAXIMO)); 
			
			return wMaximo;

		} catch (FileNotFoundException e) {
			System.out.println("ERROR: NO ENCUENTRO EL ARCHIVO");

		} catch (IOException e) {
			System.out.println("ERROR: EN LA ENTRADA O EN LA SALIDA");
		}
		return 0;
	}
	
	/**
	 * Metodo que devuelve el valor de la clave maxheigth del fichero de properties
	 * @return valor maxheigth
	 */
	public static int getHaximo() {
		try {
			leerFichero = new FileInputStream(FICHERO);
			propiedades.load(leerFichero);
			int wHaximo = Integer.parseInt( propiedades.getProperty(KEYHMAXIMO));
			
			return wHaximo;

		} catch (FileNotFoundException e) {
			System.out.println("ERROR: NO ENCUENTRO EL ARCHIVO");

		} catch (IOException e) {
			System.out.println("ERROR: EN LA ENTRADA O EN LA SALIDA");
		}
		return 0;
	}

}

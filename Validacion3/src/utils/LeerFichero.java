package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import models.Personas;

public class LeerFichero {

	public static ArrayList<Personas> personas = new ArrayList<Personas>();

	private static String titulo;
	private static String nombre;
	private static String apellidos;
	private static String telefono;
	private static String cp;
	private static String email;
	private static String url;
	private static String username;
	private static String password;
	private static String fecha;

	// Leo el fichero como argmento
	public static void leerFichero(String nombreFichero) throws Exception {
		File fichero = new File("files/" + nombreFichero);
		if (fichero.exists()) {
			try {

				BufferedReader br = new BufferedReader(new FileReader(fichero));
				br.readLine();
				String linea = br.readLine();

				while (linea != null) {

					// Campos de cada linea del fichero
					titulo = linea.split(",")[0];
					nombre = linea.split(",")[1];
					apellidos = linea.split(",")[2];
					telefono = linea.split(",")[3];
					cp = linea.split(",")[4];
					email = linea.split(",")[5];
					url = linea.split(",")[6];
					username = linea.split(",")[7];
					password = linea.split(",")[8];
					fecha = linea.split(",")[9];

					// Creo una nueva persona con los campos del fichero
					Personas nueva = new Personas(titulo, nombre, apellidos, telefono, cp, email, url, username,
							password, fecha);

					personas.add(nueva);
					linea = br.readLine();

				}
				br.close();
			} catch (FileNotFoundException e) {
				System.out.println("ERRO: NO SE PUEDO LEER EL FICHERO");
			}
		} else {
			System.out.println("ERROR: EL FICHERO NO EXISTE");
		}

	}

}

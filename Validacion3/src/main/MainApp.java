package main;

import models.Personas;
import utils.LeerFichero;
import validaciones.Validacion;

public class MainApp {

	public static void main(String[] args) throws Exception {
		// Leo el fichero y añade las personas a la lista
		LeerFichero.leerFichero(args[0]);

		// Lista de personas del fichero
		for (Personas persona : LeerFichero.personas) {

			Validacion.titulo(persona.getTitulo());
			Validacion.nombre(persona.getNombre());
			Validacion.apellidos(persona.getApellidos());
			Validacion.telefono(persona.getTelefono());
			Validacion.codigoPostal(persona.getCp());
			Validacion.email(persona.getEmail());
			Validacion.url(persona.getUrl());
			System.out.println(persona.toString());
		
		}

	}

}

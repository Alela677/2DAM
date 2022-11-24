package Utils;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import java.sql.SQLException;

import java.util.ArrayList;

import org.hibernate.Session;

import Models.SuperUsuario;

public class Funciones {

	// Funci�n para crear las tablas e insertar los datos.
	public static void crearTablaSuperusuarios(String nombreFichero) throws SQLException {
		
		// Creamos la sesion que se conecta con la base de datos
		Session sesion = HibernateUtil.getSession();

		// Iniciamos la trasaccion de datos
		sesion.getTransaction().begin();
		try {
			// Declaro un ArrayList y llamo a la funci�n para leer el fichero.
			ArrayList<String> datos = new ArrayList<String>();
			datos = leerFicheros(nombreFichero);

			// Recorro el ArrayList y voy a�adiendo los datos a la base de datos.
			for (int i = 0; i < datos.size(); i++) {
				String fila[] = datos.get(i).split(",");
				// Creamos objetos SuperUsuarios con los campod obtenidos del fichero
				SuperUsuario nuevo = new SuperUsuario(fila[0], fila[1], "2DAM" + fila[0].charAt(0) + fila[1].charAt(1));
				
				// Realizamos el insert de cada objeto creado 
				sesion.save(nuevo);
			}
			// Si todo esta bien mostrara ok 
			System.out.println("Todo ok");
			// Punto ce control de la transaccion realiza un commit 
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// Si algo sale mal mostrara el mensaje de error y realizara un rollback al ultimo punto de control
			System.out.println("Ocurrio algun error");
			sesion.getTransaction().rollback();
		}

	}

	// Leer fichero y pasarlo a un ArrayList.
	public static ArrayList<String> leerFicheros(String archivo) throws IOException {
		ArrayList<String> listado = new ArrayList<String>();

		try {
			// Leo el archivo.
			BufferedReader lector = new BufferedReader(new FileReader(archivo));

			// Leo las l�neas del fichero y los a�ado al arrayList.
			String linea = lector.readLine();

			while (linea != null) {
				listado.add(linea);
				linea = lector.readLine();
			}

			lector.close();
		} catch (Exception e) {
			System.out.println("El fichero no existe");
		}
		return listado;
	}

}

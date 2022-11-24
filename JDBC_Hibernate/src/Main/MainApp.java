package Main;


import java.sql.SQLException;

import Utils.Funciones;

public class MainApp {

	public static void main(String[] args) {
		
		
		// Main que ejecuta el metodo superusuario 
		try {
			Funciones.crearTablaSuperusuarios("Alumnado_nuevo.txt");
		} catch (SQLException e) {

			System.out.println("ERROR:");  
			e.printStackTrace();
		}
	}
}

package Threads;

import BufferImage.BufferedImage;

public class ThreadImagenes extends Thread {

	private String nombreImagen;

	// Contructor
	public ThreadImagenes(String nombreImg) {
		this.nombreImagen = nombreImg;
	}

	@Override
	public void run() {

		try {
			// Ejecuta la clase BufferedImage con el metodo que redimensiona las imagenes
			BufferedImage.imagen(nombreImagen);

		} catch (Exception e) {
			System.out.println("ERROR: EL HILO CON LA IMAGEN NO SE PUEDO EJECUTAR");

		}
	}

}

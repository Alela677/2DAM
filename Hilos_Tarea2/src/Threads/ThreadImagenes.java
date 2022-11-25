package Threads;

import WatchService.BufferedImage;

public class ThreadImagenes extends Thread {

	private String nombreImagen;

	public ThreadImagenes(String nombreImg) {
		this.nombreImagen = nombreImg;
	}
	@Override
	public void run() {

		try {

			BufferedImage.imagen(nombreImagen);

		} catch (Exception e) {
			System.out.println("ERROR: EL HILO CON LA IMAGEN NO SE PUEDO EJECUTAR");

		}
	}

	public String getNombreImagen() {
		return nombreImagen;
	}

}

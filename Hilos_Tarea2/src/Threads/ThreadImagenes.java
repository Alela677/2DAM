package Threads;

import WatchService.BufferedImage;

public class ThreadImagenes extends Thread {

	private String nombreImagen;
	private String nombreHilo;
	
	public ThreadImagenes(String nombreImg, String nombreHilo) {
		this.nombreImagen = nombreImg;
		this.nombreHilo =  nombreHilo;
	}

	@Override
	public void run() {
		
		try {
			
			BufferedImage.imagen(nombreImagen);
			System.out.println(nombreHilo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
	}

	public String getNombreImagen() {
		return nombreImagen;
	}

	public String getNombreHilo() {
		return nombreHilo;
	}

}

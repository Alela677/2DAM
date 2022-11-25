package WatchService;


import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Properties.FicheroPropiedades;

public class BufferedImage {

	private static int WMAXIMO = FicheroPropiedades.getWMaximo();
	private static int HMAXIMO = FicheroPropiedades.getHaximo();
	private static String extension;
	private static File img;
	private static String nombreGuadar;
	
	
	public static void imagen(String nombreImagen) {
		nombreGuadar = nombreImagen;
		java.awt.image.BufferedImage imagenOutput = null;
		java.awt.image.BufferedImage imagenInput = leerImagen(nombreImagen);
		
		int width = imagenInput.getWidth();
		int heigth = imagenInput.getHeight();
		
		
		
		
		imagenOutput = dibujarImagen(imagenInput, 300, 300);
		guardar(imagenOutput);
		
		
		
		
		

	}
	
	
	
	

	private static  java.awt.image.BufferedImage leerImagen(String imagen) {
		img = new File(FicheroPropiedades.getEntrada() + "/" + imagen);
		extension = imagen.split("\\.")[1];
		java.awt.image.BufferedImage bfInput = null;
		try {
			 bfInput =ImageIO.read(img);
		} catch (IOException e) {
			System.out.println("ERROR: NO SE PUDO LEER LA IMAGEN");
			
		}
		return bfInput;
	}


	
	private static java.awt.image.BufferedImage dibujarImagen(java.awt.image.BufferedImage imagenIn,int maxHeight,int maxWidth){
		
		java.awt.image.BufferedImage imagenOutput = new java.awt.image.BufferedImage(maxWidth, maxHeight, imagenIn.getType());
		
		
		Graphics2D g2d = imagenOutput.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.drawImage(imagenIn, 0, 0, maxWidth,maxHeight,null);
		g2d.dispose();

		return imagenOutput;
		
	}

	
	private static void guardar(java.awt.image.BufferedImage imagenGuardar) {
		
		File destino = new File(FicheroPropiedades.getSalida() + "/" + nombreGuadar);

		try {
			ImageIO.write(imagenGuardar, extension, destino);
		} catch (IOException e) {
			System.out.println("ERRO NO PUEDO ESCRIBIR LA IMAGEN");
		}

		img.delete();
	}
	
}

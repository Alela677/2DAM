package BufferImage;

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
		int heigt = imagenInput.getHeight();

		if (WMAXIMO == 0) {
			WMAXIMO = 100;
		} else if (HMAXIMO == 0) {
			HMAXIMO = 100;
		}

		if (width <= FicheroPropiedades.getWMaximo() && heigt <= FicheroPropiedades.getHaximo()) {

			imagenOutput = dibujarImagen(imagenInput, heigt, width);
			guardar(imagenOutput);
		}

		if (heigt > width) {
			int nuevoHeigt = (heigt * WMAXIMO) / width;
			imagenOutput = dibujarImagen(imagenInput, WMAXIMO, nuevoHeigt);
			int nuevoWidth = (width * HMAXIMO) / heigt;
			imagenOutput = dibujarImagen(imagenInput, nuevoWidth, HMAXIMO);
		} else {
			int nuevoWidth = (width * HMAXIMO) / heigt;
			imagenOutput = dibujarImagen(imagenInput, nuevoWidth, HMAXIMO);
			int nuevoHeigt = (heigt * WMAXIMO) / width;
			imagenOutput = dibujarImagen(imagenInput, WMAXIMO, nuevoHeigt);
		}

		guardar(imagenOutput);
	}

	
	private static java.awt.image.BufferedImage leerImagen(String imagen) {
		img = new File(FicheroPropiedades.getEntrada() + "/" + imagen);
		extension = imagen.split("\\.")[1];

		if (!extension.equals("jpg")) {
			img.delete();
		}

		System.out.println(extension);
		java.awt.image.BufferedImage bfInput = null;
		try {
			Thread.sleep(500);
			bfInput = ImageIO.read(img);
		} catch (Exception e) {
			System.out.println("ERROR: NO SE PUDO LEER LA IMAGEN");

		}
		return bfInput;

	}

	
	private static java.awt.image.BufferedImage dibujarImagen(java.awt.image.BufferedImage imagenIn, int maxHeight,
			int maxWidth) {

		java.awt.image.BufferedImage imagenOutput = new java.awt.image.BufferedImage(maxWidth, maxHeight,
				imagenIn.getType());

		Graphics2D g2d = imagenOutput.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.drawImage(imagenIn, 0, 0, maxWidth, maxHeight, null);
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

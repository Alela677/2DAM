package WatchService;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Properties.FicheroPropiedades;

public class BufferedImage {
	
	private static int WMAXIMO = FicheroPropiedades.getWMaximo();
	private static int HMAXIMO = FicheroPropiedades.getHaximo();
	
	public static void imagen(String nombreImage)  {

		

		try {
			File img = new File(FicheroPropiedades.getEntrada() + "/" + nombreImage);
			System.out.println(nombreImage);
			String extension = nombreImage.split("\\.")[1];
			
			java.awt.image.BufferedImage bfInput = null;
			bfInput = ImageIO.read(img);
			int w = bfInput.getWidth();
			int h = bfInput.getHeight();
			java.awt.image.BufferedImage bfOutput = new java.awt.image.BufferedImage(300, 300, bfInput.getType());
			Graphics2D g2d = bfOutput.createGraphics();
			g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g2d.drawImage(bfInput, 0, 0, 300, 300,0,0,w,h,null);
			g2d.dispose();

			File destino = new File(
					"C:\\ProyectosEclipse\\Hilos_Tarea2\\" + FicheroPropiedades.getSalida() + "\\" + nombreImage);

			try {
				ImageIO.write(bfOutput, extension, destino);
			} catch (IOException e) {
				System.out.println("ERRO NO PUEDO ESCRIBIR LA IMAGEN");
			}
			img.delete();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR: NO PUEDO LEER LA IMAGEN");
		}

	}
}

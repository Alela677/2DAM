package WatchService;

import java.awt.Graphics2D;
import java.io.File;

import javax.imageio.ImageIO;

import Properties.FicheroPropiedades;

public class BufferedImage {

	public static void main(String[] args) throws Exception {
		imagen();
	}

	public static void imagen() throws Exception {

		File img = new File(FicheroPropiedades.getEntrada() + "/incondrawer.jpg");
		java.awt.image.BufferedImage bfInput = ImageIO.read(img);
		java.awt.image.BufferedImage bfOutput = new java.awt.image.BufferedImage(300, 300, bfInput.getType());

		System.out.println(bfInput.getHeight());
		System.out.println(bfInput.getWidth());

//		Graphics2D g2d = bfOutput.createGraphics();
//		g2d.drawImage(bfOutput, 0, 0, 300, 300,null);
//		g2d.dispose();
//		
		System.out.println(bfOutput.getHeight());
		System.out.println(bfOutput.getWidth());

		String name = "incondrawer.jpg";
		File destino = new File("C:\\ProyectosEclipse\\Hilos_Tarea2\\" + FicheroPropiedades.getSalida() + "\\" + name);

		ImageIO.write(bfOutput, "jpg", destino);

	}
}

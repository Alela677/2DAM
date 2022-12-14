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

	/**
	 * Metodo que lee una imagen que pasamos a travez del hilo observador Determina
	 * si hay que redimensionar la imagen en el caso que la imagen tenga un formato
	 * jpg y necesite ser redimensionada procesa la imagen y guarda la nueva imagen
	 * en la carpeta output eliminando la imagen original en la carpteta input que
	 * es la entrada de los ficheros, si el fichero que entra es algo diferente a
	 * una imagen con extension "jpg" lo eliminara sin ser procesado
	 * 
	 * @param nombreImagen
	 */
	public static void imagen(String nombreImagen) {

		nombreGuadar = nombreImagen;
		java.awt.image.BufferedImage imagenOutput = null;
		java.awt.image.BufferedImage imagenInput = leerImagen(nombreImagen);

		// Ancho y alto de la imagen leida
		int width = imagenInput.getWidth();
		int heigt = imagenInput.getHeight();

		// Si el fichero propiedades devuelve valores nulos se proporciona un valor por
		// defecto
		if (WMAXIMO == 0) {
			WMAXIMO = 100;
		} else if (HMAXIMO == 0) {
			HMAXIMO = 100;
		}

		// Si la imagen tiene dimensiones menores a las maximas se procesa sin modificar
		if (width <= FicheroPropiedades.getWMaximo() && heigt <= FicheroPropiedades.getHaximo()) {

			imagenOutput = dibujarImagen(imagenInput, heigt, width);
			guardar(imagenOutput);
		}
		
		// La imagen no se me renderiza bien he intentado por todo los medios que se haga bien pero no lo he conseguido 
		// si encuentras que es lo que esta mal escribemelo en un comentario
		
		
		// Determina si hay que redimensionar la imagen si es necesario procesa la
		// imagen leida y la guarda en la carpeta output
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
	

	/**
	 * Lee una imagen y sacamos la extension de fichero si es distinto a jpg se
	 * elimina de lo contrario leera la imagen
	 * 
	 * @param imagen
	 * @return imagen leida
	 */
	private static java.awt.image.BufferedImage leerImagen(String imagen) {
		img = new File(FicheroPropiedades.getEntrada() + "/" + imagen);
		extension = imagen.split("\\.")[1];
		
		System.out.println(extension);
		if (!extension.equals("jpg")) {
			img.delete();
		} 
		
		java.awt.image.BufferedImage bfInput = null;
		try {
			
			// A veces lee la imagen antes de que se termine de cargar en la carpeta y suelta errores de lectura 
			// Usamos Thread.sleep para darle un tiempo al hilo y que se carge la imagen completa
			Thread.sleep(500);
			bfInput = ImageIO.read(img);
		} catch (Exception e) {
			System.out.println("ERROR: NO SE PUDO LEER LA IMAGEN");

		}
		return bfInput;

	}

	/**
	 * Dibuja un nueva imagen con las dimensiones nuevas de la imagen que hemos
	 * leido y la dibuja en otro bufferedimage que utilizamos como imagen de salida
	 * 
	 * @param imagenIn
	 * @param maxHeight
	 * @param maxWidth
	 * @return nueva imagen redimensionada
	 */
	private static java.awt.image.BufferedImage dibujarImagen(java.awt.image.BufferedImage imagenIn, int maxHeight,
			int maxWidth) {

		int width = imagenIn.getWidth();
		int heigth = imagenIn.getHeight();

		java.awt.image.BufferedImage imagenOutput = new java.awt.image.BufferedImage(maxWidth, maxHeight,
				imagenIn.getType());

		Graphics2D g2d = imagenOutput.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.drawImage(imagenIn, 0, 0, maxWidth, maxHeight, 0, 0, width, heigth, null);
		g2d.dispose();

		return imagenOutput;

	}

	/**
	 * Escribe la nueva imagen con el formato que tenia en en directorio que le
	 * indicamos y elimina la imgaen original
	 * 
	 * @param imagenGuardar
	 */
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

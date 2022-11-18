package Hilos;

import java.util.List;

public class HiloSuma implements Runnable {

	private long raizCuradra;
	private String nombreHilo;
	private long sumaTotal;
	private List<Integer> listaLeer;
	private int posIncial;
	private int posFinal;
	int numero;

	public HiloSuma(String nombre, List<Integer> listaleer, int posInicial, int posFinal) {
		super();
		this.nombreHilo = nombre;
		this.listaLeer = listaleer;
		this.posIncial = posInicial;
		this.posFinal = posFinal;
	}

	public static Thread crearHilo(String nombre, List<Integer> lista, int posIncial, int posFinal) {

		HiloSuma nuevoHilo = new HiloSuma(nombre, lista, posIncial, posFinal);
		Thread nuevoThread = new Thread(nuevoHilo);
		return nuevoThread;

	}

	@Override
	public void run() {

		for (int i = posIncial; i < posFinal; i++) {
			numero = listaLeer.get(i);
			raizCuradra = (long) Math.sqrt(numero);
			sumaTotal += raizCuradra;
		}

		System.out.println(nombreHilo + " " + sumaTotal);

	}

	public long getSumaTotal() {
		return sumaTotal;
	}

	

}

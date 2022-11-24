package es.florida.examen;

import java.util.ArrayList;

public class Proteina implements Runnable{

	static ArrayList<String> proteinas = new ArrayList<String>();
	String[] tipoProteinas = {"Alfa", "Beta", "Gamma"};
	int[] tiempo = {10, 20, 30};
	String proteina = "";
	int tmp;
	
	Proteina() {}

	synchronized public void estructuraMolecular(int indiceTipo, int indiceTiempo, String nombre) {
		proteina = tipoProteinas[indiceTipo];
		tmp = tiempo[indiceTiempo];
		proteinas.add(proteina);
		System.out.println(nombre + " de " + proteina + " ha sido agregada a la estructura molecular (tiempo que ha tardado la simulacion: " + tmp +")" );
		try {
			Thread.sleep(tmp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		int indiceTipo = (int) (Math.random() * 3);
		int indiceTiempo = (int) (Math.random() * 3);
		String nombre = Thread.currentThread().getName();
		estructuraMolecular(indiceTipo, indiceTiempo, nombre);
	}
}

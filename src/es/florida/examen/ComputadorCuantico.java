package es.florida.examen;

public class ComputadorCuantico {
	
	public static void lanzar(int numProteinas) {
		Proteina proteina;
		Thread hilo;
		
		for (int i = 1; i <= numProteinas; i++) {
			proteina = new Proteina();
			hilo = new Thread(proteina);
			hilo.setName("Proteina " + i);
			hilo.start();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Numero de proteinas en la lista: " + Proteina.proteinas.size());
	}

	public static void main(String[] args) {
		
		int numProteinas;
		if (args.length == 0) {
			numProteinas = 100;
		} else {
			numProteinas = Integer.parseInt(args[0]);			
		}
		
		lanzar(numProteinas);
	}

}

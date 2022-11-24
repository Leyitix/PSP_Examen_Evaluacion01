package es.florida.examen;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lanzadora {
	
	public static void lanzar(String proteinas) {
		String clase = "es.florida.examen.ComputadorCuantico";
		
		try {
			String javaHome = System.getProperty("java.home");
			String javaBin  = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			System.out.println(classpath);
			String className = clase;
			
			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);
			command.add(proteinas.toString());
			
			ProcessBuilder builder = new ProcessBuilder(command);
			Process process = builder.inheritIO().start();
			process.waitFor();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException {
		Scanner teclado01 = new Scanner(System.in);
		boolean lanzar = true;
		
		do {
			
			System.out.println("Introduce un número de proteinas que quieres simular:");
			int numeroProteinas = teclado01.nextInt();
			while (numeroProteinas % 3 != 0) {
				System.out.println("El número de proteinas debe de ser múltiplo de 3:");
				numeroProteinas = teclado01.nextInt();
			}
			String proteinas = String.valueOf(numeroProteinas);
			lanzar(proteinas);
			System.out.println("");
			System.err.println("PROCESO FINALIZADO!");
			lanzar = false;
			
			Scanner teclado02 = new Scanner(System.in);
			System.out.println("¿Quieres volver a lanzar la simulación (s/n)?");
			String volverALanzar = teclado02.nextLine();
			if (volverALanzar.equals("n")) {
				lanzar = false;
			} else if (volverALanzar.equals("s")) {
				lanzar = true;
			} 
			
		} while (lanzar != false);
		
		
		System.err.println("SIMULACIÓN FINALIZADA!");
		teclado01.close();
	}

}

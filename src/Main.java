import java.util.*;

public class Main {

	public static void main(String[] args) {
		Set<Particle> particles = new HashSet<Particle>();
		
		System.out.println("Reading files...");
		Input.readParticles("Dynamic100.txt", "Static100.txt", particles);
		
		System.out.println("Starting timer...");
		long valStart = System.currentTimeMillis();
		
		System.out.println("Creating grid...");
		Grid grid = new CircularGrid(Input.getL(),10,particles);
		
		System.out.println("Start simulation");
		//aca habria que pedir los datos para empezar la simulacion
		//public Simulation(Grid grid, double totalTime, double intervals, double Rc)
		//Lo de totalTime es el tiempo inicial, no?? KUYUM HEEEEEELP!
		
		Simulation s = new Simulation(grid, 1, 1, 8);

		long valEnd = System.currentTimeMillis();
		System.out.println("Stop timer");
		
		System.out.println("TOTAL TIME IN MILISECONDS: " + (valEnd-valStart));
		
	}
}

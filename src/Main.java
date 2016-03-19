import java.util.*;

public class Main {

	public static void main(String[] args) {
		Set<Particle> particles = new HashSet<Particle>();
		
		System.out.println("Reading files...");
		Input.readParticles("Dynamic100.txt", "Static100.txt", particles);
		
		System.out.println("Creating grid...");
		Grid grid = new CircularGrid(Input.getL(),10,particles);
		
		System.out.println("Start simulation");
		//aca habria que pedir los datos para empezar la simulacion
		Simulation s = new Simulation(grid, 1, 1, 8);
	}
}

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Set<Particle> particles = new HashSet<Particle>();
		InputNuevo.readParticles("Dynamic100.txt", "Static100.txt", particles);

		Grid grid = new CircularGrid(100,10,particles);
		
		Simulation s = new Simulation(grid, 1, 1, 8);
	}
}

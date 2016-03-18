import java.util.*;

public class Main {

	public static void main(String[] args) {
		Set<Particle> particles = new HashSet<Particle>();
		Input.readParticles("Dynamic100.txt", "Static100.txt", particles);
		
		Grid grid = new CircularGrid(Input.getL(),10,particles);
		
		Simulation s = new Simulation(grid, 0, 0, 8);
	}
}

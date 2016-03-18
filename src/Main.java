import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Particle p1 = new Particle(3.5, 5.7, 0, 2);
		Particle p2 = new Particle(3.5, 5.5, 0, 2);
		Particle p3 = new Particle(3.5, 7, 0, 2);
		Particle p4 = new Particle(1.7, 3.3, 0, 2);
		Particle p5 = new Particle(5, 7, 0, 2);
		Particle p6 = new Particle(5, 3.3, 0, 2);
		Particle p7 = new Particle(5, 5, 0, 2);
		Particle p8 = new Particle(1.7, 5, 0, 2);
		
	
		CircularGrid grid = new CircularGrid(10,1);
		
		grid.insertParticle(p1);
		grid.insertParticle(p2);
		grid.insertParticle(p3);
		grid.insertParticle(p4);
		grid.insertParticle(p5);
		grid.insertParticle(p6);
		grid.insertParticle(p7);
		grid.insertParticle(p8);
		
		
	}
	


}

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		Particle p1 = new Particle(1, 3.5, 5.7, 2, 2);
		Particle p2 = new Particle(1, 4.5, 6.7, 2, 2);
		Particle p3 = new Particle(1, 1.5, 1.7, 2, 2);
		Particle p4 = new Particle(1, 1.7, 3.7, 2, 2);
		
		Set<Particle> myParticles = new HashSet<>();
		
		myParticles.add(p1);
		myParticles.add(p2);
		myParticles.add(p3);
		myParticles.add(p4);
		
		Filtering f = new Filtering(8, 5);
		
		f.order(myParticles);
		
		System.out.println(f.getMap());

	}
	


}

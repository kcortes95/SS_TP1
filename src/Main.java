import java.util.*;

public class Main {

	public static void main(String[] args) {
		Set<Particle> particles = new HashSet<Particle>();
		
		//public static void generateRandomParticles(Set<Particle> particles, int N, double L)
		generateRandomParticles(particles, 50, 20);

		//timing(int totalRec, Set<Particle> particles, Double Rc, int L)
	
		timing(19,particles,1.0,20);
	}
	

	public static void timing(int totalRec, Set<Particle> particles, Double Rc, int L){ 
		
		if(totalRec<=0){
			throw new RuntimeException("M has to be positive");
		}
		
		if(L*1.0/totalRec<=Rc){
			
			throw new RuntimeException("No valid M for Cell Index Method. Remember L/M>Rc");
		}
		
		System.out.println("M - Miliseconds");
		
		for(int i=1;i<=totalRec;i++){
			long valStart = System.currentTimeMillis();
			
			Grid grid = new CircularGrid(L,i,particles);
			
			Simulation s = new Simulation(grid, 1, 1, Rc);
			s.run();
			
			long valEnd = System.currentTimeMillis();
			
			System.out.println(i + " - " + (valEnd-valStart));
		}
	}
	
	public static void generateRandomParticles(Set<Particle> particles, int N, double L){
		
		System.out.println("Generating " + N + " random particles, with L: " + L);
		
		for(int i=0; i<N; i++){
			particles.add(new Particle(Math.random(),1,Math.random()*L,Math.random()*L));
		}
	}
	
	/*
	//Esto es implementando los imputs que nos brinda la catedra
	System.out.println("Reading files...");
	Input.readParticles("Dynamic100.txt", "Static100.txt", particles);

	System.out.println("Starting timer...");
	long valStart = System.currentTimeMillis();

	System.out.println("Creating grid...");
	//public CircularGrid(double L, int M, Set<Particle> particles)
	Grid grid = new CircularGrid(Input.getL(),10,particles);
	
	System.out.println("Start simulation");
	//public Simulation(Grid grid, double totalTime, double intervals, double Rc)
	
	Simulation s = new Simulation(grid, 1, 1, 8);
	s.run();

	long valEnd = System.currentTimeMillis();
	System.out.println("Stop timer");
	
	System.out.println("TOTAL TIME IN MILISECONDS: " + (valEnd-valStart));
	
	*/
	
}

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Set<Particle> particles = new HashSet<Particle>();
		
		System.out.println("Reading files...");
		Input.readParticles("Dynamic100.txt", "Static100.txt", particles);
		
		for(int i=0; i<3000; i++){
			particles.add(new Particle(0.37,1,Math.random()*100,Math.random()*100));
		}
		
		System.out.println("Starting timer...");
		long valStart = System.currentTimeMillis();
		/*
		System.out.println("Creating grid...");
		//public CircularGrid(double L, int M, Set<Particle> particles)
		Grid grid = new CircularGrid(Input.getL(),10,particles);
		
		System.out.println("Start simulation");
		//aca habria que pedir los datos para empezar la simulacion
		//public Simulation(Grid grid, double totalTime, double intervals, double Rc)
		//Lo de totalTime es el tiempo inicial, no?? KUYUM HEEEEEELP!
		
		Simulation s = new Simulation(grid, 1, 1, 8);
		s.run();

		long valEnd = System.currentTimeMillis();
		System.out.println("Stop timer");
		
		System.out.println("TOTAL TIME IN MILISECONDS: " + (valEnd-valStart));
		
		*/
		timing(500,particles);
		
	}
	

	public static void timing(int totalRec, Set<Particle> particles){ //agregar Rc acá... y que despues lo llames en Simulation
		
		if(totalRec<=0){
			throw new RuntimeException("M has to be positive");
		}
		
		for(int i=1;i<=totalRec;i++){
			long valStart = System.currentTimeMillis();
			
			Grid grid = new CircularGrid(Input.getL(),i,particles);
			//lo de simulation esta reeeee hardcodeado... habria que pasar algo por parametro, tipo Rc
			Simulation s = new Simulation(grid, 1, 1, 8);
			s.run();
			long valEnd = System.currentTimeMillis();
			System.out.println("TOTAL TIME IN MILISECONDS IN " + i + " : " + (valEnd-valStart));
		}
		
	}
	
	
}

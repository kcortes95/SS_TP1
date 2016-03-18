import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Input {
	
	private static Scanner inputFile;
	private static List<Particle> myParticles = null;
	private static int N = 0;
	private static int L = 0;

	public static List<Particle> staticMethod(String path){
		myParticles = new ArrayList<>();
		
		try {
			inputFile = new Scanner(new File(path));
			N = inputFile.nextInt();
			L = inputFile.nextInt();
			
			while( inputFile.hasNextDouble() ){
				Random r = new Random();
				double randomX = L * r.nextDouble();
				double randomY = L * r.nextDouble();
				
				myParticles.add(new Particle(randomX, randomY, inputFile.nextDouble(), inputFile.nextDouble()));
			}
						
		} catch (FileNotFoundException e) {
			System.out.println("OOPS, no existe el archivo");
			e.printStackTrace();
		}
		return myParticles;
		
	}
	
	public static List<Particle> getMyParticles() {
		return myParticles;
	}
	
	public static int getL() {
		return L;
	}
	
	public static int getN() {
		return N;
	}

}

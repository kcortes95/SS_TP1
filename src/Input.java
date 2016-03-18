import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Input {
	
	private static Scanner inputFileStatic = null;
	private static Scanner inputFileDinamic = null;
	private static List<Particle> myParticles = null;
	private static int N = 0;
	private static int L = 0;

	public static List<Particle> createParticles(String pathStatic, String pathDinamic){
		myParticles = new ArrayList<>();
		
		try {
			inputFileStatic = new Scanner(new File(pathStatic));
			inputFileDinamic = new Scanner(new File(pathDinamic));
			N = inputFileStatic.nextInt();
			L = inputFileStatic.nextInt();
			
			while( inputFileStatic.hasNextDouble() ){
				Random r = new Random();
				double randomX = L * r.nextDouble();
				double randomY = L * r.nextDouble();
				
				myParticles.add(new Particle(randomX, randomY, inputFileStatic.nextDouble(), inputFileStatic.nextDouble()));
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

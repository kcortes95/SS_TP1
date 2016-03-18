import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Input {
	
	private static Scanner inputFileStatic = null;
	private static Scanner inputFileDinamic = null;
	private static List<Particle> myParticles = null;
	private static int N = 0;
	private static int L = 0;
	private static
	
	public static List<Particle> createParticles(String pathStatic, String pathDinamic){
		myParticles = new ArrayList<>();
		
		try {
			inputFileStatic = new Scanner(new File(pathStatic));
			inputFileDinamic = new Scanner(new File(pathDinamic));
			N = inputFileStatic.nextInt();
			L = inputFileStatic.nextInt();
			
			
			/*
			 * OJO por como se recorre... no se si esta bien!
			 */
			while( inputFileStatic.hasNextDouble() ){				
				myParticles.add(new Particle(inputFileStatic.nextDouble(), inputFileStatic.nextDouble()));
			}
			
			double timeCounter = 0;
			double posX,posY,vX,vY = 0;
			
			while( inputFileDinamic.hasNext() ){
				
				int counter = 0;
				int particleNumber = 0;
				
				timeCounter = inputFileDinamic.nextDouble();
				
				posX = inputFileDinamic.nextDouble();
				// inputFileDinamic.next(); //tengo que hacer esto o nextDouble ya me lo mueve???
				posY = inputFileDinamic.nextDouble();
				vX = inputFileDinamic.nextDouble();
				vY = inputFileDinamic.nextDouble();				
				
				
				
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

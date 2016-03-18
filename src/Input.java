import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class Input {
	
		private static int N = 0;
		private static double L = 0;
		
		public static void readParticles(String dFileName, String sFileName, Set<Particle> particles){
			
			File dFile = new File( dFileName );
			FileReader dFr = null;
			BufferedReader dBr = null;
			String dLine= null;
			String[] pos;
			
			File sFile = new File( sFileName );
			FileReader sFr = null;
			BufferedReader sBr = null;
			String sLine= null;
			String[] attr;
			
			try{
				dFr = new FileReader( dFile );
				dBr = new BufferedReader( dFr );
				dLine = dBr.readLine();
				
				sFr = new FileReader(sFile);
				sBr = new BufferedReader(sFr);
				sLine = sBr.readLine();
				N = Integer.parseInt(sLine); // ARREGLEN ESTO GILES
				sLine= sBr.readLine();
				L = Double.parseDouble(sLine);
				
				while( (dLine=dBr.readLine())!=null && (sLine=dBr.readLine())!=null){
					attr=sLine.split("\\s+");
					pos=dLine.split("\\s+");
					particles.add(new Particle(Double.parseDouble(attr[0]), Double.parseDouble(attr[1]), Double.parseDouble(pos[0]), Double.parseDouble(pos[1]), 0, 0));
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static int getN(){
			return N;
		}
		
		public static double getL() {
			return L;
		}
}
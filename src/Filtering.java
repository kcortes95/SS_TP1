import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Filtering {
	
	// private int totPart = 0; //N -> creo que no lo voy a usar en este momento porque el N me lo da el Set<Particulas>
	private double longitud = 0 ; //L
	private int totCells = 0; //M -> Matrix of M*M
	
	private Map<Integer,Set<Particle>> map = null;
	
	public Filtering( double L, int M) {
		//this.totPart = N;
		this.longitud = L;
		this.totCells = M;
		map = new HashMap<>();
	}
	
	public void sort(Set<Particle> particles){
		int cuadroX, cuadroY, cell ;
		Set<Particle> set ;
		for(Particle p : particles){
			cuadroX = (int) (Math.floor(p.getX()/(longitud/totCells)) + 1);
			cuadroY = (int) (Math.floor(p.getY()/(longitud/totCells)) + 1);
			cell = cuadroX + totCells*(cuadroY-1);
			
			if(!map.containsKey(cell)){
				set = new HashSet<>();
			}else{
				set = map.get(cell);
			}
			
			set.add(p);
			map.put(cell, set);		
		}
	}
	
	public Map<Integer, Set<Particle>> getMap() {
		return map;
	}
	
	public void search(){
		Set<Particle> set;
		for(int i=1;i<=Math.pow(totCells, 2);i++){
			if(map.containsKey(i)){
				set = map.get(i);
				System.out.println("CELDA: " + i + " - TOTAL: " + set.size());
				
				
			}
		}
	}
	
	

}

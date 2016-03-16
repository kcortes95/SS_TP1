import java.util.*;

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
				System.out.println("CELDA: " + i + " - TOTAL PARTICULAS: " + set.size());				
				
				//DESDE ACA HASTA DONDE ESTA MARCADO TIENE QUE ESTAR EN OTRO LADO
				List<Integer> vecinas = new ArrayList<>();

				if((i-totCells)>=1 && (i-totCells)<=25)
					vecinas.add(i-totCells);
				
				if((i-totCells+1)>=1 && (i-totCells+1)<=25)
					vecinas.add(i-totCells+1);
				
				if((i+1)>=1 && (i+1)<=25)
					vecinas.add(i+1);
				
				if((i+totCells)>=1 && (i+totCells)<=25)
					vecinas.add(i+totCells);

				System.out.println("VECINAS: " + vecinas.toString());
				//HASTA ACA DEBERIA SER OTRO METODO
				
				for(Integer vec : vecinas){
					map.get(vec);
					
				}
				
				
			}
		}
	}
	
	

}

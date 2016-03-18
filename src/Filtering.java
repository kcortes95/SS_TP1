import java.util.*;

public class Filtering {
	
	private double longitud = 0 ; //L
	private int totCells = 0; //M -> Matrix of M*M
	private int Rc = 0;
	private Map<Particle,Set<Particle>> condition = new HashMap<>();
	
	private Map<Integer,Set<Particle>> map = null;
	
	public Filtering( double L, int M, int Rc) {
		//this.totPart = N;
		this.longitud = L;
		this.totCells = M;
		this.Rc = Rc;
		map = new HashMap<>();
	}
	
	public void sort(Set<Particle> particles){
		int cuadroX, cuadroY, cell ;
		Set<Particle> set ;
		for(Particle p : particles){
			
			/*
			 * SOLUCIONAR ACA!!!
			 */
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
	
	public void searchNeighbours(){
		Set<Particle> set;
		for(int i=1;i<=Math.pow(totCells, 2);i++){
			if(map.containsKey(i)){
				set = map.get(i);
								
				List<Integer> vecinas = getNeighbouringCells(i);
				
				for(Integer neighbourCell : vecinas){
					Set<Particle> neighbourPart = map.get(neighbourCell);
					for(Particle p1: set){
						// Checks first for other particles in its same cell
						for(Particle paux: set){
							if(!p1.equals(paux)){
								if(getDistance(p1,paux)<=Rc){
									addToCondition(p1,paux);
								}
							}
						}
						
						// Then checks for particles in adjacent cells
						if(neighbourPart != null){
							for(Particle p2: neighbourPart){
								if(getDistance(p1,p2)<=Rc){
									addToCondition(p1,p2);
									addToCondition(p2,p1);
								}	
							}
						}
					}	
				}	
			}
		}
		
		Output.getInstace().write(condition);
	}
	
	private void addToCondition(Particle p1, Particle p2){
		if(!condition.containsKey(p1))
			condition.put(p1, new HashSet<Particle>());
		condition.get(p1).add(p2);
	}
	
	private List<Integer> getNeighbouringCells(Integer currentCell){
		List<Integer> vecinas = new ArrayList<Integer>();
		if((currentCell-totCells)>=1 && (currentCell-totCells)<=25)
			vecinas.add(currentCell-totCells);
		
		if((currentCell-totCells+1)>=1 && (currentCell-totCells+1)<=25)
			vecinas.add(currentCell-totCells+1);
		
		if((currentCell+1)>=1 && (currentCell+1)<=25)
			vecinas.add(currentCell+1);
		
		if((currentCell+totCells+1)>=1 && (currentCell+totCells+1)<=25)
			vecinas.add(currentCell+totCells+1);
		
		return vecinas;
	}
	
	public double getDistance(Particle p1, Particle p2){
		return Math.sqrt(Math.pow(p1.getX()-p2.getX(), 2) + Math.pow(p1.getY()-p2.getY(), 2))-p1.getRadio()-p2.getRadio();
	}
}



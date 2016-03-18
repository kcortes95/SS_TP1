import java.util.Set;


public abstract class Grid {
	
	private Cell[][] cells;
	private double L;
	private int M;
	
	public Grid(double L, int M, Set<Particle> particles){
		this.L = L;
		this.M = M;
		cells = new Cell[M][M];
		for(int i=0; i<M; i++){
			for(int j=0; j<M; j++){
				cells[i][j] = new Cell();
			}
		}
		insertParticles(particles);
		calculateNeighbours();
	}
	
	public abstract void calculateNeighbours();
	
	private void insertParticles(Set<Particle> particles){
		for(Particle p: particles){
			int x = (int) (Math.floor(p.getPosition().getX()/(L/M)) + 1);
			int y = (int) (Math.floor(p.getPosition().getY()/(L/M)) + 1);
			cells[x][y].getParticles().add(p);
		}
	}
	
	public Cell getCell(int x, int y){
		return cells[x][y];
	}
	
	public Cell[][] getGrid(){
		return cells;
	}
	
	public int getM(){
		return M;
	}
}

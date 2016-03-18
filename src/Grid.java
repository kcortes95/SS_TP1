
public abstract class Grid {
	
	private Cell[][] cells;
	private int L;
	private int M;
	
	public Grid(int L, int M){
		this.L = L;
		this.M = M;
		cells = new Cell[M][M];
		for(int i=0; i<M; i++){
			for(int j=0; j<M; j++){
				cells[i][j] = new Cell();
			}
		}
		calculateNeighbours();
	}
	
	public abstract void calculateNeighbours();
	
	public void insertParticle(Particle p){
		int x = (int) (Math.floor(p.getPosition().getX()/(L/M)) + 1);
		int y = (int) (Math.floor(p.getPosition().getY()/(L/M)) + 1);
		cells[x][y].getParticles().add(p);
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

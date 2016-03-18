import java.util.*;

public class Movement {

	private Map<Double,Position> movements = null;
	
	public Movement() {
		movements = new HashMap<>();
	}
	
	public void addMovement(double time, double x, double y){
		Position pos = new Position(x, y);
		movements.put(time, pos);
	}
	
	public Map<Double,Position> getMovements(){
		return movements;
	}
	
	
	
	
}

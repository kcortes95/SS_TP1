import java.util.*;

public class Movement {

	private Position velocity;
	private Map<Double,Position> movements = null;
	
	public Movement(double velx, double vely) {
		movements = new HashMap<>();
		velocity = new Position(velx,vely);
	}
	
	public void addMovement(double time, double x, double y){
		movements.put(time, new Position(x*velocity.getX(),y*velocity.getY())); // x el nuevo time
	}
	
	public Map<Double,Position> getMovements(){
		return movements;
	}
	
	
	
	
}

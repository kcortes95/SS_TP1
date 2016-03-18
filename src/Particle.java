import java.util.*;

public class Particle {
	
	private static int counter = 1;
	private int ID;
	private Movement movements = null;
	private double radio;
	private double color;
	
	public Particle(Movement movements, double radio, double color) {
		this.movements = movements;
		this.radio = radio;
		this.color = color;
		this.ID = counter++;
	}
	
	public Position getPosition(double time){
		return movements.getMovements().get(time);
	}
	
	public double getRadio() {
		return radio;
	}
	
	public void setColor(double color) {
		this.color = color;
	}
	
	public int getID(){
		return this.ID;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Particle)){
			return false;
		}else{
			Particle particleObj = (Particle) obj;
			return this.ID == particleObj.ID;
		}
	}
	
	public String toString(){
		return "" + ID;
	}
	
	
}


public class Particle {
	
	private static int counter = 1;
	private int ID;
	private double x;
	private double y;
	private double radio;
	private double color;
	
	public Particle(double x, double y, double radio, double color) {
		this.x = x;
		this.y = y;
		this.radio = radio;
		this.color = color;
		this.ID = counter++;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
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

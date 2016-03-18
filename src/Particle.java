import java.util.*;

public class Particle {
	
	/*
	 * Creo que la particula no deberia saber 
	 * como se mueve... Deberia tener solo informacion de su color y radio
	 * 
	 * Para ver donde esta la particula, habria que hacer un metodo 
	 * aparte que pase por parametro tiempo y la particula y me diga
	 * cual es la posicion. 
	 * Si quiero saber la distancia con otra particula deberia hacer lo mismo
	 * pero pasandole dos particulas por parametro.
	 * 
	 * El problema viene cuando tengo que abrir el archivo 
	 * Dinamic100 y por la forma en el que esta guardado.
	 */
	
	private static int counter = 1;
	private int ID;
	private Movement movements = null;
	private double radio;
	private double color;
	
	public Particle(double radio, double color) {
		this.movements = new Movement();
		this.radio = radio;
		this.color = color;
		this.ID = counter++;
	}
	
	public void addMovement(double tiempo, Position pos){
		movements.addMovement(tiempo, pos.getX(), pos.getY());
	}
	
	public Movement getMovement(){
		return movements;
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

package exercises;
import java.util.ArrayList;
public class Workout {

	//protected int sets;
	protected int reps;
	protected double weight;
	protected String name;
	
	public Workout(/*int sets,*/ int reps, double weight) {
		//this.sets = sets;
		this.reps = reps;
		this.weight = weight;
		//this.name = name.toUpperCase();
	}
	
	
	
	public String toString() {
		return this.reps + " reps of " + this.name + " @ " + this.weight + " lbs";
	}
	
	
	public double forceExerted() {
		return this.weight * this.reps;
	}
	

}

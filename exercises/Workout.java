package exercises;
import java.util.ArrayList;
public class Workout {

	
	protected int reps;
	protected double weight;
	protected String name;
	
	public Workout(int reps, double weight) {
		this.reps = reps;
		this.weight = weight;
		
	}
	
	
	
	public String toString() {
		return this.reps + " reps" +" @ " + this.weight + " lbs";
	}
	
	
	public void setName(String s) {
		this.name = s;
	}
	
	public double forceExerted() {
		return this.weight * this.reps;
	}
	
	public static void main(String[] args) {
		Workout test = new Workout(3, 135);
		test.setName("Bench Press");
		
	}

}

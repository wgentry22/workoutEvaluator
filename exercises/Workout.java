package exercises;

public class Workout {

	protected int sets;
	protected int reps;
	protected double weight;
	protected String name;
	
	public Workout(int sets, int reps, double weight, String name) {
		this.sets = sets;
		this.reps = reps;
		this.weight = weight;
		this.name = name.toUpperCase();
	}
	
	
	
	public String toString() {
		return this.sets + " sets of " + this.reps + " reps of " + this.name + " @ " + this.weight + " lbs";
	}
	
	public double forceExertedPerSet() {
		return this.weight * this.reps;
	}
	
	public double forceExerted() {
		return this.weight * this.sets * this.reps;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

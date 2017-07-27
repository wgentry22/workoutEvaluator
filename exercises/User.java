package exercises;
import java.util.ArrayList;
//import java.util.Scanner;

public class User {

	protected String userName;
	protected double userWeight;
	public ArrayList<Workout> userWorkout;
	
	public User(String userName, double userWeight) {
		this.userName = userName;
		this.userWeight = userWeight;
		this.userWorkout = new ArrayList<Workout>();
	}
	
	public String toString() {
		return this.userName + ": " + this.userWeight + " lbs";
	}
	
	public double percentOfBodyWeightLifted(Workout w) {
		return w.weight / this.userWeight;
	}
	
	public void workoutSummary() {
		System.out.println("Workout Summary:");
		for (int i = 0; i < this.userWorkout.size(); i++) {
			System.out.println("  - "+userWorkout.get(i));
		}
		System.out.println();
	}
	
	public void forceSummary() {
		double total = 0;
		System.out.println("Exertion Summary: ");
		for (int i = 0; i < this.userWorkout.size(); i++) {
			System.out.println("  -"+userWorkout.get(i).name + ": " + userWorkout.get(i).forceExerted() + " lbs");
			total += userWorkout.get(i).forceExerted();
		}
		System.out.println("\nFor a grand total of " + total + " lbs\n");
	}
	
	public void analyzeWorkout() {
		double total = 0;
		
		for (int i = 0; i < this.userWorkout.size(); i++) {
			total += userWorkout.get(i).forceExerted();
		}
		double analyze = total / this.userWeight;
		System.out.println("You exerted " + analyze + " times your body weight! great workout!");
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

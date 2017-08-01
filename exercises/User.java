package exercises;
import java.util.ArrayList;
//import java.util.Scanner;

public class User {

	protected String userName;
	protected int userWeight; //in pounds
	protected int userHeight; //in inches
	public ArrayList<Workout> userWorkout;
	
	public User(String userName, int userWeight, int userHeight) {
		this.userName = userName;
		this.userWeight = userWeight;
		this.userHeight = userHeight;
		this.userWorkout = new ArrayList<Workout>();
	}
	
	
	
	public String toString() {
		return this.userName + ": " + inchesToFeet(this.userHeight) + ", " + this.userWeight + " lbs";
	}
	
	public String inchesToFeet(int height) {
		int inches = height % 12;
		int feet = (height - inches) / 12;
		return feet + "'" + inches + "\"";
	}
	
	public double heightInMeters() {
		return (this.userHeight * 2.54) / 100;
	}
	
	public double weightInKg() {
		return this.userWeight * 0.45;
	}
	
	public double calculateBMI() {
		double heightSquared = this.userHeight * this.userHeight;
		return (this.userWeight / (heightSquared)) * 703; 
	}
	
	public double percentOfBodyWeightLifted(Workout w) {
		return w.weight / this.userWeight;
	}
	
	
	public void workoutSummary() {
		double percent;
		System.out.println("Workout Summary:");
		for (int i = 0; i < this.userWorkout.size(); i++) {
			percent = (this.userWorkout.get(i).weight / this.userWeight) * 100;
			System.out.print("  -"+userWorkout.get(i) + " (");
			System.out.printf("%.2f", percent);
			System.out.println("% of bodyweight)");
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
		System.out.printf("You exerted %.2f times your body weight!\n", analyze);
	}
	
	public void analyzeBMI() {
		double bmi = this.calculateBMI();
		String status;
		
		if (bmi <= 18.5) {
			status = "Underweight";
		} else if (bmi > 18.5 && bmi <=25) {
			status = "Healthy";
		} else if (bmi > 25 && bmi <= 30) {
			status = "Overweight";
		} else {
			status = "Obese";
		}
		System.out.printf("Calculated BMI: %.2f", bmi);
		System.out.println("(" + status + ")");
	}
	
	
	public void percentOfBodyWeight() {
		double percent;
		System.out.println("Percentage of Bodyweight used:");
		for (int i = 0; i < this.userWorkout.size(); i++) {
			percent = (this.userWorkout.get(i).weight / this.userWeight) * 100;
			System.out.print("  -"+this.userWorkout.get(i).name + ": ");
			System.out.printf("%.2f", percent);
			System.out.println("%");
			
		}
	}
}
	
	
	
	

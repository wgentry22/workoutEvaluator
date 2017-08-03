package exercises;
import java.util.ArrayList;
//import java.util.Scanner;

public class User {

	protected String userName;
	protected int userWeight; //in pounds
	protected int userHeight; //in inches
	public String userIntensity;
	public ArrayList<Workout> userWorkout;
	public ArrayList<ArrayList<Workout>> wkArr;
	
	public User(String userName, int userWeight, int userHeight) {
		this.userName = userName;
		this.userWeight = userWeight;
		this.userHeight = userHeight;
		this.userWorkout = new ArrayList<Workout>();
		this.wkArr = new ArrayList<ArrayList<Workout>>();
	}
	
	
	
	public String toString() {
		return this.userName + ": " + inchesToFeet(this.userHeight) + ", " + this.userWeight + " lbs";
	}
	
	public String printCeption() {
		String str = "";
		for (int i = 0; i < this.wkArr.size(); i++) {
			int k = 0;
			str += this.wkArr.get(i).get(k).name + ":\n";
			for (int j = k; j < this.wkArr.get(i).size(); j++) {
				str += "\t" + this.wkArr.get(i).get(j).reps + " @ " + this.wkArr.get(i).get(j).weight + " lbs " + percentOfBodyWeightLifted(this.wkArr.get(i).get(j)) + "\n";
			}
		}
		return str;
	}
	
	
	public void evaluateWorkout() {
		System.out.println("Analyzing workout.......\n\n\n\n\n");
		System.out.println("Workout Summary");
		System.out.println(this.printCeption());
		String percentSign = "%";
		
		double intensityScore = 0;
		int size = 0;
		for (int i = 0; i < this.wkArr.size(); i++) {
			for (int j = 0; j < this.wkArr.get(i).size(); j++) {
				intensityScore += (double) ((this.wkArr.get(i).get(j).weight / this.userWeight) * 100);
				size++;
			}
		}
		double finalScore = intensityScore / size;
		System.out.printf("Average Percentage of Body Weight used per Exercise Repetition: %.2f%s\n", finalScore, percentSign);
		System.out.println("For a total of " + size + " reps");
		String evaluatedIntensity;
		if (finalScore < 50) {
			evaluatedIntensity = "moderate";
		} else if (finalScore > 50 && finalScore < 100) {
			evaluatedIntensity = "intense";
		} else {
			evaluatedIntensity = "BEAST MODE";
		}
		
		
		System.out.println("\n\n" + this.userName + ", you thought your workout was " + this.userIntensity);
		if (evaluatedIntensity.equals(this.userIntensity)) {
			System.out.print("And we agree-- ");
			if (evaluatedIntensity.equals("moderate")) {
				System.out.println("moderate. You could stand to push more weight per exercise based on your body weight.");
			} else if (evaluatedIntensity.equals("intense")) {
				System.out.println("intense! You should be proud of yourself.");
			} else if (evaluatedIntensity.equals("BEAST MODE")) {
				System.out.println("BEAST MODE!!! You absolutely crushed this workout!!");
			}
		}
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
	
	public String percentOfBodyWeightLifted(Workout w) {
		double per =  (w.weight / this.userWeight) * 100;
		String percentSign = "%";
		return String.format("(%.2f%s of body weight per Repetition)", per, percentSign);
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
	
	
	
	

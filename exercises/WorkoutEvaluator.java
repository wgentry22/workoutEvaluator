package exercises;
import java.util.Scanner;
import java.util.ArrayList;

public class WorkoutEvaluator {

	
	public static User getUserInfo() {
		Scanner in = new Scanner(System.in);
		boolean incorrect;
		User user;
		
		do {
			System.out.println("What is your name?");
			String name = in.nextLine();
			//System.out.println("Thank you for using the Workout Evaluator, " + name);
			System.out.println("What is your weight? (lbs)");
			int weight = in.nextInt();
			System.out.println("What is your height? (inches)");
			int height = in.nextInt();
			user = new User(name, weight, height);
			System.out.println("Is the following information correct? Please enter Yes or No");
			System.out.println(user);
			String input = in.next();
			if (input.toLowerCase().equals("yes")) {
				incorrect = false;
				//in.close();
				
			} else if (input.toLowerCase().equals("no")) {
				incorrect = true;
			} else {
				System.out.println("Please enter yes or no.");
				incorrect = true;
			}
		} while (incorrect);
		
		user.userIntensity = WorkoutEvaluator.workoutIntensity();
		System.out.print(user.userIntensity + ", you say?");
		System.out.println("\nWe will be the judge of that.\n\n");
		return user;
	}
	
	public static String workoutIntensity() { //TODO: fix loop so it continues 
											  //for unexpected input
		boolean incorrect = true;
		String intensity = null;
		Scanner input = new Scanner(System.in);
		System.out.println("Would you rate your workout as moderate (1), intense (2), or BEAST MODE (3)?");
		do {
			
			if (input.hasNextInt()) {
				int n = input.nextInt();
				
				if (n == 1 || n == 2 || n == 3) {
					intensity = WorkoutEvaluator.intToIntensity(n);
					
					incorrect = false;
				}
			} else {
				System.out.println("Please select 1, 2, or 3");
				//incorrect = true;
			}
			
		} while(incorrect); 
		return intensity;
	}
	
	
	public static String intToIntensity(int n) {
		switch (n) {
		case 1: return "Moderate";
		case 2: return "Intense";
		case 3: return "BEAST MODE";
		default: return "invalid";
		}
	}
	
	public static ArrayList<ArrayList<Workout>> getWorkoutInfo() {
		//String intensity = WorkoutEvaluator.workoutIntensity();
		ArrayList<ArrayList<Workout>> wkArr = new ArrayList<ArrayList<Workout>>();
		Scanner in = new Scanner(System.in);
		Scanner in1 = new Scanner(System.in);
		
		
		System.out.println("How many exercises did you complete?");
		int numExercises = in.nextInt();
			for (int i = 0; i < numExercises; i++) {
				//int k = ++i;
				System.out.println("What was the name of Exercise " + (i + 1) + "?");
				if (i == 0) {
					in.nextLine();
				}
				String exName = in.nextLine();
				
				System.out.println("How many sets of " + exName + " did you perform?");
				int sets = in1.nextInt();
				wkArr.add(new ArrayList<Workout>());
					for (int j = 0; j < sets; j++) {
						//int l = ++j;
						System.out.println("Set " + (j + 1) + ": How many reps?");
						int reps = in1.nextInt();
						System.out.println("Performed at what weight?");
						double weight = in1.nextDouble();
						wkArr.get(i).add(new Workout(reps, weight));
						wkArr.get(i).get(j).setName(exName);
						if (j == wkArr.get(i).size() -1){
							System.out.println("\n");
						}
					}
			}
			return wkArr;
	}
	
	
	
	public static void program() {
		//System.out.println("Thank you for choosing the Workout Evaluator.");
		User user = WorkoutEvaluator.getUserInfo();
		user.wkArr = WorkoutEvaluator.getWorkoutInfo();
		user.evaluateWorkout();
	}
	
}

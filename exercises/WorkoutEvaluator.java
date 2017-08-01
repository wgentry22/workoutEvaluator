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
			System.out.println("Is the following information correct? Please enter yes or no");
			System.out.println(user);
			String input = in.next();
			if (input.toLowerCase().equals("yes")) {
				incorrect = false;
				//in.close();
				return user;
			} else if (input.toLowerCase().equals("no")) {
				incorrect = true;
			} else {
				System.out.println("Please enter yes or no.");
				incorrect = true;
			}
		} while (incorrect);
		
		return user;
	}
	
	public static String workoutIntensity() { //TODO: fix loop so it continues 
											  //for unexpected input
		boolean incorrect = true;;
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
	
	public static void getWorkoutInfo() {
		String intensity = WorkoutEvaluator.workoutIntensity();
		ArrayList<ArrayList<Workout>> wkArr = new ArrayList<ArrayList<Workout>>();
		Scanner in = new Scanner(System.in);
		
		
		
		System.out.print(intensity + ", you say?");
		System.out.println("\nWe will be the judge of that.\n\n");
		System.out.println("How many exercises did you complete?");
		int numExercises = in.nextInt();
			for (int i = 0; i < numExercises; i++) {
				int k = ++i;
				System.out.println("What was the name of Exercise " + k + "?");
				String exName = in.nextLine();
				in.nextLine();
				System.out.println("For how many sets?");
				int sets = in.nextInt();
				wkArr.add(new ArrayList<Workout>());
					for (int j = 0; j < sets; j++) {
						int l = ++j;
						System.out.println("Set " + l + ": How many reps?");
						int reps = in.nextInt();
						System.out.println("Performed at what weight?");
						double weight = in.nextDouble();
						wkArr.get(i).add(new Workout(reps, weight));
					}
			}
			//return wkArr;
	}
	
	public static void program() {
		//System.out.println("Thank you for choosing the Workout Evaluator.");
		User user = WorkoutEvaluator.getUserInfo();
		
		user.analyzeBMI();
		//user.percentOfBodyWeight();
		user.workoutSummary();
		user.forceSummary();
		user.analyzeWorkout();
		
		
	}
	
}

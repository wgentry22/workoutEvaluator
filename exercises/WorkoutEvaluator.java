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
			System.out.println("How much do you weigh?");
			double weight = in.nextDouble();
			user = new User(name, weight);
			System.out.println("Is the following information correct? Please enter yes or no");
			System.out.println(user);
			String input = in.next();
			if (input.equals("yes")) {
				incorrect = false;
				//in.close();
				return user;
			} else if (input.equals("no")) {
				incorrect = true;
			} else {
				System.out.println("Please enter yes or no.");
				incorrect = true;
			}
		} while (incorrect);
		
		return user;
	}
	
	public static ArrayList<Workout> getWorkoutInfo() {
		//Scanner in = new Scanner(System.in);
		ArrayList<Workout> userWorkout = new ArrayList<Workout>();
		boolean notDone;
		boolean errors;
		String isDone;
		
		do {
			Scanner in = new Scanner(System.in);
			System.out.println("What was the name of the workout?");
			String name = in.nextLine();
			System.out.println("For how many sets?");
			int sets = in.nextInt();
			System.out.println("For how many reps?");
			int reps = in.nextInt();
			System.out.println("At what weight did you perform " + name + "?");
			double weight = in.nextDouble();
			Workout temp = new Workout(sets, reps, weight, name);
			userWorkout.add(temp);
			do {
				System.out.println("Did you perform any other workouts? please enter yes or no");
				isDone = in.next();
				
	
				if (isDone.equals("yes")) {
					notDone = true;
					errors = false;
				} else if (isDone.equals("no")) {
					in.close();
					errors = false;
					notDone = false;
					
				} else {
					System.out.println("Please enter yes or no");
					errors = true;
					notDone = false;
				}
			} while(errors);
		} while (notDone);
		
		return userWorkout;
	}
	
	public static void program() {
		//System.out.println("Thank you for choosing the Workout Evaluator.");
		User user = WorkoutEvaluator.getUserInfo();
		user.userWorkout = WorkoutEvaluator.getWorkoutInfo();
		user.workoutSummary();
		user.forceSummary();
		user.analyzeWorkout();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//getWorkoutInfo();
	}

}

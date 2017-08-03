import exercises.*;

public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WorkoutEvaluator.program();
		
		User user = new User("Gtrain", 190, 74);
		user.userIntensity = WorkoutEvaluator.workoutIntensity();
		System.out.println(user.userIntensity);
	}

}

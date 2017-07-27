package exercises;

public enum CommonExercise {
	
	
	BENCH("BENCH PRESS", true),
	INBENCH("INCLINE BENCH PRESS", true),
	DEBENCH("DECLINE BENCH PRESS", true),
	SHPRESS("SHOULDER PRESS", true),
	ARPRESS("ARNOLD PRESS", true),
	SKULLCRUSHER("SKULLCRUSHERS", true),
	TRIEXT("TRICEP EXTENSIONS", true),
	CABLETRI("CABLE TRICEPS PRESS", true),
	SQUAT("SQUATS", true),
	FRONTSQUAT("FRONT SQUATS", true),
	LEGEXT("LEG EXTENSIONS", true),
	CALFPRESS("CALF PRESS", true),
	DBROW("DB ROWS", false), 
	HIROW("HIGH ROWS", false),
	BOR("BENT OVER ROWS", false),
	UR("UPRIGHT ROWS", false),
	DEADS("DEADLIFTS", false), 
	RDL("ROMANIAN DEADLIFTS", false),
	SHRUGS("SHRUGS", false),
	CURL("CURLS", false),
	HCURL("HAMMER CURLS", false),
	PULLUP("PULLUPS", false);
	
	private String name;
	private boolean force;
	
	
	private CommonExercise(String title, boolean isPush) {
		name = title;
		force = isPush;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean getForce() {
		return this.force;
	}
	
}

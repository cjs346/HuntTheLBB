public enum Direction {
	NORTH("n"), SOUTH("s"), EAST("e"), WEST("w");
	
	private String direction;
	Direction(String s){
		direction = s;
	}
	
	String getDirection() {
		return direction;
	}
}

public enum Commands {
	REST("r"), SHOOT_EAST("se"), SHOOT_NORTH("sn"), SHOOT_SOUTH("ss"), SHOOT_WEST("sw");
	
	private String command;
	Commands(String s){
		command = s;
	}
	String getCommand() {
		return command;
	}
}

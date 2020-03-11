import java.util.ArrayList;
import java.util.List;

public class Game {
    private int playerLocation = -1;
    private int wumpusLocation = -1;
    public boolean isGameOn;
    
    private List<String> messages = new ArrayList<>();
    private int playerArrows = 5;
    
    private Map map;
    private IMessenger messenger;
    
    public Game(Map map, IMessenger messenger) {
        this.map = map;
        this.messenger = messenger;
        this.isGameOn = true;
    }

    public void insertPlayer(int i) {
        playerLocation = i;
    }

    public void move(String direction) {
        int originalPlayerLocation = playerLocation;
        playerLocation = map.getDestination(playerLocation, direction);
        if (didYouMakeAnInvalidMove()) {
            playerLocation = originalPlayerLocation;
            messages.add("You cannot move in that direction, try moving again");
        }
        else if(didWumpusMurderYou()){
    		this.isGameOn = false;
    		messages.add("wumpus murdered you /ln");
    	}
    	else if(didYouFall()){	
    		this.isGameOn = false;
    		messages.add("You got yeeted into a pit /ln");
    	}
    }
    
    public void shootArrow(String direction) {
        playerArrows -= 1;
        int arrowLocation = playerLocation;
        int nextArrowLocation = map.getDestination(arrowLocation, direction);
        if (nextArrowLocation == -1) {
            isGameOn = false;
            messages.add("Your arrow bounced off a wall and killed you :(");
        }
        while (nextArrowLocation == -1) {
            arrowLocation = nextArrowLocation;
            if (arrowLocation == wumpusLocation) {
                isGameOn = false;
                messages.add("You shoot the wumpus !!!");
                return;
            }
            nextArrowLocation = map.getDestination(arrowLocation, direction);
        }
        messages.add("Your arrow missed :(");
    }

    public int getPlayerLocation() {
        return playerLocation;
    }

    public String EndTurn(){
    	if(youMurderedWumpus()) {
    		return messenger.reportWinMessage("reason");
    	}
    	else if (this.isGameOn){
        	messages.add("You have " + playerArrows + " arrows left. /ln");    	
    	}
    	return messages.toString();
    }
    
    private boolean didYouMakeAnInvalidMove() {
        return playerLocation == -1;
    }
    
    private boolean didWumpusMurderYou() {
		return playerLocation == wumpusLocation;
	}
    
    private boolean didYouFall() {
		return false;
	}


	private boolean youMurderedWumpus() {
    	return false;
    }
    
}

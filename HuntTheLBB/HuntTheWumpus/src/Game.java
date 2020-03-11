import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    
    public void readInputAndExecute(String input) {
    	messages = new ArrayList<String>();
    	for (Direction d : Direction.values()) {
    		if (d.getDirection().equals(input)){
    			move(input);
    			EndTurn();
    			return;
    		}
    	}
    	for (Commands c : Commands.values()) {
    		if (c.getCommand().equals(input)){
    			if (input.equals("r")) {
    				EndTurn();
    			}
    			else {
    				shootArrow(input.substring(1));
    				EndTurn();
    				return;
    			}
    		}
    	}
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
    		messages.add("wumpus murdered you.");
    	}
    	else if(didYouFall()){	
    		this.isGameOn = false;
    		messages.add("You got yeeted into a pit");
    	}
    }
    
    public void shootArrow(String direction) {
        playerArrows -= 1;
        int arrowLocation = playerLocation;
        int nextArrowLocation = map.getDestination(arrowLocation, direction);
        if (nextArrowLocation == -1) {
            isGameOn = false;
            messages.add("Your arrow bounced off a wall and killed you :(");
            return;
        }
        while (nextArrowLocation != -1) {
            arrowLocation = nextArrowLocation;
            if (arrowLocation == wumpusLocation) {
                isGameOn = false;
                messages.add("You shoot the wumpus !!!");
                return;
            }
            nextArrowLocation = map.getDestination(arrowLocation, direction);
        }
        messages.add("Your arrow missed :(");
        map.getCaverns().get(arrowLocation).setArrows(map.getCaverns().get(arrowLocation).getArrows() + 1);
    }

    public int getPlayerLocation() {
        return playerLocation;
    }

    public void EndTurn(){
    	if (this.isGameOn){ 
    		int arrows = map.getCaverns().get(playerLocation).getArrows();
        	if (arrows > 0) {
        		this.playerArrows += arrows;
        		messages.add("You picked up " + arrows + " arrows.");
        	}
        	messages.add("You have " + playerArrows + " arrows left."); 
        	for (Connection c: map.getConnections()) {
        		if (c.getFrom() == this.playerLocation) {
        			messages.add("You can move " + c.getDirection());
        		}
        	}
    	}
    }
   

    
    private boolean didYouMakeAnInvalidMove() {
        return playerLocation == -1;
    }
    
    private boolean didWumpusMurderYou() {
		return playerLocation == wumpusLocation;
	}
    
    private boolean didYouFall() {
		return map.getCaverns().get(playerLocation).HasPits();
	}


	private boolean youMurderedWumpus() {
    	return false;
    }
    
	public List<String> getMessages(){
		return this.messages;
	}
	
	public void displayMessages() {
		for (String s : this.messages) {
			System.out.println(s);
		}
	}
}

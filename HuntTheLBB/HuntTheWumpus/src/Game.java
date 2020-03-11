public class Game {
    private int playerLocation = -1;
    private int wumpusLocation = -1;
    public boolean isGameOn;
    
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
        playerLocation = map.getDestination(playerLocation, direction);
    }

    public int getPlayerLocation() {
        return playerLocation;
    }

    public String EndTurn(){
    	if(youMurderedWumpus()) {
    		return messenger.reportWinMessage("reason");
    	}
    	else if(didWumpusMurderYou()){
    		this.isGameOn = false;
    		return messenger.reportLossMessage("wumpus murdered you");
    	}
    	else if(didYouFall()){
    		this.isGameOn = false;
    		return messenger.reportLossMessage("You got yeeted into a pit");
    	}
    	else {
        	return messenger.reportArrows(playerArrows);    	
    	}
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

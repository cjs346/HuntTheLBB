public class Game {
    private int playerLocation = -1;
    private Map map;
    private IMessenger messenger;
    public Game(Map map, IMessenger messenger) {
        this.map = map;
        this.messenger = messenger;
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

    public void EndTurn(){

    }
}

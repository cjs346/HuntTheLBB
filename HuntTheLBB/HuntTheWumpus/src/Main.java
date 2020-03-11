import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	    MapGenerator mapGen = new MapGenerator();
	    Map map = mapGen.generateStaticMap();
	    Game game = new Game(map, new MessengerSpy());
	    game.insertPlayer(1);
	    while (game.isGameOn) {
	    	System.out.print("Enter a command: ");
	    	Scanner scanner = new Scanner(System.in);
	    	String inputString = scanner.nextLine();
	    	game.readInputAndExecute(inputString);
	    	game.displayMessages();
	    	
	    }
	}

}

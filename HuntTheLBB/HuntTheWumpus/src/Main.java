import java.util.Scanner;

public class Main {

	public Main() {
	    MapGenerator mapGen = new MapGenerator();
	    Map map = mapGen.generateStaticMap();
	    Game game = new Game(map, new MessengerSpy());
	    while (game.isGameOn) {
	    	System.out.print("Enter a command: ");
	    	Scanner scanner = new Scanner(System.in);
	    	String inputString = scanner.nextLine();
	    	
	    }
	}

}

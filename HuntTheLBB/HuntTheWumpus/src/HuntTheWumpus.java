import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;


public class HuntTheWumpus {

    @Test
    public void canMoveCavernToCavern() throws Exception{
        Map map = new MapGenerator().generateStaticMap();


        Game game = new Game(map, new MessengerSpy());
        game.insertPlayer(0);

        game.move(Direction.SOUTH);

        assertEquals(1, game.getPlayerLocation());
        game.move(Direction.EAST); 
        
        assertEquals(2, game.getPlayerLocation());
    }

    @Test
    public void testArrowMessage() {
        Map map = new Map(0);
        Game game = new Game(map, new MessengerSpy());

        assertEquals("[You have 5 arrows left. /ln]" ,game.EndTurn());
        assertTrue(game.isGameOn);	
        
    }
    
    @Test
    public void testPlayerDeath() {
    		
    	Map map = new MapGenerator().generateStaticMap();

        Game game = new Game(map, new MessengerSpy());
        
        game.move(Direction.REST);
        
        assertEquals("[wumpus murdered you /ln]" , game.EndTurn());
        assertFalse(game.isGameOn);	
        
    }
}

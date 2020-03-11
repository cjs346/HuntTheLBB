import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class HuntTheWumpus {

    @Test
    public void canMoveCavernToCavern() throws Exception{
        Map map = new Map();

        map.connect(1,2, Direction.EAST);

        Game game = new Game(map, new MessengerSpy());
        game.insertPlayer(1);
        game.move(Direction.EAST);

        assertEquals(2, game.getPlayerLocation());
        map.connect(2,3, Direction.NORTH);
        game.move(Direction.NORTH);
        assertEquals(3, game.getPlayerLocation());
    }

    @Test
    public void testArrowMessage() {
        Map map = new Map();
        Game game = new Game(map, new MessengerSpy());

        assertEquals("[You have 5 arrows left. /ln]" ,game.EndTurn());
        assertTrue(game.isGameOn);	
        
    }
    
    @Test
    public void testPlayerDeath() {
        Map map = new Map();
        map.connect(1,-1, Direction.EAST);
        
        Game game = new Game(map, new MessengerSpy());
        
        game.insertPlayer(1);
        game.move(Direction.EAST);
        
        assertEquals("[wumpus murdered you /ln]" , game.EndTurn());
        assertFalse(game.isGameOn);	
        
    }
}

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MapTest {

    MapGenerator mapGen = new MapGenerator();
    Map map = mapGen.generateStaticMap();
    Game game = new Game(map, new MessengerSpy());
    
    @Test
    public void CanQueryMap(){
        assertEquals(1, map.getDestination(0, Direction.SOUTH.getDirection()));
        assertEquals(3, map.getDestination(2, Direction.EAST.getDirection()));

    }
    
    @Test
    public void canMoveCavernToCavern() throws Exception{
        game.insertPlayer(2);
        game.readInputAndExecute(Direction.EAST.getDirection());

        assertEquals(3, game.getPlayerLocation());
        assertEquals("You have 5 arrows left." ,game.getMessages().get(0));
        assertTrue(game.isGameOn);	
    }
    
//    @Test
//    public void testPlayerDeath() {
//        Game game = new Game(map, new MessengerSpy());
//        
//        game.insertPlayer(1);
//        game.move(Direction.EAST);
//        
//        assertEquals("[wumpus murdered you /ln]" , game.EndTurn());
//        assertFalse(game.isGameOn);	
//        
//    }
    
}

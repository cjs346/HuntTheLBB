import org.junit.Test;

import static org.junit.Assert.assertEquals;


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


}

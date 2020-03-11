import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapTest {

    @Test
    public void CanQueryMap(){
        Map map = new Map();
        map.connect(1,2,Direction.EAST);
        assertEquals(2, map.getDestination(1, Direction.EAST));
        map.connect(2,3,Direction.NORTH);
        assertEquals(3, map.getDestination(2, Direction.NORTH));


    }
}

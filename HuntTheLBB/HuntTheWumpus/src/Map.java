import java.util.ArrayList;
import java.util.List;

public class Map {
    private List<Connection> connections = new ArrayList<>();
    public void connect(int first, int second, String direction){
        connections.add(new Connection(first, second, direction));
    }


    public int getDestination(int cavern, String direction) {
        for(Connection c : connections){
            if (c.from == cavern && direction == c.direction) {
                return c.to;
            }
        }
        return -1;
    }

    private class Connection{
        private final int from;
        private final int to;
        private final String direction;

        public Connection(int from, int to, String Direction){

            this.from = from;
            this.to = to;
            direction = Direction;
        }
    }
}

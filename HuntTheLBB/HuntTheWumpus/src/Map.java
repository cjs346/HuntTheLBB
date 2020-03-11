import java.util.ArrayList;
import java.util.List;

public class Map {
    private List<Connection> connections;
    private List<Cavern> caverns;
    private int totalCaverns;

    
    public Map(int totalCaverns) {
    		this.totalCaverns = totalCaverns;
    		connections = new ArrayList<>();
    		caverns = new ArrayList<>();
    }


    public int getDestination(int from, String direction) {
        for(Connection c : connections){
            if (c.getFrom() == from && direction.equals(c.getDirection())) {
                return c.getTo();
            }
        }
        return -1;
    }
    
    
    public List<Connection> getConnections() {
		return connections;
    }


	public void setConnections(List<Connection> connections) {
		this.connections = connections;
	}
    

	public List<Cavern> getCaverns() {
		return caverns;
	}


	public void setCaverns(List<Cavern> caverns) {
		this.caverns = caverns;
	}


	
}

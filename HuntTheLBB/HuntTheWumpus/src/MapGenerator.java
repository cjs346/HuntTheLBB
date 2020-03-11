import java.util.ArrayList;
import java.util.List;


public class MapGenerator {
	List<Connection> connections = new ArrayList<>();
	
	public Map generateStaticMap() {
		int totalCaverns = 13;		
		Map map = new Map(totalCaverns);
		List<Cavern> caverns = new ArrayList<>();
		
		for(int i = 0; i < totalCaverns; i++) {
			Cavern cavern = new Cavern(i);
			caverns.add(cavern);
		}
		
		caverns.get(4).setHasBats(true);
		caverns.get(7).setHasPits(true);
		caverns.get(12).setHasPits(true);
		
		connect(0, 1, Direction.SOUTH);
		connect(1, 2, Direction.EAST);
		connect(2, 3, Direction.EAST);
		connect(3, 4, Direction.EAST);
		connect(3, 5, Direction.SOUTH);
		connect(5, 6, Direction.SOUTH);
		connect(6, 7, Direction.SOUTH);
		connect(6, 8, Direction.EAST);
		connect(8, 9, Direction.EAST);
		connect(6, 10, Direction.WEST);
		connect(10, 11, Direction.WEST);
		connect(11, 12, Direction.NORTH);
		
		connect(1, 0, Direction.NORTH);
		connect(2, 1, Direction.WEST);
		connect(3, 2, Direction.WEST);
		connect(4, 3, Direction.WEST);
		connect(5, 3, Direction.NORTH);
		connect(6, 5, Direction.NORTH);
		connect(7, 6, Direction.NORTH);
		connect(8, 6, Direction.WEST);
		connect(9, 8, Direction.WEST);
		connect(10, 6, Direction.EAST);
		connect(11, 10, Direction.EAST);
		connect(12, 11, Direction.SOUTH);
		
		map.setCaverns(caverns);
		map.setConnections(connections);
		
		return map;
	}
	
	/*
	public Map generateDynamicMap(int totalCaverns, int totalBats, int Pits) {
		int totalCaverns = 13;		
		Map map = new Map(totalCaverns);
		List<Cavern> caverns = new ArrayList<>();
		
		for(int i = 0; i < totalCaverns; i++) {
			Cavern cavern = new Cavern(i);
			caverns.add(cavern);
		}
		
		caverns.get(4).setHasBats(true);
		caverns.get(7).setHasPits(true);
		caverns.get(12).setHasPits(true);
		
		connect(0, 1, Direction.SOUTH);
		connect(1, 2, Direction.EAST);
		connect(2, 3, Direction.EAST);
		connect(3, 4, Direction.EAST);
		connect(3, 5, Direction.SOUTH);
		connect(5, 6, Direction.SOUTH);
		connect(6, 7, Direction.SOUTH);
		connect(6, 8, Direction.EAST);
		connect(8, 9, Direction.EAST);
		connect(6, 10, Direction.WEST);
		connect(10, 11, Direction.WEST);
		connect(11, 12, Direction.NORTH);
		
		connect(1, 0, Direction.NORTH);
		connect(2, 1, Direction.WEST);
		connect(3, 2, Direction.WEST);
		connect(4, 3, Direction.WEST);
		connect(5, 3, Direction.NORTH);
		connect(6, 5, Direction.NORTH);
		connect(7, 6, Direction.NORTH);
		connect(8, 6, Direction.WEST);
		connect(9, 8, Direction.WEST);
		connect(10, 6, Direction.EAST);
		connect(11, 10, Direction.EAST);
		connect(12, 11, Direction.SOUTH);
		
		map.setCaverns(caverns);
		map.setConnections(connections);
		
		return map;
	}
	*/
	
	
	
	public void connect(int first, int second, String direction){
        connections.add(new Connection(first, second, direction));
    }

}

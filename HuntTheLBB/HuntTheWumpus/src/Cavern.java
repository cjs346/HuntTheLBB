public class Cavern {
	private int id = -1;
	private boolean hasPits;
	private boolean hasBats;
	private int arrows;
	
	public Cavern(int id) {
		this.id = id;
	}
		
	public int getId() {
		return id;
	}
	

	public boolean HasPits() {
		return hasPits;
	}
	
	public void setHasPits(boolean hasPits) {
		this.hasPits = hasPits;
	}
	
	public boolean HasBats() {
		return hasBats;
	}
	
	public void setHasBats(boolean hasBats) {
		this.hasBats = hasBats;
	}

	public int getArrows() {
		return arrows;
	}

	public void setArrows(int arrows) {
		this.arrows = arrows;
	}
	
	


}

import java.util.List;

public class Connection{
        private final int from;
        private final int to;
        private final String direction;

        public Connection(int from, int to, String Direction){

            this.from = from;
            this.to = to;
            direction = Direction;
        }

		public int getFrom() {
			return from;
		}

		public int getTo() {
			return to;
		}

		public String getDirection() {
			return direction;
		}
        
        

    }

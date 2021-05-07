package zadacha23;

   import java.awt.Color;

	class Ball implements Comparable<Ball> {
		int x = 0;
		int y = 0; // Current ball position
		int dx = 2; // Increment on ball's x-coordinate
		int dy = 2; // Increment on ball's y-coordinate
		int radius = (int) (Math.random() * 19) + 2; //mejdu 2 i 20
		
		//PiorityQ sorts only the first element
		
		Color color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
		@Override
		public int compareTo(Ball arg0) {
			// TODO Auto-generated method stub
			if (radius - arg0.radius > 0) {
				return 1;
			} else if (radius - arg0.radius < 0) {
				return -1;
			}
			return 0;
		}
	
	
	
	}


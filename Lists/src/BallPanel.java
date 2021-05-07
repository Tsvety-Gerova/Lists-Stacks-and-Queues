
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.Timer;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.JPanel;

class BallPanel extends JPanel {
	private int delay = 10;
	private ArrayList<Ball> list = new ArrayList<Ball>();
// Create a timer with the initial delay
	protected Timer timer = new Timer(delay, new TimerListener());

	private class TimerListener implements ActionListener {
		@Override /** Handle the action event */
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}

	public BallPanel() {
		timer.start();
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();  // getting the coordinates of the clicked point
				int y = e.getY();
				
				// checks if any ball is being clicked
					for (int j = 0; j < list.size(); j ++) {
						Ball nextBall = (Ball) list.get(j);
		
						double distance = BallPanel.distance(
								x, y, nextBall.x, nextBall.y);
						
						//to remove a ball by clicking
						//we compare the radius of the ball and
						//the distance between the clicked point and the radius	
						
						if ( nextBall.radius >= distance) {
							list.remove(nextBall);// can remove while its running thanx to the break
							break;
						}
					}
				}
			

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	public void add() {
		list.add(new Ball());
	}

	public void subtract() {
		if (list.size() > 0)
			list.remove(list.size() - 1); // Remove the last ball
	}

	@Override
	protected void paintComponent(Graphics g) { // paint the balls
		super.paintComponent(g);
		for (int i = 0; i < list.size(); i++) {
			Ball ball = (Ball) list.get(i); // Get a ball
			g.setColor(ball.color); // Set ball color
			// Check boundaries
			if (ball.x < 0 || ball.x > getWidth())
				ball.dx = -ball.dx;
			if (ball.y < 0 || ball.y > getHeight())
				ball.dy = -ball.dy;
			// Adjust ball position
			ball.x += ball.dx;
			ball.y += ball.dy;
			g.fillOval(ball.x - ball.radius, ball.y - ball.radius, ball.radius * 2, ball.radius * 2);
		}
		
		//to remove a ball by clicking
		//we compare the radius of the ball and
		//the distance between the clicked point and the radius	
		
		ArrayList<Ball> ballsToRemove = new ArrayList<>(); // saves all balls that will be removed later   
		for (int i = 0; i < list.size(); i ++) {   // all balls          
			Ball ball = (Ball) list.get(i);						
			for (int j = i + 1; j < list.size(); j ++) { // all balls after the current one
				Ball nextBall = (Ball) list.get(j);
				int radiusSum = ball.radius + nextBall.radius;
				double distance = BallPanel.distance(    // the distance betw two balls 
						ball.x, ball.y, nextBall.x, nextBall.y);
				
				if ( radiusSum >= distance) {
					ballsToRemove.add(nextBall);
					ball.radius += nextBall.radius;
				}
			}
			
		} // we can't remove an element while we're going through an array list
		// instead we save all the balls that must be removed into a list
		// and then remove them at the end
		
		
		list.removeAll(ballsToRemove);
		
	}
		
		public static double distance (int x1, int y1, int x2, int y2) { // dist betw 2 points
		return Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) // with Pythagorean Th
				+ Math.pow(Math.abs(y1 - y2), 2));
	}

	public void suspend() {
		timer.stop();
	}

	public void resume() {
		timer.start();
	}

	public void setDelay(int delay) {
		this.delay = delay;
		timer.setDelay(delay);
	}
}

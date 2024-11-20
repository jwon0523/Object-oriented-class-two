package task11;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;

public class GameScreen extends JComponent {
	private Unit player1, player2;
	
	public GameScreen() {
		this.player1 = new Unit(Color.blue, 400, 200);
		this.player2 = new Unit(Color.red, 50, 200);
		
		this.setFocusable(true);
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				switch(key) {
				case KeyEvent.VK_RIGHT:
					player1.isMovingRight = true;
					break;
				case KeyEvent.VK_LEFT:
					player1.isMovingLeft = true;
					break;
				case KeyEvent.VK_D:
					player2.isMovingRight = true;
					break;
				case KeyEvent.VK_A:
					player2.isMovingLeft = true;
					break;
				}
				
				moveUnits();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
				switch(key) {
				case KeyEvent.VK_RIGHT:
					player1.isMovingRight = false;
					break;
				case KeyEvent.VK_LEFT:
					player1.isMovingLeft = false;
					break;
				case KeyEvent.VK_D:
					player2.isMovingRight = false;
					break;
				case KeyEvent.VK_A:
					player2.isMovingLeft = false;
					break;
				}
				
			}
		});
	}
	
	public void moveUnits() {
		player1.move();
		player2.move();
		this.repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		player1.draw(g);
		player2.draw(g);
	}
}

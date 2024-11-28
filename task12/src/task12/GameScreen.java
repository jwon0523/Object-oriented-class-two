package task12;

import java.awt.Color;
import java.util.Random;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;

public class GameScreen extends JComponent {
	static final int FRAME_WIDTH = 500; 
	static final int FRAME_HEIGHT = 500; 
	private Unit player1, player2;
	private Thread moveThread;
	private Random random = new Random();
	
	public GameScreen() {
		this.addPlayer(1);
		this.addPlayer(2);
		this.setFocusable(true);
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				switch(key) {
				case KeyEvent.VK_RIGHT:
					player1.startMoving(Unit.RIGHT);
					break;
				case KeyEvent.VK_LEFT:
					player1.startMoving(Unit.LEFT);
					break;
				case KeyEvent.VK_UP:
					player1.startMoving(Unit.UP);
					break;
				case KeyEvent.VK_DOWN:
					player1.startMoving(Unit.DOWN);
					break;
				case KeyEvent.VK_D:
					player2.startMoving(Unit.RIGHT);
					break;
				case KeyEvent.VK_A:
					player2.startMoving(Unit.LEFT);
					break;
				case KeyEvent.VK_W:
					player2.startMoving(Unit.UP);
					break;
				case KeyEvent.VK_S:
					player2.startMoving(Unit.DOWN);
					break;
				case KeyEvent.VK_Q:
					player1.stopMoving();
					player2.stopMoving();
					break;
				}
				
				moveUnits();
			}

		});
	}
	
	void addPlayer(int id) {
		int x = random.nextInt(GameScreen.FRAME_WIDTH - Unit.UNIT_SIZE);
		int y = random.nextInt(GameScreen.FRAME_HEIGHT - Unit.UNIT_SIZE);
		
		if(id == 1) {
			this.player1 = new Unit(Color.blue, x, y);
		} else if(id == 2) {
			this.player2 = new Unit(Color.red, x, y);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		player1.draw(g);
		player2.draw(g);
	}
	
	public void start() {
		moveThread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(moveThread == Thread.currentThread()) {
					moveUnits();
					
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
//						e.printStackTrace();
					}
				}
			}
			
		});
		moveThread.start();
		this.requestFocus();
	}
	
	public void moveUnits() {
		player1.move();
		player2.move();
		
		if(checkCollision(player1, player2)) {
			player1.stopMoving();
			player2.stopMoving();
			
			player1.moveBack();
			player2.moveBack();
		}
		this.repaint();
	}
	
	public boolean checkCollision(Unit player1, Unit player2) {
		return player1.getX() < player2.getX() + Unit.UNIT_SIZE
				&& player1.getX() + Unit.UNIT_SIZE > player2.getX()
				&& player1.getY() < player2.getY() + Unit.UNIT_SIZE
				&& player1.getY() + Unit.UNIT_SIZE > player2.getY();
	}
	
	public void stop() {
		moveThread = null;
	}
	
}

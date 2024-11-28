package task12;

import java.awt.Color;
import java.awt.Graphics;

public class Unit {
	static final int UNIT_SIZE = 50;
	static final int MOVE_DISTANCE = 10;
	static final int LEFT = 1;
	static final int RIGHT = 2; 
	static final int UP = 3;
	static final int DOWN = 4;
	
	int x, y, xDirection, yDirection;
	Color color;
	
	public Unit(Color color, int x, int y) {
		this.color = color;
		this.x = x;
		this.y = y;
	}
	
	void draw(Graphics g) {
		g.setColor(this.color);
		g.fillRect(this.x, this.y, Unit.UNIT_SIZE, Unit.UNIT_SIZE);
	}
	
	void move() {
		x += xDirection * MOVE_DISTANCE;
		y += yDirection * MOVE_DISTANCE;
		
		checkBounds();
	}
	
	void startMoving(int direction) {
		stopMoving();
		
		switch(direction) {
		case LEFT:
			xDirection = -1;
			break;
		case RIGHT:
			xDirection = 1;
			break;
		case UP:
			yDirection = -1;
			break;
		case DOWN:
			yDirection = 1;
			break;
		}
	}
	
	void stopMoving() {
		xDirection = 0;
		yDirection = 0;
	}
	
	void moveBack() {
		x -= xDirection * MOVE_DISTANCE;
		y -= yDirection * MOVE_DISTANCE;
	}
	
	private void checkBounds() {
		if(x <0 || x + UNIT_SIZE > GameScreen.FRAME_WIDTH) {
			xDirection *= -1;
		}
		if(y < 0 || y + UNIT_SIZE > GameScreen.FRAME_HEIGHT) {
			yDirection *= -1;
		}
	}
	
	int getX() {
		return x;
	}
	
	int getY() {
		return y;
	}
	
}

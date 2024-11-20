package task11;

import java.awt.Color;
import java.awt.Graphics;

public class Unit {
	static final int UNIT_SIZE = 50;
	static final int MOVE_DISTANCE = 10;
	
	int x, y;
	Color color;
	boolean isMovingRight, isMovingLeft;
	
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
		if(isMovingRight && x < 450) {
			this.x += Unit.MOVE_DISTANCE;
		} 
		if(isMovingLeft && x > 0) {
			this.x -= Unit.MOVE_DISTANCE;
		}
	}
	
}

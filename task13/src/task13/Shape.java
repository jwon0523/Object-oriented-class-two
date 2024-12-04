package task13;

import java.awt.Graphics;
import java.io.Serializable;

abstract public class Shape implements Serializable {
	private static final long serialVersionUID = 1L;
	protected int x, y;
	
	public Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	abstract public void draw(Graphics g);
	
	@Override
	public String toString() {
		return String.format("%d %d", x, y);
	}
}

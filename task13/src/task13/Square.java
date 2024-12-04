package task13;

import java.awt.Graphics;

public class Square extends Shape {
	private int width, height;

	public Square(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(x - 50, y - 50, width, height);
	}
	
	@Override
	public String toString() {
		return String.format("Square %s %d %d", super.toString(), this.width, this.height);
	}

}

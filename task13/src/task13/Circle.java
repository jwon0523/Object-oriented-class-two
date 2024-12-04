package task13;

import java.awt.Graphics;

public class Circle extends Shape {
	private int radius;

	public Circle(int x, int y, int radius) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.radius = radius;
	}
	
	public int getRadius() {
		return radius;
	}
	

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
	}
	
	@Override
	public String toString() {
		return String.format("Circle %s %d", super.toString(), radius);
	}

}

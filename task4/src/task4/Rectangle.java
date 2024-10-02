package task4;

public class Rectangle {
	private static final int MAX_POINT = 100;
	private Point lt, rb; // 참조변수 선
	
	public Rectangle(int x1, int y1, int x2, int y2) {
		if(x1 >= 0 && y1 >= 0 && x1 <= MAX_POINT && y1 <= MAX_POINT) {
			lt = new Point(x1, y1);
		} 
		
		if(x2 >= 0 && y2 >= 0 && x2 <= MAX_POINT && y2 <= MAX_POINT) {
			rb = new Point(x2, y2);
		}
	}
	
	public Rectangle(Point lt, Point rb) {
		if(lt.getX() >= 0 && lt.getY() >= 0 && lt.getX() <= MAX_POINT && lt.getY() <= MAX_POINT) {
			this.lt = lt;
		}
		
		if(rb.getX() >= 0 && rb.getY() >= 0 && rb.getX() <= MAX_POINT && rb.getY() <= MAX_POINT) {
			this.rb = rb;
		}
	}
	
	public Rectangle() {
		this(0,0,0,0);
	}
	
	int getWidth() {
		return rb.getX() - lt.getX();
	}
	
	int getHeight() {
		return rb.getY() - lt.getY();
	}
	
	int getPerimeter() {
		return (getWidth() + getHeight()) * 2;
	}
	
	int getArea() {
		return getWidth() * getHeight();
	}
	
	void show() {
		System.out.print("[");
		System.out.print("직사각형 " + getWidth() + "x" + getHeight() + ": ");
		lt.show();
		System.out.print(", ");
		rb.show();
		System.out.println("]");
	}
}

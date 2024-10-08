package task4;

public class RectangleTest {
	
	static void show(Rectangle r) {
		r.show();
		System.out.print("넓이: " + r.getArea());
		System.out.print(", ");
		System.out.println("둘레: " + r.getPerimeter());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle rect0 = new Rectangle();
		RectangleTest.show(rect0);
		
		System.out.println();
		
		Rectangle rect1 = new Rectangle(0, 0, 10, 5);
		RectangleTest.show(rect1);
		
		System.out.println();
		
		Rectangle rect2 = new Rectangle(new Point(0, 0), new Point(5, 10));
		RectangleTest.show(rect2);
	}

}

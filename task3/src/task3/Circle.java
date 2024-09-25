package task3;

public class Circle {
	final double PI = 3.14;
	double radius;
	
	void setRadius(double radius) {
		this.radius = radius;
	}
	
	double getRadius() {
		return radius;
	}
	
	double getArea() {
		return PI * radius * radius;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle c1 = new Circle();
		c1.setRadius(12);
		
		System.out.println("반지름: " + c1.getRadius());
		System.out.println("넓이: " + c1.getArea());
	}

}

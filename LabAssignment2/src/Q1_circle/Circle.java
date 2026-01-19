package Q1_circle;

/*
1. Using the provided UML (circle class diagram), implement:
fields
constructors
methods (getters/setters or described methods)

2. Create a test class that:
creates Circle objects
displays radius, area, and circumference
tests multiple input values
*/

public class Circle {
	private double radius;
	private String color;

	public Circle() {
		this.radius = 1.0;
		this.color = "red";
	}

	public Circle(double r) {
		setRadius(r);
		this.color = "red";
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double r) {
		if (r < 0) {
			throw new IllegalArgumentException("Given radius must be positive.");
		}
		this.radius = r;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		if (color == null || color.length() == 0) {
			throw new IllegalArgumentException("Color cannot be empty.");
		}
		this.color = color;
	}

	public double getArea() {
		return Math.PI * (radius * radius);
	}

	public double getCircumference() {
		return 2 * Math.PI * radius;
	}
}

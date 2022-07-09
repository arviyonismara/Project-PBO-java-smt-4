public class Circle extends GeometriObject implements Benefits {
	private double radius;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return radius * radius * Math.PI;
	}

	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}

	public void application() {
		System.out.println("Circles are on wheels,rings,clocks,etc");

	}
}

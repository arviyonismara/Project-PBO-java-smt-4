public class Demo {
	public static void main(String[] args) {
		Circle c = new Circle();
		c.setRadius(5);
		System.out.println("The circle's area is " + c.getArea());
		System.out.println("The circle's Perimeter is " + c.getPerimeter());
		c.application();

		System.out.println(" ");

		Square s = new Square();
		s.application();
	}
}

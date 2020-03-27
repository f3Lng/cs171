public class HW2Example {

	public static Boolean isLarger(Circle c, Rectangle r) {
		double areaCircle = c.getArea();
		double areaRectangle = r.area();
		return (areaCircle >= areaRectangle);
	}

	public static Boolean containsCenter(Circle a, Circle b) {
		double x = b.getX();
		double y = b.getY();
		return a.containsPoint(x, y);
	}

	public static double isLonger(Circle c, Rectangle r) {
		double perimCircle = c.getCircumference();
		double perimRect = r.perimeter();
		if (perimCircle > perimRect) {
			return perimCircle;
		}
		else {
			return perimRect;
		}
	}

	public static double isLonger(Rectangle r, Circle c) {
		double perimCircle = c.getCircumference();
		double perimRect = r.perimeter();
		if (perimCircle > perimRect) {
			return perimCircle;
		}
		else {
			return perimRect;
		}
	}

	public static double isDeeper(Circle c, Rectangle r) {
		double areaCirc = c.getArea();
		double areaRect = r.area();
		if (areaCirc > areaRect) {
			return areaCirc;
		}
		else {
			return areaRect;
		}
	}

	public static double isDeeper(Rectangle r, Circle c) {
		double areaCirc = c.getArea();
		double areaRect = r.area();
		if (areaCirc > areaRect) {
			return areaCirc;
		}
		else {
			return areaRect;
		}
	}


	// public static void main(String[] args) {
	// 	Circle a = new Circle(4.0, 0.0, 0.0);
	// 	Circle b = new Circle(5.0, 5.0, 5.0);

	// 	System.out.println(a.getRadius()); //100.0
	// 	System.out.println(b.getRadius()); //200.0
	// 	System.out.println(a.getArea());
	// 	System.out.println(b.getArea());
	// 	System.out.println(a.getCircumference());
	// 	System.out.println(b.getCircumference());
	// 	System.out.println(a.isBiggerThan(b));
	// 	System.out.println(b.isBiggerThan(a));
	// 	System.out.println(a.containsPoint(0.0, 0.0));
	// 	System.out.println(b.containsPoint(0.0, 7.0));


	// 	Rectangle c = new Rectangle(5.0, 3.0, 0.0, 0.0);
	// 	System.out.println(c.getLength());
	// 	System.out.println(c.getHeight());
	// 	c.setLength(6.0);
	// 	c.setHeight(4.0);
	// 	System.out.println(c.getLength());
	// 	System.out.println(c.getHeight());
	// 	System.out.println(c.perimeter());
	// 	System.out.println(c.area());

	// 	System.out.println(isLarger(a, c));
	// 	System.out.println(containsCenter(a, b));
	// 	//System.out.println(containsCenter())

	// 	Cylinder d = new Cylinder();
	// 	System.out.println(d.getArea());
	// }
}
public class Cylinder extends Circle{

	private double z;
	private double h;

	public Cylinder() {
		x = 0.0;
		y = 0.0;
		z = 0.0;
		h = 1.0;
		radius = 1.0;
	}

	public Cylinder(double ex, double why, double radius, double height) {
		x = ex;
		y = why;
		this.radius = radius;
		h = height;
	}

	public double getArea() {
		return h*radius*radius*Math.PI;
	}

	public double getHeight() {
		return h;
	}

	public void setHeight(double height) {
		h = height;
	}
}
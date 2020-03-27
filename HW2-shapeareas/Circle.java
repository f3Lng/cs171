//A class for a circle. 
public class Circle {  // Save as "Circle.java"
   // private instance variable, not accessible from outside this class
   protected double radius;//the radius of the circle. 
   protected double x; //the x coordinate of the circle.
   protected double y;// the y coordinate fo the circle. 
   // The default constructor with no argument.
   // It sets the radius and color to their default value.
   public Circle() {
      radius = 1.0;
      
   }
   
   // 2nd constructor with given radius, but color default
   public Circle(double r) {
      radius = r;
      
   }
   
   //You should complete this next constructor. "r" is the radius name, "ex" should be the x coordinate, and "why" should be the y coordinate. 

   public Circle(double r, double ex, double why) {
   	radius = r;
   	x = ex;
   	y = why;
   	//your code here. 
   }

   public double getX() {
   	return x;
   }

   public double getY() {
   	return y;
   }

   // A public method for retrieving the radius
   public double getRadius() {
     return radius; 
   }
   
   // A public method for computing the area of circle
   public double getArea() {
      return radius*radius*Math.PI;
   }

   //A public method you need to write to compute the circumference of the circle.

   public double getCircumference(){
   	return 2*radius*Math.PI;
   	//your code goes here. 
   }

   //A public method that compares the sizes of two circles. CircleA.isBiggerThan(CircleB) should return true if circleA has a larger area than circle B, false otherwise. 
   //The method is named, but you should fill in the signature. 
   public boolean isBiggerThan(Circle b){
   	double areaA = radius*radius*Math.PI;
   	double areaB = b.getArea();
   	return (areaA > areaB);
   	//Fill this code in. 
   }
   //A public method that takes as input an x coordinate (as a double) and a y coordinate (a double), and returns true if the (x,y) coordinate 
   //is inside the circle, and false otherwise. The method is named, but you should fill in the signature. 

   public boolean containsPoint(double xPoint, double yPoint){
   	return (((xPoint - x)*(xPoint - x)) + ((yPoint - y)*(yPoint - y)) < (radius*radius));
   	//fill in this code. 
   }

   





}
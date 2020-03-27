import java.util.*; //want everything from java

public class ArrayListExample {

	public static void main(String[] args) {
		ArrayList<String> objects = new ArrayList<String>();
		objects.add("apple");
		objects.add("banana");
		objects.add("canteloupe");

		System.out.println(objects);

		objects.remove("banana");

		System.out.println(objects);

		objects.add("apple");

		System.out.println(objects);

		objects.remove("apple"); //removes the apple in index 0 (first one)

		System.out.println(objects); 
	}
}
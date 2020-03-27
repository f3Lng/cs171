import java.util.*;

public class Arraylis{

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1000);
		numbers.add(2000);
		numbers.add(3000);

		numbers.add(1, 25000);
		System.out.println(numbers);

		Iterator<Integer> numItr = numbers.iterator(); //wtf is this
		while (numItr.hasNext()) {
			System.out.println(numItr.next()); //print next element if there is one (prints index 0)
		}

	}
}
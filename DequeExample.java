import java.util.Deque;
import java.util.ArrayDeque;

public class DequeExample {
	public static void main(String[] args) {
		Deque<String> deque = new ArrayDeque<String>();
		// for (int k = 1; k <= 7; k++) {
		// 	deque.enqueue(k);
		// }

		// for (int k = 1; k <=4; k++) {
		// 	deuque.enqueue(deque.dequeue());
		// 	deque.dequeue();
		// }

		deque.add("E1"); //E1
		deque.addFirst("E2"); //adds to head E2  E1
		deque.addLast("E3"); //E2  E1  E3
		deque.push("E4"); // pushes to front of line E4  E2  E1  E3
		deque.offer("E5"); // E4  E2  E1  E3  E5
		deque.offerFirst("E6"); // E6  E4  E2  E1  E3  E5
		deque.offerLast("E7"); //E6  E4  E2  E1  E3  E5  E7
 
		deque.pop(); //pops from front E4  E2  E1  E3  E5  E7
		deque.removeLast(); //E4  E2  E1  E3  E5 
		deque.removeFirst(); //  E2  E1  E3  E5 


		for (String s: deque) {
			System.out.println(s);
		}
	}
}
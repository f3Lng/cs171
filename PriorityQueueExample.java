import java.util.PriorityQueue;

public class PriorityQueueExample {
	public static void main(String[] args) {
		PriorityQueue<Integer> s = new PriorityQueue<Integer>();

		s.add(25);
		s.add(35);

		System.out.println(s.remove()); //25
		
		s.add(45);
		s.add(15);
		System.out.println(s.remove()); //15
		System.out.println(s.remove()); //35

	}
}

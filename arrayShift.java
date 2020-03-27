import java.util.ArrayList;

public class arrayShift {

	// public static int[] arrayShift(int[] x) {
	// 	int size = x.length;
	// 	int[] sorted = new int[size];
	// 	int nextSmallest = 0;
	// 	for (int i = 0; i < size-1; i++) {
	// 		for (int j = i + 1; j < size; j++) {
	// 			if (x[i] < x[j]) {
	// 				nextSmallest = x[i];
	// 			} 
	// 		}
	// 	}

	// }

	public static ArrayList<Integer> arrayShift(ArrayList<Integer> x) {
		ArrayList<Integer> sorted = new ArrayList<Integer>();
		int i = 0;
		int min = 0;
		while (i < x.size()-1) {
			for (int j = 1; j < x.size(); j++) {
				if (x.get(i) < x.get(j)) {
					min = x.get(i);
				} else {
					j++;
				}
			}
			sorted.add(min);
			i++;
		}
		return sorted;
	}

	public static ArrayList<Integer> arrayShift2(ArrayList<Integer> x) {
		ArrayList<Integer> sorted = new ArrayList<Integer>();
		for (int i = 0; i < x.size() - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < x.size(); j++) {
				if (x.get(j) < x.get(minIndex)) {
					minIndex = j;
				}
			}
			int temp = x.get(minIndex);
			sorted.add(temp);
		}
		return sorted;
	}

	public static ArrayList<Integer> arrayShift3(ArrayList<Integer> x) {
		ArrayList<Integer> sorted = new ArrayList<Integer>();
		int min = x.get(0);
		for (int i = 1; i < x.size(); i++) {
			if (x.get(i) < min) {
				min = x.get(i);
				sorted.add(min);
				x.remove(i);
			}
		}
		return sorted;
	}

	public static ArrayList<Integer> arrayShift4(ArrayList<Integer> x) {
		ArrayList<Integer> sorted = new ArrayList<Integer>();
		int min = x.get(0);
		for (int j = 0; j < x.size(); j++) {
		for (int i = 1; i < x.size(); i++) {
			if (x.get(i) < min) {
				min = x.get(i);
			}
		}
			x.remove(min);
			System.out.println(x);
			sorted.add(min);
			System.out.println(sorted);
		}
		return sorted;
	}
	
	public static void main (String[] args) {
		ArrayList<Integer> x = new ArrayList<Integer>();
		x.add(4);
		x.add(3);
		x.add(2);
		x.add(1);
		x.add(0);

		ArrayList<Integer> y = arrayShift4(x);
		System.out.println(y);


	}
}
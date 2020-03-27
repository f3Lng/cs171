public class BubbleSort{
	public static void main(String[] args) {
		int[] a = {7, 6, 2, 1, 4, 5, 9, 3};
		bubbleSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static void bubbleSort(int[] a) {
		for (int j = 0; j < a.length; j++) {
			for (int i = 0; i < a.length-1; i++) {
				if (a[i] > a[i+1]) {
					int temp = a[i+1];
					a[i+1] = a[i];
					a[i] = temp;
				}
			}
		}
	}
}
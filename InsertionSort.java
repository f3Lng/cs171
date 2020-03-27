public class InsertionSort{
	public static void main(String[] args) {
		int[] a = {7, 6, 2, 1, 4, 5, 9, 3};
		insertionSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static void insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i-1; j >= 0; j--) {
				if (a[i] < a[j]) {
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
					j--;
				} else {
					break;
				}
			}
		}
	}
}
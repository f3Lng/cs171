public class SelectionSort{
	public static void main(String[] args) {
		int[] a = {7, 6, 2, 1, 4, 5, 9, 3};
		selectionSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static void selectionSort(int[] a) {
		for (int j = 0; j < a.length-1; j++) {
			int min = j;
			for (int i = j+1; i < a.length; i++) {
				if (a[i] < a[min]) {
					min = i;
				}
			}
			int temp = a[min];
			a[min] = a[j];
			a[j] = temp;
		}
	}
}
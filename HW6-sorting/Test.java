public class Test{

	public static void MergeSortNonRec(long[] a) {

		 long[] aux = new long[a.length];

		 // int k = 1;
		 // while ((int)Math.pow(2, k) <= a.length) { //last passthrough when one final merge
		 // 	for (int j = 0; j < a.length/(int)Math.pow(2, k); j++) { //number of times you merge in one pass through
		 // 		int i = (int)Math.pow(2, k) * j;
		 // 		merge(a, aux, i, i + ((int)Math.pow(2, k-1) - 1), i + ((int)Math.pow(2, k) - 1)); //lo:i  mid:i or i+1 or i+3 etc  hi: i+1 or i+3 or i+7 etc
		 // 	}
		 // 	k++;
		 // }

		 for (int i = 2; i <= a.length; i = i*2) {
		 	int lo = 0;
		 	for (int j = a.length/i; j > 0; j--) {
		 		//System.out.println("lo: " + lo);
		 		merge(a, aux, lo, lo+(i/2)-1, lo+i-1);

		 		//System.out.println("update");
		 		// for (int m = 0; m < a.length; m++) {
		 		// 	System.out.println(a[m]);
		 		// }


		 		lo = lo + i;
		 		// System.out.println("lo: " + lo);
		 	}
		 	//System.out.println("done with one pass");
		 }
		 // merge(a, aux, 0, (a.length/2)-1, a.length-1);
		 // System.out.println("done");
	}

	private static void merge(long[] a, long[] aux, int lo, int mid, int hi) {

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; 
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)           a[k] = aux[j++];
            else if (j > hi)            a[k] = aux[i++];
            else if (aux[j] < aux[i]) 	a[k] = aux[j++];
            else                        a[k] = aux[i++];
        }
    }

	// public static boolean testSort(long[] a) {
	// 	long[] a2 = new long[a.length];
	// 	System.arraycopy(a, 0, a2, 0, a.length);
	// 	Arrays.sort(a);
	// 	for(int i = 0; i < a.length; i++)
	// 		if(a2[i] != a[i]) 
	// 			return false;
	// 	return true;
	// }//testSort()

	public static boolean testSort(long[] a) {
		boolean result = true;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] < a[i+1]) {
				result = true;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		long[] test = new long[16];
		test[0] = 15;
		test[1] = 5;
		test[2] = 7;
		test[3] = 1;
		test[4] = 16;
		test[5] = 4;
		test[6] = 13;
		test[7] = 3;
		test[8] = 6;
		test[9] = 2;
		test[10] = 8;
		test[11] = 12;
		test[12] = 14;
		test[13] = 11;
		test[14] = 9;
		test[15] = 10;
		for (int i = 0; i < 16; i++) {
			System.out.println(test[i]);
		}
		System.out.println("sorted");

		MergeSortNonRec(test);

		for (int i = 0; i < 16; i++) {
			System.out.println(test[i]);
		}
	}


}
public class intTest{

	public static void main(String[] args) {
		String x = null; //int is a primative data type
		if (x == null) {
			System.out.println("null");
		}

		int y = 7;
		if (y == 8) System.out.println("8");
		else if (y == 9) System.out.println("9");
		else if (y == 7) System.out.println("7");
		else System.out.println("nothing");
	}
}
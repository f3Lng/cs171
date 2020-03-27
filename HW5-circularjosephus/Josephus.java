/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT 
CONSULTING CODE WRITTEN BY OTHER STUDENTS. 
Lydia Feng*/


public class Josephus{
	
        public static void main(String[] args){
                /* 
                 * Sample testing code
                 * Feel free to edit for additional tests of your CircularList 
                 * imlementation as well as the solve method
                 */

                System.out.println("------Testing Methods------");

                CircularList cl2 = new CircularList();

                cl2.insert(new ListElem(1));
                cl2.insert(new ListElem(2));
                cl2.insert(new ListElem(3));
                cl2.insert(new ListElem(4));
                System.out.println(cl2.getSize()); //4
                cl2.remove(); 
                cl2.printList(); //3 2 1
                System.out.println("size: " + cl2.getSize());
                System.out.println(cl2.remove()); //3
                cl2.printList(); //2 1
                System.out.println(cl2.isEmpty());
                cl2.printList();
                System.out.println("size: " + cl2.getSize());

                CircularList cl4 = new CircularList();
                cl4.remove();
                cl4.rotate();


                System.out.println("------Testing Solve------");


                CircularList cl = new CircularList();
                for(int i=0; i<10; i++)
                       cl.insert(new ListElem(i));

                int m =3; 
                System.out.println(solve(cl,3));

                
                CircularList cl3 = new CircularList();
                for (int j = 0; j < 12; j++) {
                        cl3.insert(new ListElem(j));
                }
                System.out.println(solve(cl3, 2));

                System.out.println("example from instructions");
                CircularList cl5 = new CircularList();
                for (int k = 0; k < 7; k++) {
                        cl5.insert(new ListElem(k));
                }
                System.out.println(solve(cl5, 3));

                CircularList cl6 = new CircularList();
                for (int l = 0; l < 50; l++) {
                        cl6.insert(new ListElem(l));
                }
                System.out.println(solve(cl6, 5));



        


        }

	public static int solve(CircularList cl, int m){
		/*
		* your code to solve the Josephus problem
		*/
                if (cl.getSize() == 1) {
                        return cl.remove(); //surviving element if only one element in cl
                } else {
                        while (cl.getSize() > 1) {
                                for (int i = 0; i < m - 1; i++) {
                                       cl.rotate(); //rotate m-1 times to get m-th element to head
                                }
                                cl.remove(); //remove m-th element from head
                        }
                        return cl.remove(); //return final survivor
                }
	}

}

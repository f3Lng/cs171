/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT 
CONSULTING CODE WRITTEN BY OTHER STUDENTS. 
Lydia Feng*/



public class CircularList {
	
	private ListElem tail;		// pointer to the last element in list
	private int size;		// size of the list
	
	public CircularList(){
		/*
		 * build an empty CircularList
		 */

		tail = null; 
		size = 0;
	}

        // Insert your methods here

	public boolean isEmpty() {
		return (tail == null);
	}

	public int getSize() {
		return size;
	}

	public Integer remove() {
		int result = 0;
		if (size == 0) {
			return null; //if there's nothing to remove, return null
		} else {
			result = tail.next.value; //the value of the head that will be returned
			tail.next = tail.next.next; //reassign head to head.next
			}

			size = size - 1;
		return result;
	}

	public void insert(ListElem newElem) {
		ListElem newHead = newElem;
		if (size == 0) {
			tail = newHead; 
			tail.next = tail; //points to itself
			size = 1;
		} else {
			ListElem temp = tail.next; //temporary ListElem to store old head
			newHead.next = temp; //new head points to old head
			tail.next = newHead; //connect tail to new head
			size++;
		}
	}
	

	public void rotate() {
		if (size != 0) {
			ListElem temp = tail;
			tail = tail.next; //reassign tail to head
			temp.next = tail; //everything else shifts forward to adjust
		}
	}

	public void printList() {
		ListElem x = tail.next; //start at head
		if (size > 0) {
			System.out.println(x.value);
		}
		if (size > 1) {
			x = x.next;
			while (x != tail.next) { //while x is not the head
				System.out.println(x.value);
				x = x.next;
			} 
		}
	}

}

/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS. Lydia Feng
*/

public class HashSeparateChaining {

	private class Node {
		Entry entry;
		Node next;

		Node(Entry entry) { this.entry = entry; }
	}

	Node[] hashTable;
	int arraySize;
	int tableSize; //14,000

	public HashSeparateChaining(){
		hashTable = new Node[10];
		arraySize = 10;
	}

	/** TODO: Write a resizing method for the hash table.*/
	private void resize() {
		if (((double)tableSize / (double)arraySize) > 5) {
			arraySize = 2*arraySize; 
			Node[] old = hashTable; 
			hashTable = new Node[arraySize]; //new array with updated size
			for (int i = 0; i < arraySize/2; i++) { 
				Node current = old[i]; //traverse through old hashtable
				while (current != null) {
					Node next = current.next;
					String tempKey = current.entry.getKey();
					int position = hash(tempKey);
					current.next = hashTable[position]; //save node at hashTable[position]
					hashTable[position] = current; //replace hashTable[position] with current
					current = next;
				 }
			}
		}

		if (((double)tableSize / (double)arraySize) < 0.2) {
			arraySize = arraySize/2;
			Node[] old = hashTable;
			hashTable = new Node[arraySize]; //new array with updated size
			for (int i = 0; i < arraySize*2; i++) {
				Node current = old[i]; //traverse through old hashtable
				while (current != null) {
					String tempKey = current.entry.getKey();
				 	int tempValue = current.entry.getValue();
				 	int position = hash(tempKey);

				 	Entry temp = new Entry(tempKey, tempValue);
				 	Node tempNode = new Node(temp);
				 	hashTable[position] = tempNode; //insert updated Node into updated position

				 	current = current.next;
				}
			}
		}	
	}

	/** Computes the index in the hash table from a given key */
	private int hash(String key) {
		int hashCode = key.hashCode();
		return (hashCode & 0x7fffffff) % arraySize;
	}

	/** Returns the number of entries in the hash table. */
	public int size() { return tableSize; }

	/** Checks whether the hash table is empty */
	public boolean isEmpty() { return tableSize == 0; }

	/** Returns the node containing the given key value if it exists in the table.
	    Otherwise, it returns a null value. */
	private Node findEntry(String key) {
		int index = hash(key);

		Node currentNode = hashTable[index];
		while (currentNode != null && !currentNode.entry.getKey().equals(key))
			currentNode = currentNode.next;

		return currentNode;

	}

	/** Returns the integer value paired with the given key, if the key is in the table.
		Otherwise, it returns null. */
	public Integer get(String key) {
		Node searchResult = findEntry(key);

		if (searchResult != null)
			return searchResult.entry.getValue();
		else
			return null;

	}

	/** If the given key is not in the table, creates a new entry and adds it to the table.
		Otherwise, it updates the value associated with the given key. */
	public void put(String key, Integer value) {
		Node searchResult = findEntry(key);

		if (searchResult != null){
			searchResult.entry.setValue(value);
			return;
		}

		if (((double)tableSize / (double)arraySize) > 5) {
			resize();
		}

		Entry newEntry = new Entry(key, value);
		Node newNode = new Node(newEntry);

		int index = hash(key);
		if (hashTable[index] != null)
			newNode.next = hashTable[index];

		hashTable[index] = newNode;
		tableSize++;

	}

	/** Removes the entry containing the given key from the table, if the key exists in the table. */
	public void delete(String key) {
		Node searchResult = findEntry(key);
		if (searchResult == null)
			return;

		int index = hash(key);
		if (hashTable[index] == searchResult)
			hashTable[index] = searchResult.next;
		else{
			Node currentNode = hashTable[index];
			while (currentNode.next != searchResult)
				currentNode = currentNode.next;
			currentNode.next = searchResult.next;
		}
		tableSize--;

		if (((double)tableSize / (double)arraySize) < 0.2) {
			resize();
		}

	}

	/** Produces a string representation of the table. */
	@Override
	public String toString(){
		String output = "";
		for (int i = 0; i < arraySize; i++){
			output += "(" + i + "): ";
			Node currentNode = hashTable[i];
			if (currentNode == null)
				output += currentNode + "\n";
			else{
				while (currentNode != null){
					output += " -> " + currentNode.entry;
					currentNode = currentNode.next;
				}
				output += "\n";
			}
		}

		return output;

	}
}

public class TripleLinkedListDummy {
	int n;
	Node head;
	Node last;
	Node bottom;

	/*
	 * TripleLinkedList() { head = new Node(); last = new Node(); bottom = new
	 * Node(); head.next = last; last.prev = head; bottom.prev = head; bottom.next =
	 * last;
	 * 
	 * }
	 */

	private class Node {
		Node prev;
		Node next;
		Node bottom;
		String value;

	}

	public void add(String value) {
		Node newNode = new Node();
		Node currNode = new Node();
		if (head == null) {
			newNode.next = head;
			newNode.prev = null;
			newNode.bottom = null;
			newNode.value = value;

			head = newNode;
		} else {
			String value1 = head.value;
			newNode.value = value;
			String value2 = newNode.value;
			while (head != null) {
				String lowestStr = compareTwoString(value1, value2);
				if (lowestStr.equals(value1)) {
					currNode = head;
					head = head.next;
					head = currNode ;
					head.next = currNode.next;
					head.prev = currNode.prev;
					head.bottom = currNode.bottom;
					value1 = currNode.value;
					// head.next = newNode;
					// head.prev = null;
					// head.bottom = null;

				} else if (lowestStr.equals(value2)) {
					newNode.value = head.value;
					head.value = value2;
					head.prev = null;
					head.next = newNode;
					head.bottom = null;
				}
			}
		}

	}

	public void addIntoLinkedList(String value) {

	}

	public void printAll(Node head) {
		Node last;
		while (head != null) {
			System.out.println("val traverse" + head.value);

			last = head;
			head = head.next;
		}

	}

	public static int compareTwoChar(char value1, char value2) {
		int a = (int) value1;
		int b = (int) value2;
		System.out.println("ASCII 1:" + a);
		System.out.println("ASCII 2:" + b);
		int diff = a - b;
		System.out.println("diff : " + diff);
		if (a == b) {
			return -1;
		} else if (a > b) {
			return 1;
		} else {
			return 0;
		}
	}

	public static String compareTwoString(String value1, String value2) {
		int val1Size = value1.length();
		int val2Size = value2.length();
		if (val1Size > val2Size) {
			for (int i = 0; i < val2Size;) {
				if (value1.charAt(i) == value2.charAt(i)) {
					i++;
				} else {
					int ascii = compareTwoChar(value1.charAt(i), value2.charAt(i));
					if (ascii == -1) {
						i++;
					} else if (ascii == 1) {
						return value2;
					} else {
						return value1;
					}
				}
			}
			return value2;
		} else {
			for (int i = 0; i < val1Size;) {
				if (value1.charAt(i) == value2.charAt(i)) {
					i++;
				} else {
					int ascii = compareTwoChar(value1.charAt(i), value2.charAt(i));
					if (ascii == -1) {
						i++;
					} else if (ascii == 1) {
						return value2;
					} else {
						return value1;
					}
				}
			}
			return value1;

		}
	}

}

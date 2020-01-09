
public class SortedLinkedList {
	//array of head node to have max 1000 level of hierarchy
	Node[] head = new Node[1000];
	static int count = 0;

	public class Node {
		public Node next;
		//bottom node holds pointer of lower levels.
		public Node bottom;

		public String value;

		public Node(String val) {
			value = val;
			next = null;
			bottom = null;
		}
	}

	public void addNewNode(String val, Coin flip) {
		Node newNode = new Node(val);
		Node currNode;
		//checks for null head and if head having greater value than new value. rewrite head with newnode
		if (head[0] == null || newNode.value.equals(compareTwoString(head[0].value, newNode.value))) {
			newNode.next = head[0];
			newNode.bottom = null;
			head[0] = newNode;
			count = 0;

			checkCoinFlip(val, flip, head[0]);

		} else {
			//checks for each element in the linked list to compare string
			currNode = head[0];
			while (currNode.next != null
					&& currNode.next.value.equals(compareTwoString(currNode.next.value, newNode.value))) {
				currNode = currNode.next;

			}
			newNode.next = currNode.next;
			currNode.next = newNode;
			currNode.bottom = null;
			count = 0;
			checkCoinFlip(val, flip, currNode);

		}

		printList();
	}

	//this method is called after each insertion to the linked list
	public void checkCoinFlip(String val, Coin flip, Node node) {
		int check = flip.flip();
		Node currNode;
		
		if (check == 1) {
			Node newNode = new Node(val);
			//if flip returns 1, add new level to hierarchy
			count = count + 1;
			if (head[count] == null || newNode.value.equals(compareTwoString(head[count].value, newNode.value))) {
				newNode.next = head[count];
				head[count] = newNode;
				//sets bottom pointer to lower hierarchy list
				head[count].bottom = node;

				checkCoinFlip(val, flip, head[count]);

			} else {
				currNode = head[count];
				while (currNode.next != null
						&& currNode.next.value.equals(compareTwoString(currNode.next.value, newNode.value))) {
					currNode = currNode.next;

				}
				newNode.next = currNode.next;
				currNode.next = newNode;
				currNode.bottom = node;
				// recursive call to check if flip again returns 1 to add another level of hierarchy
				checkCoinFlip(val, flip, currNode);

			}

		}

	}

	public void printList() {
		
		for (int i = 999; i >= 0; i--) {
			//iterates the loop and checks if head is not null at each level
			if (head[i] != null) {
				Node currNodeNew = head[i];
				while (currNodeNew != null) {
					System.out.print(" " + currNodeNew.value+" bottom :"+ currNodeNew.bottom.value);
					currNodeNew = currNodeNew.next;
				}
				System.out.println();

			}
		}

	}

	public boolean findNode(String key) {
		//iterates the loop and checks if head is not null at each level

		for (int i = 999; i >= 0; i--) {
			if (head[i] != null) {
				Node currNode = head[i];
				while (currNode != null) {
					if (currNode.next != null) {
						
						int k = (int) key.charAt(0);

						int a = (int) currNode.value.charAt(0);
						int b = (int) currNode.next.value.charAt(0);
						
						//checks if key string has any elements between currNode and its next, to move to its lowest hierarchy
						if ((a < k && k < b) || (b < k && k < a)) {
							currNode = currNode.bottom;

						}
					}
					if (currNode != null) {
						if (currNode.value.equals(key)) {
							return true;
						}
						currNode = currNode.next;
					}
				}
			}
		}

		return false;
	}

	public int compareTwoChar(char value1, char value2) {
		int a = (int) value1;
		int b = (int) value2;

		if (a == b) {
			return -1;
		} else if (a > b) {
			return 1;
		} else {
			return 0;
		}
	}

	public String compareTwoString(String value1, String value2) {
		//compares two string values and returns lowest string value
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

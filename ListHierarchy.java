
public class ListHierarchy {
	static Coin flip;
	static SortedLinkedList sortedLinkedList;
	// Object[] object = new Object[96295];

	public ListHierarchy(Coin flip) {
		this.flip = flip;
		sortedLinkedList = new SortedLinkedList();
			}

	public static boolean add(String key) {

		if (sortedLinkedList != null) {
			boolean findNode = sortedLinkedList.findNode(key);
			if (findNode == true) {
				return true;
			}
		}

		sortedLinkedList.addNewNode(key, flip);

		if (sortedLinkedList.head != null) {
			return true;
		}
		return false;
	}

	public static boolean find(String key) {
		return sortedLinkedList.findNode(key);
	}

}

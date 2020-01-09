//no need
public class ListHierarchyDummy {

	public static void main(String[] args) {
		
		
		int check = compareTwoChar('A','a');
		System.out.println(check);
		
		String getLowestString = compareTwoString( "zzzzzz","zzzzza");
		System.out.println("check:"+getLowestString);
		
	}

	
	public static int compareTwoChar(char value1, char value2) {
		int a = (int)value1;
		int b = (int)value2;
		System.out.println("ASCII 1:"+ a);
		System.out.println("ASCII 2:"+ b);
		int diff = a - b;
		System.out.println("diff : "+diff);
			if(a  == b ) {
				return -1;
			}
			else if(a > b ) {
				return 1;
			}
			else {
				return 0;
			}
		}
	
	public static String compareTwoString(String value1 , String value2) {
		int val1Size = value1.length();
		int val2Size = value2.length();
		if(val1Size > val2Size) {
			for(int i = 0; i<val2Size;) {
				if(value1.charAt(i) == value2.charAt(i)) {
					i++;
				}else {
					int ascii = compareTwoChar(value1.charAt(i), value2.charAt(i));
					if(ascii == -1) {
						i++;
					}else if(ascii == 1) {
						return value2;
					}else {
						return value1;
					}
				}
			}
			return value2;
		}else {
			for(int i = 0; i<val1Size;) {
				if(value1.charAt(i) == value2.charAt(i)) {
					i++;
				}else {
					int ascii = compareTwoChar(value1.charAt(i), value2.charAt(i));
					if(ascii == -1) {
						i++;
					}else if(ascii == 1) {
						return value2;
					}else {
						return value1;
					}
				}
			}
			return value1;

		}
	}
	
}

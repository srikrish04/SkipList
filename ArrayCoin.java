
public class ArrayCoin implements Coin {
	private static int[] source = new int[] {1, 1 ,0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0};
	private static int position = 0;
	
    public int flip( ) {
    		int newvalue = source[position];
    		position = (position + 1) % source.length;
    		
            return newvalue;
    }
}

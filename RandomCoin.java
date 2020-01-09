import java.util.Random;

public class RandomCoin implements Coin {
		private static Random generator = null;
		
        public int flip( ) {
        		// Have one generator for the whole class for a consistent generation of random values.
        	
        		if (generator == null) {
        			generator = new Random();
        		}
 
                return generator.nextInt(2);
        }
}
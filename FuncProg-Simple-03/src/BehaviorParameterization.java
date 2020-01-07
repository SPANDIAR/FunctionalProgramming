import java.util.Random;

public class BehaviorParameterization {

	public static void main(String[] args) {
		
		getRandomInteger();
	}
	
	private static int getRandomInteger() {
		Random random = new Random();
		return random.nextInt(1000);
	}

}

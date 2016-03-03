package bootcamp.topic1.app;
 
public class Calculator {
 	
 	public int adition(int value1, int value2) {
 		return value1 + value2;
 	}
 	
 	public int multiply(int value1, int value2) {
 		int result = 0;
 		for (int i = 0; i < value2; i++) {
 			result = result + value1;
 		}
 		return result;
 	}
}

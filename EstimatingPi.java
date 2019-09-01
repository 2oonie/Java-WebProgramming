import java.util.Scanner;

public class EstimatingPi {

	public static void main(String[] args) {
		
		Scanner Reader = new Scanner(System.in);
		
		int input;
		
		System.out.print("Enter the number of iterations:");
		
		input = Reader.nextInt();
		
		double pi = 0.0;
		
		for (double i = 1; i <= input; i++) {
			
			pi += Math.pow(-1, i + 1)/((2.0*i-1.0));
			
			if (i % 10 == 0) {
				
				System.out.println("i: " + i + " the pi is " + pi*4.0);
			}	
	}

}
	}

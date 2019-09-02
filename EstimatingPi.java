import java.util.Scanner;

public class EstimatingPi {

	public static boolean isPowerOfTen(int i) {
		if (i % 10 != 0 || i == 0) {
            return false;
        }

        if (i == 10) {
            return true;
        }

        return isPowerOfTen(i/10);
    }
	
	
	public static void main(String[] args) {
		
		Scanner Reader = new Scanner(System.in);
		
		int input;
		
		System.out.print("Enter the number of iterations:");
		
		input = Reader.nextInt();
		
		double pi = 0.0;
		
		for (int i = 1; i <= input; i++) {
			
			pi += Math.pow(-1, i + 1)/((2.0*i-1.0));
			
			System.out.println("i: " + isPowerOfTen(i) + " the pi is " + pi*4.0);
				
	}

}
	}

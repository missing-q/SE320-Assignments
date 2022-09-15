import java.util.InputMismatchException;
import java.util.Scanner;

public class P1 {

	public static void main(String[] args) {
		System.out.println("Please enter two integers.");
		boolean cont =  true; // we're going to use this to ensure the sequence loops on incorrect input and terminates gracefully on correct inputs.
		Scanner s = new Scanner(System.in);
		int a = 0;
		int b = 0;
		while (cont) {
			try {
				a= s.nextInt();
				b = s.nextInt();
				cont = false;
			} catch(InputMismatchException e) {
				s.nextLine(); //this is to "flush" s' buffer, otherwise it'll just keep reading in the same input indefinitely
				System.out.println("Incorrect input. Please try again.");
			}
		}
		System.out.println(a+b);
		s.close();

	}

}

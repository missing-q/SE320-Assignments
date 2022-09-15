import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.lang.ArrayIndexOutOfBoundsException;


public class P2 {

	public static void main(String[] args) {
		//generate array
		Random rn = new Random();
		int[] a = new int[100];
		for (int i = 0; i < 100; i++) {
			a[i] = rn.nextInt(); //might be a better way to populate this but oh well
		}
		
		System.out.println("Please enter a valid array index.");
		Scanner s = new Scanner(System.in);
		int index;
		try {
			index= s.nextInt();
			System.out.println(a[index]);
			
		} catch(ArrayIndexOutOfBoundsException e) { //out of bounds
			System.out.println("Out of bounds.");
		} catch(InputMismatchException e) { //not an integer
			System.out.println("Not an valid array index.");
		} 
		s.close();

	}

}

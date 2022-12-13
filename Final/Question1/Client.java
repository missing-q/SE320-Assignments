import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws IOException {
		
		//get weight and height from user input
		System.out.println("Please input weight and height, in that order.");
		Scanner s = new Scanner(System.in);
				
		//connect to server
		Socket socket = new Socket("localhost", 8000);

		// Data IO streams
		DataInputStream inputFromServer = new DataInputStream(socket.getInputStream());
		DataOutputStream outputToServer = new DataOutputStream(socket.getOutputStream());

		outputToServer.writeDouble(s.nextDouble()); //weight
		outputToServer.writeDouble(s.nextDouble()); //height
		
		//Get BMI from server
		System.out.println("BMI: " + inputFromServer.readDouble());
		
		//close
		inputFromServer.close();
		outputToServer.close();
		socket.close();
		s.close();
		
	}
}

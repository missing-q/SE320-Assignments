import java.io.*;
import java.net.*;

public class Server {
	public static void main(String[] args) throws IOException {
		//make socket
		ServerSocket serverSocket = new ServerSocket(8000);
		System.out.println("Started server!");

		// Listen for request
		Socket socket = serverSocket.accept();

		// Data IO streams
		DataInputStream inputFromClient = new DataInputStream(
				socket.getInputStream());
		DataOutputStream outputToClient = new DataOutputStream(
				socket.getOutputStream());

		// Read in data
		double weight = inputFromClient.readDouble();
		double height = inputFromClient.readDouble();

		// Calculate BMI
		double bmi = weight / (height * height);

		// send back to client
		outputToClient.writeDouble(bmi);
		
		//close
		inputFromClient.close();
		outputToClient.close();
		socket.close();
		serverSocket.close();
	}
}

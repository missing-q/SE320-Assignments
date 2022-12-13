//implements server with threading to handle multiple clients
import java.io.*;
import java.net.*;

public class Server2 {
	public static void main(String[] args) throws IOException {
		//make socket
		ServerSocket serverSocket = new ServerSocket(8000);
		System.out.println("Started server!");
		
		//infinite loop to handle multiple requests
		while (true) {
			// Listen for request
			Socket socket = serverSocket.accept();
			// Create new thread
            Thread thread = new Thread(new Handler(socket));
            // Start new thread
            thread.start();
            
		}
	}
}

class Handler implements Runnable {
    private Socket socket;

    // Initialize socket in constructor
    public Handler(Socket socket) {
        this.socket = socket;
    }

    // Implementation of run()
    public void run() {
    	try {
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
    		
    	} catch (IOException e) {
    		
    	}
    }
}

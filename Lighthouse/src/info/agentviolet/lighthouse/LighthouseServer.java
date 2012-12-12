package info.agentviolet.lighthouse;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;

public class LighthouseServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// declaration section:
		// declare a server socket and a client socket for the server
		// declare an input and an output stream
		ServerSocket echoServer = null;
		String line;		
		PrintStream os;
		Socket clientSocket = null;
		// Try to open a server socket on port 9999
		// Note that we can't choose a port less than 1023 if we are not
		// privileged users (root)
		try {
			echoServer = new ServerSocket(80);
			System.out.println("Server started.");
		} catch (IOException e) {
			System.out.println(e);
		}
		// Create a socket object from the ServerSocket to listen and accept
		// connections.
		// Open input and output streams
		try {
			System.out.println("listening...");
			clientSocket = echoServer.accept();			
			
			System.out.println("accepted connection.");
			
			BufferedReader is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	 			
			os = new PrintStream(clientSocket.getOutputStream());
			// As long as we receive data, echo that data back to the client.
			while (true) {
				line = is.readLine();
				os.println(line);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("exit.");
	}
}

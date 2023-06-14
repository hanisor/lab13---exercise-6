package server;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class launch the server side application using TCP.
 * The server generates current date.
 * Each connected client will received current date from the server.
 * 
 * @author hanis sorhana
 *
 */

public class ServerTranslationApplication {

	/**
	 * Main entry point to the server side application
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		// Launch the server frame
		ServerTranslationFrame serverFrame = new ServerTranslationFrame();
		serverFrame.setVisible(true);
		
		// Binding to a port or any other port no you are fancy of
		int portNo = 4228;
		ServerSocket serverSocket = new ServerSocket(portNo);
		
		Translation translate = new Translation();
		
		// Counter to keep track the number of requested connection
		int totalRequest = 0;
		
		// Server needs to be alive forever
		while (true) {
			
			// Message to indicate server is alive
			serverFrame.updateServerStatus(false);
			String engText = "Thank you";
			String targetLanguage = "Bahasa Malaysia";
			
			// Accept client request for connection
			Socket clientSocket = serverSocket.accept();
			
			// Generate translated text
			
			String translation = translate.getTranslate(targetLanguage);
			
			// Create stream to write data on the network
			DataOutputStream outputStream = 
					new DataOutputStream(clientSocket.getOutputStream());
			
			// Send current word count back to the client
			outputStream.writeUTF(translation);
			
			// Close the socket
			clientSocket.close();
			serverSocket.close();
		
			// Update the request status
			serverFrame.updateRequestStatus(
					"Translated text from : " + engText + " \nTo : " + translation);
			serverFrame.updateRequestStatus("Accepted connection to from the "
					+ "client. Total request = " + ++totalRequest );
			
		}
		
		

	}

}

package client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import server.Translation;

/**
 * This method launch the frame and manage the connection to the server.
 * 
 * @author hanis sorhana
 *
 */

public class ClientTranslationApplication {

	public static void main(String[] args) 
			throws UnknownHostException, IOException {
		
		
		
		Translation translate = new Translation();
		
		// Launch client-side frame
		ClientTranslationFrame clientFrame = new ClientTranslationFrame();
		String targetLanguage = "Bahasa Malaysia";
		clientFrame.setVisible(true);
		
		// Connect to the server @ localhost, port 4228
		Socket socket = new Socket(InetAddress.getLocalHost(), 4228);
		
		// Update the status of the connection
		clientFrame.updateConnectionStatus(socket.isConnected());
		
		// Read from network
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		
		// Display the current word count
		String translation = translate.getTranslate(targetLanguage);
		clientFrame.updateServerLanguage(translation);
		
		// Close everything
		bufferedReader.close();
		socket.close();

	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	ServerSocket serverSocket;
	Socket socket;

	public Server() {
		try {
			serverSocket = new ServerSocket(1131);
			System.out.println("So it begins ~ Server");
			socket = serverSocket.accept();
			System.out.println("Wir sind verbunden");
			OutputStream output = socket.getOutputStream();
			PrintWriter printi = new PrintWriter(output);

			InputStream input = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));

			String fromClient = null;

			while (true) {
				fromClient = reader.readLine();
				System.out.println("Der Client schrieb: " + fromClient);

			}
			// printi.close();
			// reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Server();

	}

}
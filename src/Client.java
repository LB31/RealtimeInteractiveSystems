import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	Socket clientSocket;
	BufferedReader buffer;
	PrintWriter printi;
	BufferedReader reader;

	public Client() {
		try {
			clientSocket = new Socket("localhost", 1131);
			System.out.println("Client ist an Board");

			printi = new PrintWriter(clientSocket.getOutputStream());

			// InputStream input = clientSocket.getInputStream();
			reader = new BufferedReader(new InputStreamReader(System.in));

			String consoleInput = null;

			while (true) {
				consoleInput = reader.readLine();
				printi.println(consoleInput);
				printi.flush();
				System.out.println(consoleInput);
			}

			// printi.write("Na du");
			//
			//
			// printi.close();
			// reader.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new Client();

	}

}
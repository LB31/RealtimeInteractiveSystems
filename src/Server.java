import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private final ServerSocket server;

	public Server(int port) throws IOException {
		server = new ServerSocket(port);
	}

	private void connect() {

		while (true) {
			Socket socket = null;
			try {
				socket = server.accept();
				inOut(socket);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (socket != null)
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}
	}

	private void inOut(Socket socket) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream output = new PrintStream(socket.getOutputStream());
		String s;

		while (input.ready()) {
			s = input.readLine();
			output.println(s);
		}
	}

	public static void main(String[] args) throws IOException {
		Server server = new Server(3141);
		System.out.println("Server started");
		server.connect();
		
	}
}
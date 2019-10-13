import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

class Client {

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 3141);

            OutputStream output = socket.getOutputStream();
            PrintStream ps = new PrintStream(output, true);
            ps.println("Hallo Welt!");
            ps.println("Hallo Otto!");

            InputStream input = socket.getInputStream();
            System.out.println("verf\u00FCgbare Bytes: " + input.available());
            BufferedReader buff = new BufferedReader(new InputStreamReader(input));
            
            while (buff.ready()) {
                System.out.println(buff.readLine());
            }

        } catch (UnknownHostException e) {
            System.out.println("Unknown Host...");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOProbleme...");
            e.printStackTrace();
        } finally {
            if (socket != null)
                try {
                    socket.close();
                    System.out.println("Socket opened...");
                } catch (IOException e) {
                    System.out.println("Socket cannot be opened...");
                    e.printStackTrace();
                }
        }
    }
} 
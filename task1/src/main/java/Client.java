import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.stream.Stream;

public class Client {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 9797;

        try (Socket clientsocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientsocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()))) {

            out.println("Client");

            String response = in.readLine();
            System.out.println(response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

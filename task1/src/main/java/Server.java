import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        int port = 9797;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started");

            while (true) {

                try (Socket clientSocket = serverSocket.accept(); // ждем подключения
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ) {

                    System.out.println("New connection accepted. Port:" + clientSocket.getPort());

                    final String name = in.readLine();

                    out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

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
                    String request = in.readLine();
                    System.out.println(request);


                    out.println("Hello. What is your name?");
                    String name = in.readLine();
                    System.out.println(name);

                    out.println(name + ", Are you child? (yes/no)");
                    String response = in.readLine();

                    if (response.toLowerCase(Locale.ROOT).equals("yes")) {
                        out.printf("Welcome to the kids area, %s Let's play!", name);
                    } else {
                        out.printf("Welcome to the adult zone, %s Have a good rest, or a good working day!", name);
                    }

//                    out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

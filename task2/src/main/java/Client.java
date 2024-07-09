import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String host = "netology.homework";
        int port = 9797;

        try (Socket clientsocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientsocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()))) {

            out.println("Hello");

            String response = in.readLine();
            System.out.println(response);
            String name = scan.nextLine();
            out.println(name);

            response = in.readLine();
            System.out.println(response);
            String answer = scan.nextLine();
            out.println(answer);

            response = in.readLine();
            System.out.println(response);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

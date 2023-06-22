import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class ChatServer {
    private int portNumber;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    public BufferedReader in;
    public PrintWriter out;
    private String inputString;
    private String outputString;

    public ChatServer(int portNumber) {
        this.portNumber = portNumber;
    }

    public void startServer() {

        try {
            serverSocket = new ServerSocket(portNumber);
            clientSocket = serverSocket.accept();
            System.out.println("ChatServer accepts serverSocket");
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
        }
        read();
        write();
        stopServer();
    }

    public void read() {
        System.out.println("ChatServer reads");
        try {
            while(in.readLine() != null) {
                inputString = in.readLine();
                System.out.println("ChatServer reads inputString " + inputString);
            }
        } catch (IOException e) {
            System.out.println("Something wrong with reading from server");
        }
    }

    public void write(){
        System.out.println("ChatServer writes");
        out.print(outputString);
    }

    public void stopServer() {
        System.out.println("ChatServer stops");
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e){
            System.out.println("Something wrong with stopping the server");
        }
    }
}
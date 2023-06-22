import java.io.*;
import java.net.Socket;

public class ChatClient {
    private String hostName;
    private int portNumber;
    private Socket serverConnectionSocket;
    public PrintWriter out;
    public BufferedReader in;
    private String inputString;
    private String message;

    public ChatClient(String hostName, int portNumber) {
        this.hostName = hostName;
        this.portNumber = portNumber;
    }

    public void startClient(){
        try {
            serverConnectionSocket = new Socket(hostName, portNumber);
            System.out.println("ChatClient connected to port " + portNumber);
            in = new BufferedReader(new InputStreamReader(serverConnectionSocket.getInputStream()));
            out = new PrintWriter(serverConnectionSocket.getOutputStream(), true);
        } catch (IOException e) {
        }
        write();
        read();
        stopClient();
    }

    public void read() {
        System.out.println("ChatClient reads");
        try {
            while(in.readLine() != null) {
                inputString = in.readLine();
                System.out.println("ChatClient reads inputString " + inputString);
            }
        } catch (IOException e) {
            System.out.println("Something wrong with reading from server");
        }
    }

    public void write() {
        System.out.println("ChatClient writes");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (reader.readLine() != null) {
                message = reader.readLine();
                System.out.println("ChatClient writes message " + message);
                out.print(message);
                out.flush();
            }
            } catch(IOException e){
                System.out.println("something is wrong with write method from client");
            }
        }

    public void stopClient() {
        System.out.println("ChatClient stops");
        try {
            in.close();
            out.close();
            serverConnectionSocket.close();
        } catch (IOException e) {
            System.out.println("Something wrong with stopping the client");
        }
    }
}












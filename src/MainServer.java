public class MainServer {

    public static void main(String[] args) {

        int portNumber = 1111;

        ChatServer chatServer = new ChatServer(portNumber);
        chatServer.startServer();
    }
}

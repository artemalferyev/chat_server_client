public class MainClient {

    public static void main(String[] args) {

        int portNumber = 1111;
        String hostName = "192.168.1.4";

        ChatClient chatClient = new ChatClient(hostName, portNumber);
        chatClient.startClient();
    }
}

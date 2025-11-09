import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.function.Consumer;

public class Server {

    public Consumer<Socket> getConsumer(){
        // return new Consumer<Socket>() {
        //     @Override
        //     public void accept(Socket clientSocket){
        //         try {
        //             PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream());
        //             toClient.println("Hello from the server");
        //             toClient.close();
        //             clientSocket.close();
    
        //         } catch (Exception e) {
        //             e.printStackTrace();
        //         }
        //     }
        // };

        return (clientSocket) -> {
            try (PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(), true)) {
                toClient.println("Hello from the server");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (Exception ignored) {}
            }
        };
    }

    public static void main(String[] args) {
        int port = 8010;
        Server server = new Server();
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
            System.out.println("Server is linstening on port "+port);
            
            while(true){
                Socket acceptedSocket = serverSocket.accept();
                System.out.println("Connection accepted from client " + acceptedSocket.getRemoteSocketAddress());
                Thread thread = new Thread(()->server.getConsumer().accept(acceptedSocket));
                thread.start();
            }
        } catch (SocketTimeoutException e) {
            System.out.println("No client connected in the last 10 seconds, still waiting...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
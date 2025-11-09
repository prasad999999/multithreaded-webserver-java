package ThreadPool;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private final ExecutorService threadPool;

    public Server(int poolSize) {
        this.threadPool = Executors.newFixedThreadPool(poolSize);
    }

    public void handleClient(Socket clientSocket) {
        try {
            PrintWriter toSocket = new PrintWriter(clientSocket.getOutputStream(), true);
            toSocket.println("Hello from Server "+ clientSocket.getInetAddress());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int port = 8010;
        int poolSize = 500;
        Server server = new Server(poolSize);

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(70000);
            System.out.println("Server is listening on port "+port);

            while(true){
                Socket clienSocket = serverSocket.accept();

                server.threadPool.execute(() -> server.handleClient(clienSocket));

            }
        }catch (SocketTimeoutException e) {
            System.out.println("No client connected in the last 10 seconds, still waiting...");
        } catch (IOException e) {
            e.printStackTrace();

        }finally{
            server.threadPool.shutdown();
        }
    }
}

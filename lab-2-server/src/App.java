import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) throws Exception {
        
        ServerSocket server = new ServerSocket(5504);
        Socket client = null;
        ExecutorService service = Executors.newCachedThreadPool();
        while (true) {
            System.out.println("oczekuje na połączenie...");
            client = server.accept();
            service.execute(new MyServer(client));
        }
        // service.shutdown();
        // client.close();
        // server.close();
    }
}

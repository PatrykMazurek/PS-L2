import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyServer implements Runnable{

    Socket clientSocket;
    PrintWriter writer;
    BufferedReader reader;

    public MyServer(Socket s){
        clientSocket = s;
        try {
            writer = new PrintWriter(clientSocket.getOutputStream(), true);
            reader = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("połączenie z klientem " + clientSocket.getInetAddress().getHostName());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        
        writer.println("witaj możesz komunikować się");
        String line = null;
        while (true) {
            try {
                line = reader.readLine();
                System.out.println(line);
                if (line.trim().equals("q")){
                    writer.println("pa pa");
                    break;
                }
                writer.println(line.toUpperCase());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        disconnect();
    }
    
    private void disconnect(){
        if(!clientSocket.isClosed()){
            try {
                reader.close();
                writer.close();
                clientSocket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}

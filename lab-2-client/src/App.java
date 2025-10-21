import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Socket client = new Socket("localhost", 5504);
        
        PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(client.getInputStream()));

        String line = null;
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(reader.readLine());
                line = scan.nextLine();
                if (line.trim().equals("q")){
                    writer.println(line);
                    break;
                }
                writer.println(line);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("zakończenie komunikacji");

        try {
            reader.close();
            writer.close();
            client.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

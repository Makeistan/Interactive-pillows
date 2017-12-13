import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Thrd extends Thread
{
    private Socket sock;

    public Thrd(Socket s)
    {
        sock = s;
    }
    @Override
    public  void run(){
        while (true) {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            String messange = null;
            try {
                messange = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int key = Integer.parseInt(messange.split(",")[0]);

            for (int i = 0; i < Main.sv.size(); i++)
            {
                if(key == Main.sv.get(i).getKey())
                {
                    Socket partner = Main.sv.get(i).getConnection();
                    try {
                        PrintWriter pr = new PrintWriter(partner.getOutputStream());
                        pr.println(messange.split(",")[1]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

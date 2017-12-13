import com.sun.corba.se.spi.presentation.rmi.IDLNameTranslator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Main {
    public static Vector<KeyValPair> sv;

    public static void main(String[] args) throws IOException {
        ServerSocket ss;
        sv =new Vector<KeyValPair>();
        ss = new ServerSocket(1234);
        while (true) {
            Socket s = ss.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            int key = Integer.parseInt(br.readLine());
            sv.add(new KeyValPair(s,key));
            Thrd t = new Thrd(s);
            t.start();
        }
    }
}
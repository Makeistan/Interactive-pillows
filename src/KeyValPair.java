import java.net.Socket;

public class KeyValPair {
    private Socket connection;
    private int key;
    public KeyValPair(Socket s, int KEY){
        connection = s;
        key = KEY;
    }
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Socket getConnection() {
        return connection;
    }

    public void setConnection(Socket connection) {
        this.connection = connection;
    }
}


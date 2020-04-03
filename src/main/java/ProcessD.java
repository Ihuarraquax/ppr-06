import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ProcessD {


    private static ServerSocket socket;

    static {
        try {
            socket = new ServerSocket(8083);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        String liczby = getFromA();
        System.out.println(liczby);






    }

    private static String getFromA() throws IOException {
        Socket socketA = socket.accept();
        DataInputStream input =new DataInputStream(socketA.getInputStream());
        DataOutputStream output =new DataOutputStream(socketA.getOutputStream());
        if(input.readUTF().equals("gotowy?")){
            output.writeBoolean(true);
            return input.readUTF();
        }
        return null;
    }
}

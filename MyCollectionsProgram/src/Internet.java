import java.net.*;
import java.io.*;
import java.util.Date;

public class Internet {
    public static int serverPort = 998;
    public static int clientPort = 999;
    public static int bufferSize = 1024;
    public static DatagramSocket datagramSocket;
    public static byte[] buffer =
            new byte[bufferSize];
    public static void TheServer() throws IOException {
        int pos = 0;
        while (true){
            int c = System.in.read();
            switch (c) {
                case -1:
                    System.out.println("Server error - Quits");

                case '\r':
                    break;
                case '\n':
                    datagramSocket.send(
                            new DatagramPacket(
                                    buffer,
                                    pos,
                                    InetAddress.getLocalHost(),
                                    clientPort
                            )
                    );
                default:
                    buffer[pos++] = (byte) c;

            }

        }
    }
    public static void TheClient() throws IOException {
        while(true){
            DatagramPacket p =
                    new DatagramPacket(
                            buffer,
                            buffer.length
                    );
            datagramSocket.receive(p);

            System.out.println(new String(p.getData(),
                    0,
                    p.getLength()
            ));
        }
    }
    public static void main(String[] args) throws IOException {
        if(args.length == 1){
            datagramSocket = new DatagramSocket(serverPort);
            TheServer();
        } else{
            datagramSocket = new DatagramSocket(clientPort);
            TheClient();
        }
    }
}

package rippleclient;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Node extends Thread
{
    private Integer port;
    private List<Integer> unl;
    private ServerSocket serverSocket;


    // listening
    public void run() {
        System.out.println("Waiting for client on port " +
                serverSocket.getLocalPort() + "...");
        Socket server = null;

        while(true) {
            try {
                server = serverSocket.accept();

                System.out.println("Just connected to " + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());


                // parse string
                // store
                // if wszystkie UNL, to decyzja

//                DataOutputStream out = new DataOutputStream(server.getOutputStream());
//                out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress()
//                        + "\nGoodbye!");



            }catch(SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            }catch(IOException e) {
                e.printStackTrace();
                break;
            } finally {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main( String[] args )
    {

        try {
//            Thread t = new Node();
            Node node = new Node();
            node.setPorts(args);
            node.start();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }


    public void setPorts(String[] args) throws IOException{

        port = new Integer(args[0]);
        serverSocket = new ServerSocket(port);

        unl = new ArrayList<Integer>();


        unl.add(Integer.getInteger(args[1]));
        unl.add(Integer.getInteger(args[2]));
        unl.add(Integer.getInteger(args[3]));
        unl.add(Integer.getInteger(args[4]));
    }
}

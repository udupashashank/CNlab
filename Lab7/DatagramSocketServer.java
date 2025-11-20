import java.net.*;
import java.util.*;
/**
 *
 * @author Lab6
 */
public class DatagramSocketServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        Scanner in =new Scanner(System.in);
        DatagramSocket severSocket=new DatagramSocket(9000);
        byte[] receiveData=new byte[1024];
        byte[] sendData=new byte[1024];
        System.out.println("***sever side ****");
        DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
        severSocket.receive(receivePacket);
        System.out.println(new String(receivePacket.getData()));
        InetAddress IPAddress=receivePacket.getAddress();
        int port=receivePacket.getPort();
        while(true){
            System.out.println("Type some message to display at the client side ");
            String message=in.nextLine();
            sendData=message.getBytes();
            System.out.println("Message sent from the server :"+new String(sendData));
            DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IPAddress,port);
            severSocket.send(sendPacket);
        }
       
        }
        // TODO code application logic here
    }
    

import java.net.*;
/**
 *
 * @author Lab6
 */
public class DatagramSocketClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        String Line="Connected with Client ";
        DatagramSocket clientSocket=new DatagramSocket();
        InetAddress IPAddress=InetAddress.getByName("localhost");
        byte[] sendData=new byte[1024];
        byte[] receiveData=new byte[1024];
        sendData=Line.getBytes();
        DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IPAddress,9000);
        clientSocket.send(sendPacket);
        System.out.println("****9client Display Terminal****");
                 while(true){
                     DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
                     clientSocket.receive(receivePacket);
                     String messageReceived=new String (receivePacket.getData(),receivePacket.getOffset(),receivePacket.getLength());
                     System.out.println("Message typed at the serbver side is :"+messageReceived);
                     
                     
                 }
             // TODO code application logic here
    }
    
}

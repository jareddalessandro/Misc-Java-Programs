package Networking_Udemy_UDP;

import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost(); // getByName() if your using a different machine as host
            DatagramSocket dataGramSocket = new DatagramSocket();

            Scanner scanner = new Scanner(System.in);
            String echoString;
            do {
                System.out.println("Enter string to be echoed");
                echoString = scanner.nextLine();

                byte[] buffer = echoString.getBytes();

                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5000);
                dataGramSocket.send(packet);

                // If we wanted for the client to wait for a response
//                byte[] buffer2 = new byte[50];
//                packet = new DatagramPacket(buffer2, buffer2.length);
//                dataGramSocket.receive(packet);
//                System.out.println("Received " + new String(buffer2, 0, packet.getLength()));

            } while(!echoString.equals("exit"));

        } catch(SocketTimeoutException e) {
            System.out.println("Socket Timed out");
        } catch(IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }

}

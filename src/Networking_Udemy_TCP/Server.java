package Networking_Udemy_TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        
        try(ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("----- Server Online -----");
            // Infinite loop that wait for "close"
            int id = 0;
            while(true){
                id++;
                new Echoer(serverSocket.accept(), id).start();
                System.out.printf("\n----- Client #"+ id + " connected -----\n");

            }

        } catch (IOException e) {
            System.out.println("Server Exception : " + e.getMessage());
        }

    }
}

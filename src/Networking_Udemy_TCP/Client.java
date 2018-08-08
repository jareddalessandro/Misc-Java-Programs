package Networking_Udemy_TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Client {

    /**
     * Run this after Server.main is run for the client to connect to the server on port 5000
     */
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            BufferedReader echoes = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);

            Scanner scan = new Scanner(System.in);
            String echoString;
            String response;

            do {
                System.out.println("\nSend message to server: ");
                echoString = scan.nextLine();

                stringToEcho.println(echoString);
                if (!echoString.equals("close")) {
                    response = echoes.readLine();
                    System.out.println("----- Message sent to server: " + echoString + " -----");
                }
                else{
                    System.out.println("----- Killing connection to server -----");
                }
            } while (!echoString.equals("close"));
        } catch(IOException e){
            System.out.println("Client error: " + e.getMessage());
        }
    }
}


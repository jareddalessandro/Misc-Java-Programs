package Networking_Udemy_TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends Thread {

    private Socket socket;
    private int id;

    public Echoer(Socket socket, int id) {
        this.socket = socket;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            while(true){
                String echoString = input.readLine();
                System.out.printf("\nReceived client #%s input: %s", id, echoString);
                if(echoString.equals("close")){
                    break;
                }
                try{
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    System.out.println("Thread was interrupted");
                }
                output.println(echoString);
            }
        } catch(IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } finally {
            try {
                System.out.println("\n----- Killing Client #" + id + " -----\n");
                socket.close();
            } catch(IOException e) {
                // Don't flag
            }
        }
    }
}

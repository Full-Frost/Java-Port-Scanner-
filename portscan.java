package sockets.port;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class portscan {
    public static void main(String[] args) throws IOException{
        if(args.length != 2){
            System.err.println("Usage: Java portscan <hostname> <portnumber>");
        }
        String hostname = args[0];
        int portnumber = Integer.parseInt(args[1]);
        System.out.println("This is connecting to "+ hostname + ": "+ portnumber);
        try(
                Socket portSocket = new Socket(hostname, portnumber);
                PrintWriter out = new PrintWriter(portSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(portSocket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
                ) {
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("port: " + in.readLine());
            }
        }catch (UnknownHostException e){
            System.err.println("Host is weird" + hostname);
            System.exit(1);
        }catch (IOException e){
            System.err.println("Couldn't get I/O for the connection to " + hostname);
            System.exit(1);
        }
    }
}

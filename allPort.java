package sockets.port;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class allPort {
    public static void main(String[] args){
        if(args.length != 1){
            System.err.println("Usage: java portscan <hostname> ");
        }
        int SYSTEM_MAX = 1023;
        String hostname = args[0];
        ArrayList<Integer> systemPorts = new ArrayList<>();
        for(int i = 0; i <= SYSTEM_MAX; i++){
            systemPorts.add(i);
        }

        for(int i : systemPorts){
            System.out.println("This is connecting to "+ hostname+" on port "+i);
            try{
                Socket socketCheck = new Socket(hostname,i);
                //socketCheck.connect(new InetSocketAddress(hostname, i));
                socketCheck.close();
            }catch (IOException e){
            }
        }
    }
}

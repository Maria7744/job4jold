package ioBot;

//import com.google.common.net.InetAddresses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientNew {
    public ClientNew(String ip,int port) throws IOException{
       // Socket socket = new Socket(InetAddress.getByName(ip),port) ;
        Socket socket = new Socket(InetAddress.getByName(null), port) ;
        PrintWriter out  = new PrintWriter( socket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())) ;
        Scanner console = new Scanner(System.in);
        String regueste = null;//str
        String response = null;
        do{
            regueste = console.nextLine();
            out.println(regueste);
            if ("Exit".equals(regueste)){
                while (!(response = in.readLine()).isEmpty()){

                    System.out.println(response);
                    out.flush();
                    out.close();
                    in.close();
                    socket.close();
                }
            }
        }
                while (!("Exit".equals(regueste)));
            }
            public static void main(String[] args) throws IOException {
                new ClientNew("localhost", 9000);
            }


    }










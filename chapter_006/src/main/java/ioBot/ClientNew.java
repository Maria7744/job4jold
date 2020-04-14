package ioBot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientNew {
    private static  int port = 9000;
    private static  String ip;

    public ClientNew(String ip,int port) {
        this.ip = ip;
        this.port = port;
    }
       public static void start() throws IOException{
        Socket socket = new Socket(InetAddress.getByName(null), port) ;
        PrintWriter out  = new PrintWriter( socket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())) ;
        Scanner console = new Scanner(System.in);
        String regueste ;
        String response ;
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










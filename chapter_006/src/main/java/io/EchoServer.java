package io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) throws IOException {
      
        ServerSocket server = new ServerSocket(9000) ;
            while (true) {
                Socket clientSocket = server.accept();
                BufferedWriter out  = new BufferedWriter( new OutputStreamWriter (clientSocket.getOutputStream()));
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(clientSocket.getInputStream())) ;
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                    }
                    String question =in.readLine();

                    if ("bye".equals(question)) {
                         str="http://localhost:9000/?msg=Exit";
                        out.write(str);
                        out.newLine();
                        out.flush();
                        out.close();
                    } else if ("hellow".equals(question)) {
                          str="http://localhost:9000/?msg=hellow";
                        out.write(str);
                        out.newLine();


                    }else{
                        out.write("http://localhost:9000/?msg=What");
                    out.flush();
                    out.close();
                    in.close();
                    clientSocket.close();

                }



            }
        }
    }




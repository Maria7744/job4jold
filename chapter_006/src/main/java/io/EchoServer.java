package io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket( 9000) ;
            while (true) {
                Socket clientSocket = server.accept();
                BufferedWriter out  = new BufferedWriter( new OutputStreamWriter (clientSocket.getOutputStream()));
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(clientSocket.getInputStream())) ;
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                    }
                     str =in.readLine();

                    if ("bye".equals(str)) {
                        String answer="http://localhost:9000/?msg=Exit";
                        out.write(answer);
                        out.newLine();
                        out.flush();
                        out.close();
                        server.close();
                    } else if (str.equals("hellow")) {
                         String answer="http://localhost:9000/?msg=hellow";
                        out.write(answer);
                        out.newLine();
                    } else if (str.equals("exit")) {

                        break;
                    }else{
                        String answer="http://localhost:9000/?msg=What";
                        out.write(answer);
                    out.flush();
                    out.close();
                    in.close();
                    clientSocket.close();

                }



            }
        }
    }




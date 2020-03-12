package io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket( 9000) ;
            while (true) {
                Socket clientSocket = server.accept();
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

                out.write("HTTP/1.1 200 OK\r\n");
                String str = in.readLine();
                if (str.equals("bue")) {

                    out.write("http://localhost:9000/?msg=Exit");
                    out.newLine();
                    out.flush();
                    out.close();
                    server.close();
                } else if (str.equals("hellow")) {
                    out.write("http://localhost:9000/?msg=hellow");
                    out.newLine();
                } else if (str.equals("exit")) {

                    break;
                }else {
                    out.write("http://localhost:9000/?msg=What");
                }
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                    }


                    out.flush();
                    out.close();
                    in.close();
                    clientSocket.close();

                }



            }
        }





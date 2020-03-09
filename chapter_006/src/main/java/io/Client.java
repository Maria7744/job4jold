package io;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket clientSocket = new Socket("",9000) ;
        BufferedWriter out  = new BufferedWriter( new OutputStreamWriter (clientSocket.getOutputStream()));
                 BufferedReader in = new BufferedReader(
                         new InputStreamReader(clientSocket.getInputStream())) ;
                         String str = "hellow";
                          out.write(str);
                           out.newLine();
                String answer =in.readLine();
            System.out.println(answer);





                out.flush();
                out.close();
                in.close();
                clientSocket.close();

            }



        }



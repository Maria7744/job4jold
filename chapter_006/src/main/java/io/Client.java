package io;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        // int count =0;
        Socket clientSocket = new Socket("",9000) ;

        BufferedWriter out  = new BufferedWriter( new OutputStreamWriter (clientSocket.getOutputStream()));
                 BufferedReader in = new BufferedReader(
                         new InputStreamReader(clientSocket.getInputStream())) ;

out.write("http://localhost:9000/?msg=hellow");
out.newLine();
                String str =in.readLine();
            System.out.println(str);



                    out.flush();
                    out.close();

                out.flush();
                out.close();
                in.close();
                clientSocket.close();

            }



        }



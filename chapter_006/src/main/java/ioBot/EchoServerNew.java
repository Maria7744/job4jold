package ioBot;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerNew {

   // private static int port;

    private static final int port = 9000;
    private final Socket socket;

    public EchoServerNew(Socket socket) {

        this.socket= socket;
    }



    public void start() throws IOException {
       // Socket socket = new ServerSocket(port).accept();

        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(this.socket.getInputStream()));

        // out.write("HTTP/1.1 200 OK\r\n");
        //   String str = in.readLine();
        String ask = null;
        do {
            System.out.println("ВВедите вопрос");
            ask = in.readLine();
            System.out.println(ask);
            if ("hellow".equals(ask)) {

                out.println("http://localhost:9000/?msg=hellow,dear");
                out.println();
                // out.flush();
                //  out.close();
                //   server.close();
            } else if ("What".equals(ask)) {
                out.write("http://localhost:9000/?msg=What...");
                out.println();
            } else if ("exit".equals(ask)) {
                out.println(" ");
                break;

            }
        }
        while (!("exit".equals(ask)));
        // System.out.println(ask);
    }


    public static void main(String[] args) throws IOException {

        try (
                final Socket socket = new ServerSocket(9000).accept()) {
            new EchoServerNew(socket);
        }


    }
}
       // out.flush();
      //  out.close();
      //  in.close();
      //  clientSocket.close();







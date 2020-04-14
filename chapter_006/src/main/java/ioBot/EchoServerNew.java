package ioBot;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerNew {
    private static final int port = 9000;
    private final Socket socket;

    public EchoServerNew(Socket socket) {
        this.socket= socket;
    }

    public void start() throws IOException {
        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(this.socket.getInputStream()));
        String ask = null;
        do {
            System.out.println("ВВедите вопрос");
            ask = in.readLine();
            System.out.println(ask);
            if ("Hello".equals(ask)) {
                out.println("http://localhost:9000/?msg=Hello");
                out.println();
                out.flush();
                  out.close();
            } else if ("Any".equals(ask)) {
                out.write("http://localhost:9000/?msg=Any...");
                out.println();
            } else if ("exit".equals(ask)) {
                out.println(" ");
                break;
            }
        }
        while (!("exit".equals(ask)));
    }

    public static void main(String[] args) throws IOException {
        try (
                final Socket socket = new ServerSocket(9000).accept()) {
            new EchoServerNew(socket);
        }
    }
}







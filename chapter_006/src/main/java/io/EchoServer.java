package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
       //Сначала нам нужно создать сервер.
        try (ServerSocket server = new ServerSocket(9000)) {
            //Зачем тут нужен вечный цикл?
           // метод ассеpt принимает один запрос от клиента, чтобы о
            // тправить второй, программа должна снова получить объект socket.
            while (true) {
                //ServerSocket создает сервер. Чтобы клиент мог узнать, где находится сервер ему нужен адрес и порт. По аналогии с людьми мы обращаемся по имени, чтобы начать разговор.
                //9000 - это порт. По умолчанию адрес будет localhost.
                Socket socket = server.accept();
                //server.acсept - ожидает, когда к нему обратиться клиент. Программа переходит в
                // режим ожидания.
                // Когда клиент обратился к серверу программа получает входной поток и может отправить
                // данные в выходной поток.
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    //В программе читается весь входной поток.
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                    }
                    // //В ответ мы записываем строчку.
                    //Программа curl отправляет запросы через протокл TCP/IP. Для передачи текстовых сообщений этот фортам передачи не удобен.
                    //Протокол HTTP - это удобная обёртка над протоколом TCP/IP. Наша программа сразу работает с этим протоколом.
                    //Давайте добавь ответ клиенту.
                   // public static String answer( String question) { //IDEA жалуеться при анализе, private-puиlic

                    String question =in.readLine();
                    if ("Привет.".equals(question)) {

                        out.write("Hello, dear friend.".getBytes());
                    } else if ("exit".equals(question)) {
                        out.write("http://localhost:9000/?msg=Exit".getBytes());


                        }else
                            out.write("http://localhost:9000/?msg=What".getBytes());


                    }



                }
            }
        }


}


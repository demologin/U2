package com.javarush.module2.lesson19;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketChat {
    public static final int PORT = 1234;

    public static void main(String[] args) {
        new Thread(new ServerDemo()).start();
        new Thread(new ClientDemo()).start();
    }


    static class ServerDemo implements Runnable {


        @Override
        public void run() {
            try (ServerSocket serverSocket = new ServerSocket(PORT)) {
                String hostName = serverSocket.getInetAddress().getHostName();
                int localPort = serverSocket.getLocalPort();
                System.err.printf("Server start at %s:%d%n", hostName, localPort);
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(inputStreamReader);

                OutputStream outputStream = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream);

                String line;
                while (!(line = reader.readLine()).contains("stop")) {
                    writer.printf("Все говорят %s, а ты возьми и купи слона!!!%n", line.toUpperCase());
                    writer.flush();
                }
                writer.println("Эх, зря не купил!!!! Но я понял: " + line);
                writer.flush();
                System.err.println("Server finished");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class ClientDemo implements Runnable {

        @Override
        public void run() {
            try (Socket socket = new Socket("localhost", PORT)) {
                Scanner console = new Scanner(System.in);
                PrintWriter request = new PrintWriter(socket.getOutputStream());
                BufferedReader response = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line;
                do {
                    line = console.nextLine();
                    System.out.println("QUESTION:" + line);
                    request.println(line);
                    request.flush();
                    line = response.readLine();
                    System.out.println("ANSWER:" + line);
                } while (!line.contains("stop"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

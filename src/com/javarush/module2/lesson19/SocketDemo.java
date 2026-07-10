package com.javarush.module2.lesson19;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.Socket;

public class SocketDemo {
    public static void main(String[] args) {
        String host = "www.google.com";
        String path = "/";
        int port = 443;
        String request = "GET %s HTTP/1.1\r\nHost: %s\r\n\r\n"
                .formatted(path, host);
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try (Socket socket = factory.createSocket(host, port)) {
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream);
            writer.print(request);
            writer.flush();
            socket.shutdownOutput();

            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.javarush.module2.lesson19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NioSimpleSocket {
    public static void main(String[] args) {
        String host = "ya.ru";
        String path = "/robots.txt";
        String request = "GET %s HTTP/1.1\r\nHost: %s\r\n\r\n".formatted(path, host);
        InetSocketAddress address = new InetSocketAddress(host, 80);
        try (SocketChannel socketChannel = SocketChannel.open(address)) {
            ByteBuffer buffer=ByteBuffer.wrap(request.getBytes());
            socketChannel.write(buffer);
            socketChannel.shutdownOutput();
            buffer.clear();
            while (socketChannel.read(buffer)>0) {
                buffer.flip();
                byte[] array=new byte[buffer.remaining()];
                buffer.get(array);
                String txt = new String(array);
                System.out.print(txt);
                buffer.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

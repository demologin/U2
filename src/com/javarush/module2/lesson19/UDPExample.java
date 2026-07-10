package com.javarush.module2.lesson19;

import java.io.IOException;
import java.net.*;

public class UDPExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 1234;
        // создаем сокет для отправки сообщений
        DatagramSocket senderSocket = new DatagramSocket();
        // создаем сокет для приема сообщений
        DatagramSocket receiverSocket = new DatagramSocket(port);
        // сообщение для отправки
        String message = "Hello, World!";
        // создаем пакет для отправки сообщения
        InetAddress address = InetAddress.getByName("localhost");
        byte[] buffer = message.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
        // отправляем пакет
        senderSocket.send(packet);
        System.out.println("Sent message: " + message);

        Thread.sleep(5000);
        // создаем пакет для приема сообщения
        buffer = new byte[1024];
        packet = new DatagramPacket(buffer, buffer.length);
        // ждем получения сообщения
        receiverSocket.receive(packet);
        String receivedMessage = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Received message: " + receivedMessage);

        // закрываем сокеты
        senderSocket.close();
        receiverSocket.close();
    }
}
package com.javarush.lesson24;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AsyncFileReader {

    private static final int BUFFER_SIZE = 4; // Размер буфера в байтах

    public static void main(String[] args) {
        Path filePath = Paths.get("U2.iml").toAbsolutePath();
        try (AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(filePath, StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
            readFile(fileChannel, buffer, 0L);
            // Блокирующий вызов, чтобы дождаться завершения всех операций, вместо CountDownLatch
            try {
                Thread.sleep(10000); // Примерное время для завершения чтения
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readFile(AsynchronousFileChannel channel, ByteBuffer buffer, long position) {
        buffer.clear();
        channel.read(buffer, position, buffer, new CompletionHandler<>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                if (result != -1) { // Если не конец файла
                    buffer.flip();
                    while (buffer.hasRemaining()) {
                        System.out.print((char) buffer.get());
                    }
                    readFile(channel, buffer, position + result); // Читаем следующий блок
                } else {
                    System.out.println("\nFile reading completed.");
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.err.println("Error reading file: " + exc.getMessage());
                try {
                    channel.close();
                } catch (IOException e) {
                    System.err.println("Error closing file channel: " + e.getMessage());
                }
            }
        });
    }
}
package org.example;

import org.example.calculate.domain.Calculator;
import org.example.calculate.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomWebApplicationServer {
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    private final int port;
    private final static Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public void run() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("[CustomWebApplicationServer] started {} port", port);
            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client.");

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("[CustomWebApplicationServer] client connected");

                executorService.execute(new ClientRequestHandler(clientSocket));
            }

        }

    }

}



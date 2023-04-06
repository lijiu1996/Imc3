package com.example.demo.socket;

import com.fasterxml.jackson.core.util.BufferRecycler;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lijiawei
 * @Description
 * @Date 2021/5/7 9:37
 * @Version 1.0
 */
public class serverTest {

    public static void main(String[] args) throws Exception {

        String readline = null;
        String inTemp = null;
        String turnList = "\n";
        final String client = "Client:";
        final String server = "Server:";

        int port = 5556;
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();

        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        DataInputStream dis = new DataInputStream(bis);
        String ret = "";
        byte[] bytes = new byte[1];
        while( dis.read(bytes) != -1) {
            ret += bytes[0] + " ";
            if (dis.available() == 0)
                dosomeThing(ret);
        }
    }

    private static void dosomeThing(String ret) {
        System.out.println(ret);
    }
}

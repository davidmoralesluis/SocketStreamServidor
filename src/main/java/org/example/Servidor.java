package org.example;

import java.io.*;
import java.net.*;

public class Servidor {
    public Servidor() throws IOException {

        int serverPort = 12345;

        ServerSocket serverSocket = new ServerSocket(serverPort);

        while (true) {
            Socket clientSocket = serverSocket.accept();

            InputStream in = clientSocket.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            OutputStream out = clientSocket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);

            String request = dis.readUTF();

            String [] x=request.split("#");

            System.out.println("0 > "+x[0]);
            System.out.println("1 > "+x[1]);


            String response = "";
            double numero=0;
            double gas=0;

            try {
                numero=Integer.parseInt(x[1]);
            }catch (Exception e){
                System.out.println(e);
            }

            switch (x[0]){
                case "1":
                    System.out.println("case 1");
                    response=""+(numero/105);
                    break;
                case "2":
                    System.out.println("case 2");
                    response=""+(450-numero);
                    break;
                case "3":
                    System.out.println("case 3");
                    response=""+(numero/25);
                    break;
                case "4":
                    System.out.println("case 4");
                    gas=numero-1.45;
                    response=""+gas;
                    break;
                default:
                    response="ERROR";
                    System.out.println("error");
            }
            dos.writeUTF(response);

            dis.close();
            dos.close();
            clientSocket.close();
        }
    }
}


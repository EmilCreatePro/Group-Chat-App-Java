package smartBit.Server;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Server
{
    //private Socket socket   = null;
    //private ServerSocket server   = null;
    private static DataInputStream inSocket =  null;
    private static DataOutputStream outSocket = null;

    private static boolean serverOn = true;

    private static final int port = 1234;

    private static ArrayList<HandleClient> connections = new ArrayList<HandleClient>();

    private static int nrClients = 0;

    public static void main(String[] args) throws IOException, InterruptedException
    {
        ServerSocket server = new ServerSocket(port);//socket that listens to port 1234
        //it represents the passive side -> aka the server

        Socket socket;// it represents the active side, the one that communicates with the client

        while(serverOn)
        {
            System.out.println("Waiting for a incoming client " + (nrClients + 1));

            socket = server.accept();//wait and accept an incoming request

            inSocket = new DataInputStream(socket.getInputStream());
            outSocket = new DataOutputStream(socket.getOutputStream());
            //get the input and output streams

            HandleClient newClient = new HandleClient(socket, "Client" + nrClients, inSocket, outSocket);

            Thread handleClientThread = new Thread(newClient);//create a new thread for this client

            connections.add(newClient);

            handleClientThread.start();

            nrClients++;
        }

    }

    public static ArrayList<HandleClient> getConnections()
    {
        return connections;
    }

    /*

    // constructor with port
    public Server(int port)
    {
        // starts server and waits for a connection
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted");

            // takes input from the client socket
            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

            BufferedReader input = new BufferedReader(new InputStreamReader(in));//stop the deprecation and convert bytes correctly

            String line = "";

            // reads message from client until "Over" is sent
            while (!line.equals("Over"))
            {
                try
                {
                    line = in.readUTF();
                    //line = input.readLine();
                    System.out.println(line);

                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");

            // close connection
            socket.close();
            in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    public static void main(String args[])
    {
        Server server = new Server(5000);
    }

    */
}

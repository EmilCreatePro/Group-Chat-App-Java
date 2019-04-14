package smartBit.Server;


import java.io.*;
import java.net.Socket;
import java.util.*;

public class HandleClient implements Runnable
{
    Scanner scn = new Scanner(System.in);
    private Integer clientID;
    private final DataInputStream dis;
    private final DataOutputStream dos;
    private Socket socket;
    private boolean hasConnected;
    private boolean runClient = true;

    public HandleClient(Socket socket, Integer clientID, DataInputStream in, DataOutputStream out)
    {
        this.socket = socket;
        this.clientID = clientID;
        dis = in;
        dos = out;
        hasConnected = true;
    }
    
    @Override
    public void run()
    {
        String msgRecv = "";
        while(runClient)
        {
            try{
                 msgRecv = dis.readUTF();
                System.out.println("Message from client:" + msgRecv);
                String name = returnName(msgRecv);
                msgRecv = returnActualMessage(msgRecv);
                int iterateIDs = 0;

                if(msgRecv.equals("logout"))
                {
                    hasConnected = false;
                    this.socket.close();
                    break;
                }

                //if not working try calling the functions once and put the connections in  a local list
                for(HandleClient client : Server.getConnections())
                {

                    if(client.hasConnected == true && (iterateIDs != clientID)) //to add condition to check if the name of the client corresponds with the one desired
                    {
                        System.out.println(name + ": " + msgRecv);
                        client.dos.writeUTF(name + " " + msgRecv);
                    }
                    iterateIDs++;
                }

            }
            catch (EOFException e)
            {
                System.out.println("Client " + clientID + " has disconnected!");
                runClient = false;
                try
                {
                    this.dis.close();
                    this.dos.close();
                    this.socket.close();
                }catch (IOException ex)
                {
                    ex.printStackTrace();
                }

                //e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        try {
            this.dis.close();
            this.dos.close();
            this.socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private String returnName(String msg)
    {
        String[] tokens = msg.split(":");

        return tokens[0];
    }

    private String returnActualMessage(String msg)//if there are other ':' characters, put them back in!
    {
        String[] tokens = msg.split(":");

        String message = "";

        for(int i = 1; i < tokens.length; i++)
            message += ":" + tokens[i];

        return message;
    }
}

package smartBit.Server;


import java.io.*;
import java.net.Socket;
import java.util.*;

public class HandleClient implements Runnable
{
    Scanner scn = new Scanner(System.in);
    private String clientName;
    private final DataInputStream dis;
    private final DataOutputStream dos;
    private Socket socket;
    private boolean hasConnected;
    private boolean runClient = true;

    public HandleClient(Socket socket, String clientName, DataInputStream in, DataOutputStream out)
    {
        this.socket = socket;
        this.clientName = clientName;
        dis = in;
        dos = out;
        hasConnected = true;
    }



    @Override
    public void run()
    {
        String msgRecv;

        while(runClient)
        {
            try{

                msgRecv = dis.readUTF();
                System.out.println("Message from client:" + msgRecv);

                if(msgRecv.equals("logout"))
                {
                    hasConnected = false;
                    this.socket.close();
                    break;
                }

                //if not working try calling the functions once and put the connections in  a local list
                for(HandleClient client : Server.getConnections())
                {
                    if(client.hasConnected == true) //to add condition to check if the name of the client corresponds with the one desired
                    {
                        System.out.println(this.clientName + ": " + msgRecv);
                        client.dos.writeUTF(this.clientName + ": " + msgRecv);
                    }
                }

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        try
        {
            this.dis.close();
            this.dos.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

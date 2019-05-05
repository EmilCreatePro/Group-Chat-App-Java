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
    private boolean chatNotifiedOfConnection = false;

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



                if(msgRecv.equals("logout"))
                {
                    hasConnected = false;
                    this.socket.close();
                    break;
                }

                ArrayList<HandleClient> allClients = Server.getConnections();
                Integer lastConnectionID = (allClients.get(allClients.size() - 1)).clientID;
                System.out.println("Client ID:" + lastConnectionID);

                /*Start from 1 because the proper connection starts from ID 1*/
                int iterateIDs = 1;

//                for(HandleClient client : allClients)
//                {
//
//                    if(client.hasConnected == true && (iterateIDs != clientID)) //to add condition to check if the name of the client corresponds with the one desired
//                    {
//                        if(chatNotifiedOfConnection == false)
//                        {
//                            msgRecv = " has joined the conversation!";
//                        }
//                        System.out.println(name + ": " + msgRecv);
//                        client.dos.writeUTF(name + " " + msgRecv);
//                    }
//                    iterateIDs+=2;
//                }
                int count = 0;

                while(iterateIDs <= lastConnectionID)
                {
                    if(((allClients.get(count).hasConnected) == true) && (iterateIDs != clientID)) //to add condition to check if the name of the client corresponds with the one desired
                    {
                        if(chatNotifiedOfConnection == false)
                        {
                            msgRecv = " has joined the conversation!";
                        }
                        System.out.println(name + ": " + msgRecv);
                        allClients.get(count).dos.writeUTF(name + " " + msgRecv);
                    }
                    iterateIDs+=2;
                    count++;
                }

                /*
                 * This is to ensure that the first message of a new client won't be replaced with 'join the conversation!'
                 * This Variable will be false only in the beginning
                 */
                chatNotifiedOfConnection = true;

            }
            catch (EOFException e)
            {
                closeConnection("EOF problem");

                //e.printStackTrace();
            }
            catch (IOException e)
            {
                //e.printStackTrace();
                closeConnection("IOProblem");
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

    private void closeConnection(String msg)
    {
        System.out.println("Client " + (clientID+1) + " has disconnected! " + msg);
        runClient = false;
        try
        {
            this.dis.close();
            this.dos.close();
            this.socket.close();
            //Server.nrClients--;
            Server.removeDisconnectedClient(this);
            hasConnected = false;
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    /*
        Overwrite this method because ArrayList.remove uses equals method to
        determine whether the object should be remove. We need to test this
        accordingly.
     */
    public boolean equals(Object obj)
    {
        if(obj != null)
        {
            if(obj instanceof HandleClient)
            {
                HandleClient castObj = (HandleClient)obj;
                return this.hashCode() == castObj.hashCode();
            }
        }
        return false;
    }

//    public Integer getClientID()
//    {
//        return this.clientID;
//    }
}

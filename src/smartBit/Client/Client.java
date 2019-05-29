package smartBit.Client;

import javax.swing.*;
import java.net.*;
import java.io.*;


//ctrl + shift + F10 to run properly
public class Client implements IClient
{
    // initialize socket and input output streams
    private Socket socket            = null;
    private DataInputStream input = null;
    private DataOutputStream out     = null;
    private GUIClient clientGUI;
    private static GiveNamePort inputGUI;
    private String text = "";
    private String clientName;
    private String ip;
    private int port;

    public Client()
    {
        try {
            createInputGUI(this);
        }catch (Exception e)
        {
            System.out.println("Could not create input GUI!");
        }

    }
    // constructor to put ip address and port
    public Client(String clientName, String address, int port)
    {

        this.clientName = clientName;

        // establish a connection
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            //input  = new BufferedReader(new InputStreamReader(System.in));

            input = new DataInputStream(socket.getInputStream());

            // sends output to the socket
            out    = new DataOutputStream(socket.getOutputStream());

            try {
                createGUI(this);

            }catch (Exception e)
            {
                System.out.println("Could not create GUI for client!");
            }

            try{
                Thread.sleep(500);
            }catch (InterruptedException ie){
                System.out.println("Could not put it to sleep!");
            }

            // sendMessage thread
            Thread sendMessage = new Thread(new Runnable()
            {
                @Override
                public void run() {

                    /*Alert the chat room who has connected! */
                    try{
                        out.writeUTF(initialGreetingMessage());
                    }catch (IOException e) {
                        e.printStackTrace();
                    }

                    /* Realises requirement Req_5_ChatApp */
                    /* Realises requirement Req_9_ChatApp */
                    while (true) {
                        // read the message to deliver.
                        try {
                            try{
                                Thread.sleep(500);
                            }catch (InterruptedException ie){
                                System.out.println("Could not put it to sleep!");
                            }
                            // write on the output stream
                            text = getText();
                            if(!getText().equals(""))
                            {
                                System.out.println("I said:" + text);
                                out.writeUTF(clientName +":"+ text);
                                text = "";
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            // readMessage thread
            Thread readMessage = new Thread(new Runnable()
            {
                @Override
                public void run() {

                    while (true) {
                        try {
                            try{
                                Thread.sleep(500);
                            }catch (InterruptedException ie){
                                System.out.println("Could not put it to sleep!");
                            }
                            // read the message sent to this client
                            String msg = input.readUTF();
                            clientGUI.appendDialogueText(msg);
                            System.out.println("Message received: " + msg);
                        }
                        catch (EOFException e) {
                            System.out.println("Server is down!");
                            return;
                            //e.printStackTrace();
                        }
                        catch (IOException e) {

                            e.printStackTrace();
                        }
                    }
                }
            });

            sendMessage.start();
            readMessage.start();

        }
        /* Realises requirement Req_7_ChatApp */
        catch(UnknownHostException u)
        {
            System.out.println("The IP address of a host could not be determined!");
        }
        /* Realises requirement Req_7_ChatApp */
        catch(IOException i)
        {
            System.out.println("Sorry, could not connect");
        }



//            }
//            catch(IOException e)
//            {
//                System.out.println(e);
//            }
//        }

        // close the connection
//        try
//        {
//            input.close();
//            out.close();
//            socket.close();
//        }
//        catch(IOException i)
//        {
//            System.out.println(i);
//        }
    }

    private void createGUI(IClient client) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException
    {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                clientGUI = new GUIClient(client);
                clientGUI.setVisible(true);

            }
        });
    }

    public void receiveText(String text)
    {
        //System.out.println(text);
        this.text = text;
    }

    private String getText()
    {
        String text = this.text;
        if(text.equals("fuck"))
            System.out.println(text);

        return text;
    }

    public String getClientName()
    {
        return this.clientName;
    }

    private void createInputGUI(IClient client) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException
    {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                inputGUI = new GiveNamePort(client);
                inputGUI.setVisible(true);
            }
        });
    }

    public void connectButtonPressed(IClient client)
    {
        getInputInfo();
        inputGUI.setVisible(false);
        inputGUI = null;

        try {
            client = new Client(clientName, ip, port);
        }catch (Exception e)
        {
            System.out.println(e);
        }

    }


    private void getInputInfo()
    {
        clientName = inputGUI.giveClientName();
        ip = inputGUI.giveIp();
        port = inputGUI.givePort();
    }

    public static void main(String[] args)
    {
        try {
            IClient client = new Client();
        }catch (Exception e)
        {
            System.out.println(e);
        }

    }

    private String initialGreetingMessage()
    {
        return "\t" + this.clientName + ": I connected!";
    }
}
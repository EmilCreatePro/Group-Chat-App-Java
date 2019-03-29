package smartBit.Client;

import smartBit.Client.ClientGUI;

import javax.swing.*;
import java.net.*;
import java.io.*;


//ctrl + shift + F10 to run properly
public class Client
{
    // initialize socket and input output streams
    private Socket socket            = null;
    private BufferedReader  input   = null;
    private DataOutputStream out     = null;
    private ClientGUI clientGUI;
    private String text = "";
    private boolean textWasSent = false;

    // constructor to put ip address and port
    public Client(String address, int port)
    {
        try {
            createGUI(this);

        }catch (Exception e)
        {
            System.out.println("Could not create GUI for client!");
        }

        // establish a connection
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            input  = new BufferedReader(new InputStreamReader(System.in));

            // sends output to the socket
            out    = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }

        while (!getText().equals("Over"))
        {
            try
            {

                try{
                    Thread.sleep(500);
                }catch (InterruptedException ie){
                    System.out.println("Could not put it to sleep!");
                }

                if(!getText().equals(""))
                {
                    //line = text;
                    text = getText();
                    out.writeUTF(text);
                    System.out.println("text=" + text);
                    text = "";
                }
            }
            catch(IOException e)
            {
                System.out.println(e);
            }
        }

        // close the connection
        try
        {
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    private void createGUI(Client client) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException
    {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                clientGUI = new ClientGUI(client);
                clientGUI.setVisible(true);
            }
        });
    }

    public void receiveText(String text)
    {
        System.out.println(text);
        this.text = text;
    }

    public String getText()
    {
        String text = this.text;
        if(text.equals("fuck"))
            System.out.println(text);

        return text;
    }


    public static void main(String args[])
    {

        try {
            Client client = new Client("127.0.0.1", 5000);

        }catch (Exception e)
        {
            System.out.println(e);
        }

    }
}
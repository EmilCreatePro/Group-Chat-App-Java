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
    private DataInputStream input = null;
    private DataOutputStream out     = null;
    private ClientGUI clientGUI;
    private String text = "";
    private String name;

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
            //input  = new BufferedReader(new InputStreamReader(System.in));

            input = new DataInputStream(socket.getInputStream());

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

        try{
            Thread.sleep(500);
            clientGUI.appendDialogueText("FMMM AM ZIS!!!");
        }catch (InterruptedException ie){
            System.out.println("Could not put it to sleep!");
        }

        // sendMessage thread
        Thread sendMessage = new Thread(new Runnable()
        {
            @Override
            public void run() {
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
                            out.writeUTF(text);
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
                    } catch (IOException e) {

                        e.printStackTrace();
                    }
                }
            }
        });

        sendMessage.start();
        readMessage.start();

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
        //System.out.println(text);
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
            Client client = new Client("127.0.0.1", 1234);

        }catch (Exception e)
        {
            System.out.println(e);
        }

    }
}
package smartBit.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class GiveNamePort extends JFrame
{
    private JLabel givePortLabel;
    private JLabel giveNameLabel;
    private JTextArea nameArea;
    private JTextArea portArea;
    private JButton connectButton;
    private JPanel inputForm;
    private JTextArea ipTextArea;
    private IClient client;
    private String inputErrorMessage = "";

    public GiveNamePort(IClient client)
    {
        this.client = client;
        add(inputForm);
        setTitle("Connect Form");
        setSize(400,500);

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    if(hasInputCorrectForm())
                    {
                        if(isAddressValid())
                        {
                            client.connectButtonPressed(client);
                        }
                        else
                        {
                            notifyError();
                        }
                    }
                    else
                    {
                        notifyError();
                    }
                }
                catch(Exception ex)
                {
                    System.out.println("Error occured when pressing Connect");
                    System.out.println(ex);
                }
            }
        });
    }

    public String giveClientName()
    {
        return nameArea.getText();
    }

    public String giveIp()
    {
        String ip = ipTextArea.getText();
        if(ip.equals("") || ip == null)
        {
            ip = "127.0.0.1";
        }

        return ip;
    }

    public int givePort()
    {
        String port = portArea.getText();
        if(port.equals("") || port == null)
        {
            port = "1234";
        }

        return Integer.parseInt(port);//convert string to int
    }

    private boolean isAddressValid()
    {
        boolean retVal = true;

        if(hasInputCorrectForm()) {
            String ip = ipTextArea.getText();
            String port = portArea.getText();

            int portInt;

            if(port.equals("")) portInt = 1234;
            else
             portInt = Integer.parseInt(port);

            try{
            Socket connectionTest = new Socket(ip,portInt);
            }
            catch(UnknownHostException u)
            {
                System.out.println("The IP address of a host could not be determined!");
            }
            catch(IOException i)
            {
                inputErrorMessage = "The network could not be found!";
                retVal = false;
                //new ConnectionWarning("The network could not be found!");
            }

        }
        else retVal = false;



        return  retVal;
    }

    private boolean hasInputCorrectForm()
    {
        String ip = ipTextArea.getText();
        String port = portArea.getText();
        String name = nameArea.getText();
        boolean retVal = true;

        if(name.equals(""))
        {
            /* The only way to insert a newline to a jlabel is to wrap around a html label and use <br/> for new line*/
            inputErrorMessage += "Give a valid name<br/>";
            retVal = false;
        }
        if(!ip.equals(""))
        {
            if(validateIP(ip) == false)
            {
                /* The only way to insert a newline to a jlabel is to wrap around a html label and use <br/> for new line*/
                inputErrorMessage += "IP address not valid! Give values between 0.0.0.0 and 255.255.255.255<br/>";
                retVal = false;
            }
        }
        if(!port.equals(""))
        {
            try{
                int portInt = Integer.parseInt(port);

                if(portInt<0 || portInt > 65536)
                {
                    /* The only way to insert a newline to a jlabel is to wrap around a html label and use <br/> for new line*/
                    inputErrorMessage += "Port number not valid! Give values between 0-65536<br/>";
                    retVal = false;
                }
            }catch (NumberFormatException e)
            {
                System.out.println("Port not formed only with digits!");
            }
        }
        return retVal;
    }

    private boolean validateIP(String ip)
    {
        String[] tokens = ip.split("\\.");

        if(tokens.length != 4) return false;

        /*
         * If we have periods at the end 'split' method won't add them to tokens[] therefore we need to check
         * ex: 123.123.123.123. might be considered correct if not for this check
         */
        if(ip.charAt(ip.length()-1) == '.') return false;

        for(int i = 0; i < tokens.length; i++)
        {
            int ipField;
            try
            {
                ipField = Integer.parseInt(tokens[i]);
            }catch (NumberFormatException e)
            {
                System.out.println("IP address not formed only with digits!");
                return false;
            }

            if(ipField<0 || ipField>255)
                    return false;
        }

        return true;
    }

    private void notifyError()
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new ConnectionWarning(inputErrorMessage);
                    inputErrorMessage = "";
                }
            });
        }catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
}

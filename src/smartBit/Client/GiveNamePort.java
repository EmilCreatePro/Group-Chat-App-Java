package smartBit.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                    client.connectButtonPressed(client);
                }
                catch(Exception ex)
                {
                    System.out.println("Error occured when pressing Connect");
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


}

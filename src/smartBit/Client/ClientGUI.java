package smartBit.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGUI extends JFrame{
    private JButton sendButton;
    private JPanel clientPanel;
    private JTextArea dialogueBox;
    private Client client;

    public ClientGUI(Client client)
    {
        this.client = client;
        add(clientPanel);
        setTitle("Client Form");
        setSize(400,500);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(clientPanel, dialogueBox);
                client.receiveText(getClientText());
                dialogueBox.setText("");

            }
        });


    }

    public String getClientText()
    {
        String text = dialogueBox.getText();
        return text;
    }
}

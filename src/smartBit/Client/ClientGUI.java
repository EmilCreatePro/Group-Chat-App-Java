package smartBit.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class ClientGUI extends JFrame{
    private JButton sendButton;
    private JPanel clientPanel;
    private JTextArea dialogueBox;
    private JTextArea clientInput;
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
//                try{
//                    TimeUnit.SECONDS.sleep(1);
//                }catch (InterruptedException ie){
//                    System.out.println("Could not put it to sleep!");
//                }

                clientInput.setText("");

            }
        });
    }

    public String getClientText()
    {
        String text = clientInput.getText();
        displayMessages(text);
        return text;
    }

    private void displayMessages(String msg)
    {
        dialogueBox.setText(dialogueBox.getText() + "Me: " + msg + "\n");
    }

    public void appendDialogueText(String msg)
    {
        dialogueBox.setText(dialogueBox.getText() + msg + "\n");
    }


}

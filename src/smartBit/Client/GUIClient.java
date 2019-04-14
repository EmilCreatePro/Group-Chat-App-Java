package smartBit.Client;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUIClient extends JFrame {

    private JTextArea clientInput;
    private JTextArea dialogueBox;
    private JScrollPane scroll;
    private JButton sendButton;
    private JPanel panel;
    private IClient client;

    public GUIClient(IClient client) {

        this.client = client;
        setSize(550, 550);
        setResizable(false);
        setTitle("Client " + client.getClientName());
        setLocation(200, 100);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        scroll = new JScrollPane();
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        dialogueBox = new JTextArea();
        dialogueBox.setBounds(20, 20, 500, 400);
        dialogueBox.setBorder(new LineBorder(Color.BLACK));
        dialogueBox.setEditable(false);

        clientInput = new JTextArea();
        clientInput.setBounds(20, 450, 400, 40);
        clientInput.setBorder(new LineBorder(Color.BLACK));

        scroll.setBounds(20, 20, 500, 400);
        scroll.getViewport().setBackground(Color.WHITE);
        scroll.getViewport().add(dialogueBox);

        // Create JButton and JPanel
        sendButton = new JButton("Send");
        panel = new JPanel();

        panel.setBounds(450, 450, 80, 40);

        // Add button to JPanel
        panel.add(sendButton);
        // And JPanel needs to be added to the JFrame itself!
        this.getContentPane().add(panel);

        //add(panel);

        add(clientInput);
        add(scroll);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(clientPanel, dialogueBox);
                sendMessageRequest();
            }
        });



        KeyAdapter isEnterPressed = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    sendMessageRequest();
                    e.consume();
                    System.out.println("ENTER key pressed");
                }

            }
        };

        clientInput.addKeyListener(isEnterPressed);

        repaint();

        setVisible(true);

    }

    private void sendMessageRequest()
    {
        if(!clientInput.equals(""))
        {
            client.receiveText(getClientText());
            clientInput.setCaretPosition(0);
            clientInput.setText("");
        }
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
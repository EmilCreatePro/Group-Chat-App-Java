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
    private JScrollPane dialogueBoxScroll, clientInputScroll;
    private JButton sendButton;
    private JPanel panel;
    private IClient client;
    private final int xPositionTextArea = 20;
    private final int yPositionDialogBox = 20;
    private final int yPositionClientInput = 450;
    private final int widthDialogueBox = 500;
    private final int heightDialogueBox = 400;
    private final int widthClientInput = 400;
    private final int heightClientInput = 40;


    public GUIClient(IClient client) {

        this.client = client;
        setSize(550, 550);
        setResizable(false);
        setTitle("Client " + client.getClientName());
        setLocation(200, 100);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        dialogueBox = createJTextArea(xPositionTextArea, yPositionDialogBox, widthDialogueBox, heightDialogueBox);

        /* Realises requirement Req_11_ChatApp */
        dialogueBoxScroll = createJScrollPane(xPositionTextArea, yPositionDialogBox, widthDialogueBox, heightDialogueBox, dialogueBox);

        clientInput = createJTextArea(xPositionTextArea, yPositionClientInput, widthClientInput, heightClientInput);
        clientInput.setEditable(true);

        /* Realises requirement Req_11_ChatApp */
        clientInputScroll = createJScrollPane(xPositionTextArea, yPositionClientInput, widthClientInput, heightClientInput, clientInput);


        // Create JButton and JPanel
        sendButton = new JButton("Send");
        panel = new JPanel();

        panel.setBounds(450, 450, 80, 40);

        // Add button to JPanel
        panel.add(sendButton);
        // And JPanel needs to be added to the JFrame itself!
        this.getContentPane().add(panel);

        //add(panel);
        /* Realises requirement Req_11_ChatApp */
        add(clientInputScroll);
        add(dialogueBoxScroll);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(clientPanel, dialogueBox);
                sendMessageRequest();
            }
        });


        /* Realises requirement Req_12_ChatApp */
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
        if(!clientInput.getText().equals(""))
        {
            client.receiveText(getClientText());
            clientInput.setCaretPosition(0);
            clientInput.setText("");
        }
    }

    private String getClientText()
    {
        String text = clientInput.getText();
        displayMessages(text);
        return text;
    }

    /* Realises requirement Req_10_ChatApp */
    private void displayMessages(String msg)
    {
        dialogueBox.setText(dialogueBox.getText() + "Me: " + msg + "\n");
    }

    public void appendDialogueText(String msg)
    {
        dialogueBox.setText(dialogueBox.getText() + msg + "\n");
    }

    private JTextArea createJTextArea(int xPos, int yPos, int width, int height)
    {
        JTextArea jta = new JTextArea();
        jta.setBounds(xPos, yPos, width, height);
        jta.setBorder(new LineBorder(Color.BLACK));
        jta.setEditable(false);
        /* If text is longer than the width of text box -> it gives a new line */
        jta.setLineWrap(true);

        return jta;

    }

    private JScrollPane createJScrollPane(int xPos, int yPos, int width, int height, JTextArea textArea)
    {
        JScrollPane jsp = new JScrollPane();
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jsp.setBounds(xPos, yPos, width, height);
        jsp.getViewport().setBackground(Color.WHITE);
        jsp.getViewport().add(textArea);

        return jsp;
    }
}
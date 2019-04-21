package smartBit;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    private JTextArea clientInput;
    private JTextArea dialogueBox;
    private JScrollPane scroll;
    private JButton sendButton;
    private JPanel panel;

    public Main()
    {
        setSize(550,550);
        setResizable(false);
        setTitle("Fuck");
        setLocation(200,100);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        scroll = new JScrollPane();
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        dialogueBox = new JTextArea();
        dialogueBox.setBounds(20,20,500,400);
        dialogueBox.setBorder(new LineBorder(Color.BLACK));
        dialogueBox.setEditable(false);

        clientInput = new JTextArea();
        clientInput.setBounds(20,450,400,40);
        clientInput.setBorder(new LineBorder(Color.BLACK));

        scroll.setBounds(20,20,500,400);
        scroll.getViewport().setBackground(Color.WHITE);
        scroll.getViewport().add(dialogueBox);

        // Create JButton and JPanel
        sendButton = new JButton("Send");
        panel = new JPanel();

        panel.setBounds(450,450,80,40);

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
                clientInput.setText("");

            }
        });

        repaint();

        setVisible(true);

    }

    public static void main(String[] args) {
	// write your code here

//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (UnsupportedLookAndFeelException e) {
//            e.printStackTrace();
//        }
//
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                Main m = new Main();
//            }
//        });
//        String ip = new String("123.123.123.123.2");
//        String[] tokens = ip.split("\\.");
//        System.out.println(ip + " has " + tokens.length);

        //new ConnectionWarning("<html>Error<br/>Sal</html>");
        //new ConnectionDialog();
    }
}

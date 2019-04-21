package smartBit.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectionWarning extends JFrame {
    private JButton OKButton;
    private JLabel warningMessage;
    private JPanel warningPanel;

    public ConnectionWarning(String msg)
    {
        add(warningPanel);
        setTitle("Connection Failed!");
        setSize(550, 200);
        /* The only way to insert a newline to a jlabel is to wrap around a html label */
        warningMessage.setText("<html>" + msg + "</html>");
        setVisible(true);
        toFront();

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    warningMessage.setText("");
                    setVisible(false);
                }
                catch(Exception ex)
                {
                    System.out.println("Error occured when pressing OK");
                }
            }
        });
    }
}

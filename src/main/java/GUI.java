import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.*;

public class GUI {
    private JButton login;
    private JPanel panel1;
    private JTextField userdb;
    private JTextField usernameinput;
    private JLabel usernamelabel;
    private JLabel passwordlabel;
    private JPasswordField passwordinput;

    public GUI() {
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userDB = userdb.getText();
                String userName = usernameinput.getText();
                String password = passwordinput.getText();
                try {
                    Connection connection = (Connection) DriverManager.getConnection(("jdbc:mysql://triton.towson.edu:3360/" + userDB), userName, password);
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Howdy");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new GUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

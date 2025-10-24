
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AtmLogin extends JFrame implements ActionListener {

    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    AtmLogin() {

        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);

        ImageIcon i1 = new ImageIcon("C:\\Users\\Asus\\OneDrive\\Desktop\\graphs\\Project\\icons\\iconics.jpg");
        Image i2 = i1.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(i2));
        label.setBounds(70, 10, 100, 100);
        add(label);

        ImageIcon gifIcon = new ImageIcon("C:\\Users\\Asus\\OneDrive\\Desktop\\graphs\\Project\\icons\\donald.gif");
        Image gifImage = gifIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT); // small size
        JLabel label2 = new JLabel(new ImageIcon(gifImage));
        label2.setBounds(-10, -20, 150, 150); // next to the first image
        add(label2);

        JLabel text = new JLabel("Welcome to Krishna ATM");
        text.setFont(new Font("Onward", Font.BOLD, 38));
        text.setBounds(200, 40, 800, 40);
        add(text);

        JLabel cardno = new JLabel("CARD NO : ");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 300, 40);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        JLabel pin = new JLabel("PIN : ");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.white);
        setSize(800, 480);
        setLocation(350, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == login) {
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '" + cardnumber + "' and pin = '" + pinnumber + "'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card no or Pin");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new AtmLogin();
    }
}

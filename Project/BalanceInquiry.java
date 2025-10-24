import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceInquiry extends JFrame implements ActionListener {

    String pinnumber;
    JButton back;

    BalanceInquiry(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel heading = new JLabel("Your Current Account Balance");
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("System", Font.BOLD, 16));
        heading.setBounds(230, 250, 400, 30);
        image.add(heading);

        int balance = 0;
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "'");
            while (rs.next()) {
                String type = rs.getString("type");
                int amount = Integer.parseInt(rs.getString("amount"));
                if (type.equalsIgnoreCase("Deposit")) {
                    balance += amount;
                } else {
                    balance -= amount;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel text = new JLabel("Balance: Rs " + balance);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 300, 400, 30);
        image.add(text);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceInquiry("");
    }
}

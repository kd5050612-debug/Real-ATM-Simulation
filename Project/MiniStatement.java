import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {

    MiniStatement(String pinnumber) {
        setTitle("Mini Statement");
        setLayout(null);

        JLabel bank = new JLabel("Krishna Bank");
        bank.setBounds(150, 20, 200, 20);
        bank.setFont(new Font("System", Font.BOLD, 16));
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 350, 20);
        add(card);

        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 300);
        add(mini);

        JLabel balanceLabel = new JLabel();
        balanceLabel.setBounds(20, 460, 300, 20);
        add(balanceLabel);

        try {
            Conn conn = new Conn();

            // Fetch card number
            ResultSet rs = conn.s.executeQuery("SELECT * FROM login WHERE pin = '" + pinnumber + "'");
            while (rs.next()) {
                String cardNumber = rs.getString("cardnumber");
                if (cardNumber != null && cardNumber.length() >= 12) {
                    card.setText("Card Number: " + cardNumber.substring(0, 4) + "XXXXXXXX" + cardNumber.substring(12));
                }
            }

            ResultSet rs2 = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "'");
            int balance = 0;
            StringBuilder statement = new StringBuilder("<html>");
            while (rs2.next()) {
                String date = rs2.getString("date");
                String type = rs2.getString("type");
                String amount = rs2.getString("amount");

                statement.append(date)
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(type)
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;Rs ")
                        .append(amount)
                        .append("<br><br>");

                if (type.equalsIgnoreCase("Deposit")) {
                    balance += Integer.parseInt(amount);
                } else {
                    balance -= Integer.parseInt(amount);
                }
            }
            statement.append("</html>");
            mini.setText(statement.toString());
            balanceLabel.setText("Current Balance: Rs " + balance);

        } catch (Exception e) {
            e.printStackTrace();
        }

        getContentPane().setBackground(Color.WHITE);
        setSize(400, 600);
        setLocation(20, 20);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}

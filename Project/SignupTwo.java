
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField panTextField, aadharTextField;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox<String> religion, category, occupation, education, income;
    String formno;

    public SignupTwo(String formno) {
        this.formno = formno;

        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 150, 30);
        add(name);

        String valReligion[] = { "Hindu", "Muslim", "Sikh", "Christian", "Other" };
        religion = new JComboBox<>(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel Fname = new JLabel("Category:");
        Fname.setFont(new Font("Raleway", Font.BOLD, 20));
        Fname.setBounds(100, 190, 150, 30);
        add(Fname);

        String valcategory[] = { "General", "OBC", "SC", "ST", "Other" };
        category = new JComboBox<>(valcategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 150, 30);
        add(dob);

        String incomecategory[] = { "NULL", "<1,50,000", "<3,00,000", "<5,00,000", "Upto 12,00,000" };
        income = new JComboBox<>(incomecategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel educationLbl = new JLabel("Educational");
        educationLbl.setFont(new Font("Raleway", Font.BOLD, 20));
        educationLbl.setBounds(100, 290, 200, 30);
        add(educationLbl);

        JLabel qualificationLbl = new JLabel("Qualification:");
        qualificationLbl.setFont(new Font("Raleway", Font.BOLD, 20));
        qualificationLbl.setBounds(100, 315, 200, 30);
        add(qualificationLbl);

        String educationValues[] = { "Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others" };
        education = new JComboBox<>(educationValues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel occupationLbl = new JLabel("Occupation:");
        occupationLbl.setFont(new Font("Raleway", Font.BOLD, 20));
        occupationLbl.setBounds(100, 390, 200, 30);
        add(occupationLbl);

        String occupationValues[] = { "Salaried", "Self-Employed", "Business", "Student", "Retired", "Others" };
        occupation = new JComboBox<>(occupationValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel panLbl = new JLabel("PAN No:");
        panLbl.setFont(new Font("Raleway", Font.BOLD, 20));
        panLbl.setBounds(100, 440, 200, 30);
        add(panLbl);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);

        JLabel aadharLbl = new JLabel("Aadhar No:");
        aadharLbl.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharLbl.setBounds(100, 490, 200, 30);
        add(aadharLbl);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 490, 400, 30);
        add(aadharTextField);

        JLabel seniorLbl = new JLabel("Senior Citizen:");
        seniorLbl.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorLbl.setBounds(100, 540, 200, 30);
        add(seniorLbl);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);

        JLabel existingLbl = new JLabel("Existing Account:");
        existingLbl.setFont(new Font("Raleway", Font.BOLD, 20));
        existingLbl.setBounds(100, 590, 200, 30);
        add(existingLbl);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(eyes);
        existingGroup.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 100, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();

        String seniorcitizen = syes.isSelected() ? "Yes" : "No";
        String existingaccount = eyes.isSelected() ? "Yes" : "No";

        String span = panTextField.getText();
        String saadhar = aadharTextField.getText();

        try {
            if (span.equals("") || saadhar.equals("")) {
                JOptionPane.showMessageDialog(null, "All fields are required");
            } else {
                Conn c = new Conn();
                String query = "INSERT INTO signuptwo (formno, religion, category, income, education, occupation, pan, aadhar, seniorcitizen, existingaccount) VALUES ('"
                        + formno + "', '" + sreligion + "', '" + scategory + "', '" + sincome + "', '" + seducation
                        + "', '" + soccupation + "', '" + span + "', '" + saadhar + "', '" + seniorcitizen + "', '"
                        + existingaccount + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Details Saved Successfully");
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}

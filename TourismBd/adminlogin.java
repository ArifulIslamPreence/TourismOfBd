/**
 * Created by ariful on 9/1/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Font;

class Admin extends JFrame {
    static String adusername;
    JLabel adnamelabel1, adnamelabel2, adnamelabel3, adnamelabel4;
    JTextField adtext1;
    JButton adbtn1, adbtn2;
    JPasswordField adpf;

    public Admin(Point p) {
        this.setLocation(p);
        this.getContentPane().setBackground( Color.black );

        adnamelabel1 = new JLabel("Admin Panel");
        adnamelabel1.setFont(new Font("Courier New", Font.BOLD, 30));
        adnamelabel1.setForeground(Color.GRAY);
        adnamelabel1.setBounds(20, 100, 600, 20);
        this.add(adnamelabel1);

        adnamelabel2 = new JLabel("Admin Username:");
        adnamelabel2.setFont(new Font("Courier New", Font.BOLD, 16));
        adnamelabel2.setForeground(Color.GRAY);
        adnamelabel2.setBounds(20, 180, 150, 20);
        this.add(adnamelabel2);

        adtext1 = new JTextField();
        adtext1.setBounds(20, 220, 300, 28);
        this.add(adtext1);

        adnamelabel3 = new JLabel("Admin Password:");
        adnamelabel3.setFont(new Font("Courier New", Font.BOLD, 16));
        adnamelabel3.setForeground(Color.GRAY);
        this.add(adnamelabel3);
        adnamelabel3.setBounds(20, 270, 150, 20);

        adpf = new JPasswordField();
        adpf.setBounds(20, 310, 300, 28);
        this.add(adpf);

        adnamelabel4 = new JLabel("Don't have an admin account? Creat now!");
        adnamelabel4.setBounds(20, 410, 300, 20);
        this.add(adnamelabel4);
        adbtn1 = new JButton("Sign In");
        adbtn1.setBounds(210, 360, 100, 40);
        this.add(adbtn1);
        adbtn1.addActionListener(e->
        {
            //DBMethod.login(text1.getText(),pf.getText());

            if (DBMethod.adminlogin(adtext1.getText(),adpf.getText())) {
                //adusername=adtext1.getText();
                new Edit(this.getLocation());
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Username or Password incorrect");
            }

        });

        adbtn2 = new JButton("Sign Up");
        adbtn2.setBounds(20, 440, 100, 40);
        this.add(adbtn2);
        adbtn2.addActionListener(e->
        {
            new Adminsignup(this.getLocation());

            this.setVisible(false);
        });
        this.setSize(800, 600);
        this.setLayout(null);
        this.setVisible(true);


    }

    //Connection con=DB.getConnection();
    //Statement statement;


}
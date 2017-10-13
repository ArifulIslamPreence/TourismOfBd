/**
 * Created by arifu on 9/1/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Font;

class Security extends JFrame {
    static String password;

    JLabel securitylabel;
    JPasswordField securitypass;
    JButton securitybtn;
    public Security(Point p) {
        this.setLocation(p);
        this.getContentPane().setBackground( Color.black );

        securitylabel= new JLabel("Enter The Security Code");
        securitylabel.setBounds(50, 100, 700, 200);
        securitylabel.setFont(new Font("Courier New", Font.BOLD, 50));
        securitylabel.setForeground(Color.GRAY);
        this.add(securitylabel);

        securitypass= new JPasswordField();
        securitypass.setBounds(250,250,300,50);
        this.add(securitypass);

        securitybtn= new JButton("Enter");
        securitybtn.setBounds(350,330,100,40);
        this.add(securitybtn);
        securitybtn.addActionListener(e->
        {
            // DBMethod.adminlogin(securitypass.getText());

            if (DBMethod.security(securitypass.getText()))
            {
                //password=securitypass.getText();
                new Admin(this.getLocation());
                this.setVisible(false);
            }
            else
            {
                JOptionPane.showMessageDialog(this, " Security Key incorrect");
            }
        });

		/*securitybtn.addActionListener(e->{
            new Admin(this.getLocation());

            this.setVisible(false);
        });*/

        this.setSize(800, 600);
        this.setLayout(null);
        this.setVisible(true);
    }

    //Connection con=DB.getConnection();
    //Statement statement;


}

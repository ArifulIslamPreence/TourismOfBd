
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Font;

class Loginas extends JFrame{
    ButtonGroup bg2;
    JRadioButton loginrb1,loginrb2;
    JButton loginlext;

    public Loginas(Point p) {
        this.setLocation(p);
        this.getContentPane().setBackground( Color.black );

        bg2=new ButtonGroup();
        loginrb1 = new JRadioButton("Login as Admin");
        loginrb1.setFont(new Font("Courier New", Font.BOLD, 16));
        loginrb1.setForeground(Color.BLACK);
        loginrb1.setBounds(20, 130, 300, 50);
        this.add(loginrb1);
        bg2.add(loginrb1);



        loginrb2 = new JRadioButton("Login as User");
        loginrb2.setFont(new Font("Courier New", Font.BOLD, 16));
        loginrb2.setForeground(Color.BLACK);
        loginrb2.setBounds(20, 200, 300, 50);
        this.add(loginrb2);
        bg2.add(loginrb2);

        this.setSize(800, 600);
        this.setLayout(null);
        this.setVisible(true);

        loginlext = new JButton("Next");
        loginlext.setBounds(600, 510, 100, 40);
        this.add(loginlext);

        loginlext.addActionListener(e->
        {
            if(loginrb1.isSelected()) {
                new Security(this.getLocation());
                this.setVisible(false);
            }
            else if(loginrb2.isSelected()){
                new Userlogin(this.getLocation());
                this.setVisible(false);
            }

        });

    }

}


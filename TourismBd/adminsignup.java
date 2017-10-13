import javax.swing.*;
import java.awt.*;

class Adminsignup extends JFrame{
    JLabel firstnamead, lastnamead, usernamead,passadd,adminlabel;
    JTextField textfirstname,textlastname,usertext;
    JPasswordField pfad;
    JButton btnad;
    public Adminsignup(Point p){

        this.setLocation(p);


        getContentPane().setBackground(Color.BLACK);

        adminlabel = new JLabel("Admin Sign Up:");
        adminlabel.setFont(new Font("Courier New", Font.BOLD, 50));
        adminlabel.setForeground(Color.WHITE);
        adminlabel.setBounds(20, 50, 500, 50);
        this.add(adminlabel);

        firstnamead = new JLabel("First Name:");
        firstnamead.setFont(new Font("Courier New", Font.BOLD, 16));
        firstnamead.setForeground(Color.WHITE);
        firstnamead.setBounds(20, 110, 300, 50);
        this.add(firstnamead);

        textfirstname = new JTextField();
        textfirstname.setBounds(20, 150, 300, 28);
        this.add(textfirstname);

        lastnamead = new JLabel("Last Name:");
        lastnamead.setFont(new Font("Courier New", Font.BOLD, 16));
        lastnamead.setForeground(Color.WHITE);
        lastnamead.setBounds(20, 200, 300, 50);
        this.add(lastnamead);

        textlastname = new JTextField();
        textlastname.setBounds(20, 240, 300, 28);
        this.add(textlastname);

        usernamead = new JLabel("UserName:");
        usernamead.setFont(new Font("Courier New", Font.BOLD, 16));
        usernamead.setForeground(Color.WHITE);
        usernamead.setBounds(20, 290, 300, 50);
        this.add(usernamead);

        usertext = new JTextField();
        usertext.setBounds(20, 330, 300, 28);
        this.add(usertext);

        passadd = new JLabel("Password:");
        passadd.setFont(new Font("Courier New", Font.BOLD, 16));
        passadd.setForeground(Color.WHITE);
        passadd.setBounds(20, 380, 300, 50);
        this.add(passadd);

        pfad = new JPasswordField();
        pfad.setBounds(20, 420, 300, 28);
        this.add(pfad);

        btnad = new JButton("Done!");
        btnad.setBounds(220, 470, 100, 30);
        this.add(btnad);
        btnad.setFont(new Font("Courier New", Font.BOLD, 14));
        btnad.setForeground(Color.RED);
        btnad.addActionListener(e->
        {


            if(usertext.getText().isEmpty() || textfirstname.getText().isEmpty()||textlastname.getText().isEmpty()||pfad.getText().isEmpty())

            {
                //JOptionPane option =new JOptionPane("All fields are not filled");
                JOptionPane.showMessageDialog(this,"All fields are not filled");

            }
            else {
               //DBMethod.adminsignup(usertext.getText(), firstnamead.getText(),lastnamead.getText(),pfad.getText());
                if(DBMethod.adminsignup(textfirstname .getText(), textlastname .getText(),usertext.getText(),pfad.getText()))
                {
                    JOptionPane.showMessageDialog(this,"Account created!!");
                }
                //FormTest.username=text4.getText();
                new Edit(this.getLocation());
                this.setVisible(false);
            }
            //DBMethod.adminsignup(usertext.getText(), firstnamead.getText(),lastnamead.getText(),pfad.getText());


        });

        this.setSize(800,600);
        this.setLayout(null);
        this.setVisible(true);

    }


}
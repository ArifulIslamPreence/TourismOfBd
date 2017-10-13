import javax.swing.*;
import java.awt.*;


class Userlogin extends JFrame {
    static String username;
    JLabel namelabel1, namelabel2, namelabel3, namelabel4,adminusername,adminpassword;
    JTextField text1;
    JButton btn1, btn2,adminl;
    JPasswordField pf;

    public Userlogin(Point p) {
        this.setLocation(p);
        /*Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;

        // Move the window
        this.setLocation(x, y);*/


        ImageIcon img= new ImageIcon("C:\\Users\\arifu\\Desktop\\art-gallery-icon-20.png");
        this.setIconImage(img.getImage());

        getContentPane().setBackground(Color.GRAY);

        namelabel1 = new JLabel("Welcome to The World of Traveling");
        namelabel1.setFont(new Font("Courier New", Font.BOLD, 30));
        namelabel1.setForeground(Color.BLUE);
        namelabel1.setBounds(20, 100, 600, 20);
        this.add(namelabel1);

        namelabel2 = new JLabel("username:");
        namelabel2.setFont(new Font("Courier New", Font.BOLD, 16));
        namelabel2.setForeground(Color.RED);
        namelabel2.setBounds(20, 180, 100, 20);
        this.add(namelabel2);

        text1 = new JTextField();
        text1.setBounds(20, 220, 300, 28);
        this.add(text1);

        namelabel3 = new JLabel("password:");
        namelabel3.setFont(new Font("Courier New", Font.BOLD, 14));
        namelabel3.setForeground(Color.RED);
        this.add(namelabel3);
        namelabel3.setBounds(20, 270, 100, 20);

        pf = new JPasswordField();
        pf.setBounds(20, 310, 300, 28);
        this.add(pf);




        namelabel4 = new JLabel("Don't have an account yet? Creat now!");
        namelabel4.setFont(new Font("Courier New", Font.BOLD, 14));
        namelabel4.setForeground(Color.DARK_GRAY);
        namelabel4.setBounds(20, 410, 300, 20);
        this.add(namelabel4);

        btn1 = new JButton("Sign In");
        btn1.setFont(new Font("Courier New", Font.BOLD, 14));
        btn1.setForeground(Color.RED);
        btn1.addActionListener(e->
        {
            //DBMethod.login(text1.getText(),pf.getText());

            if (DBMethod.userlogin(text1.getText(),pf.getText())==true) {
                username=text1.getText();
                new District(this.getLocation());
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Username or Password incorrect");
            }

        });

        btn1.setBounds(210, 360, 100, 40);
        this.add(btn1);


       /* adminl.setBounds(600, 360, 100, 40);
        this.add(adminl);*/

        btn2 = new JButton("Sign Up");
        btn2.setBounds(20, 440, 100, 40);
        this.add(btn2);
        btn2.setFont(new Font("Courier New", Font.BOLD, 14));
        btn2.setForeground(Color.RED);
        btn2.addActionListener(e->
        {
            new Usersignup(this.getLocation());

            this.setVisible(false);
        });

        this.setSize(800, 600);
        this.setLayout(null);
        this.setVisible(true);




    }
}
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;

class Welcome extends JFrame {
    JLabel n1;
    JButton b;
    public Welcome() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;

        // Move the window
        this.setLocation(x, y);

        getContentPane().setBackground(Color.BLACK);

        ImageIcon img= new ImageIcon("C:\\Users\\arifu\\Desktop\\art-gallery-icon-20.png");
        this.setIconImage(img.getImage());

        n1= new JLabel("WELCOME!");
        n1.setFont(new Font("Courier New", Font.BOLD, 100));
        n1.setForeground(Color.BLUE);
        n1.setBounds(150, 80, 600, 100);
        this.add(n1);

        b = new JButton("Enter");
        b.setBounds(350, 300, 150, 50);
        this.add(b);
        b.setFont(new Font("Courier New", Font.BOLD, 30));
        b.setForeground(Color.RED);

        b.addActionListener(e->
        {
            new Loginas(this.getLocation());
            this.setVisible(false);

        });



        this.setSize(800, 600);
        this.setLayout(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Welcome();


    }
}
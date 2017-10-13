import javafx.scene.effect.Light;

import javax.swing.*;
import java.awt.*;

class Info extends JFrame{
    JLabel name1,name2,name3,name4,name5,name6,name7,y,y1,y2,y3;
    JButton b;
    public Info(Point p){
        setLocation(p);

        ImageIcon img= new ImageIcon("C:\\Users\\arifu\\Desktop\\art-gallery-icon-20.png");
        this.setIconImage(img.getImage());

        getContentPane().setBackground(Color.black);

        name1 = new JLabel("Here You Go!");
        name1.setFont(new Font("Courier New", Font.BOLD, 40));
        name1.setForeground(Color.BLUE);
        name1.setBounds(280, 20, 300, 50);
        this.add(name1);

        name2 = new JLabel("Name: "+Userlogin.username);
        name2.setFont(new Font("Courier New", Font.BOLD, 16));
        name2.setForeground(Color.RED);
        name2.setBounds(20, 100, 500, 50);
        this.add(name2);

        name3 = new JLabel("Selected Place: "+District.districtname);
        name3.setFont(new Font("Courier New", Font.BOLD, 16));
        name3.setForeground(Color.RED);
        name3.setBounds(20, 150, 500, 50);
        this.add(name3);

        name4 = new JLabel("Selected Spot: "+spot.spotname);
        name4.setFont(new Font("Courier New", Font.BOLD, 16));
        name4.setForeground(Color.RED);
        name4.setBounds(20, 200, 500, 50);
        this.add(name4);

        name5 = new JLabel("Selected Hotel: "+Hotel.hotel);
        name5.setFont(new Font("Courier New", Font.BOLD, 16));
        name5.setForeground(Color.RED);
        name5.setBounds(20, 250, 500, 50);
        this.add(name5);

        name6 = new JLabel("Distance: "+DBMethod.distance(spot.spotname));
        name6.setFont(new Font("Courier New", Font.BOLD, 16));
        name6.setForeground(Color.RED);
        name6.setBounds(20, 300, 500, 50);
        this.add(name6);

        System.out.println(DBMethod.busFare(spot.spotname));
        int totalFare=Bus.noOfPerson*Integer.valueOf(DBMethod.busFare(spot.spotname));
        name7 = new JLabel("Total Cost:(BUSFARE) "+totalFare+"/=  ");
        name7.setFont(new Font("Courier New", Font.BOLD, 16));
        name7.setForeground(Color.RED);
        name7.setBounds(20, 350, 500, 50);
        this.add(name7);

        y = new JLabel("Created by");
        y.setFont(new Font("Courier New", Font.BOLD, 12));
        y.setForeground(Color.GRAY);
        y.setBounds(600, 450, 300, 50);
        this.add(y);
        y1 = new JLabel("Md Ariful Islam Preence");
        y1.setFont(new Font("Courier New", Font.BOLD, 12));
        y1.setForeground(Color.GRAY);
        y1.setBounds(600, 465, 300, 50);
        this.add(y1);
        y2 = new JLabel("Sanzila Hossain Tuya");
        y2.setFont(new Font("Courier New", Font.BOLD, 12));
        y2.setForeground(Color.GRAY);
        y2.setBounds(600, 480, 300, 50);
        this.add(y2);
        y3 = new JLabel("Abduj Zawad");
        y3.setFont(new Font("Courier New", Font.BOLD, 12));
        y3.setForeground(Color.GRAY);
        y3.setBounds(600, 495, 300, 50);
        this.add(y3);

        b = new JButton("Finish!");
        b.setBounds(320, 510, 100, 30);
        this.add(b);
        b.setFont(new Font("Courier New", Font.BOLD, 14));
        b.setForeground(Color.RED);
        b.addActionListener(e->
        {
            this.dispose();

        });

        this.setSize(800, 600);
        this.setLayout(null);
        this.setVisible(true);
    }
}
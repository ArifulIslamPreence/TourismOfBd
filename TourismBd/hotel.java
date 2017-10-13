import javax.swing.*;
import java.awt.*;
import java.util.Vector;

class Hotel extends JFrame{
    static String hotel,hotelfare;
    JLabel namelabel13,namelabel14,namelabel15,namelabel16;
    JButton btn8,btn9;
    public Hotel(Point p ){
        setLocation(p);

        ImageIcon img= new ImageIcon("C:\\Users\\arifu\\Desktop\\art-gallery-icon-20.png");
        this.setIconImage(img.getImage());

        getContentPane().setBackground(Color.DARK_GRAY);

        // System.out.println(FormTest4.spotname);
        namelabel13 = new JLabel(spot.spotname);
        namelabel13.setFont(new Font("Courier New", Font.BOLD, 40));
        namelabel13.setForeground(Color.BLUE);
        namelabel13.setBounds(250, 20, 500, 50);
        this.add(namelabel13);

        namelabel14 = new JLabel("Recommended Hotels");
        namelabel14.setFont(new Font("Courier New", Font.BOLD, 24));
        namelabel14.setForeground(Color.BLUE);
        namelabel14.setBounds(20, 50, 300, 50);
        this.add(namelabel14);
        //String[] rs=DBMethod.hotel();
        //String[] rs2=DBMethod.hotel();
        namelabel15 = new JLabel(DBMethod.Hotel(spot.spotname));
        System.out.println(DBMethod.Hotel(spot.spotname));
        hotel=DBMethod.Hotel(spot.spotname);

        namelabel15.setFont(new Font("Courier New", Font.BOLD, 20));
        namelabel15.setForeground(Color.RED);
        namelabel15.setBounds(20, 160, 400, 20);
        //namelabel15.setText(rs[0]);
        //Vector<String> V=DBMethod.place(spot.spotname);
        //JLabel label=new JLabel();
        //this.add(label);


       this.add(namelabel15);

        btn8 = new JButton("Back");
        btn8.setBounds(20, 510, 100, 30);
        this.add(btn8);
        btn8.setFont(new Font("Courier New", Font.BOLD, 14));
        btn8.setForeground(Color.RED);
        btn8.addActionListener(e->
        {
            new spot(this.getLocation());
            this.setVisible(false);

        });

        btn9 = new JButton("Next");
        btn9.setBounds(600, 510, 100, 30);
        this.add(btn9);
        btn9.setFont(new Font("Courier New", Font.BOLD, 14));
        btn9.setForeground(Color.RED);
        btn9.addActionListener(e->
        {

            new Bus(this.getLocation());
            this.setVisible(false);


        });

        this.setSize(800,600);
        this.setLayout(null);
        this.setVisible(true);
    }
}
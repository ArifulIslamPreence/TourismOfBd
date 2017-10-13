import javax.swing.*;
import java.awt.*;

class Bus extends JFrame{
    static int noOfPerson;
    JLabel namelabel17,namelabel18,namelabel19,namelabel20;
    JComboBox cm1;
    JButton btn10,btn11;
    public Bus(Point p){
        setLocation(p);

        ImageIcon img= new ImageIcon("C:\\Users\\arifu\\Desktop\\art-gallery-icon-20.png");
        this.setIconImage(img.getImage());

        getContentPane().setBackground(Color.cyan);

        namelabel17 = new JLabel("Buy Tickets");
        namelabel17.setFont(new Font("Courier New", Font.BOLD, 40));
        namelabel17.setForeground(Color.BLUE);
        namelabel17.setBounds(250, 20, 300, 50);
        this.add(namelabel17);


        namelabel18 = new JLabel("Fare per person(By Bus): ");
        namelabel18.setFont(new Font("Courier New", Font.BOLD, 20));
        namelabel18.setForeground(Color.BLUE);
        namelabel18.setBounds(20, 100, 400, 50);
        this.add(namelabel18);

        namelabel20 = new JLabel(DBMethod.busFare(spot.spotname)+"/=  ");
        namelabel20.setFont(new Font("Courier New", Font.BOLD, 20));
        namelabel20.setForeground(Color.BLUE);
        namelabel20.setBounds(450, 100, 300, 50);
        this.add(namelabel20);

        namelabel19 = new JLabel("Select Person:  ");
        namelabel19.setFont(new Font("Courier New", Font.BOLD, 16));
        namelabel19.setForeground(Color.RED);
        namelabel19.setBounds(20, 150, 300, 50);
        this.add(namelabel19);

        /*cm1=new JTextField();
        this.add(cm1);
        cm1.set*/

        cm1= new JComboBox();
        this.add(cm1);
        cm1.setBounds(20,200,300,30);

        int i;
        for(i=1;i<=10;i++){
            cm1.addItem(i);
        }

        btn10 = new JButton("Back");
        btn10.setBounds(20, 510, 100, 30);
        this.add(btn10);
        btn10.setFont(new Font("Courier New", Font.BOLD, 14));
        btn10.setForeground(Color.RED);
        btn10.addActionListener(e->
        {
            new Hotel(this.getLocation());
            this.setVisible(false);

        });


        btn11 = new JButton("Next");
        btn11.setBounds(600, 510, 100, 30);
        this.add(btn11);
        btn11.setFont(new Font("Courier New", Font.BOLD, 14));
        btn11.setForeground(Color.RED);
        btn11.addActionListener(e->
        {
            //System.out.println(cm1.getSelectedItem());
            noOfPerson= (int) cm1.getSelectedItem();
            //System.out.println(noOfPerson);
            new Info(this.getLocation());
            this.setVisible(false);



        });


        this.setSize(800, 600);
        this.setLayout(null);
        this.setVisible(true);

    }
}
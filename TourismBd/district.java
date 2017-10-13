import javax.swing.*;
import java.awt.*;
import java.util.Vector;

class District extends JFrame{


    static String districtname;
    JLabel namelabel10;

    JButton btn4,btn5;
    Vector<JRadioButton> r=new Vector<>();

    public District(Point p){
        this.setLocation(p);

        ImageIcon img= new ImageIcon("C:\\Users\\arifu\\Desktop\\art-gallery-icon-20.png");
        this.setIconImage(img.getImage());

        getContentPane().setBackground(Color.lightGray);

        namelabel10 = new JLabel("Choose for Travel");
        namelabel10.setFont(new Font("Courier New", Font.BOLD, 30));
        namelabel10.setForeground(Color.BLUE);
        namelabel10.setBounds(20, 20, 600, 50);
        this.add(namelabel10);
        Vector<String> V=DBMethod.district();
        ButtonGroup bg = new ButtonGroup();

        int a=20,b=50,c=120,d=20;
        for(int i=0;i<V.size();i++)
        {
            JRadioButton rb=new JRadioButton();
            rb.setBounds(a,b+10,c,d);
            b+=30;
            while(b>480) {
                a += 150;
                b=50;
            }
            rb.setText(V.get(i));
            bg.add(rb);
            r.add(rb);
            this.add(rb);
        }

        btn4 = new JButton("Back");
        btn4.setBounds(20, 510, 100, 30);
        this.add(btn4);
        btn4.setFont(new Font("Courier New", Font.BOLD, 14));
        btn4.setForeground(Color.RED);
        btn4.addActionListener(e->
        {
            new Userlogin(this.getLocation());
            this.setVisible(false);

        });

        btn5 = new JButton("Next");
        btn5.setBounds(600, 510, 100, 30);
        this.add(btn5);
        btn5.setFont(new Font("Courier New", Font.BOLD, 14));
        btn5.setForeground(Color.RED);
        btn5.addActionListener(e->
        {

            boolean flag=true;
            for(int i=0;i<r.size();i++) {
                if (r.get(i).isSelected()) {
                    flag = false;
                    districtname = r.get(i).getText();
                    new spot(this.getLocation());
                    this.setVisible(false);
                }
            }
            if(flag==false) flag=false;

                else {
                    JOptionPane.showMessageDialog(this, "All fields are not filled");
                }
        });

        this.setSize(800,600);
        this.setLayout(null);
        this.setVisible(true);
    }

}
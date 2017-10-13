import javax.swing.*;
import java.awt.*;


class Edit extends JFrame {
    static String districtadd,districtdel,spotadd,spotdel,hoteladd,hoteldel;
    JLabel disadd,disdel,sptadd,sptdel,dischoose,sptchoose,htladd,htldel,disidadd;
    JTextField disaddtext,disdeltext,sptaddtext,sptdeltext,dischoosetext,sptchoosetext,htladdtext,htldeltext,disidaddtext;
    JLabel dis,spt,htl;
    JButton dn;
    public Edit(Point p) {
        this.setLocation(p);
        getContentPane().setBackground(Color.BLACK);

        dis= new JLabel("District:");
        dis.setFont(new Font("Courier New", Font.BOLD, 20));
        dis.setForeground(Color.WHITE);
        dis.setBounds(20, 50, 300, 30);
        this.add(dis);

        disadd= new JLabel(" Add:");
        disadd.setFont(new Font("Courier New", Font.BOLD, 16));
        disadd.setForeground(Color.GRAY);
        disadd.setBounds(20, 100, 100, 20);
        this.add(disadd);

        disaddtext=new JTextField();
        disaddtext.setBounds(70,100,150,20);
        this.add(disaddtext);

        disdel= new JLabel("Delete:");
        disdel.setFont(new Font("Courier New", Font.BOLD, 16));
        disdel.setForeground(Color.GRAY);
        disdel.setBounds(280, 100, 100, 20);
        this.add(disdel);

        disdeltext=new JTextField();
        disdeltext.setBounds(350,100,150,20);
        this.add(disdeltext);

        spt= new JLabel("Spotname:");
        spt.setFont(new Font("Courier New", Font.BOLD, 20));
        spt.setForeground(Color.WHITE);
        spt.setBounds(20, 150, 300, 30);
        this.add(spt);

        dischoose=new JLabel("Choose District name:");
        dischoose.setFont(new Font("Courier New", Font.BOLD, 16));
        dischoose.setForeground(Color.WHITE);
        dischoose.setBounds(20,200,300,30);
        this.add(dischoose);

        dischoosetext=new JTextField();
        dischoosetext.setBounds(240,200,200,20);
        this.add(dischoosetext);

        sptadd= new JLabel("Add:");
        sptadd.setFont(new Font("Courier New", Font.BOLD, 16));
        sptadd.setForeground(Color.GRAY);
        sptadd.setBounds(20, 100, 100, 20);
        this.add(sptadd);

        sptaddtext=new JTextField();
        sptaddtext.setBounds(70,250,200,20);
        this.add(sptaddtext);

        sptdel= new JLabel("Delete:");
        sptdel.setFont(new Font("Courier New", Font.BOLD, 16));
        sptdel.setForeground(Color.GRAY);
        sptdel.setBounds(280, 250, 100, 20);
        this.add(sptdel);

        sptdeltext=new JTextField();
        sptdeltext.setBounds(350,250,200,20);
        this.add(sptdeltext);

        htl= new JLabel("Hotelname:");
        htl.setFont(new Font("Courier New", Font.BOLD, 20));
        htl.setForeground(Color.WHITE);
        htl.setBounds(20, 300, 300, 30);
        this.add(htl);

        sptchoose=new JLabel("Choose the Spot:");
        sptchoose.setFont(new Font("Courier New", Font.BOLD, 16));
        sptchoose.setForeground(Color.WHITE);
        sptchoose.setBounds(20,350,300,30);
        this.add(sptchoose);

        sptchoosetext=new JTextField();
        sptchoosetext.setBounds(230,350,200,20);
        this.add(sptchoosetext);

        htladd= new JLabel("Add:");
        htladd.setFont(new Font("Courier New", Font.BOLD, 16));
        htladd.setForeground(Color.GRAY);
        sptadd.setBounds(20, 400, 100, 20);
        this.add(htladd);

        htladdtext=new JTextField();
        htladdtext.setBounds(70,400,200,20);
        this.add(htladdtext);

        htldel= new JLabel("Delete:");
        htldel.setFont(new Font("Courier New", Font.BOLD, 16));
        htldel.setForeground(Color.GRAY);
        htldel.setBounds(280, 400, 100, 20);
        this.add(htldel);

        htldeltext=new JTextField();
        htldeltext.setBounds(350,400,200,20);
        this.add(htldeltext);

        dn = new JButton("DONE");
        dn.setBounds(600, 510, 100, 40);
        this.add(dn);
        dn.addActionListener(e->
        {
            if(disaddtext.getText().isEmpty()&&disdeltext.getText().isEmpty()&&dischoosetext.getText().isEmpty()&&sptaddtext.getText().isEmpty()&&sptdeltext.getText().isEmpty()&&sptchoosetext.getText().isEmpty()&&htladdtext.getText().isEmpty()&&htldeltext.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(this," Fields are missing");
            }
            else
            {
                if(!disaddtext.getText().isEmpty())
                {
                    DBMethod.districtedit(disaddtext.getText(),"add");
                    new Loginas(this.getLocation());
                    this.setVisible(false);
                    JOptionPane.showMessageDialog(this,"Information updated!!");

                }
                else if(!disdeltext.getText().isEmpty())
                {
                    DBMethod.districtedit(disdeltext.getText(),"rmv ");
                    new Loginas(this.getLocation());
                    this.setVisible(false);
                    JOptionPane.showMessageDialog(this,"Information updated!!");
                }
                else if(!sptaddtext.getText().isEmpty())
                {
                    DBMethod.spotedit(dischoosetext.getText(),sptaddtext.getText(),"add");
                    new Loginas(this.getLocation());
                    this.setVisible(false);
                    JOptionPane.showMessageDialog(this,"Information updated!!");
                }
                else if(!sptdeltext.getText().isEmpty())
                {
                    DBMethod.spotedit(dischoosetext.getText(),sptdeltext.getText(),"rmv");
                    new Loginas(this.getLocation());
                    this.setVisible(false);
                    JOptionPane.showMessageDialog(this,"Information updated!!");
                }
                else if(!htladdtext.getText().isEmpty())
                {
                    DBMethod.hoteledit(sptchoosetext.getText(),htladdtext.getText(),"add");
                    new Loginas(this.getLocation());
                    this.setVisible(false);
                    JOptionPane.showMessageDialog(this,"Information updated!!");
                }
                else if(!htldeltext.getText().isEmpty())
                {
                    DBMethod.hoteledit(sptchoosetext.getText(),htldeltext.getText(),"rmv");
                    new Loginas(this.getLocation());
                    this.setVisible(false);
                    JOptionPane.showMessageDialog(this,"Information updated!!");
                }

            }

        });

        this.setSize(800, 600);
        this.setLayout(null);
        this.setVisible(true);
    }


}


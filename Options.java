package BankingSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class MYFRAME3 extends JFrame implements ActionListener
{
    JLabel l;
    JButton b1,b2,b3,b4,b5,b6;
    String pin;
    MYFRAME3(String pin)
    {
        
        super("Options");
        this.pin=pin;
        setLayout(null);
        l=new JLabel("Please, Select One Option");
        l.setFont(new Font("Times New Roman",Font.BOLD,26));
        l.setBounds(180,25,350,30);
        add(l);

        b1=new JButton("Deposit Money");
        b1.setFont(new Font("Times New Roman",Font.BOLD,15));
        b1.setBounds(220,150,200,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2=new JButton("Withdraw Money");
        b2.setFont(new Font("Times New Roman",Font.BOLD,15));
        b2.setBounds(220,200,200,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        b3=new JButton("Show All Transaction");
        b3.setFont(new Font("Times New Roman",Font.BOLD,15));
        b3.setBounds(220,250,200,30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        add(b3);

        b4=new JButton("Change Pin");
        b4.setFont(new Font("Times New Roman",Font.BOLD,15));
        b4.setBounds(220,300,200,30);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        add(b4);

        b5=new JButton("Balance Enquiry");
        b5.setFont(new Font("Times New Roman",Font.BOLD,15));
        b5.setBounds(220,350,200,30);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        add(b5);

        b6=new JButton("Exit");
        b6.setFont(new Font("Times New Roman",Font.BOLD,15));
        b6.setBounds(220,400,200,30);
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        add(b6);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        getContentPane().setBackground(Color.LIGHT_GRAY);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==b1)
        {
            setVisible(false);
            MYFRAME4 f= new MYFRAME4(pin);
            f.setVisible(true);
            f.setSize(550,650);
            f.setLocation(400, 150);
        }
        if(e.getSource()==b2)
        {
            setVisible(false);
            MYFRAME5 f= new MYFRAME5(pin);
            f.setVisible(true);
            f.setSize(550,650);
            f.setLocation(400, 150);
        }
        if(e.getSource()==b3){
            setVisible(false);
            MYFRAME8 f=new MYFRAME8(pin);
            f.setSize(550,650 );
            f.setLocation(400, 100);
            f.setVisible(true);
        }
        if(e.getSource()==b4){
            setVisible(false);
            MYFRAME6 f=new MYFRAME6(pin );
            f.setSize(550,650 );
            f.setLocation(400, 100);
            f.setVisible(true);
        }
        if(e.getSource()==b5){
            setVisible(false);
            MYFRAME7 f=new MYFRAME7(pin);
            f.setSize(550,650 );
            f.setLocation(400, 100);
            f.setVisible(true);
        }
        if(e.getSource()==b6)
        {
            System.exit(0);
        
       
        }

    }
    
}

public class Options {
    public static void main(String[] args) {
        MYFRAME3 f=new MYFRAME3("");
        f.setSize(650,750 );
        f.setLocation(400, 50);
        //f.setUndecorated(true);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

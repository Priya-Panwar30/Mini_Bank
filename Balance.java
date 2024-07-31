package BankingSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class MYFRAME7 extends JFrame implements ActionListener
{
    String pin;
    JButton b1;
    JLabel l1;

    MYFRAME7(String pin)
    {
    super("Balance Enquiry");
    setLayout(null);
    this.pin=pin;

    b1=new JButton("Back");
    b1.setFont(new Font("Times New Roman",Font.BOLD,23));
    b1.setBounds(60,350,110,30);
    b1.setBackground(Color.BLACK);
    b1.setForeground(Color.WHITE);
    b1.addActionListener(this);
    add(b1);

    int balance=0;
    try{
        conn c1 = new conn();
        ResultSet rs = c1.s.executeQuery("select * from bank where pinnum = '"+pin+"'");
        
        while (rs.next()) {
            if (rs.getString("type").equals("Deposit")) {
                balance += Integer.parseInt(rs.getString("amount"));
            } else {
                balance -= Integer.parseInt(rs.getString("amount"));
            }
        }
    }catch(Exception e){}

    l1=new JLabel("Your Current Balance is Rs "+balance);
    l1.setFont(new Font("Times New Roman",Font.BOLD,25));
    l1.setBounds(60,100,400,30);
    add(l1);

    
    getContentPane().setBackground(Color.LIGHT_GRAY);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        MYFRAME3 f=new MYFRAME3(pin);
        f.setSize(650,750 );
        f.setLocation(400, 50);
        f.setVisible(true);
    }
}

public class Balance {
    public static void main(String[] args) {
        MYFRAME7 f=new MYFRAME7("");
        f.setSize(550,650 );
        f.setLocation(400, 100);
        f.setVisible(true);
    }
}

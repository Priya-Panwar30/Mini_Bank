package BankingSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class MYFRAME8 extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4;
    JButton b1;
    String pin;
    MYFRAME8(String pin)
    {
        super("Mini Statement");
        this.pin=pin;
        setLayout(null) ;

        l1=new JLabel();
        l1.setFont(new Font("Times New Roman",Font.PLAIN,16));
        l1.setBounds(50,150,400,200);
        add(l1);

        l2=new JLabel("Mini Bank");
        l2.setFont(new Font("Times New Roman",Font.BOLD,26));
        l2.setBounds(210,25,350,30);
        add(l2);

        l3=new JLabel();
        l3.setFont(new Font("Times New Roman",Font.PLAIN,22));
        l3.setBounds(110,80,350,30);
        add(l3);

        l4=new JLabel();
        l4.setFont(new Font("Times New Roman",Font.PLAIN,20));
        l4.setBounds(50,350,400,40);
        add(l4);


        b1=new JButton("BACK");
        b1.setFont(new Font("Times New Roman",Font.PLAIN,18));
        b1.setBounds(50,430,110,40);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);
        try{
            conn c1=new conn();
            ResultSet rs= c1.s.executeQuery("select * from account where pinnum='"+pin+"'");
            while(rs.next()){
                l3.setText(" Account Number: "+ rs.getString("accountnum"));
            }

        }
        catch(Exception ae){
            System.out.println(ae);
        }



        try{

            int balance=0;
            conn c1=new conn();
            ResultSet rs=c1.s.executeQuery("select * from bank where pinnum='"+pin+"'");
            while(rs.next()){
                l1.setText(l1.getText()+ "<html>" +rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");

                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            l4.setText("Your total Balance is Rs "+balance);

            }

        catch(Exception ae){}
        getContentPane().setBackground(Color.LIGHT_GRAY);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            setVisible(false);
            MYFRAME3 f=new MYFRAME3(pin);
            f.setSize(650,750 );
            f.setLocation(400, 50);
            f.setVisible(true);


        }
    }
}

public class Statement {
    public static void main(String[] args) {
        MYFRAME8 f=new MYFRAME8("");
        f.setSize(550,650 );
        f.setLocation(400, 100);
        f.setVisible(true);
    }
}

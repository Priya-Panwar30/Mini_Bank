package BankingSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class MYFRAME2 extends JFrame implements ActionListener
{
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField tf2;
    JButton b,b1;

    MYFRAME2(){
    super("Existing Customer login");
    setLayout(null);

    l1=new JLabel("WELCOME");
    l1.setFont(new Font("Times New Roman",Font.BOLD,30));
    l1.setBounds(220, 20, 300, 30);
    add(l1);

    l2= new JLabel("Account Number:");
    l2.setFont(new Font("Times New Roman",Font.BOLD,25));
    l2.setBounds(60,150,300,30);
    add(l2);

    l3= new JLabel("PIN Number:");
    l3.setFont(new Font("Times New Roman",Font.BOLD,25));
    l3.setBounds(90,190,300,30);
    add(l3);

    tf1=new JTextField(20);
    tf1.setBounds(260, 150, 280, 30);
    add(tf1);

    tf2=new JPasswordField(20);
    tf2.setBounds(260, 190, 280, 30);
    add(tf2);

    b=new JButton(" LOGIN ");
    b.setBounds(420, 350,100 , 30);
    b.setBackground(Color.BLACK);
    b.setForeground(Color.WHITE);
    add(b);

    b1=new JButton(" BACK ");
    b1.setBounds(80, 350,100 , 30);
    b1.setBackground(Color.BLACK);
    b1.setForeground(Color.WHITE);
    add(b1);

    
    getContentPane().setBackground(Color.LIGHT_GRAY);

    b.addActionListener(this);
    b1.addActionListener(this);
    
    }

    public void actionPerformed(ActionEvent e) {
        
        String accno=tf1.getText();
        if(e.getSource()==b1){
            setVisible(false);
            MYFRAME1 f= new MYFRAME1();
            f.setSize(600,600);
            f.setVisible(true);
            f.setLocation(400, 150);
        }
     
        try{
        if (accno.equals("")){
                JOptionPane.showMessageDialog(null, "All Fields are Mandantory");     
        }

        else if(e.getSource()==b){
            conn c=new conn();
            String acc=tf1.getText();
            String pin=tf2.getText();

            String query="select * from account where accountnum='"+acc+"' and pinnum='"+pin+"'";

            ResultSet rs=c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                MYFRAME3 f=new MYFRAME3(pin);
                f.setSize(650,750 );
                f.setLocation(400, 50);
                f.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null,"Incorrect Account Number or PIN");
            }
        }
    }
        catch(Exception ae)
        {

            System.out.println(ae);
        }


    }
}  


public class Existingcust 
{
    public static void main(String[] args) {
        MYFRAME2 f=new MYFRAME2();
        f.setSize(650,750 );
        f.setLocation(400, 50);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

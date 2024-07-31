package BankingSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

class MYFRAME6 extends JFrame implements ActionListener
{
    JPasswordField t1,t2;
    JButton b1,b2;
    JLabel l1,l2,l3;
    String pin;
    MYFRAME6(String pin)
    {
        super("Pin Change");
        setLayout(null);

        this.pin=pin;
        l1=new JLabel("Change Your Pin ");
        l1.setFont(new Font("Times New Roman",Font.BOLD,28));
        l1.setBounds(155,80,300,30);
        add(l1);

        l2=new JLabel("New Pin: ");
        l2.setFont(new Font("Times New Roman",Font.BOLD,25));
        l2.setBounds(50,190,300,30);
        add(l2);

        l3=new JLabel("Re-Enter Pin: ");
        l3.setFont(new Font("Times New Roman",Font.BOLD,25));
        l3.setBounds(50,250,300,30);
        add(l3);

        t1=new JPasswordField();
        t1.setFont(new Font("Times New Roman",Font.PLAIN,19));
        t1.setBounds(220,190,300,30);
        add(t1);

        t2=new JPasswordField();
        t2.setFont(new Font("Times New Roman",Font.PLAIN,19));
        t2.setBounds(220,250,300,30);
        add(t2);

        b1=new JButton("Back");
        b1.setFont(new Font("Times New Roman",Font.BOLD,23));
        b1.setBounds(55,400,100,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Submit");
        b2.setFont(new Font("Times New Roman",Font.BOLD,23));
        b2.setBounds(350,400,110,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(Color.LIGHT_GRAY);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b2){
        try{

            String npin=t1.getText();
            String rpin=t2.getText();

            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered Pin Does not Match");
                return;
            }

            if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter New Pin" );
                return;
            }
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null,"Please Re-Enter New Pin" );
                return;
            }

            conn c1=new conn();
            String query="update bank set pinnum='"+rpin+"'where pinnum='"+pin+"'";
            String query1="update account set pinnum='"+rpin+"'where pinnum='"+pin+"'";
            
            c1.s.executeUpdate(query);
            c1.s.executeUpdate(query1);

            JOptionPane.showMessageDialog(null,"Pin Change Sucessfully" );
            setVisible(false);
            MYFRAME3 f=new MYFRAME3(rpin);
            f.setSize(650,750 );
            f.setLocation(400, 50);
            f.setVisible(true);

        }
        catch(Exception ae){}
    }
        else if(e.getSource()==b1){
            setVisible(false);
            MYFRAME3 f=new MYFRAME3(pin);
            f.setSize(650,750 );
            f.setLocation(400, 50);
            f.setVisible(true);


    }
    }

}

public class Pinchange {
    
    public static void main(String[] args) {
        MYFRAME6 f=new MYFRAME6("");
        f.setSize(550,650 );
        f.setLocation(400, 100);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

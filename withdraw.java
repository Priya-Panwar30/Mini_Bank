package BankingSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
class MYFRAME5 extends JFrame  implements ActionListener
{
    JLabel l;
    JTextField t1;
    JButton b1,b2;
    String pin;
    MYFRAME5(String pin)
    {
        super("Withdraw Money");
        this.pin=pin;
        setLayout(null);
        l=new JLabel("Enter Amount to Withdraw: ");
        l.setFont(new Font("Times New Roman",Font.BOLD,25));
        l.setBounds(125,100,300,30);
        add(l);

        t1=new JTextField();
        t1.setFont(new Font("Times New Roman",Font.PLAIN,22));
        t1.setBounds(107,150,300,30);
        add(t1);

        b1=new JButton("BACK");
        b1.setFont(new Font("Times New Roman",Font.PLAIN,20));
        b1.setBounds(50,250,130,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("SUBMIT");
        b2.setFont(new Font("Times New Roman",Font.PLAIN,20));
        b2.setBounds(350,250,130,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);



        getContentPane().setBackground(Color.LIGHT_GRAY);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b2){
            String number=t1.getText();
            String number2="10000";
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "ENTER THE AMOUNT TO WITHDRAW");
            }
            else{
                try{
                    conn c1=new conn();
                    
                    
                    ResultSet rs = c1.s.executeQuery("select * from bank where pinnum = '"+pin+"'");
                    int balance = 0;
                    while(rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            balance += Integer.parseInt(rs.getString("amount"));
                        }else{
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if(balance < Integer.parseInt(number)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    if(Integer.parseInt(number) > Integer.parseInt(number2)){
                        JOptionPane.showMessageDialog(null, "Cannot Withdraw more than 10000");
                        return;
                    }
                    String query="insert into bank values('"+pin+"','"+date+"','Withdraw','"+number+"')";
                    c1.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+number+" Withdraw Succesfully");
                    setVisible(false);
                    MYFRAME3 f=new MYFRAME3(pin);
                    f.setVisible(true);
                    f.setSize(650,750 );
                    f.setLocation(400, 50);
                }
                catch(Exception ae){}
            }
        }
        else if(e.getSource()==b1){
            setVisible(false);
            MYFRAME3 f=new MYFRAME3(pin);
            f.setVisible(true);
            f.setSize(650,750 );
            f.setLocation(400, 50);
        }
    }
}

public class withdraw {
    public static void main(String[] args) {
        MYFRAME5 f=new MYFRAME5("");
        f.setSize(550,650 );
        f.setLocation(400, 100);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

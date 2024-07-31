package BankingSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class MYFRAME1 extends JFrame implements ActionListener
{
    JLabel l;
    JButton b1,b2;
   // JPanel p1,p2;
    
    MYFRAME1()
    {
        super("Banking System");
        setLayout(null);


        //ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("C:/Users/Dell/OneDrive/Pictures/Screenshots/Screenshot 2024-07-25 085444.png"));
        

        l=new JLabel("WELCOME TO MINIBANK");
        l.setFont(new Font("Times New Roman",Font.BOLD,25));
       // l.setLocation(200,100);
        l.setBounds(150, 30, 350, 30);

        b1=new JButton("NEW CUSTOMER");
      //  b1.setLocation(200,400);
        b1.setBounds(160,150,250,30);
        b1.setFont(new Font("Times New Roman",Font.BOLD,17));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2=new JButton("EXISTING CUSTOMER");
       // b2.setLocation(200, 400);
        b2.setBounds(160,200,250,30);
        b2.setFont(new Font("Times New Roman",Font.BOLD,17));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);



        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        add(l);
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

   // @Override
        public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==b1){
            setVisible(false);
            MYFRAME f= new MYFRAME();
            f.setVisible(true);
            f.setSize(650,750 );
            f.setLocation(400, 50);
        }
        if(e.getSource()==b2){
            setVisible(false);
            MYFRAME2 f1= new MYFRAME2();
            f1.setVisible(true);
            f1.setSize(650,750 );
            f1.setLocation(400, 50);
        }
        
    }

}
public class welcome extends JFrame {
    public static void main(String[] args) {
        MYFRAME1 f= new MYFRAME1();
        f.setSize(600,600);
        f.setVisible(true);
        f.setLocation(400, 150);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

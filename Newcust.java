package BankingSystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

class MYFRAME extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JLabel form;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
    JButton b1,b2;
    JPanel jp1,jp2,jp3;
    JRadioButton r1;
    JRadioButton r2;
    JDateChooser dateChooser;
    Random ran=new Random();
    long formn=Math.abs((ran.nextLong() %9000L)+1000L);
    long acc=Math.abs((ran.nextLong() % 90000000L)+5040936000000000L);
    long pin=Math.abs((ran.nextLong()%9000L)+1000L);
    

        
    
        MYFRAME()
        {
        super("New Customer Details");
        

        Font f=new Font("Times New Roman",Font.BOLD,26);
        Font f1=new Font("Times New Roman",Font.PLAIN,20);

       // ran=new Random();
       // long random=Math.abs((ran.nextLong() %9000L)+1000L);


        setLayout(null);;
        l1=new JLabel("ADD CUSTOMER DETAILS");
        l1.setFont(new Font("Times New Roman",Font.BOLD,28));
        l1.setBounds(95,15,400,40);
        add(l1);

        form=new JLabel("Form No: "+formn);
        form.setBounds(450,0,150,20);
        add(form);

        l2=new JLabel("Name: ");
        l2.setFont(f);
        l2.setBounds(50,120,100,30);
        add(l2);

        l3=new JLabel("Father's name: ");
        l3.setFont(f);
        l3.setBounds(50,160,300,30);
        add(l3);

        l4=new JLabel("Date of Birth: ");
        l4.setFont(f);
        l4.setBounds(50,200,300,30);
        add(l4);

        JDateChooser dateChooser=new JDateChooser();
        dateChooser.setBounds(250,200,300,30);
        dateChooser.setFont(f1);
        add(dateChooser);

        l8=new JLabel("Gender");
        l8.setFont(f);
        l8.setBounds(50,240,300,30);
        add(l8);

        l5=new JLabel("Phone no: ");
        l5.setFont(f);
        l5.setBounds(50,280,300,30);
        add(l5);

        l6=new JLabel("Aadhar Number: ");
        l6.setFont(f);
        l6.setBounds(50,320,300,30);
        add(l6);

        l7=new JLabel("Address: ");
        l7.setFont(f);
        l7.setBounds(50,360,300,30);
        add(l7);

        tf1=new JTextField(20);
        tf1.setBounds(250,120,300,30);
        tf1.setFont(f1);
        add(tf1);

        tf2=new JTextField(20);
        tf2.setBounds(250,160,300,30);
        tf2.setFont(f1);
        add(tf2);

        tf3=new JTextField(20);
        tf3.setBounds(250,200,300,30);
        tf3.setFont(f1);
        add(tf3);

        r1=new JRadioButton("Male");
        r1.setFont(new Font("Times New Roman",Font.BOLD,23));
        r1.setBounds(250, 240, 80, 30);
        r1.setBackground(Color.LIGHT_GRAY);
        add(r1);

        r2=new JRadioButton("Female");
        r2.setFont(new Font("Times New Roman",Font.BOLD,23));
        r2.setBounds(350,240,100,30);
        r2.setBackground(Color.LIGHT_GRAY);
        add(r2);

        ButtonGroup gender=new ButtonGroup();
        gender.add(r1);
        gender.add(r2);


        tf4=new JTextField(20);
        tf4.setBounds(250,280,300,30);
        tf4.setFont(f1);
        add(tf4);

        tf5=new JTextField(20);
        tf5.setBounds(250,320,300,30);
        tf5.setFont(f1);
        add(tf5);

        tf6=new JTextField(20);
        tf6.setBounds(250,360,300,30);
        tf6.setFont(f1);
        add(tf6);
    

        b1=new JButton(" SUBMIT ");
        b1.setBounds(410,450,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2=new JButton(" BACK ");
        b2.setBounds(80,450,120,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        
        
        getContentPane().setBackground(Color.LIGHT_GRAY);

        b1.addActionListener(this);
        b2.addActionListener(this);


    }


        @Override
        public void actionPerformed(ActionEvent ae) {
            
        String formno = "" + formn;
        String name = tf1.getText();
        String father_name =tf2.getText();
        String dob = tf3.getText();
        String gender = null;
        if(r1.isSelected()){
            gender = "Male";
        }else if(r2.isSelected()){
            gender = "Female";
        }
        String phone = tf4.getText();
        String address = tf6.getText();
        String aadhar = tf5.getText();

        String accountnum ="" + acc;
        String pinnum="" + pin;
        
        try{

            if (name.equals("")){
                JOptionPane.showMessageDialog(null,"ALL FIELD ARE MANDANTORY");
            }
            else if(father_name.equals("")){
                JOptionPane.showMessageDialog(null,"ALL FIELD ARE MANDANTORY");
            }
            /*   else if(dob.equals("")){
                JOptionPane.showMessageDialog(null,"ALL FIELD ARE MANDANTORY");
            }*/
            else if(gender.equals("")){
                JOptionPane.showMessageDialog(null,"ALL FIELD ARE MANDANTORY");
            }
            else if(phone.equals("")){
                JOptionPane.showMessageDialog(null,"ALL FIELD ARE MANDANTORY");
            }
            else if(address.equals("")){
                JOptionPane.showMessageDialog(null,"ALL FIELD ARE MANDANTORY");
            }
            else if(aadhar.equals("")){
                JOptionPane.showMessageDialog(null,"ALL FIELD ARE MANDANTORY");
            }
            else{

                conn c=new conn();
                String query="insert into signup values('"+formno+"','"+name+"','"+father_name+"','"+gender+"','"+phone+"','"+address+"','"+aadhar+"')";
                String query1="insert into account values('"+formno+"','"+accountnum+"','"+pinnum+"')";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query1);

                JOptionPane.showMessageDialog(null, "Account Number: "+accountnum+"\nPin: "+pinnum);

                setVisible(false);
                
                MYFRAME2 f=new MYFRAME2();
                f.setVisible(true);
                f.setSize(650,750 );
                f.setLocation(400, 50);
            }

        }
        catch(Exception e){}

        
        }


}


public class Newcust {
    public static void main(String[] args) {
        MYFRAME f=new MYFRAME();
        f.setSize(650,750 );
        f.setLocation(400, 50);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

}
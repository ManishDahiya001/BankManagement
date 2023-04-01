package BankManagement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
@SuppressWarnings("serial")
public class Pinchange extends JFrame implements ActionListener
{
	JButton back,change;
	JPasswordField pin,repin;
	String pinnumber;
	
   Pinchange(String pinnumber)
   {
	   this.pinnumber=pinnumber;
	   setLayout(null);
	   
	   
	   ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons//atm.jpg"));
	   Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
	   ImageIcon i3=new ImageIcon(i2);
	   
	   JLabel img = new JLabel(i3);
	   img.setBounds(0,0,900,900);
	   add(img);
	   
	   JLabel text = new JLabel("Change Your Pin");
	   text.setForeground(Color.white);
	   text.setFont(new Font("System",Font.BOLD,16));
	   text.setBounds(250,280,500,35);
	   img.add(text);
	   
	   JLabel pintext = new JLabel("New Pin :");
	   pintext.setForeground(Color.white);
	   pintext.setFont(new Font("System",Font.BOLD,16));
	   pintext.setBounds(165,320,180,25);
	   img.add(pintext);
	   
	   pin = new JPasswordField();
	   pin.setFont(new Font("Raleway",Font.BOLD,25));
	   pin.setBounds(330,320,180,25);
	   img.add(pin);
	   
	   
	   JLabel repintext = new JLabel("RE-Enter New Pin :");
	   repintext.setForeground(Color.white);
	   repintext.setFont(new Font("System",Font.BOLD,16));
	   repintext.setBounds(165,360,180,25);
	   img.add(repintext);
	   
	   repin = new JPasswordField();
	   repin.setFont(new Font("Raleway",Font.BOLD,25));
	   repin.setBounds(330,360,180,25);
	   img.add(repin);
	   
	   change = new JButton("Change");
	   change.setBounds(355,485,150,28);
	   change.setBackground(Color.white);
	   change.addActionListener(this);
	   img.add(change);
	   
	   back = new JButton("Back");
	   back.setBounds(355,520,150,28);
	   back.setBackground(Color.white);
	   back.addActionListener(this);
	   img.add(back);
	   
	   setUndecorated(true);
	   setSize(900,900);
	   setLocation(300,0);
	   setVisible(true);
	  
   }
public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==change)
	{
		try 
		{
			@SuppressWarnings("deprecation")
			String npin = pin.getText();
			@SuppressWarnings("deprecation")
			String rpin = repin.getText();
			
			if(!npin.equals(rpin))
			{
				JOptionPane.showMessageDialog(null,"Entered Pin Does Not Match");
				return;
			}
			if(npin.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please Enter New Pin");
				return;
			}
			if(rpin.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please Re-Enter New Pin");
				return;
			}
			
			Conn c = new Conn();
			String query1="update bank set pin='"+rpin+"' where pin='"+pinnumber+"'";
			String query2="update login set pin='"+rpin+"' where pin='"+pinnumber+"'";
			String query3="update signupthree set pin='"+rpin+"' where pin='"+pinnumber+"'";
			
			c.s.executeUpdate(query1);
			c.s.executeUpdate(query2);
			c.s.executeUpdate(query3);
			
			JOptionPane.showMessageDialog(null,"Pin Changed Sucessfully");
			
			setVisible(true);
			new Transaction(rpin).setVisible(true);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	else 
	{
		setVisible(false);
		new Transaction(pinnumber).setVisible(true);
	}
}
   
   
public static void main(String [] args)
{
  new Pinchange("").setVisible(true);	
}
}

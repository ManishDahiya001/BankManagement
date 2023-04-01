package BankManagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener
{
	JButton login,signup,clear;
	JTextField cardtextfield;
	JPasswordField pintextfield;
	Login()
	{ 
		setTitle("Automated Teller Machine");
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons//logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(70,10,100,100);
		add(label);
		
		JLabel text = new JLabel("Welcome To ATM");
		text.setFont(new Font("Osward",Font.BOLD,38));
		text.setBounds(200,40,400,40);
		add(text);
		

		JLabel cardno = new JLabel("Card No :");
		cardno.setFont(new Font("Raleway",Font.BOLD,28));
		cardno.setBounds(120,150,150,30);
		add(cardno);
		
		cardtextfield = new JTextField();
		cardtextfield.setBounds(300,150,230,30);
		cardtextfield.setFont(new Font("Arial",Font.BOLD,15));
		add(cardtextfield);

		JLabel pin = new JLabel("Pin :");
		pin.setFont(new Font("Raleway",Font.BOLD,28));
		pin.setBounds(120,220,250,30);
		add(pin);
		
		pintextfield = new JPasswordField();
		pintextfield.setBounds(300,220,230,30);
		pintextfield.setFont(new Font("Arial",Font.BOLD,15));
		add(pintextfield);
		
		login = new JButton("Sign In");
		login.setBounds(300,300,100,30);
		login.setForeground(Color.white);
		login.setBackground(Color.black);
		login.addActionListener(this);
		add(login);
		

		clear = new JButton("CLEAR");
		clear.setBounds(430,300,100,30);
		clear.setForeground(Color.white);
		clear.setBackground(Color.black);
		clear.addActionListener(this);
		add(clear);
		

		signup = new JButton("SIGN UP");
		signup.setBounds(300,350,230,30);
		signup.setForeground(Color.white);
		signup.setBackground(Color.black);
		signup.addActionListener(this);
		add(signup);
		
		getContentPane().setBackground(Color.white);
		
		setSize(800,480);
		setVisible(true);
		setLocation(300,200);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == clear)
		{
			cardtextfield.setText("");
			pintextfield.setText("");
			
		}
		else if(ae.getSource()== login)
		{
			Conn con = new Conn();
			String cardnumber=cardtextfield.getText();
			@SuppressWarnings("deprecation")
			String pinnumber=pintextfield.getText();
			String query="select * from login where cardnumber ='"+cardnumber+"' and pin = '"+pinnumber+"'";
			try {
				ResultSet rs =con.s.executeQuery(query);
				if(rs.next())
				{
					setVisible(false);
					new Transaction(pinnumber).setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Incorrect Card Number Or Pin");
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}	
		}
		else if(ae.getSource()== signup)
		{
			setVisible(false);
			new Signup1().setVisible(true);
		}
	}
	
	public static void main(String[] args)
	{

       new Login();
	}

}
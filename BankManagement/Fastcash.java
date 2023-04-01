package BankManagement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
@SuppressWarnings("serial")
public class Fastcash extends JFrame implements ActionListener
{ 
	JButton rs100,rs500,rs1000,rs2000,rs5000,rs10000,back;
	String pinnumber;
	
	Fastcash(String pinnumber)
	{
		this.pinnumber=pinnumber;
		setLayout(null);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons//atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("Select Withdrwal Amount");
		text.setBounds(210,300,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		rs100 = new JButton("Rs 100");
		rs100.setBounds(170,415,150,30);
		rs100.setFont(new Font("System",Font.BOLD,13));
		rs100.setBackground(Color.white);
		rs100.addActionListener(this);
		image.add(rs100);
		
		rs500 = new JButton("Rs 500");
		rs500.setBounds(355,415,150,30);
		rs500.setFont(new Font("System",Font.BOLD,13));
		rs500.setBackground(Color.white);
		rs500.addActionListener(this);
		image.add(rs500);
		
		rs1000 = new JButton("Rs 1000");
		rs1000.setBounds(170,450,150,30);
		rs1000.setFont(new Font("System",Font.BOLD,13));
		rs1000.setBackground(Color.white);
		rs1000.addActionListener(this);
		image.add(rs1000);
		
		rs2000 = new JButton("Rs 2000");
		rs2000.setBounds(355,450,150,30);
		rs2000.setFont(new Font("System",Font.BOLD,13));
		rs2000.setBackground(Color.white);
		rs2000.addActionListener(this);
		image.add(rs2000);
		
		rs5000 = new JButton("Rs 5000");
		rs5000.setBounds(170,485,150,30);
		rs5000.setFont(new Font("System",Font.BOLD,13));
		rs5000.setBackground(Color.white);
		rs5000.addActionListener(this);
		image.add(rs5000);
		
		rs10000 = new JButton("Rs 10000");
		rs10000.setBounds(355,485,150,30);
		rs10000.setFont(new Font("System",Font.BOLD,13));
		rs10000.setBackground(Color.white);
		rs10000.addActionListener(this);
	 	image.add(rs10000);
		
		back = new JButton("Back");
		back.setBounds(355,520,150,30);
		back.setFont(new Font("System",Font.BOLD,13));
		back.setBackground(Color.white);
		back.addActionListener(this);
		image.add(back);
		
		
		
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==back)
		{
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		}
		else 
		{
			String amount=((JButton)ae.getSource()).getText().substring(3);
			Conn c = new Conn();
			try
			{
				ResultSet rs=c.s.executeQuery("Select * from bank where pin= '"+pinnumber+"'");
				int balance=0;
				while(rs.next())
				{
					if(rs.getString("type").equals("Deposit"))
					{
						balance += Integer.parseInt(rs.getString("amount")); 
					}
					else
					{
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}
				
				if(ae.getSource()!= back && balance < Integer.parseInt(amount))
				{
					JOptionPane.showMessageDialog(null,"InSufficient Balance");
					return;
				}
				
				Date date = new Date();
				String query="insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Sucessfully");
				
				setVisible(false);
				new Transaction(pinnumber).setVisible(true);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}

	public static void main(String[] args) 
	{
		new Fastcash("");

	}

}

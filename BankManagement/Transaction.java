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
@SuppressWarnings("serial")
public class Transaction extends JFrame implements ActionListener
{ 
	JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
	String pinnumber;
	
	Transaction(String pinnumber)
	{
		this.pinnumber=pinnumber;
		setLayout(null);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons//atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("Please Select your Transaction");
		text.setBounds(210,300,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(170,415,150,30);
		deposit.setFont(new Font("System",Font.BOLD,13));
		deposit.setBackground(Color.white);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawl = new JButton("Cash Withdrawl");
		withdrawl.setBounds(355,415,150,30);
		withdrawl.setFont(new Font("System",Font.BOLD,13));
		withdrawl.setBackground(Color.white);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		fastcash = new JButton("Fast Cash");
		fastcash.setBounds(170,450,150,30);
		fastcash.setFont(new Font("System",Font.BOLD,13));
		fastcash.setBackground(Color.white);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		ministatement = new JButton("Mini Statement");
		ministatement.setBounds(355,450,150,30);
		ministatement.setFont(new Font("System",Font.BOLD,13));
		ministatement.setBackground(Color.white);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		pinchange = new JButton("Pin Change");
		pinchange.setBounds(170,485,150,30);
		pinchange.setFont(new Font("System",Font.BOLD,13));
		pinchange.setBackground(Color.white);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceenquiry = new JButton("Balance Enquiry");
		balanceenquiry.setBounds(355,485,150,30);
		balanceenquiry.setFont(new Font("System",Font.BOLD,13));
		balanceenquiry.setBackground(Color.white);
		balanceenquiry.addActionListener(this);
	 	image.add(balanceenquiry);
		
		exit = new JButton("Exit");
		exit.setBounds(355,520,150,30);
		exit.setFont(new Font("System",Font.BOLD,13));
		exit.setBackground(Color.white);
		exit.addActionListener(this);
		image.add(exit);
		
		
		
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==exit)
		{
			System.exit(0);
		}
		else if(ae.getSource()==deposit)
		{
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
		}
		else if(ae.getSource()==withdrawl)
		{
			setVisible(false);
			new Withdrawl(pinnumber).setVisible(true);
		}
		else if(ae.getSource()==fastcash)
		{
			setVisible(false);
			new Fastcash(pinnumber).setVisible(true);
		}
		else if(ae.getSource()==pinchange)
		{
			setVisible(false);
			new Pinchange(pinnumber).setVisible(true);
		}
		else if(ae.getSource()==balanceenquiry)
		{
			setVisible(false);
			new BalanceEnquiry(pinnumber).setVisible(true);
		}
		else if(ae.getSource()==ministatement)
		{
			
			new MiniStatement(pinnumber).setVisible(true);
		}

	}

	public static void main(String[] args) 
	{
		new Transaction("");

	}

}


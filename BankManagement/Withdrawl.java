package BankManagement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
@SuppressWarnings("serial")
public class Withdrawl extends JFrame implements ActionListener
{
	JButton withdraw,back;
	JTextField amount;
	String pinnumber;
	
	Withdrawl(String pinnumber)
	{
		this.pinnumber=pinnumber;
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons//atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("Enter The Amount You Want To Withdraw ");
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(170,300,400,30);
		image. add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway",Font.BOLD,22));
		amount.setBounds(170,350,320,25);
		image.add(amount);
		
		withdraw = new JButton("Withdraw");
		withdraw.setBounds(355,485,150,30);
		withdraw.setBackground(Color.white);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		back = new JButton("Back");
		back.setBounds(355,520,150,30);
		back.setBackground(Color.white);
		back.addActionListener(this);
		image.add(back);
		
		setUndecorated(true);
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==withdraw)
		{
			String number=amount.getText();
			Date date = new Date();
			if(number.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please Enter The Amount You Want To Withdraw");
			}
			else
			{
				Conn con = new Conn();
				String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
				try {
					con.s.executeUpdate(query);
					setVisible(false);
					new Transaction(pinnumber).setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Rs "+number+" Withdraw Sucessfully");
			}
		}
		else if(ae.getSource()== back)
		{
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);;
		}
	}

	public static void main(String[] args)
	{
		new Withdrawl("");

	}

}


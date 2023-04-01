package BankManagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;


@SuppressWarnings("serial")
public class Signup2 extends JFrame implements ActionListener
{
	JTextField aadhar,pan;
	JButton next;
	JRadioButton syes,sno,eyes,eno;
	JDateChooser datechooser;
	JComboBox<?> religion,catagory,income,education,occupation;
	String formno;
	Signup2(String formno)
	{
		this.formno=formno;
		setLayout(null);
		
		setTitle("New Application Form No : 2");
		

		JLabel additiondetails = new JLabel("Page 2 :Additional Details");
		additiondetails.setFont(new Font("Raleway",Font.BOLD,22));
		additiondetails.setBounds(290,80,300,30);
		add(additiondetails);
		
		
		JLabel religon = new JLabel("Religion :");
		religon.setFont(new Font("Raleway",Font.BOLD,22));
		religon.setBounds(100,140,200,30);
		add(religon);
		
		String valreligion[] ={"Hindu","Muslim","Sikh","Christian","Jain","Budhist","Others"};
		
		religion = new JComboBox<Object>(valreligion);
		religion.setBounds(300,140,400,30);
		religion.setBackground(Color.white);
		add(religion);

		JLabel Category = new JLabel("Category :");
		Category.setFont(new Font("Raleway",Font.BOLD,22));
		Category.setBounds(100,190,200,30);
		add(Category);
		
		String valcatgory[] = {"General","OBC","ST","SC","Others"};
		
		catagory = new JComboBox<Object>(valcatgory);
		catagory.setBounds(300,190,400,30);
		catagory.setBackground(Color.white);
		add(catagory);

		JLabel Income = new JLabel("Income :");
		Income.setFont(new Font("Raleway",Font.BOLD,22));
		Income.setBounds(100,240,200,30);
		add(Income);
		
        String incomecatgory[] = {"Null","<1,50,000","<2,50,000","<5,00,000","up to 10,00,000"};
		
		income = new JComboBox<Object>(incomecatgory);
		income.setBounds(300,240,400,30);
		income.setBackground(Color.white);
		add(income);
		
		JLabel Education = new JLabel("Educational");
		Education.setFont(new Font("Raleway",Font.BOLD,22));
		Education.setBounds(100,290,200,30);
		add(Education);
		
		JLabel qualification = new JLabel("Qualification :");
		qualification.setFont(new Font("Raleway",Font.BOLD,22));
		qualification.setBounds(100,315,200,30);
		add(qualification);
		
		String educationcatgory[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
			
		education = new JComboBox<Object>(educationcatgory);
		education.setBounds(300,315,400,30);
		education.setBackground(Color.white);
		add(education);
		
		
		JLabel Occupation = new JLabel("Occupation :");
		Occupation.setFont(new Font("Raleway",Font.BOLD,22));
		Occupation.setBounds(100,390,200,30);
		add(Occupation);

		String occupationncatgory[] = {"Student","Bussinessman","Self-Employed","Salaried","Retired","Others"};
		
		occupation = new JComboBox<Object>(occupationncatgory);
		occupation.setBounds(300,390,400,30);
		occupation.setBackground(Color.white);
		add(occupation);

		JLabel panno = new JLabel("Pan Nnumber :");
		panno.setFont(new Font("Raleway",Font.BOLD,22));
		panno.setBounds(100,440,200,30);
		add(panno);
		
		pan = new JTextField();
		pan.setFont(new Font("Raleway",Font.BOLD,14));
		pan.setBounds(300,440,400,30);
		add(pan);
		
		JLabel Aadhar = new JLabel("Aadhar Number :");
		Aadhar.setFont(new Font("Raleway",Font.BOLD,22));
		Aadhar.setBounds(100,490,200,30);
		add(Aadhar);
		
		aadhar = new JTextField();
		aadhar.setFont(new Font("Raleway",Font.BOLD,14));
		aadhar.setBounds(300,490,400,30);
		add(aadhar);
		
		JLabel senior = new JLabel("Senior Citizen :");
		senior.setFont(new Font("Raleway",Font.BOLD,22));
		senior.setBounds(100,540,200,30);
		add(senior);
		
		syes=new JRadioButton("Yes");
		syes.setBounds(300,540,200,30);
		syes.setBackground(Color.white);
		add(syes);
		
		
		sno=new JRadioButton("No");
		sno.setBounds(500,540,200,30);
		sno.setBackground(Color.white);
		add(sno);
		
		ButtonGroup seniorgroup= new ButtonGroup();
		seniorgroup.add(syes);
		seniorgroup.add(sno);
		
		JLabel Exist = new JLabel("Existing Account :");
		Exist.setFont(new Font("Raleway",Font.BOLD,22));
		Exist.setBounds(100,590,200,30);
		add(Exist);
		

		eyes=new JRadioButton("Yes");
		eyes.setBounds(300,590,200,30);
		eyes.setBackground(Color.white);
		add(eyes);
		
		
		eno=new JRadioButton("No");
		eno.setBounds(500,590,200,30);
		eno.setBackground(Color.white);
		add(eno);
		
		ButtonGroup existgroup= new ButtonGroup();
		existgroup.add(eyes);
		existgroup.add(eno);
		
		
		next = new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.setBounds(620,660,80,30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		
		String sreligion=(String)religion.getSelectedItem();
		String scatagory=(String)catagory.getSelectedItem();
		String sincome=(String)income.getSelectedItem();
		String seducation=(String)education.getSelectedItem();
		String soccupation=(String)occupation.getSelectedItem();
		String seniorcitizen=null;
		if(syes.isSelected())
		{
			seniorcitizen="Yes";
		}
		else if(sno.isSelected())
		{
			seniorcitizen="No";
		}
		String existingaccount=null;
		if(eyes.isSelected())
		{
			existingaccount="Yes";
		}
		else if(eno.isSelected())
		{
			existingaccount="No";
		}
		String span = pan.getText();
		String saadhar = aadhar.getText();
		try 
		{
			if(pan.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please Enter Pan Number");
			}
			if(aadhar.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please Enter Aadhar Name");
			}
			else
			{
				Conn c = new Conn();
				String query ="insert into signuptwo values ('"+formno+"','"+sreligion+"','"+scatagory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
	            c.s.executeUpdate(query);
	            
	            //signup3 Object
	            setVisible(false);
	            new Signup3(formno).setVisible(true);
	            
			}
		}
		catch(Exception e)
		{
		System.out.print(e);	
		}
	}

	public static void main(String[] args)
	{
		new Signup2("");

	}

}
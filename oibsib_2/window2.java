package codsoft;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class window2 
{
	static int b;
	static int score=0;
	public static void main(String[] args) 
	{
		
	}
		
	public static int gen_num()
	{
		int num=(int)(Math.random()*(100-1+1)+1);  
		return num;
	}
	public static int cal_score(int sc)
	{
		score+=sc;
		return score;
	}
	public static void showwindow()
	{
		JFrame f1=new JFrame(" Guessing Game");
		
		
		JLabel sco=new JLabel("Score: "+score);
		sco.setForeground(Color.red);
		sco.setFont(new Font("bookman old style",Font.BOLD,20));
		sco.setBounds(20,0,300,20);
		f1.getContentPane().add(sco);
		
		JLabel atmt=new JLabel("Attempts Remain: 5 ");
		atmt.setForeground(Color.red);
		atmt.setFont(new Font("bookman old style",Font.BOLD,20));
		atmt.setBounds(360,0,300,20);
		f1.getContentPane().add(atmt);
		
		Container c = f1.getContentPane(); //Gets the content layer
        JLabel label = new JLabel(); //JLabel Creation
        label.setIcon(new ImageIcon("guess.jpg")); //Sets the image to be displayed as an icon
        Dimension size = label.getMinimumSize();//Gets the size of the image
        label.setBounds(0, 100, size.width, size.height); //Sets the location of the image
        c.add(label); //Adds objects to the container
        

        Color prp=new Color(106, 13, 173);
		JLabel tg = new JLabel("Try and guess it!!!");
		tg.setBounds(150,50,600,50);
		tg.setFont(new Font("monotype corsiva", Font.BOLD,  40));
		f1.getContentPane().add(tg);
		
		JLabel en=new JLabel("Enter a number between 1-100");
		en.setBounds(250,90,300,100);
		en.setFont(new Font("verdana",Font.BOLD,16));
		f1.getContentPane().add(en);
		
		JTextField n=new JTextField();
		n.setBounds(250,180,90,40);
		f1.getContentPane().add(n);
		
		JButton Guess=new JButton("Guess!!");
		Guess.setBounds(350, 180, 80, 40);
		Guess.setHideActionText(true);
		f1.getContentPane().add(Guess);
		
		
		
		
		JLabel status=new JLabel("");
		status.setForeground(Color.red);
		status.setFont(new Font("monotype corsiva", Font.BOLD,  20));
		status.setBounds(250,200,400,80);
		f1.getContentPane().add(status);
		
		JButton giup=new JButton("Give Up");
		giup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				f1.setVisible(false);
				result r=new result();
				r.displayresult(score);
			}
		});
		giup.setBounds(250, 300, 100, 40);
		giup.setHideActionText(true);
		f1.getContentPane().add(giup);
		
		JButton pA=new JButton("Play Again");
		pA.setBounds(370, 300, 100, 40);
		pA.setHideActionText(true);
		f1.getContentPane().add(pA);
		
		 b =  gen_num();
		
		//Guess Button Event
		 Color grn=new Color(0, 128, 0);
		Guess.addActionListener(new ActionListener()
		{
			int attempts=5;
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				String ev=n.getText();
			
				if((Integer.parseInt(ev)==b))
				{
					status.setText("Congratulations....Correct Guess");
					status.setForeground(grn);
					int s=cal_score(attempts);
					sco.setText("Score:"+s);
					attempts=5;
					Guess.setEnabled(false);
				}
				else if((Integer.parseInt(ev)<b))
				{
					status.setText("Too Low than original number..");
					status.setForeground(Color.red);
				}
				else 
				{
					status.setForeground(Color.red);
					status.setText("Too High than original number..");
				}
				attempts--;
				atmt.setText("Attempts Remain:"+attempts);
				if(attempts==0)
				{
					attempts=5;
					Guess.setEnabled(false);
					status.setText("You lost!!Play Again...");
				}
				System.out.println(b);  
			}
		});
		
		//Play Again Event
		pA.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				b=gen_num();
				Guess.setEnabled(true);
				status.setText("");
				atmt.setText("Attempts Remain:5 ");
				n.setText(null);
			}
		});
		
		
		
		Color color=new Color(255, 255, 255);
		f1.getContentPane().setBackground( color);
		f1.getContentPane().setLayout(null);
		f1.setSize(600,450);
		f1.setVisible(true);
	}

}

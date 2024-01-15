package codsoft;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class result 
{

	public static void displayresult(int score)
	{
		JFrame fm=new JFrame("Result");
		
		JButton b1=new JButton("Restart");
		b1.setBounds(80, 40, 100, 50);
		fm.add(b1);
		b1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				fm.setVisible(false);
				window2 w=new window2();
				w.showwindow();
			}
		});
		
		JButton b2=new JButton("Exit");
		b2.setBounds(220, 40, 100, 50);
		fm.add(b2);
		b2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				fm.setVisible(false);
			}
		});
		
		
		JLabel jl=new JLabel("",JLabel.CENTER);
		 Color grn=new Color(0, 128, 0);
		//Color r=new Color();
		jl.setFont(new Font("monotype corsiva", Font.BOLD,  35));
		jl.setBounds(0, 150, 400, 30);
		fm.getContentPane().add(jl);
		
		JLabel sc=new JLabel("Your Score :"+score);
		sc.setBounds(120, 250, 200, 40);
		sc.setFont(new Font("calibri",Font.BOLD,25));
		fm.getContentPane().add(sc);
		if(score!=0)
		{
			jl.setText("Congratulations....");
			jl.setForeground(grn);
		}
		else
		{
			jl.setText("Better Luck Next Time!!!");
			jl.setForeground(Color.red);
		}
		fm.setSize(400,400);
		fm.setLayout(null);
		fm.setVisible(true);
	}
	public static void main(String[] args) 
	{
		
	}

}

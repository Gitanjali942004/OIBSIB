package codsoft;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
public class Number_Guessing_Game 
{
    
	public static void main(String[] args) 
	{
		JFrame f=new JFrame("Number Guessing Game");
		
		
		Container c = f.getContentPane(); //Gets the content layer
        JLabel label = new JLabel(); //JLabel Creation
        label.setIcon(new ImageIcon("newbgnumgame.jpg")); //Sets the image to be displayed as an icon
        Dimension size = label.getMinimumSize();//Gets the size of the image
        label.setBounds(0, 0, size.width, size.height); //Sets the location of the image
        c.add(label); //Adds objects to the container
        
        
        
        
		JButton start=new JButton("Play");
		start.setBounds(160, 290, 80, 50);
		Color color=new Color(209,106,255);
		start.setBackground(color);
		f.add(start);
		start.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				f.setVisible(false);
				window2 w=new window2();
				w.showwindow();
			}
		});
		f.setLayout(null);
		f.setSize(400,385);
		f.setVisible(true);
	}

}

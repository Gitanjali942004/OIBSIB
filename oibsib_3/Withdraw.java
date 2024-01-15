import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Withdraw extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	public Withdraw()
	{
		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try {
					Withdraw frame = new Withdraw();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param cNumber 
	 */
	public Withdraw(String cNumber) {
		setTitle("Withdraw Transaction");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 749);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Withdraw");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(173, 10, 178, 45);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		textField.setBounds(255, 101, 270, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(111, 195, 340, 384);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(4, 4, 0, 0));
		
		JButton b1 = new JButton("1");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"1");
			}
		});
		b1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		b1.setBackground(Color.LIGHT_GRAY);
		panel.add(b1);
		
		JButton b2 = new JButton("2");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"2");
			}
		});
		b2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		b2.setBackground(Color.LIGHT_GRAY);
		panel.add(b2);
		
		JButton b3 = new JButton("3");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"3");
			}
		});
		b3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		b3.setBackground(Color.LIGHT_GRAY);
		panel.add(b3);
		
		JButton b4 = new JButton("4");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"4");
			}
		});
		b4.setFont(new Font("Times New Roman", Font.BOLD, 25));
		b4.setBackground(Color.LIGHT_GRAY);
		panel.add(b4);
		
		JButton b5 = new JButton("5");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"5");
			}
		});
		b5.setFont(new Font("Times New Roman", Font.BOLD, 25));
		b5.setBackground(Color.LIGHT_GRAY);
		panel.add(b5);
		
		JButton b6 = new JButton("6");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"6");
			}
		});
		b6.setFont(new Font("Times New Roman", Font.BOLD, 25));
		b6.setBackground(Color.LIGHT_GRAY);
		panel.add(b6);
		
		JButton b7 = new JButton("7");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"7");
			}
		});
		b7.setFont(new Font("Times New Roman", Font.BOLD, 25));
		b7.setBackground(Color.LIGHT_GRAY);
		panel.add(b7);
		
		JButton b8 = new JButton("8");
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"8");
			}
		});
		b8.setFont(new Font("Times New Roman", Font.BOLD, 25));
		b8.setBackground(Color.LIGHT_GRAY);
		panel.add(b8);
		
		JButton b9 = new JButton("9");
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"9");
			}
		});
		b9.setFont(new Font("Times New Roman", Font.BOLD, 25));
		b9.setBackground(Color.LIGHT_GRAY);
		panel.add(b9);
		
		JButton clear = new JButton("CLEAR");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
			}
		});
		clear.setForeground(Color.WHITE);
		clear.setFont(new Font("Times New Roman", Font.BOLD, 20));
		clear.setBackground(Color.RED);
		panel.add(clear);
		
		JButton b0 = new JButton("0");
		b0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"0");
			}
		});
		b0.setFont(new Font("Times New Roman", Font.BOLD, 25));
		b0.setBackground(Color.LIGHT_GRAY);
		panel.add(b0);
		
		
		
		
		JButton enter = new JButton("ENTER");
		
		enter.setForeground(Color.WHITE);
		enter.setFont(new Font("Times New Roman", Font.BOLD, 20));
		enter.setBackground(new Color(0, 128, 0));
		panel.add(enter);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton.setBounds(180, 644, 204, 45);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Amount:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblNewLabel_1.setBounds(49, 100, 178, 45);
		contentPane.add(lblNewLabel_1);
		
		enter.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
				    
				    Class.forName("com.mysql.cj.jdbc.Driver");
				    String url = "jdbc:mysql://localhost:3306/atm_projectjava";
				    String user = "root";
				    String password = "@gita123";

				    Connection connection = DriverManager.getConnection(url, user, password);

				    // Replace "your_table_name" with the actual table name
				    String sqlSelect = "SELECT * FROM customer WHERE account_number = ?";
				    PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
				    preparedStatement.setString(1, cNumber);

				    ResultSet resultSet = preparedStatement.executeQuery();

				    if (resultSet.next()) 
				    {
				        String acc_number = resultSet.getString("account_number");
				        int bal = resultSet.getInt("balance");
				        
				        // Assuming textField is a JTextField
				        String textFieldValue = textField.getText();
				        int amountToAdd = Integer.parseInt(textFieldValue);
			            
				        
				        
				        	 bal = bal - amountToAdd;
				        
				       
			            // Update the balance
			           
			            
			            if(bal>=2000)
			            {
			            	try
			            	{
					            // Convert the textField value to an integer
					           
					            // Use a prepared statement for the update
					            String sqlUpdate = "UPDATE customer SET balance = ? WHERE account_number = ?";
					            PreparedStatement updateStatement = connection.prepareStatement(sqlUpdate);
					            updateStatement.setInt(1, bal);
					            updateStatement.setString(2, acc_number);
					            
					            // Execute the update statement
					            updateStatement.executeUpdate();

					            JOptionPane.showMessageDialog(Withdraw.this, "Transaction Successfull!!\n\n"+amountToAdd+"debited from your account.\n Remaining Balance:"+bal);
					            setVisible(false);
								
					        } 
			            	catch (NumberFormatException e2) 
			            	{
					            // Handle the case where the textField does not contain a valid integer
					            JOptionPane.showMessageDialog(Withdraw.this, "Invalid input in the text field. Please enter a valid number.");
					        }
					    }
			            else
			            {
			            	 JOptionPane.showMessageDialog(Withdraw.this, "Account balance must be 2000Rs we cant process withdraw request.\n Available Balance:"+(bal+amountToAdd));
			            }
			        }
				        
				    else 
				    {
				        JOptionPane.showMessageDialog(Withdraw.this, "Customer not found for Account Number: " + cNumber);
				    }
				} catch (SQLException | ClassNotFoundException e2) {
				    // Handle any SQL or class loading exceptions here
				    e2.printStackTrace(); // Or log the exception
				}

			}
		});
		
	}
	public void showbal(String CNumber) 
	{
		Withdraw b1= new Withdraw(CNumber);
		b1.setVisible(true);
		b1.setBounds(830, 100, 600, 750);
	}
}

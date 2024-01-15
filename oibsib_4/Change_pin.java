import java.awt.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class Change_pin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField newpass;
	private JPasswordField reenterpass;
	public int status=0;

	public Change_pin()
	{
		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Change_pin frame = new Change_pin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Change_pin(String  cNumber)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 50, 470, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Change Pin");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(137, 31, 166, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterNewPassword = new JLabel("Enter New Password");
		lblEnterNewPassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEnterNewPassword.setBounds(64, 127, 166, 13);
		contentPane.add(lblEnterNewPassword);
		
		newpass = new JPasswordField();
		newpass.setToolTipText("Enter Current Password");
		newpass.setFont(new Font("Times New Roman", Font.BOLD, 15));
		newpass.setBounds(64, 150, 323, 41);
		contentPane.add(newpass);
		
		JLabel lblReenterThePassword = new JLabel("ReEnter the Password");
		lblReenterThePassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblReenterThePassword.setBounds(64, 242, 166, 13);
		contentPane.add(lblReenterThePassword);
		
		reenterpass = new JPasswordField();
		reenterpass.setToolTipText("Enter Current Password");
		reenterpass.setFont(new Font("Times New Roman", Font.BOLD, 15));
		reenterpass.setBounds(64, 265, 323, 41);
		contentPane.add(reenterpass);
		
		JButton btnsubmit = new JButton("Submit");
	
		btnsubmit.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		btnsubmit.setBounds(162, 375, 137, 59);
		contentPane.add(btnsubmit);
		btnsubmit.addActionListener(new ActionListener() {
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
				       
				        
				        // Assuming textField is a JTextField
				        String npass = newpass.getText();
				        String RePass = reenterpass.getText();
			            
			            
			            
			           
			            	try
			            	{
					            // Convert the textField value to an integer
					           
					            // Use a prepared statement for the update
					            String sqlUpdate = "UPDATE customer SET pin = ? WHERE account_number = ?";
					            PreparedStatement updateStatement = connection.prepareStatement(sqlUpdate);
					            updateStatement.setString(1, npass);
					            updateStatement.setString(2, acc_number);
					            
					            // Execute the update statement
					            updateStatement.executeUpdate();

					            JOptionPane.showMessageDialog(Change_pin.this, "Pin Changed Successfully");
					            setVisible(false);
								
					        } 
			            	catch (NumberFormatException e2) 
			            	{
					            // Handle the case where the textField does not contain a valid integer
					            JOptionPane.showMessageDialog(Change_pin.this, "Pin Change Failed");
					        }
					    
			        }
				        
				    else 
				    {
				        JOptionPane.showMessageDialog(Change_pin.this, "Customer not found for Account Number: " + cNumber);
				    }
				} catch (SQLException | ClassNotFoundException e2) {
				    // Handle any SQL or class loading exceptions here
				    e2.printStackTrace(); // Or log the exception
				}

			}
		});
		
		
	}
	public void GetAcc(String accNo)
	{
		Change_pin cp=new Change_pin(accNo);
		cp.setVisible(true);
		cp.setBounds(830, 100, 450, 500);
	}
	
	
}

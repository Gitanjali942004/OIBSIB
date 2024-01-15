import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class mainscreen extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel custNameLabel;
    private JLabel custAccLabel;
    private JButton btnwithdraw;
    private JButton btnchangepin;
    private JButton btnbalance;
    private JButton btnNewButton_4;

    public static void main(String[] args) {
    	
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    mainscreen frame = new mainscreen();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public mainscreen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 749, 580);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(123, 123, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        custNameLabel = new JLabel("Welcome ");
        custNameLabel.setForeground(new Color(255, 255, 255));
        custNameLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
        custNameLabel.setBounds(151, 34, 387, 71);
        contentPane.add(custNameLabel);

        custAccLabel = new JLabel("Account No :");
        custAccLabel.setForeground(new Color(255, 255, 255));
        custAccLabel.setFont(new Font("Verdana", Font.BOLD, 16));
        custAccLabel.setBounds(10, 122, 174, 26);
        contentPane.add(custAccLabel);
        
        JButton btndeposit = new JButton("Deposit");
        btndeposit.setFont(new Font("Times New Roman", Font.BOLD, 25));
        btndeposit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btndeposit.setBounds(420, 222, 229, 51);
        contentPane.add(btndeposit);
        btndeposit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		
        		Deposit w=new Deposit();
        		w.setVisible(true);
        		String accno=custAccLabel.getText();
        		w.showbal(accno.substring(12));
        	}
        });
        
        btnwithdraw = new JButton("Withdraw");
        btnwithdraw.setFont(new Font("Times New Roman", Font.BOLD, 25));
        btnwithdraw.setBounds(83, 222, 239, 51);
        contentPane.add(btnwithdraw);
        btnwithdraw.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		
        		Withdraw w=new Withdraw();
        		w.setVisible(true);
        		String accno=custAccLabel.getText();
        		w.showbal(accno.substring(12));
        	}
        });
        
        btnchangepin = new JButton("Change Pin");
        btnchangepin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		
        		Change_pin cp=new Change_pin();
        		cp.setVisible(true);
        		String accno=custAccLabel.getText();
        		cp.GetAcc(accno.substring(12));
        		
        	}
        });
        btnchangepin.setFont(new Font("Times New Roman", Font.BOLD, 25));
        btnchangepin.setBounds(420, 355, 229, 51);
        contentPane.add(btnchangepin);
        
        btnbalance = new JButton("Balance Enquiry");
        btnbalance.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		bal_enqu be=new bal_enqu();
        		String accno=custAccLabel.getText();
        		be.showbal(accno.substring(12));
        		bal_enqu b=new bal_enqu();
        	}
        });
        btnbalance.setFont(new Font("Times New Roman", Font.BOLD, 25));
        btnbalance.setBounds(83, 355, 239, 51);
        contentPane.add(btnbalance);
        
        btnNewButton_4 = new JButton("Log Out");
        btnNewButton_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		setVisible(false);
        		Login l=new Login();
        		l.setVisible(true);
        	}
        });
        btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnNewButton_4.setBounds(573, 21, 123, 21);
        contentPane.add(btnNewButton_4);
    }

    public void fetchCustomerDetails(String cardNumber) {
        String CNumber = cardNumber;

        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/atm_projectjava";
            String user = "root";
            String password = "@gita123";

            Connection connection = DriverManager.getConnection(url, user, password);

            // Replace "your_table_name" with the actual table name
            String sql = "SELECT * FROM customer WHERE account_number = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, CNumber);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String acc_number = resultSet.getString("account_number");

                custNameLabel.setText("WELCOME " + name+"!!!");
                custAccLabel.setText("Account No :" + acc_number);
            } else {
                JOptionPane.showMessageDialog(this, "Customer not found for Account Number: " + CNumber);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching customer details: " + ex.getMessage());
        }
    }
      
}

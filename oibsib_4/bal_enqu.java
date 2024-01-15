import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class bal_enqu extends JFrame {
	
	public bal_enqu() {}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bal_enqu frame = new bal_enqu();
					frame.setBounds(1000, 100, WIDTH, HEIGHT);
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
	public bal_enqu(String s1) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Balance Enquiry");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(127, 26, 196, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lbldate = new JLabel("Date:");
		lbldate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbldate.setBounds(64, 119, 324, 32);
		contentPane.add(lbldate);
		
		JLabel lblaccno = new JLabel("Account No:");
		lblaccno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblaccno.setBounds(64, 161, 324, 45);
		contentPane.add(lblaccno);
		
		JLabel lblbal = new JLabel("Balance:");
		lblbal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblbal.setBounds(64, 270, 324, 32);
		contentPane.add(lblbal);
		
		JLabel lblholder = new JLabel("Acc. Holder Name:");
		lblholder.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblholder.setBounds(64, 216, 324, 32);
		contentPane.add(lblholder);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 379, 96, 32);
		contentPane.add(btnNewButton);
		
		
		//Fetchdata
		try {
            // Replace these placeholders with your actual database credentials
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/atm_projectjava";
            String user = "root";
            String password = "@gita123";

            Connection connection = DriverManager.getConnection(url, user, password);

            // Replace "your_table_name" with the actual table name
            String sql = "SELECT * FROM customer WHERE account_number = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, s1);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String acc_number = resultSet.getString("account_number");
                int bal=resultSet.getInt("balance");

               
                lblaccno.setText("Account No :" + acc_number);
                lblholder.setText("Acc. Holder Name: "+name);
                lblbal.setText("Balance:    "+bal);
            } else {
                JOptionPane.showMessageDialog(this, "Customer not found for Account Number: " + s1);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching customer details: " + ex.getMessage());
        }
		
		
		
		
		
		//Current Date
		  LocalDate date = LocalDate.now();
		  lbldate.setText("Date:  "+date);
		
	}

	public void showbal(String CNumber) 
	{
		bal_enqu b1= new bal_enqu(CNumber);
		b1.setVisible(true);
		b1.setBounds(830, 100, 400, 500);
	}
}

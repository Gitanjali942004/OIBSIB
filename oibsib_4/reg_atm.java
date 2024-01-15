import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class reg_atm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtmob;
	private JTextField txtacc;
	private JTextField txtpin;
	private JTextField txtadhar;
	protected Window frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reg_atm frame = new reg_atm();
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
	public reg_atm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 627);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblsignup = new JLabel("Sign Up");
		lblsignup.setFont(new Font("Gabriola", Font.BOLD, 35));
		lblsignup.setBounds(191, 46, 125, 67);
		contentPane.add(lblsignup);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblName.setBounds(70, 120, 83, 24);
		contentPane.add(lblName);
		
		txtname = new JTextField();
		txtname.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txtname.setBounds(191, 123, 256, 24);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblMobileNo = new JLabel("Mob No. :");
		lblMobileNo.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblMobileNo.setBounds(66, 174, 115, 24);
		contentPane.add(lblMobileNo);
		
		txtmob = new JTextField();
		txtmob.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txtmob.setColumns(10);
		txtmob.setBounds(191, 177, 256, 24);
		contentPane.add(txtmob);
		
		JLabel lblAccNo = new JLabel("Acc No. :");
		lblAccNo.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblAccNo.setBounds(70, 290, 111, 27);
		contentPane.add(lblAccNo);
		
		txtacc = new JTextField();
		txtacc.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txtacc.setColumns(10);
		txtacc.setBounds(191, 292, 256, 24);
		contentPane.add(txtacc);
		
		JLabel lblPin = new JLabel("Pin :");
		lblPin.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblPin.setBounds(70, 338, 83, 24);
		contentPane.add(lblPin);
		
		txtpin = new JPasswordField();
		txtpin.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txtpin.setColumns(10);
		txtpin.setBounds(191, 339, 256, 24);
		contentPane.add(txtpin);
		
		JButton btnsubmit = new JButton("Submit");
		btnsubmit.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 30));
		btnsubmit.setBounds(165, 420, 151, 67);
		contentPane.add(btnsubmit);
		
		JLabel lblAdharNo = new JLabel("Adhar No.");
		lblAdharNo.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblAdharNo.setBounds(70, 234, 111, 27);
		contentPane.add(lblAdharNo);
		
		txtadhar = new JTextField();
		txtadhar.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txtadhar.setColumns(10);
		txtadhar.setBounds(191, 236, 256, 24);
		contentPane.add(txtadhar);
		
		btnsubmit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				customer_data();
				
			}
		});
	}
	
	
//	CREATE TABLE customer (
//		    name VARCHAR(255) NOT NULL,
//		    mob_no VARCHAR(15) NOT NULL,
//		    adhar_card_no VARCHAR(20) UNIQUE NOT NULL,
//		    account_number VARCHAR(20) UNIQUE NOT NULL,
//		    pin VARCHAR(4) NOT NULL
//		);
	
	
	public void customer_data()
	{
		String name=txtname.getText();
		String mob=(String)txtmob.getText();
		String adharno=txtadhar.getText();
		String acc=txtacc.getText();
		String pin=txtpin.getText();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/atm_projectjava";
			Properties properties = new Properties();
			properties.setProperty("user", "root");
			properties.setProperty("password", "@gita123");
			// Add any additional properties as needed

			Connection con = DriverManager.getConnection(url, properties);
			Statement stmt=con.createStatement();
			System.out.println("Inserting Records into Customer");
			 String sql = "INSERT INTO customer VALUES ('" + name + "', '" + mob + "', '" + adharno + "', '" + acc + "', '" + pin + "',2000)";
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(this, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
			this.setVisible(false);
			Login l=new Login();
			l.setVisible(true);
			
			}
		catch(Exception e)
		{
			System.out.println(e);
			JOptionPane.showMessageDialog(this, "Registration Failed!", "Success", JOptionPane.INFORMATION_MESSAGE);
			
			
		}
	}
	
	
}

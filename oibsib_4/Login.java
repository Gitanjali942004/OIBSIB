import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtcardn;
	private JTextField txtpin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 686);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Wlc = new JLabel("WELCOME TO ATM");
		Wlc.setFont(new Font("Bookman Old Style", Font.BOLD, 33));
		Wlc.setBounds(87, 71, 339, 41);
		contentPane.add(Wlc);
		
		JLabel lblcn = new JLabel("Card No : ");
		lblcn.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblcn.setBounds(51, 172, 109, 51);
		contentPane.add(lblcn);
		
		txtcardn = new JTextField();
		txtcardn.setBounds(203, 172, 254, 39);
		contentPane.add(txtcardn);
		txtcardn.setColumns(10);
		
		JLabel lblPin = new JLabel("PIN : ");
		lblPin.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblPin.setBounds(51, 270, 109, 51);
		contentPane.add(lblPin);
		
		txtpin = new JPasswordField();
		txtpin.setColumns(10);
		txtpin.setBounds(203, 270, 254, 39);
		contentPane.add(txtpin);
		
		JButton btnsignin = new JButton("Sign In");
		btnsignin.setFont(new Font("Sitka Text", Font.BOLD, 20));
		btnsignin.setBounds(203, 386, 113, 60);
		contentPane.add(btnsignin);
		btnsignin.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				validateLogin();
			}
		});
		
		
		
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClear.setFont(new Font("Sitka Text", Font.BOLD, 20));
		btnClear.setBounds(344, 386, 113, 60);
		contentPane.add(btnClear);
		
		JButton btnsignup = new JButton("Sign Up");
		btnsignup.setFont(new Font("Sitka Text", Font.BOLD, 20));
		btnsignup.setBounds(203, 474, 254, 60);
		contentPane.add(btnsignup);
		btnsignup.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
			   setVisible(false);
			   reg_atm r=new reg_atm();
			   r.setVisible(true);
			}
		});

	}
	
	 private void validateLogin() {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            String url = "jdbc:mysql://localhost:3306/atm_projectjava ";
	            String user = "root";
	            String password = "@gita123";

	            Connection con = DriverManager.getConnection(url, user, password);
	            String cardNumber=txtcardn.getText();
	            String pin=txtpin.getText();
	            String query = "SELECT * FROM customer WHERE account_number = ? AND pin = ?";
	            try (PreparedStatement pstmt = con.prepareStatement(query)) {
	                pstmt.setString(1, cardNumber);
	                pstmt.setString(2, pin);

	                ResultSet rs = pstmt.executeQuery();

	                if (rs.next()) {
	                    
	                	 setVisible(false);
	      			     mainscreen r=new mainscreen();
	      			     r.setVisible(true);
	      			     r.fetchCustomerDetails(cardNumber);
	      			    
	                	
	                } else {
	                	JOptionPane.showMessageDialog(this, "Invalid credentials. Please try again.", "Success", JOptionPane.INFORMATION_MESSAGE);
	                	txtcardn.setText("");
	                	txtpin.setText("");
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}

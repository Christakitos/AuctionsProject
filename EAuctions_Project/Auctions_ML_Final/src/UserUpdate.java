import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Toolkit;

public class UserUpdate {

	public JFrame UserUpdateframe;
	private JTextField textEmail;
	private JPasswordField CpasswordField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//UserUpdate wUserUpdate = new UserUpdate();
					//wUserUpdate.UserUpdateframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public UserUpdate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		UserUpdateframe = new JFrame();
		UserUpdateframe.setTitle("My Profile Editor");
		UserUpdateframe.setResizable(false);
		UserUpdateframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\AuctionsSetupFiles\\imgs\\Main image.jpg"));
		UserUpdateframe.setBounds(100, 100, 384, 208);
		UserUpdateframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		UserUpdateframe.getContentPane().setLayout(null);
		
		JLabel lblError = new JLabel("*An error occurred please try again later");
		lblError.setForeground(Color.RED);
		lblError.setVisible(false);
		lblError.setBounds(10, 89, 252, 14);
		UserUpdateframe.getContentPane().add(lblError);
		
		JLabel lblPassError = new JLabel("*Error at Passwrods");
		lblPassError.setForeground(Color.RED);
		lblPassError.setVisible(false);
		lblPassError.setBounds(241, 11, 119, 14);
		UserUpdateframe.getContentPane().add(lblPassError);
		
		JLabel lblEmailError = new JLabel("*Not valid Email");
		lblEmailError.setForeground(Color.RED);
		lblEmailError.setVisible(false);
		lblEmailError.setBounds(241, 61, 119, 14);
		UserUpdateframe.getContentPane().add(lblEmailError);
		
		CpasswordField = new JPasswordField();
		CpasswordField.setBounds(112, 33, 119, 20);
		UserUpdateframe.getContentPane().add(CpasswordField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(111, 8, 120, 20);
		UserUpdateframe.getContentPane().add(passwordField);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setBounds(10, 11, 91, 14);
		UserUpdateframe.getContentPane().add(lblNewPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setBounds(10, 36, 91, 14);
		UserUpdateframe.getContentPane().add(lblConfirmPassword);
		
		JLabel lblNewEmail = new JLabel("New Email:");
		lblNewEmail.setBounds(10, 61, 91, 14);
		UserUpdateframe.getContentPane().add(lblNewEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(111, 58, 120, 20);
		UserUpdateframe.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbConnection db = new dbConnection();
				db.UpdateStatus();
				db.close();
				
				MyProfile wMyProfile = new MyProfile();
				wMyProfile.MyProfileframe.setVisible(true);
				UserUpdateframe.dispose();
			}
		});
		btnBack.setBounds(269, 130, 89, 23);
		UserUpdateframe.getContentPane().add(btnBack);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//------Hide Error Messages------
				lblPassError.setVisible(false);
				lblEmailError.setVisible(false);
				lblError.setVisible(false);
				//-------------------------------
				
				boolean Flag = true;
				char [] pass= passwordField.getPassword();
				String EnteredPassword = new String(pass);
				char [] cpass= CpasswordField.getPassword();
				String EnteredCPassword = new String(cpass);
				
				// Check Pass
				if(!EnteredPassword.equals(EnteredCPassword) || EnteredPassword.equals(""))
				{
					Flag = false;
					lblPassError.setVisible(true);
				}
				// Check Email valid
				if(textEmail.getText().indexOf('@')<0)
				{
					Flag = false;
					lblEmailError.setVisible(true);
				}
				
				if( Flag == true)
				{
				dbConnection db = new dbConnection();
				int rs =db.UpdateUser(main.Username,EnteredPassword,textEmail.getText());
				db.close();
				if(rs !=1)
				{	
					lblError.setVisible(true);
				}
				else
					{
					main.Email =textEmail.getText();
					MyProfile wMyProfile = new MyProfile();
					wMyProfile.MyProfileframe.setVisible(true);
					UserUpdateframe.dispose();
					}
				}
			}
		});
		btnConfirm.setBounds(10, 124, 91, 34);
		UserUpdateframe.getContentPane().add(btnConfirm);
		
		JButton btnDelete = new JButton("Delete Account");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserDeleteAccount wUserDeleteAccount = new UserDeleteAccount();
				wUserDeleteAccount.UserDeleteAcountframe.setVisible(true);
				UserUpdateframe.dispose();
			}
		});
		btnDelete.setBounds(229, 85, 129, 23);
		UserUpdateframe.getContentPane().add(btnDelete);
		

		

		

	}
}

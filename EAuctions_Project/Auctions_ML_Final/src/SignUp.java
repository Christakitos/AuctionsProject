import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class SignUp {

	public JFrame SignUpframe;
	private JTextField textUsername;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldChk;
	private JTextField textEmail;
	private JTextField textName;
	private JTextField textSurname;

	/**
	 * Launch the application.
	 */
	public void mainSignUp() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//SignUp window = new SignUp();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		SignUpframe = new JFrame();
		SignUpframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\AuctionsSetupFiles\\imgs\\Main image.jpg"));
		SignUpframe.setResizable(false);
		SignUpframe.setTitle("SignUp");
		SignUpframe.setBounds(100, 100, 450, 379);
		SignUpframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		SignUpframe.getContentPane().setLayout(null);
		
		JLabel lblChkUser = new JLabel("*Invalid Username!");
		lblChkUser.setForeground(Color.RED);
		lblChkUser.setVisible(false);
		lblChkUser.setBounds(261, 14, 163, 14);
		SignUpframe.getContentPane().add(lblChkUser);
		
		JLabel lblChkPass = new JLabel("*Passwords don't match!");
		lblChkPass.setForeground(Color.RED);
		lblChkPass.setVisible(false);
		lblChkPass.setBounds(261, 38, 163, 14);
		SignUpframe.getContentPane().add(lblChkPass);
		
		JLabel lblChkEmail = new JLabel("*Invalid Email-Address!");
		lblChkEmail.setForeground(Color.RED);
		lblChkEmail.setVisible(false);
		lblChkEmail.setBounds(232, 157, 137, 14);
		SignUpframe.getContentPane().add(lblChkEmail);
		
		JLabel lblError = new JLabel("Not all information entered!");
		lblError.setForeground(Color.RED);
		lblError.setVisible(false);
		lblError.setBounds(121, 199, 153, 14);
		SignUpframe.getContentPane().add(lblError);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(32, 107, 60, 14);
		SignUpframe.getContentPane().add(lblName);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setBounds(32, 132, 60, 14);
		SignUpframe.getContentPane().add(lblSurname);
		
		textName = new JTextField();
		textName.setBounds(102, 101, 120, 20);
		SignUpframe.getContentPane().add(textName);
		textName.setColumns(10);
		
		textSurname = new JTextField();
		textSurname.setBounds(102, 126, 120, 20);
		SignUpframe.getContentPane().add(textSurname);
		textSurname.setColumns(10);
		
		JLabel lblChkname = new JLabel("*Name not Entered!");
		lblChkname.setForeground(Color.RED);
		lblChkname.setVisible(false);
		lblChkname.setBounds(232, 104, 137, 14);
		SignUpframe.getContentPane().add(lblChkname);
		
		JLabel lblChksurname = new JLabel("*Surname not Entered!");
		lblChksurname.setForeground(Color.RED);
		lblChksurname.setVisible(false);
		lblChksurname.setBounds(232, 129, 137, 14);
		SignUpframe.getContentPane().add(lblChksurname);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 11, 111, 14);
		SignUpframe.getContentPane().add(lblUsername);
		
		JLabel lblEnterPassword = new JLabel("Enter Password:");
		lblEnterPassword.setBounds(10, 35, 111, 14);
		SignUpframe.getContentPane().add(lblEnterPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setBounds(10, 60, 111, 14);
		SignUpframe.getContentPane().add(lblConfirmPassword);
		
		JLabel lblEnterEmailAddress = new JLabel("Email-Address:");
		lblEnterEmailAddress.setBounds(10, 160, 87, 14);
		SignUpframe.getContentPane().add(lblEnterEmailAddress);
		
		textUsername = new JTextField();
		textUsername.setBounds(131, 11, 120, 20);
		SignUpframe.getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(131, 35, 120, 20);
		SignUpframe.getContentPane().add(passwordField);
		
		passwordFieldChk = new JPasswordField();
		passwordFieldChk.setBounds(131, 57, 120, 20);
		SignUpframe.getContentPane().add(passwordFieldChk);
		
		textEmail = new JTextField();
		textEmail.setBounds(102, 154, 120, 20);
		SignUpframe.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JCheckBox chckbxRobot = new JCheckBox("I am not a robot!");
		chckbxRobot.setBounds(26, 233, 120, 23);
		SignUpframe.getContentPane().add(chckbxRobot);
		
		JCheckBox chckbxITerms = new JCheckBox("I accept the ");
		chckbxITerms.setBounds(26, 260, 95, 23);
		SignUpframe.getContentPane().add(chckbxITerms);
		
		JLabel lblTermsOfAgrrement = new JLabel("Terms of agrrement!");
		lblTermsOfAgrrement.setForeground(Color.BLUE);
		lblTermsOfAgrrement.addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	TermsOfAgreement wTerms = new TermsOfAgreement();
				wTerms.TermsOfAgreementframe.setVisible(true);
		       

		    }
		});
		lblTermsOfAgrrement.setBounds(121, 264, 120, 14);
		SignUpframe.getContentPane().add(lblTermsOfAgrrement);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainWindow mainwindow = new MainWindow();
				mainwindow.Mainframe.setVisible(true);
				SignUpframe.dispose();
			}
		});
		btnBack.setBounds(335, 309, 89, 20);
		SignUpframe.getContentPane().add(btnBack);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Make labels Invisible
				lblChkUser.setVisible(false);
				lblChkPass.setVisible(false);
				lblChkname.setVisible(false);
				lblChksurname.setVisible(false);
				lblChkEmail.setVisible(false);
				lblError.setVisible(false);
				//--------------------------------
				// Give variables their first value
				boolean Flag = true;
				boolean FlagUser = false;
				
				//--------------------------------
				
				dbConnection db = new dbConnection();
				FlagUser = db.ChkUsername(textUsername.getText());
				db.close();
				
				

				// Check Username value
				if(textUsername.getText().equals("") || FlagUser == true)
				{
					lblChkUser.setVisible(true);
					Flag = false;
					
				}
				
				//Check if passwords match
				char [] pass= passwordField.getPassword();
				String EnteredPassword = new String(pass);
				char [] cpass= passwordFieldChk.getPassword();
				String EnteredCPassword = new String(cpass);
				
				if(!EnteredPassword.equals(EnteredCPassword) || EnteredPassword.equals(""))
				{
					Flag = false;
					lblChkPass.setVisible(true);
				}
				
				//Check if Name is null
				if(textName.getText().equals(""))
				{
					Flag = false;
					lblChkname.setVisible(true);
				}
				
				//Check if Surname is null
				if(textSurname.getText().equals(""))
				{
					Flag = false;
					lblChksurname.setVisible(true);
				}
				//Check if Email = null and Email is real
				if(textEmail.getText().indexOf('@')<0)
				{
					Flag = false;
					lblChkEmail.setVisible(true);
				}
				//Checking the checkboxes
				if (!chckbxRobot.isSelected() || !chckbxITerms.isSelected() )
				{
					Flag = false;
					lblError.setVisible(true);
					
				}
				

				if (Flag == true)
				{
					dbConnection db1 = new dbConnection();
					db1.SignUp(textUsername.getText(), EnteredPassword, textName.getText(), textSurname.getText(), textEmail.getText());
					db1.close();
					
					SignUpMessage wSignUpMessage = new SignUpMessage();
					wSignUpMessage.SignUpMessageframe.setVisible(true);
					SignUpframe.dispose();
				}	
			}
		});
		btnSignUp.setBounds(26, 290, 89, 34);
		SignUpframe.getContentPane().add(btnSignUp);
		
		
	}
}

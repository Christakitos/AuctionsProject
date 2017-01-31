

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Toolkit;


public class SignIn {
	public JFrame SignInframe;
	private JTextField textUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public void mainSignIn() {

	}

	/**
	 * Create the application.
	 */
	public SignIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		SignInframe = new JFrame();
		SignInframe.setResizable(false);
		SignInframe.setTitle("Sign In");
		SignInframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\AuctionsSetupFiles\\imgs\\Main image.jpg"));
		SignInframe.setBounds(100, 100, 255, 182);
		SignInframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		SignInframe.getContentPane().setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(89, 33, 140, 20);
		SignInframe.getContentPane().add(passwordField);
		
		JLabel lblLogError = new JLabel("*Username or Password incorrect!");
		lblLogError.setForeground(Color.RED);
		lblLogError.setBounds(10, 61, 219, 14);
		lblLogError.setVisible(false);
		SignInframe.getContentPane().add(lblLogError);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 11, 69, 14);
		SignInframe.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 36, 69, 14);
		SignInframe.getContentPane().add(lblPassword);
		

		textUsername = new JTextField();
		textUsername.setBounds(89, 8, 140, 20);
		SignInframe.getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dbConnection db = new dbConnection();
				db.UpdateStatus();
				db.close();
				
				if(main.ItemsPage == false)
				{
				MainWindow mainwindow = new MainWindow();
				mainwindow.Mainframe.setVisible(true);
				SignInframe.dispose();
				}
				else
				{
					ItemPage wItem= new ItemPage();
					wItem.Itemsframe.setVisible(true);
					SignInframe.dispose();
				}
			}
		});
		btnBack.setBounds(140, 116, 89, 23);
		SignInframe.getContentPane().add(btnBack);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// connect code
				
				String EnteredUsername = textUsername.getText(); 
				System.out.println(EnteredUsername);
				
				char [] pass= passwordField.getPassword();
				String EnteredPassword = new String(pass);
				System.out.println(EnteredPassword);
				
				dbConnection db = new dbConnection();
				boolean Flag = db.SignIn(EnteredUsername,EnteredPassword);
				
				//--Used At old Version
				//db.CategoriesPop ();
				//db.close();
				
				if(Flag == true && main.Admin==1)
				{
					AdminWindow wAdmin = new AdminWindow();
					wAdmin.AdminWindowframe.setVisible(true);
					SignInframe.dispose();
					
				}
				
				if(Flag == true && main.Admin != 1)
				{
					db.AuctionsStatus();
					    
					
					main.logged = true; //when logged in as User
					if(main.ItemsPage == false)
					{
						dbConnection db3 = new dbConnection();
						db3.UpdateStatus();
						db3.close();
					MainWindow mainwindow = new MainWindow();
					mainwindow.Mainframe.setVisible(true);
					}
					else
					{
						dbConnection db2 = new dbConnection();
						db2.UpdateStatus();
						db2.close();
						ItemPage wItem= new ItemPage();
						wItem.Itemsframe.setVisible(true);
					}
					SignInframe.dispose();
				}
				else
				{
					System.out.println("entered else");
					lblLogError.setVisible(true);

				}
				db.close();
				textUsername.setText("");
				passwordField.setText("");
			}
		});
		btnSignIn.setBounds(10, 82, 89, 23);
		SignInframe.getContentPane().add(btnSignIn);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp wSignUp = new SignUp();
				wSignUp.SignUpframe.setVisible(true);
				wSignUp.mainSignUp();
				SignInframe.dispose();
			}
		});
		btnSignUp.setBounds(140, 82, 89, 23);
		SignInframe.getContentPane().add(btnSignUp);
		

		

	}
}

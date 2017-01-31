import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class SignUpMessage {

	public JFrame SignUpMessageframe;

	/**
	 * Launch the application.
	 */
	public static void mainSignUpMessage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//SignUpMessage wSignUpMessage = new SignUpMessage();
					//wSignUpMessage.SignUpMessageframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUpMessage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		SignUpMessageframe = new JFrame();
		SignUpMessageframe.setTitle("SignUp Message");
		SignUpMessageframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\AuctionsSetupFiles\\imgs\\Main image.jpg"));
		SignUpMessageframe.setResizable(false);
		SignUpMessageframe.setBounds(100, 100, 337, 128);
		SignUpMessageframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		SignUpMessageframe.getContentPane().setLayout(null);
		
		JLabel lblYouHaveSuccesfully = new JLabel("You have successfully created your account!");
		lblYouHaveSuccesfully.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouHaveSuccesfully.setBounds(10, 11, 301, 14);
		SignUpMessageframe.getContentPane().add(lblYouHaveSuccesfully);
		
		JButton btnNewButton = new JButton("Great!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dbConnection db = new dbConnection();
				db.UpdateStatus();
				db.close();
					if(main.ItemsPage == false)
					{
						
				 	MainWindow mainwindow = new MainWindow();
					mainwindow.Mainframe.setVisible(true);
					SignUpMessageframe.dispose();
					}
					else
					{
							ItemPage wItem= new ItemPage();
							wItem.Itemsframe.setVisible(true);
							SignUpMessageframe.dispose();
					}
			}
		});
		btnNewButton.setBounds(109, 47, 99, 31);
		SignUpMessageframe.getContentPane().add(btnNewButton);
	}
}

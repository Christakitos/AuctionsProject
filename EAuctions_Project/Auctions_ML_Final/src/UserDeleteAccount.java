import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class UserDeleteAccount {

	public JFrame UserDeleteAcountframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//UserDeleteAccount wUserUpdateframe = new UserDeleteAccount();
					//wUserUpdateframe.UserDeleteAcountframe.setVisible(true);
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
	public UserDeleteAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		UserDeleteAcountframe = new JFrame();
		UserDeleteAcountframe.setTitle("Warning!");
		UserDeleteAcountframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\AuctionsSetupFiles\\imgs\\Main image.jpg"));
		UserDeleteAcountframe.setResizable(false);
		UserDeleteAcountframe.setBounds(100, 100, 247, 160);
		UserDeleteAcountframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		UserDeleteAcountframe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html>Are you sure that you want to delete your account?\r\nThis Action is irreversible!</html>");
		lblNewLabel.setBounds(10, 11, 211, 44);
		UserDeleteAcountframe.getContentPane().add(lblNewLabel);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserUpdate wUserUpdate = new UserUpdate();
				wUserUpdate.UserUpdateframe.setVisible(true);
				UserDeleteAcountframe.dispose();
			}
		});
		btnBack.setBounds(132, 87, 89, 23);
		UserDeleteAcountframe.getContentPane().add(btnBack);
		
		JCheckBox chckbxIAmSure = new JCheckBox("I am Sure");
		chckbxIAmSure.setBounds(20, 62, 97, 23);
		UserDeleteAcountframe.getContentPane().add(chckbxIAmSure);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxIAmSure.isSelected())
				{
					dbConnection db = new dbConnection();
					db.UserDeleteAccount();
					db.UpdateStatus();
					db.close();
					main.logged = false;
					MainWindow mainwindow = new MainWindow();
					mainwindow.Mainframe.setVisible(true);
					UserDeleteAcountframe.dispose();
					
				}
			}
		});
		btnDelete.setBounds(10, 87, 89, 23);
		UserDeleteAcountframe.getContentPane().add(btnDelete);
	}
}

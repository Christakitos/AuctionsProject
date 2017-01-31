import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class MyProfile {

	public JFrame MyProfileframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//MyProfile wMyProfile = new MyProfile();
					//wMyProfile.MyProfileframe.setVisible(true);
					
					
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
	public MyProfile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MyProfileframe = new JFrame();
		MyProfileframe.setTitle("My Profile");
		MyProfileframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\AuctionsSetupFiles\\imgs\\Main image.jpg"));
		MyProfileframe.setResizable(false);
		MyProfileframe.setBounds(100, 100, 450, 257);
		MyProfileframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		MyProfileframe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\AuctionsSetupFiles\\imgs\\Profile.jpg"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 11, 70, 70);
		MyProfileframe.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername1 = new JLabel("Username:");
		lblUsername1.setBounds(90, 11, 70, 14);
		MyProfileframe.getContentPane().add(lblUsername1);
		
		JLabel lblName1 = new JLabel("Name:");
		lblName1.setBounds(90, 39, 70, 14);
		MyProfileframe.getContentPane().add(lblName1);
		
		JLabel lblSurname1 = new JLabel("Surname:");
		lblSurname1.setBounds(90, 64, 70, 14);
		MyProfileframe.getContentPane().add(lblSurname1);
		
		JLabel lblEmail1 = new JLabel("Email:");
		lblEmail1.setBounds(90, 92, 54, 14);
		MyProfileframe.getContentPane().add(lblEmail1);
		
		JLabel lblAuctionsWonne = new JLabel("Auctions Won :");
		lblAuctionsWonne.setBounds(10, 118, 95, 14);
		MyProfileframe.getContentPane().add(lblAuctionsWonne);
		
		JLabel lblNotYetPaid = new JLabel("Not yet Paid:");
		lblNotYetPaid.setBounds(10, 157, 95, 14);
		MyProfileframe.getContentPane().add(lblNotYetPaid);
		
		JComboBox comboBoxNotPaid = new JComboBox(main.AuctionsNotPaidName.toArray());
		comboBoxNotPaid.setBounds(100, 154, 225, 20);
		MyProfileframe.getContentPane().add(comboBoxNotPaid);
		
		JComboBox comboBoxPaid = new JComboBox(main.AuctionsPaidName.toArray());
		comboBoxPaid.setBounds(100, 117, 225, 20);
		MyProfileframe.getContentPane().add(comboBoxPaid);
		
		JButton btnNotPaied = new JButton("Go");
		btnNotPaied.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dbConnection db = new dbConnection();
				main.SelectedAuctionID = Integer.valueOf(main.AuctionsNotPaidID.get(comboBoxNotPaid.getSelectedIndex()));
		        db.NotPaidInfo(main.SelectedAuctionID);
		        db.close();
		        PayWindow wPay = new PayWindow();
				wPay.Payframe.setVisible(true);
				MyProfileframe.dispose();
				
			}
		});
		btnNotPaied.setBounds(335, 153, 89, 23);
		MyProfileframe.getContentPane().add(btnNotPaied);
		
		JLabel lblUsername = new JLabel("");
		lblUsername.setBounds(176, 11, 106, 14);
		lblUsername.setText(main.Username);
		MyProfileframe.getContentPane().add(lblUsername);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(176, 39, 106, 14);
		lblName.setText(main.Name);
		MyProfileframe.getContentPane().add(lblName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(176, 64, 106, 14);
		lblSurname.setText(main.Surname);
		MyProfileframe.getContentPane().add(lblSurname);
		
		JLabel lblEmail = new JLabel("");
		lblEmail.setBounds(150, 89, 169, 14);
		lblEmail.setText(main.Email);
		MyProfileframe.getContentPane().add(lblEmail);
		
		JButton btnChangeInfo = new JButton("Edit your profile");
		btnChangeInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserUpdate wUserUpdate = new UserUpdate();
				wUserUpdate.UserUpdateframe.setVisible(true);
				MyProfileframe.dispose();
			}
		});
		btnChangeInfo.setBounds(292, 35, 132, 43);
		MyProfileframe.getContentPane().add(btnChangeInfo);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbConnection db = new dbConnection();
				db.UpdateStatus();
				db.close();
				
				MainWindow mainwindow = new MainWindow();
				mainwindow.Mainframe.setVisible(true);
				MyProfileframe.dispose();
			}
		});
		btnBack.setBounds(335, 184, 89, 23);
		MyProfileframe.getContentPane().add(btnBack);
	}
}

import java.awt.EventQueue;
import java.awt.Desktop;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class PayWindow {

	public JFrame Payframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//PayWindow wPay = new PayWindow();
					//wPay.Payframe.setVisible(true);
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
	public PayWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Payframe = new JFrame();
		Payframe.setResizable(false);
		Payframe.setTitle("Payment");
		Payframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\AuctionsSetupFiles\\imgs\\Main image.jpg"));
		Payframe.setBounds(100, 100, 335, 232);
		Payframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Payframe.getContentPane().setLayout(null);
		
		JLabel lblItemsName = new JLabel("Items Name:");
		lblItemsName.setBounds(10, 11, 83, 14);
		Payframe.getContentPane().add(lblItemsName);
		
		JLabel lblWinningPrice = new JLabel("Winning Price:");
		lblWinningPrice.setBounds(10, 61, 83, 14);
		Payframe.getContentPane().add(lblWinningPrice);
		
		JLabel lblNewLabel = new JLabel("Items ID:");
		lblNewLabel.setBounds(10, 36, 83, 14);
		Payframe.getContentPane().add(lblNewLabel);
		
		JLabel lblEndTime = new JLabel("End Time:");
		lblEndTime.setBounds(10, 86, 83, 14);
		Payframe.getContentPane().add(lblEndTime);
		
		JLabel lblWarningMustBe = new JLabel("Warning: Must be paied until 7Days of the End Time!");
		lblWarningMustBe.setForeground(Color.ORANGE);
		lblWarningMustBe.setBounds(10, 111, 303, 14);
		Payframe.getContentPane().add(lblWarningMustBe);
		
		JLabel lblNewLabel_1 = new JLabel(main.SelectedAuctionName);
		lblNewLabel_1.setBounds(103, 11, 206, 14);
		Payframe.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel(Integer.toString(main.SelectedAuctionID));
		label.setBounds(103, 36, 206, 14);
		Payframe.getContentPane().add(label);
		
		JLabel label_1 = new JLabel(Integer.toString(main.SelectedAuctionPrice));
		label_1.setBounds(103, 61, 206, 14);
		Payframe.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel(String.valueOf(main.SelectedAuctionTime)+" "+main.SelectedAuctionDate.toString());
		label_2.setBounds(103, 86, 206, 14);
		Payframe.getContentPane().add(label_2);
		
		JButton btnGoToPay = new JButton("<html>Go to Pay Website</html>");
		btnGoToPay.setVerticalAlignment(SwingConstants.TOP);
		btnGoToPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Desktop d = Desktop.getDesktop();
				try {
					d.browse(new URI("https://www.vivawallet.com/el-gr/personal/add-pay-transfer"));
					dbConnection db =new dbConnection();
					db.PayAuction(main.SelectedAuctionID);
					db.AuctionsStatus();
					db.UpdateStatus();
					db.close();
					
					MyProfile wMyProfile = new MyProfile();
					wMyProfile.MyProfileframe.setVisible(true);
					Payframe.dispose();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnGoToPay.setBounds(4, 136, 102, 43);
		Payframe.getContentPane().add(btnGoToPay);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyProfile wMyProfile = new MyProfile();
				wMyProfile.MyProfileframe.setVisible(true);
				Payframe.dispose();
			}
		});
		btnBack.setBounds(220, 159, 89, 23);
		Payframe.getContentPane().add(btnBack);
	}

}

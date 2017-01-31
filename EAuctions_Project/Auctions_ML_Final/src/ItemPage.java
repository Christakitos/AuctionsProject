import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemPage {

	public JFrame Itemsframe;
	private JTextField textBid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//ItemPage wItem= new ItemPage();
					//wItem.Itemsframe.setVisible(true);
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
	public ItemPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Itemsframe = new JFrame();
		Itemsframe.setTitle("Piraeus University of Applied Science Auctions");
		Itemsframe.setResizable(false);
		Itemsframe.setBounds(100, 100, 450, 409);
		Itemsframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Itemsframe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\AuctionsSetupFiles\\imgs\\Items.png"));
		lblNewLabel.setBounds(10, 11, 120, 120);
		Itemsframe.getContentPane().add(lblNewLabel);
		
		JLabel lblItemName = new JLabel(main.SeName);
		lblItemName.setBounds(140, 11, 120, 14);
		Itemsframe.getContentPane().add(lblItemName);
		
		JLabel lblEndingTime = new JLabel("Ending Time :");
		lblEndingTime.setBounds(140, 36, 80, 14);
		Itemsframe.getContentPane().add(lblEndingTime);
		
		JLabel lblHighestBider = new JLabel("Highest Bider:");
		lblHighestBider.setBounds(140, 64, 80, 14);
		Itemsframe.getContentPane().add(lblHighestBider);
		
		JLabel lblcp = new JLabel("Current Price:");
		lblcp.setBounds(140, 89, 80, 14);
		Itemsframe.getContentPane().add(lblcp);
		
		JLabel lblBid = new JLabel("BID:");
		lblBid.setBounds(140, 114, 35, 14);
		Itemsframe.getContentPane().add(lblBid);
		
		textBid = new JTextField();
		textBid.setBounds(166, 111, 80, 20);
		Itemsframe.getContentPane().add(textBid);
		textBid.setColumns(10);
		
		JCheckBox chckbxIAmSure = new JCheckBox("I Am sure!");
		chckbxIAmSure.setBounds(252, 108, 92, 23);
		Itemsframe.getContentPane().add(chckbxIAmSure);
		
		JButton btnBid = new JButton("BID!");
		btnBid.setEnabled(main.logged);
		btnBid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean Flag = true;
				if(chckbxIAmSure.isSelected())
				{
					String Insert =textBid.getText();
					for (int i = 0;i < Insert.length(); i++){
						if(Insert.charAt(i) >= 'a')
						{
							Flag = false;
						}
						
						
					}
					if(Flag == true)
					{
						boolean Flag2 = false;
						dbConnection db = new dbConnection();
						 Flag2 =db.Bid(textBid.getText(),main.Username,Integer.parseInt(main.SeID));
						db.close();
						if(Flag2 = true)
						{
							main.SeWinner = main.Username;
							main.SePrice = textBid.getText();
							Itemsframe.dispose();
							dbConnection db2 = new dbConnection();
							db2.UpdateStatus();
							db2.close();
							ItemPage wItem= new ItemPage();
							wItem.Itemsframe.setVisible(true);
						}
					}
					
				}
				chckbxIAmSure.setSelected(false);
			}
		});
		btnBid.setBounds(350, 108, 74, 23);
		Itemsframe.getContentPane().add(btnBid);
		
		JLabel lblNewLabel_1 = new JLabel("Items Description");
		lblNewLabel_1.setBounds(10, 142, 120, 14);
		Itemsframe.getContentPane().add(lblNewLabel_1);
		
		JLabel lblItemsdescription = new JLabel(main.SeItemD);
		lblItemsdescription.setHorizontalAlignment(SwingConstants.LEFT);
		lblItemsdescription.setVerticalAlignment(SwingConstants.TOP);
		lblItemsdescription.setBounds(10, 167, 414, 60);
		Itemsframe.getContentPane().add(lblItemsdescription);
		
		JLabel lblSellersDescription = new JLabel(main.SeSellerD);
		lblSellersDescription.setVerticalAlignment(SwingConstants.TOP);
		lblSellersDescription.setHorizontalAlignment(SwingConstants.LEFT);
		lblSellersDescription.setBounds(10, 263, 414, 60);
		Itemsframe.getContentPane().add(lblSellersDescription);
		
		JLabel lblSellersDescriptiondsd = new JLabel("Seller's description");
		lblSellersDescriptiondsd.setBounds(10, 238, 120, 14);
		Itemsframe.getContentPane().add(lblSellersDescriptiondsd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbConnection db = new dbConnection();
				db.CategoriesPop ();
				db.close();
				main.ItemsPage = false;
				MainWindow mainwindow = new MainWindow();
				mainwindow.Mainframe.setVisible(true);
				Itemsframe.dispose();
			}
		});
		btnBack.setBounds(335, 336, 89, 23);
		Itemsframe.getContentPane().add(btnBack);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.ItemsPage = true;
				SignIn wSignIn = new SignIn();
				wSignIn.SignInframe.setVisible(true);
				wSignIn.mainSignIn();
				Itemsframe.dispose();
				
			}
		});
		btnLogIn.setBounds(335, 11, 89, 23);
		Itemsframe.getContentPane().add(btnLogIn);
		
		JLabel lblId = new JLabel(main.SeID);
		lblId.setBounds(350, 142, 74, 14);
		Itemsframe.getContentPane().add(lblId);
		
		JLabel lblItemsId = new JLabel("Items ID:");
		lblItemsId.setBounds(262, 142, 82, 14);
		Itemsframe.getContentPane().add(lblItemsId);
		
		JLabel lblTime = new JLabel(main.SeTime+"    "+main.SeDate);
		lblTime.setBounds(230, 36, 194, 14);
		Itemsframe.getContentPane().add(lblTime);
		
		JLabel labelWinner = new JLabel(main.SeWinner);
		labelWinner.setBounds(230, 64, 194, 14);
		Itemsframe.getContentPane().add(labelWinner);
		
		JLabel lblPrice = new JLabel(main.SePrice+"  Euro");
		lblPrice.setBounds(230, 89, 194, 14);
		Itemsframe.getContentPane().add(lblPrice);
		
		JButton btnRefresh = new JButton("");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Itemsframe.dispose();
				dbConnection db2 = new dbConnection();
				db2.UpdateStatus();
				db2.close();
				ItemPage wItem= new ItemPage();
				wItem.Itemsframe.setVisible(true);
				
			}
		});
		btnRefresh.setIcon(new ImageIcon("C:\\AuctionsSetupFiles\\imgs\\Refresh.png"));
		btnRefresh.setBounds(301, 11, 25, 23);
		Itemsframe.getContentPane().add(btnRefresh);
	}
}

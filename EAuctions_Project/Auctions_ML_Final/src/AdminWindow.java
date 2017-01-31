import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.Toolkit;



public class AdminWindow {

	public JFrame AdminWindowframe;
	private JTextField textUsername;
	private JPasswordField passwordField;
	private JPasswordField CpasswordField;
	private JTextField textCNAName;
	private JTextField textCNAPrice;
	private JTextField textCNATimeH;
	private JTextField textCNASeller;
	private JTextField textCNAItem;
	private JTextField textCNAImage;
	private JTextField textNewCategory;
	private JTextField textNewSubCategory;
	
	//------------------------------------
	public static int CNACategoryValue =0;
	private JTextField textTags;
	private JTextField textCNADateD;
	private JTextField textCNADateM;
	private JTextField textCNADateY;
	private JTextField textCNATimeM;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//AdminWindow wAdmin = new AdminWindow();
					//wAdmin.AdminWindowframe.setVisible(true);
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
	public AdminWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AdminWindowframe = new JFrame();
		AdminWindowframe.setTitle("Administration Panel");
		AdminWindowframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\AuctionsSetupFiles\\imgs\\Profile.jpg"));
		AdminWindowframe.setResizable(false);
		AdminWindowframe.setAutoRequestFocus(false);
		AdminWindowframe.setBounds(100, 100, 809, 734);
		AdminWindowframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		AdminWindowframe.getContentPane().setLayout(null);
		
		JLabel lblerrorAtEntry = new JLabel("*Error at entry!");
		lblerrorAtEntry.setForeground(Color.RED);
		lblerrorAtEntry.setVisible(false);
		lblerrorAtEntry.setBounds(263, 174, 101, 14);
		AdminWindowframe.getContentPane().add(lblerrorAtEntry);
		
		JLabel lblWelcomeAdminstrator = new JLabel("Welcome Administrator,");
		lblWelcomeAdminstrator.setBounds(10, 11, 140, 14);
		AdminWindowframe.getContentPane().add(lblWelcomeAdminstrator);
		
		JLabel lblCreateNewAdmin = new JLabel("Create New Admin");
		lblCreateNewAdmin.setBounds(130, 61, 112, 14);
		AdminWindowframe.getContentPane().add(lblCreateNewAdmin);
		
		JButton btnAdminCreate = new JButton("Create");
		btnAdminCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblerrorAtEntry.setVisible(false);
				boolean Flag = true;
				
				char [] pass= passwordField.getPassword();
				String EnteredPassword = new String(pass);
				char [] cpass= CpasswordField.getPassword();
				String EnteredCPassword = new String(cpass);
				
				if(!EnteredPassword.equals(EnteredCPassword) || EnteredPassword.equals(""))
				{
					Flag = false;
				}
				
				if(textUsername.getText().equals(null))
				{
					Flag = false;
				}
				
				if(Flag == true)
				{
					dbConnection db = new dbConnection();
					db.CreateAdmin(textUsername.getText(),EnteredPassword);
					db.close();
				}
				else
				{
					lblerrorAtEntry.setVisible(true);
				}
			}
		});
		btnAdminCreate.setBounds(130, 170, 89, 23);
		AdminWindowframe.getContentPane().add(btnAdminCreate);
		
		JLabel lblAdminManagmentMenu = new JLabel("Admin Manager Menu");
		lblAdminManagmentMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminManagmentMenu.setBounds(235, 36, 129, 14);
		AdminWindowframe.getContentPane().add(lblAdminManagmentMenu);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(130, 88, 112, 14);
		AdminWindowframe.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(130, 113, 112, 14);
		AdminWindowframe.getContentPane().add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setBounds(130, 138, 112, 14);
		AdminWindowframe.getContentPane().add(lblConfirmPassword);
		
		textUsername = new JTextField();
		textUsername.setBounds(252, 85, 112, 20);
		AdminWindowframe.getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(253, 110, 111, 20);
		AdminWindowframe.getContentPane().add(passwordField);
		
		CpasswordField = new JPasswordField();
		CpasswordField.setBounds(253, 135, 111, 20);
		AdminWindowframe.getContentPane().add(CpasswordField);
		
		JLabel lblSelectAdminsTo = new JLabel("Select Admins to delete");
		lblSelectAdminsTo.setBounds(414, 61, 140, 14);
		AdminWindowframe.getContentPane().add(lblSelectAdminsTo);
		
		JComboBox comboBoxAdminList = new JComboBox();
		comboBoxAdminList.setBounds(438, 85, 130, 20);
		comboBoxAdminList.addPopupMenuListener(new PopupMenuListener()
		{
		    public void popupMenuWillBecomeVisible(PopupMenuEvent e)
		    {
		    	comboBoxAdminList.removeAllItems();
		    	dbConnection db = new dbConnection();
		    	db.AdminList();
				db.close();
		    	int i=0;
		    	while(i<main.AdminList.size())
		    	{
		    		comboBoxAdminList.addItem(main.AdminList.get(i));
		    		i++;
		    	}
		    }

		    public void popupMenuCanceled(PopupMenuEvent e) {}
		    public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}

		});
		AdminWindowframe.getContentPane().add(comboBoxAdminList);
		
		JCheckBox chckbxDelAdmin = new JCheckBox("I am sure!");
		chckbxDelAdmin.setBounds(526, 134, 97, 23);
		AdminWindowframe.getContentPane().add(chckbxDelAdmin);
		
		JButton btnAdminDelete = new JButton("Delete");
		btnAdminDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(chckbxDelAdmin.isSelected())
				{
				dbConnection db = new dbConnection();
				db.RemoveAdmin(comboBoxAdminList.getSelectedItem().toString());
				db.close();
				db.AdminList();
				db.close();
				}
				chckbxDelAdmin.setSelected(false);
				
			}
		});
		btnAdminDelete.setBounds(427, 134, 89, 23);
		AdminWindowframe.getContentPane().add(btnAdminDelete);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow mainwindow = new MainWindow();
				mainwindow.Mainframe.setVisible(true);
				AdminWindowframe.dispose();
			}
		});
		btnLogOut.setBounds(694, 7, 89, 23);
		AdminWindowframe.getContentPane().add(btnLogOut);
		
		JLabel lblAuctionsMenu = new JLabel("Auctions Menu");
		lblAuctionsMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuctionsMenu.setBounds(235, 207, 140, 14);
		AdminWindowframe.getContentPane().add(lblAuctionsMenu);
		
		JLabel lblManageRunningAuctions = new JLabel("Manage Active Auctions");
		lblManageRunningAuctions.setBounds(89, 219, 140, 14);
		AdminWindowframe.getContentPane().add(lblManageRunningAuctions);
		
		JLabel lblSelect = new JLabel("Select ID:");
		lblSelect.setBounds(10, 245, 69, 14);
		AdminWindowframe.getContentPane().add(lblSelect);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(211, 245, 46, 14);
		AdminWindowframe.getContentPane().add(lblName);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(211, 269, 46, 14);
		AdminWindowframe.getContentPane().add(lblPrice);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(211, 294, 46, 14);
		AdminWindowframe.getContentPane().add(lblTime);
		
		JLabel lblBider = new JLabel("Bidder:");
		lblBider.setBounds(209, 319, 46, 14);
		AdminWindowframe.getContentPane().add(lblBider);
		
		JLabel lblMAAPrice = new JLabel("New label");
		lblMAAPrice.setBounds(267, 269, 85, 14);
		AdminWindowframe.getContentPane().add(lblMAAPrice);
		
		JLabel lblMAATime = new JLabel("New label");
		lblMAATime.setBounds(267, 294, 85, 14);
		AdminWindowframe.getContentPane().add(lblMAATime);
		
		JLabel lblMAABidder = new JLabel("New label");
		lblMAABidder.setBounds(267, 319, 85, 14);
		AdminWindowframe.getContentPane().add(lblMAABidder);
		
		JLabel lblMAAName = new JLabel("New label");
		lblMAAName.setBounds(263, 245, 89, 14);
		AdminWindowframe.getContentPane().add(lblMAAName);
		
		JComboBox comboBoxMAA = new JComboBox();
		comboBoxMAA.setBounds(89, 245, 112, 20);
		comboBoxMAA.addPopupMenuListener(new PopupMenuListener()
		{
		    public void popupMenuWillBecomeVisible(PopupMenuEvent e)
		    {

		    	comboBoxMAA.removeAllItems();
		    	comboBoxMAA.addItem("");
		    	dbConnection db = new dbConnection();
		    	db.AuctionStatus();
				db.close();
		    	int i=0;
		    	while(i<main.ActiveActionsIDs.size())
		    	{
		    		comboBoxMAA.addItem(main.ActiveActionsIDs.get(i));
		    		i++;
		    	}

		    }
		    
		    public void popupMenuCanceled(PopupMenuEvent e) {}
		    public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}

		});
		comboBoxMAA.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	if(comboBoxMAA.getSelectedIndex()>0)
		    	{
		    	dbConnection db = new dbConnection();
		        db.GetAuctionInfoActive(comboBoxMAA.getSelectedIndex());
		        db.close();
		        
		        lblMAAName.setText(main.SelectedAuctionName);
		        lblMAAPrice.setText(String.valueOf(main.SelectedAuctionPrice));
		        lblMAATime.setText(String.valueOf(main.SelectedAuctionTime)+" "+main.SelectedAuctionDate.toString());
		        lblMAABidder.setText(main.SelectedAuctionWinner);
		    	}
		        
		    }
		});
		AdminWindowframe.getContentPane().add(comboBoxMAA);
		
		
		
		JLabel label_1 = new JLabel("Select ID:");
		label_1.setBounds(407, 245, 62, 14);
		AdminWindowframe.getContentPane().add(label_1);
		
		JLabel lblManagePausedpassedAuctions = new JLabel("Manage Paused/ See Passed Auctions");
		lblManagePausedpassedAuctions.setBounds(457, 219, 213, 14);
		AdminWindowframe.getContentPane().add(lblManagePausedpassedAuctions);
		
		JLabel label_3 = new JLabel("Name:");
		label_3.setBounds(601, 245, 46, 14);
		AdminWindowframe.getContentPane().add(label_3);
		
		JLabel lblMPAName = new JLabel("");
		lblMPAName.setBounds(657, 245, 126, 14);
		AdminWindowframe.getContentPane().add(lblMPAName);
		
		JLabel label_5 = new JLabel("Price:");
		label_5.setBounds(601, 269, 46, 14);
		AdminWindowframe.getContentPane().add(label_5);
		
		JLabel lblMPAPrice = new JLabel("");
		lblMPAPrice.setBounds(657, 269, 126, 14);
		AdminWindowframe.getContentPane().add(lblMPAPrice);
		
		JLabel label_7 = new JLabel("Time:");
		label_7.setBounds(601, 294, 46, 14);
		AdminWindowframe.getContentPane().add(label_7);
		
		JLabel lblMPATime = new JLabel("");
		lblMPATime.setBounds(657, 294, 126, 14);
		AdminWindowframe.getContentPane().add(lblMPATime);
		
		JLabel label_9 = new JLabel("Bidder:");
		label_9.setBounds(599, 319, 46, 14);
		AdminWindowframe.getContentPane().add(label_9);
		
		JLabel lblMPABidder = new JLabel("");
		lblMPABidder.setBounds(657, 319, 126, 14);
		AdminWindowframe.getContentPane().add(lblMPABidder);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(599, 344, 46, 14);
		AdminWindowframe.getContentPane().add(lblStatus);
		
		JLabel lblMPAStatus = new JLabel("");
		lblMPAStatus.setBounds(657, 344, 126, 14);
		AdminWindowframe.getContentPane().add(lblMPAStatus);
		
		JComboBox<String> comboBoxMPA = new JComboBox<String>();
		comboBoxMPA.setBounds(479, 245, 112, 20);
		comboBoxMPA.addPopupMenuListener(new PopupMenuListener()
		{
		    public void popupMenuWillBecomeVisible(PopupMenuEvent e)
		    {
		    	
		    	comboBoxMPA.removeAllItems();
		    	comboBoxMPA.addItem("");
		    	dbConnection db = new dbConnection();
		    	db.AuctionStatus();
				db.close();
		    	int i=0;
		    	while(i<main.NonActiveActionsIDs.size())
		    	{
		    		comboBoxMPA.addItem(main.NonActiveActionsIDs.get(i));
		    		i++;
		    	}
		    	

		    }

		    public void popupMenuCanceled(PopupMenuEvent e) {}
		    public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}

		});
		comboBoxMPA.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	if(comboBoxMPA.getSelectedIndex()>0)
		    	{
		    	dbConnection db = new dbConnection();
		        db.GetAuctionInfoNonActive(comboBoxMPA.getSelectedIndex());
		        db.close();
				
		        lblMPAName.setText(main.SelectedAuctionName);
		        lblMPAPrice.setText(String.valueOf(main.SelectedAuctionPrice));
		        lblMPATime.setText(String.valueOf(main.SelectedAuctionTime)+" "+main.SelectedAuctionDate.toString());
		        lblMPABidder.setText(main.SelectedAuctionWinner);
		        lblMPAStatus.setText(main.SelectedAuctionStatus);
		    	}
		        
		    }
		});
		AdminWindowframe.getContentPane().add(comboBoxMPA);
		
		JCheckBox chckbxIMPA = new JCheckBox("I am sure!");
		chckbxIMPA.setBounds(494, 310, 97, 23);
		AdminWindowframe.getContentPane().add(chckbxIMPA);
		
		
		
		JButton btnMPAResume = new JButton("Resume");
		btnMPAResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxIMPA.isSelected())
				{
					dbConnection db = new dbConnection();
					db.ResumeNonActiveAuction(main.SelectedAuctionID);
					db.close();
				}
				chckbxIMPA.setSelected(false);
			}
		});
		btnMPAResume.setBounds(479, 335, 89, 23);
		AdminWindowframe.getContentPane().add(btnMPAResume);
		
		JCheckBox chckbxIMAAPause = new JCheckBox("I am sure!");
		chckbxIMAAPause.setBounds(112, 315, 89, 23);
		AdminWindowframe.getContentPane().add(chckbxIMAAPause);
		
		JButton btnMAAPause = new JButton("Pause");
		btnMAAPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxIMAAPause.isSelected())
				{
					dbConnection db = new dbConnection();
					db.PauseActiveAuction(main.SelectedAuctionID);
					db.close();
				}
				chckbxIMAAPause.setSelected(false);
			}
		});
		btnMAAPause.setBounds(112, 340, 89, 23);
		AdminWindowframe.getContentPane().add(btnMAAPause);
		
		JLabel lblUserAdmin = new JLabel("");
		lblUserAdmin.setForeground(Color.ORANGE);
		lblUserAdmin.setBounds(160, 11, 97, 14);
		lblUserAdmin.setText(main.Username);
		AdminWindowframe.getContentPane().add(lblUserAdmin);
		
		JLabel lblCreateNewAuction = new JLabel("Create New Auction");
		lblCreateNewAuction.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateNewAuction.setBounds(235, 374, 140, 14);
		AdminWindowframe.getContentPane().add(lblCreateNewAuction);
		
		JLabel lblNewAuctionsId = new JLabel("New Auctions ID:");
		lblNewAuctionsId.setBounds(10, 397, 112, 14);
		AdminWindowframe.getContentPane().add(lblNewAuctionsId);
		
		JLabel lblICNAID = new JLabel("ID num");
		lblICNAID.setBounds(130, 397, 89, 14);
		AdminWindowframe.getContentPane().add(lblICNAID);
		
		JLabel lblNewAuctionsName = new JLabel("New Auctions Name:");
		lblNewAuctionsName.setBounds(10, 422, 121, 14);
		AdminWindowframe.getContentPane().add(lblNewAuctionsName);
		
		textCNAName = new JTextField();
		textCNAName.setBounds(130, 422, 140, 20);
		AdminWindowframe.getContentPane().add(textCNAName);
		textCNAName.setColumns(10);
		
		JLabel lblStartingPrice = new JLabel("Starting Price:");
		lblStartingPrice.setBounds(280, 422, 84, 14);
		AdminWindowframe.getContentPane().add(lblStartingPrice);
		
		textCNAPrice = new JTextField();
		textCNAPrice.setColumns(10);
		textCNAPrice.setBounds(374, 419, 140, 20);
		AdminWindowframe.getContentPane().add(textCNAPrice);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(534, 422, 36, 14);
		AdminWindowframe.getContentPane().add(lblDate);
		
		JLabel lblTime_1 = new JLabel("Time:");
		lblTime_1.setBounds(534, 447, 36, 14);
		AdminWindowframe.getContentPane().add(lblTime_1);
		
		textCNATimeH = new JTextField();
		textCNATimeH.setColumns(10);
		textCNATimeH.setBounds(590, 444, 20, 20);
		AdminWindowframe.getContentPane().add(textCNATimeH);
		
		JLabel lblSellersDescription = new JLabel("Seller's description:");
		lblSellersDescription.setBounds(10, 450, 121, 14);
		AdminWindowframe.getContentPane().add(lblSellersDescription);
		
		textCNASeller = new JTextField();
		textCNASeller.setBounds(130, 447, 386, 20);
		AdminWindowframe.getContentPane().add(textCNASeller);
		textCNASeller.setColumns(10);
		
		textCNAItem = new JTextField();
		textCNAItem.setColumns(10);
		textCNAItem.setBounds(130, 475, 386, 20);
		AdminWindowframe.getContentPane().add(textCNAItem);
		
		JLabel lblItemsDescription = new JLabel("Items description:");
		lblItemsDescription.setBounds(10, 478, 121, 14);
		AdminWindowframe.getContentPane().add(lblItemsDescription);
		
		JLabel lblImageSrc = new JLabel("Image SRC path:");
		lblImageSrc.setBounds(10, 509, 121, 14);
		AdminWindowframe.getContentPane().add(lblImageSrc);
		
		textCNAImage = new JTextField();
		textCNAImage.setColumns(10);
		textCNAImage.setBounds(130, 506, 386, 20);
		AdminWindowframe.getContentPane().add(textCNAImage);
		
		JCheckBox chckbxICNA = new JCheckBox("I am sure!");
		chckbxICNA.setBounds(372, 533, 97, 23);
		AdminWindowframe.getContentPane().add(chckbxICNA);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setBounds(526, 478, 62, 14);
		AdminWindowframe.getContentPane().add(lblCategory);
		
		JLabel lblScategory = new JLabel("S_Category:");
		lblScategory.setBounds(519, 509, 69, 14);
		AdminWindowframe.getContentPane().add(lblScategory);
		
		JComboBox comboBoxCNACategory = new JComboBox(main.CategoriesName.toArray());
		comboBoxCNACategory.setBounds(590, 475, 123, 20);
		AdminWindowframe.getContentPane().add(comboBoxCNACategory);
		
		JComboBox comboBoxCNASubcategory = new JComboBox();
		comboBoxCNASubcategory.setBounds(590, 506, 123, 20);
		comboBoxCNASubcategory.addPopupMenuListener(new PopupMenuListener()
		{
		    public void popupMenuWillBecomeVisible(PopupMenuEvent e)
		    {
		    	comboBoxCNASubcategory.removeAllItems();
		        
		        int i =0;
		        int Value =0;
		       CNACategoryValue = comboBoxCNACategory.getSelectedIndex()+1;
		        while(i < main.SubCategoriesID.size())
		        {
		        	Value = Integer.parseInt(main.SubCategoriesCatID.get(i));
		        	if(CNACategoryValue == Value )
		        	{
		        		comboBoxCNASubcategory.addItem(main.SubCategoriesName.get(i));
		        	}
		        	i++;
		        }
		    }

		    public void popupMenuCanceled(PopupMenuEvent e) {}
		    public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}

		});
		AdminWindowframe.getContentPane().add(comboBoxCNASubcategory);
		
		JLabel lblCategorysubcategoryMenu = new JLabel("Category/Subcategory Menu");
		lblCategorysubcategoryMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategorysubcategoryMenu.setBounds(235, 560, 161, 14);
		AdminWindowframe.getContentPane().add(lblCategorysubcategoryMenu);
		
		JLabel lblViewCategories = new JLabel("View Categories:");
		lblViewCategories.setBounds(10, 585, 112, 14);
		AdminWindowframe.getContentPane().add(lblViewCategories);
		
		JLabel lblViewSubcategories = new JLabel("View SubCategories:");
		lblViewSubcategories.setBounds(0, 610, 121, 14);
		AdminWindowframe.getContentPane().add(lblViewSubcategories);
		
		JLabel lblCNAError = new JLabel("*Error at entry!");
		lblCNAError.setForeground(Color.RED);
		lblCNAError.setVisible(false);
		lblCNAError.setBounds(158, 537, 101, 14);
		AdminWindowframe.getContentPane().add(lblCNAError);
		
		JComboBox comboBoxCategories = new JComboBox(main.CategoriesName.toArray());
		comboBoxCategories.setBounds(130, 582, 140, 20);
		AdminWindowframe.getContentPane().add(comboBoxCategories);
		
		JComboBox comboBoxSubCategories = new JComboBox(main.SubCategoriesName.toArray());
		comboBoxSubCategories.setBounds(130, 607, 140, 20);
		comboBoxSubCategories.addPopupMenuListener(new PopupMenuListener()
		{
		    public void popupMenuWillBecomeVisible(PopupMenuEvent e)
		    {
		    	comboBoxSubCategories.removeAllItems();
		        
		        int i =0;
		        int Value =0;
		       CNACategoryValue = comboBoxCategories.getSelectedIndex()+1;
		        while(i < main.SubCategoriesID.size())
		        {
		        	Value = Integer.parseInt(main.SubCategoriesCatID.get(i));
		        	System.out.println(Value);
		        	if(CNACategoryValue == Value )
		        	{
		        		System.out.println("entered");
		        		comboBoxSubCategories.addItem(main.SubCategoriesName.get(i));
		        	}
		        	i++;
		        }
		    }

		    public void popupMenuCanceled(PopupMenuEvent e) {}
		    public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}

		});
		AdminWindowframe.getContentPane().add(comboBoxSubCategories);
		
		JLabel lblCreateNewCategory = new JLabel("Create New Category:");
		lblCreateNewCategory.setBounds(280, 585, 145, 14);
		AdminWindowframe.getContentPane().add(lblCreateNewCategory);
		
		JLabel lblCreateNewSubcategory = new JLabel("Create New SubCategory:");
		lblCreateNewSubcategory.setBounds(280, 610, 145, 14);
		AdminWindowframe.getContentPane().add(lblCreateNewSubcategory);
		
		textNewCategory = new JTextField();
		textNewCategory.setBounds(427, 582, 117, 20);
		AdminWindowframe.getContentPane().add(textNewCategory);
		textNewCategory.setColumns(10);
		
		textNewSubCategory = new JTextField();
		textNewSubCategory.setBounds(427, 607, 117, 20);
		AdminWindowframe.getContentPane().add(textNewSubCategory);
		textNewSubCategory.setColumns(10);
		
		JCheckBox chckbxCategory = new JCheckBox("I am sure");
		chckbxCategory.setBounds(550, 581, 84, 23);
		AdminWindowframe.getContentPane().add(chckbxCategory);
		
		JCheckBox chckbxSubCategory = new JCheckBox("I am sure");
		chckbxSubCategory.setBounds(624, 661, 84, 23);
		AdminWindowframe.getContentPane().add(chckbxSubCategory);
		
		JLabel lblNewCategoryError = new JLabel("*Exists!");
		lblNewCategoryError.setForeground(Color.RED);
		lblNewCategoryError.setVisible(false);
		lblNewCategoryError.setBounds(723, 585, 60, 14);
		AdminWindowframe.getContentPane().add(lblNewCategoryError);
		
		JLabel lblNewSubError = new JLabel("*Exists");
		lblNewSubError.setForeground(Color.RED);
		lblNewSubError.setVisible(false);
		lblNewSubError.setBounds(479, 665, 65, 14);
		AdminWindowframe.getContentPane().add(lblNewSubError);
		
		JButton btnCategoryCreate = new JButton("Create");
		btnCategoryCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewCategoryError.setVisible(false);
				if(chckbxCategory.isSelected() && !textNewCategory.getText().equals(null))
				{
					dbConnection db = new dbConnection();
					db.CreateNewCategory(textNewCategory.getText());
					db.close();
					
					
					
				}
				else
				{
					lblNewCategoryError.setVisible(true);
				}
				chckbxCategory.setSelected(false);
			}
		});
		btnCategoryCreate.setBounds(640, 581, 73, 23);
		AdminWindowframe.getContentPane().add(btnCategoryCreate);
		
		JComboBox comboBoxSubCatselCat = new JComboBox(main.CategoriesName.toArray());
		comboBoxSubCatselCat.setBounds(550, 635, 163, 20);
		AdminWindowframe.getContentPane().add(comboBoxSubCatselCat);
		
		JButton btnSubCategoryCreate = new JButton("Create");
		btnSubCategoryCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewSubError.setVisible(false);
				
				if(chckbxSubCategory.isSelected() && !textNewSubCategory.getText().equals(null) && comboBoxSubCatselCat.getSelectedItem() !=null )
				{
					int ID = comboBoxSubCatselCat.getSelectedIndex();
					int FinalID = Integer.valueOf(main.CategoriesID.get(ID));
					int SubID = main.SubCategoriesCatID.size()+1;
					dbConnection db = new dbConnection();
					db.CreateNewSubCategory(textNewSubCategory.getText(),FinalID,SubID);
					db.CategoriesPop();
					db.close();
				}
				else
				{
					lblNewSubError.setVisible(true);
				}
				chckbxSubCategory.setSelected(false);
			}
		});
		btnSubCategoryCreate.setBounds(550, 661, 73, 23);
		AdminWindowframe.getContentPane().add(btnSubCategoryCreate);
		
		
		
		JLabel lblSelectCategory = new JLabel("Select Category");
		lblSelectCategory.setBounds(554, 610, 159, 14);
		AdminWindowframe.getContentPane().add(lblSelectCategory);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(200, 472, -22, 7);
		AdminWindowframe.getContentPane().add(btnNewButton);
		
		JCheckBox checkBoxMAADellete = new JCheckBox("I am sure!");
		checkBoxMAADellete.setBounds(10, 315, 89, 23);
		AdminWindowframe.getContentPane().add(checkBoxMAADellete);
		
		JButton btnMAADelete = new JButton("Delete");
		btnMAADelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (checkBoxMAADellete.isSelected())
				{
					if(checkBoxMAADellete.isSelected())
					{
					dbConnection db= new dbConnection();
					db.DeleteActiveAction(main.SelectedAuctionID);
					db.close();
					}
				}
				checkBoxMAADellete.setSelected(false);
			}
		});
		btnMAADelete.setBounds(10, 340, 89, 23);
		AdminWindowframe.getContentPane().add(btnMAADelete);
		
		
		
		JLabel lblIDChkError = new JLabel("*ID not Checked!");
		lblIDChkError.setForeground(Color.RED);
		lblIDChkError.setVisible(false);
		
		textTags = new JTextField();
		textTags.setColumns(10);
		textTags.setBounds(590, 534, 86, 20);
		AdminWindowframe.getContentPane().add(textTags);
		lblIDChkError.setBounds(310, 399, 154, 14);
		AdminWindowframe.getContentPane().add(lblIDChkError);
		
		JButton btnCheckForId = new JButton("Check ID");
		btnCheckForId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbConnection db = new dbConnection();
				db.AuctionStatus();
				db.close();
				lblICNAID.setText(String.valueOf(main.AuctionsMaxID));
			}
		});
		btnCheckForId.setBounds(211, 393, 89, 23);
		AdminWindowframe.getContentPane().add(btnCheckForId);
		
		textCNADateD = new JTextField();
		textCNADateD.setColumns(10);
		textCNADateD.setBounds(590, 419, 20, 20);
		AdminWindowframe.getContentPane().add(textCNADateD);
		
		JLabel lblDdmmyyyy = new JLabel("DD/MM/YYYY");
		lblDdmmyyyy.setHorizontalAlignment(SwingConstants.CENTER);
		lblDdmmyyyy.setBounds(694, 422, 73, 14);
		AdminWindowframe.getContentPane().add(lblDdmmyyyy);
		
		JLabel lblHhmm = new JLabel("HH:MM");
		lblHhmm.setBounds(657, 447, 97, 14);
		AdminWindowframe.getContentPane().add(lblHhmm);
		
		JLabel label = new JLabel("/");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(609, 422, 14, 14);
		AdminWindowframe.getContentPane().add(label);
		
		textCNADateM = new JTextField();
		textCNADateM.setColumns(10);
		textCNADateM.setBounds(624, 419, 20, 20);
		AdminWindowframe.getContentPane().add(textCNADateM);
		
		JLabel label_2 = new JLabel("/");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(645, 422, 14, 14);
		AdminWindowframe.getContentPane().add(label_2);
		
		textCNADateY = new JTextField();
		textCNADateY.setColumns(10);
		textCNADateY.setBounds(657, 419, 36, 20);
		AdminWindowframe.getContentPane().add(textCNADateY);
		
		JLabel label_4 = new JLabel(":");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(609, 447, 14, 14);
		AdminWindowframe.getContentPane().add(label_4);
		
		textCNATimeM = new JTextField();
		textCNATimeM.setColumns(10);
		textCNATimeM.setBounds(620, 444, 20, 20);
		AdminWindowframe.getContentPane().add(textCNATimeM);
		
		JButton btnCNACreate = new JButton("Create");
		btnCNACreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Visibility of errors
				lblCNAError.setVisible(false);
				lblIDChkError.setVisible(false);
				//Flag
				boolean Flag = true;
				//Local Variables
				String Time = "";
				String DateValue ="";
				// ID check
				if(main.AuctionsMaxID <=0)
				{
					lblCNAError.setVisible(true);
					lblIDChkError.setVisible(true);
					Flag = false;
				}
				// I am sure check
				if(!chckbxICNA.isSelected())
				{
					lblCNAError.setVisible(true);
					Flag = false;
				}
				//Check Date
				if( textCNADateD.getText().equals("")||textCNADateM.getText().equals("") ||textCNADateY.getText().equals("") )
				{
					lblCNAError.setVisible(true);
					Flag = false;
				}
				else
				{
					int D = Integer.valueOf(textCNADateD.getText());
					int M =  Integer.valueOf(textCNADateM.getText());
					int Y = Integer.valueOf(textCNADateY.getText());
					if( (D >=0 && D<=30) && (M>=0 && M<=12) && ( Y>=2017))
					{
						 DateValue = Integer.toString(D)+"/"+Integer.toString(M)+"/"+Integer.toString(Y);
					}
					else
					{
						lblCNAError.setVisible(true);
						Flag = false;
					}
	
				}
				//check Time
				if (textCNATimeH.getText().equals("") || textCNATimeM.getText().equals(""))
				{
					lblCNAError.setVisible(true);
					Flag = false;
				}
				else
				{
					String Time1 = "";
					String Time2="";
					int H = Integer.valueOf(textCNATimeH.getText());
					int min = Integer.valueOf(textCNATimeM.getText());
					if( (H>=0 && H<=24)&& (min>=0 && min<=59))
					{
						if(H<10)
						{
							Time1 = "0"+Integer.toString(H);
						}
						else
						{
							Time1 = Integer.toString(H);
						}
						if(min<10)
						{
							Time2 = "0"+Integer.toString(min);
						}
						else
						{
							Time2 = Integer.toString(min);
						}
						Time = Time1 +":"+ Time2;
					}
					else
					{
						lblCNAError.setVisible(true);
						Flag = false;
					}
					chckbxICNA.setSelected(false);
				}
				//All fields filled
				if(textCNAName.getText().equals("") ||textCNAPrice.getText().equals("")|| textCNASeller.getText().equals("")|| textCNAItem.getText().equals("") || comboBoxCNACategory.getSelectedItem().equals(null) || comboBoxCNASubcategory.getSelectedItem().equals(null))
				{
					
					lblCNAError.setVisible(true);
					Flag = false;
				}
				
				///Enter Action
				if( Flag == true)
				{
					dbConnection db = new dbConnection();
					db.CreateAuction( Integer.valueOf(main.AuctionsMaxID) ,textCNAName.getText(), textCNAPrice.getText(),DateValue, Time, comboBoxCNACategory.getSelectedIndex()+1,(comboBoxCNASubcategory.getSelectedItem().toString()) , textCNASeller.getText(), textCNAItem.getText(), textCNAImage.getText(),textTags.getText());
					db.close();
					System.out.println("yeaH!!!");

				}
			}
		});
		btnCNACreate.setBounds(277, 533, 89, 23);
		AdminWindowframe.getContentPane().add(btnCNACreate);
		
		JLabel lblTags = new JLabel("Tags:");
		lblTags.setBounds(526, 537, 46, 14);
		AdminWindowframe.getContentPane().add(lblTags);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;

public class MainWindow {

	public JFrame Mainframe;
	private JTextField textSearch;
	
	//--------Variables-------
	//------------------------------------
	public static int CategoryValue =0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dbConnection db = new dbConnection();
					db.CategoriesPop ();
					db.UpdateStatus();
					db.close();
					
					MainWindow mainwindow = new MainWindow();
					mainwindow.Mainframe.setVisible(true);

					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Mainframe = new JFrame();
		Mainframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\AuctionsSetupFiles\\imgs\\Main image.jpg"));
		Mainframe.setTitle("Piraeus University of Applied Science Auctions");
		Mainframe.setResizable(false);
		Mainframe.getContentPane().setEnabled(false);
		Mainframe.setBounds(100, 100, 450, 413);
		Mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Mainframe.getContentPane().setLayout(null);
		
		JLabel lblProfile = new JLabel("");
		lblProfile.setForeground(Color.BLUE);
		lblProfile.addMouseListener(new MouseAdapter()
		{  
			
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	if(!lblProfile.getText().equals(""))
				{
		    		dbConnection db = new dbConnection();
					db.UpdateStatus();
					db.close();
					
		    	MyProfile wMyProfile = new MyProfile();
				wMyProfile.MyProfileframe.setVisible(true);
				Mainframe.dispose();
				} 

		    }
			
		});
		lblProfile.setBounds(77, 11, 95, 14);
		Mainframe.getContentPane().add(lblProfile);
		
		JLabel lblWelcome = new JLabel("Welcome!");
		lblWelcome.setBounds(10, 11, 67, 14);
		Mainframe.getContentPane().add(lblWelcome);
		
		JButton btnlogIn = new JButton("Log In");
		btnlogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignIn wSignIn = new SignIn();
				wSignIn.SignInframe.setVisible(true);
				wSignIn.mainSignIn();
				
				Mainframe.dispose();
				
			}
		});
		btnlogIn.setBounds(234, 11, 89, 23);
		Mainframe.getContentPane().add(btnlogIn);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp wSignUp = new SignUp();
				wSignUp.SignUpframe.setVisible(true);
				wSignUp.mainSignUp();
				Mainframe.dispose();
			}
		});
		btnSignUp.setBounds(335, 11, 89, 23);
		Mainframe.getContentPane().add(btnSignUp);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.logged=false;
				main.Username="";
				btnLogOut.setVisible(false);
				btnlogIn.setVisible(true);
				btnSignUp.setVisible(true);
				lblProfile.setText("");
				
			}
		});
		btnLogOut.setBounds(333, 11, 89, 23);
		Mainframe.getContentPane().add(btnLogOut);
		btnLogOut.setVisible(false);
		

		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\AuctionsSetupFiles\\imgs\\Main image.jpg"));
		lblNewLabel.setBounds(10, 37, 414, 182);
		Mainframe.getContentPane().add(lblNewLabel);
		
		JLabel lblSearch = new JLabel("Search By Category");
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setBounds(10, 230, 172, 14);
		Mainframe.getContentPane().add(lblSearch);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setBounds(10, 255, 77, 14);
		Mainframe.getContentPane().add(lblCategory);
		
		JLabel lblSubcategory = new JLabel("SubCategory:");
		lblSubcategory.setBounds(10, 280, 77, 14);
		Mainframe.getContentPane().add(lblSubcategory);
		
		JComboBox comboBoxCategory = new JComboBox(main.CategoriesName.toArray());
		comboBoxCategory.setBounds(97, 252, 104, 20);
		Mainframe.getContentPane().add(comboBoxCategory);
		
		JComboBox comboBoxSubCategory = new JComboBox();
		comboBoxSubCategory.setBounds(97, 277, 104, 20);
		comboBoxSubCategory.addPopupMenuListener(new PopupMenuListener()
		{
		    public void popupMenuWillBecomeVisible(PopupMenuEvent e)
		    {
		    	comboBoxSubCategory.removeAllItems();
		        
		        int i =0;
		        int Value =0;
		       CategoryValue = comboBoxCategory.getSelectedIndex()+1;
		        while(i < main.SubCategoriesID.size())
		        {
		        	Value = Integer.parseInt(main.SubCategoriesCatID.get(i));
		        	if(CategoryValue == Value )
		        	{
		        		comboBoxSubCategory.addItem(main.SubCategoriesName.get(i));
		        	}
		        	i++;
		        }
		    }

		    public void popupMenuCanceled(PopupMenuEvent e) {}
		    public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}

		});
		Mainframe.getContentPane().add(comboBoxSubCategory);
		
		JLabel lblSearchTags = new JLabel("Search by name");
		lblSearchTags.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchTags.setBounds(238, 230, 172, 14);
		Mainframe.getContentPane().add(lblSearchTags);
		
		textSearch = new JTextField();
		textSearch.setBounds(238, 252, 125, 20);
		Mainframe.getContentPane().add(textSearch);
		textSearch.setColumns(10);
		
		JComboBox comboBoxResults = new JComboBox(main.ScName.toArray());
		comboBoxResults.setBounds(234, 306, 129, 20);
		Mainframe.getContentPane().add(comboBoxResults);
		
		JButton btnGo_1 = new JButton("Go");
		btnGo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!textSearch.getText().equals(""))
				{
					System.out.println("Enetered");
					dbConnection db = new dbConnection();
					db.Ssearch(textSearch.getText());
					db.close();
					comboBoxResults.removeAllItems();
					int j=0;
					while(j <main.ScName.size())
					{
						comboBoxResults.addItem(main.ScName.get(j));
						j++;
					}
					
				}
				main.Searched = true;
			}
		});
		btnGo_1.setBounds(373, 251, 58, 23);
		Mainframe.getContentPane().add(btnGo_1);
		
		JLabel lblNewLabel_1 = new JLabel("Results");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(238, 280, 186, 14);
		Mainframe.getContentPane().add(lblNewLabel_1);
		
		JButton btnSearch = new JButton("Go");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(main.Searched == true)
				{
				if(!comboBoxResults.getSelectedItem().equals(null))
				{
				int i =comboBoxResults.getSelectedIndex();
				main.SeName = main.ScName.get(i);
				main.SeID = main.ScID.get(i);
				main.SePrice = main.ScPrice.get(i) ;
				main.SeTime =  main.ScTime.get(i);
				main.SeDate =  main.ScDate.get(i);
				main.SeWinner =  main.ScWinner.get(i);
				main.SeSellerD = main.ScSellerD.get(i);
				main.SeItemD =  main.ScItemD.get(i);
				
				
				}
				
				dbConnection db = new dbConnection();
				db.UpdateStatus();
				db.close();
				
				ItemPage wItem= new ItemPage();
				wItem.Itemsframe.setVisible(true);
				Mainframe.dispose();
				}
				
			}
		});
		btnSearch.setBounds(373, 305, 58, 23);
		Mainframe.getContentPane().add(btnSearch);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		btnExit.setBounds(335, 340, 89, 23);
		Mainframe.getContentPane().add(btnExit);
		
		JButton btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About wAbout = new About();
				wAbout.Aboutframe.setVisible(true);
			}
		});
		
		JButton btnGo = new JButton("GO");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxCategory.getSelectedItem() != null && comboBoxSubCategory.getSelectedItem()!= null )
				{
					 String SubName = comboBoxSubCategory.getSelectedItem().toString() ;
					 int i=0;
					 int SubID = 0;
					 while(i<main.SubCategoriesName.size())
					 {
						 
						 if(main.SubCategoriesName.get(i).equals(SubName))
						 {
							 SubID= i+1;
							 System.out.println(SubName);
						 }
						 i++;
					 }
					System.out.println(SubID);

					dbConnection db = new dbConnection();
					db.CSsearch( comboBoxCategory.getSelectedIndex()+1,SubID);
					db.close();
					comboBoxResults.removeAllItems();
					int j=0;
					while(j <main.ScName.size())
					{
						comboBoxResults.addItem(main.ScName.get(j));
						j++;
					}
					main.Searched = true;
					
				}
			}
		});
		btnGo.setBounds(77, 305, 89, 23);
		Mainframe.getContentPane().add(btnGo);
		btnAbout.setBounds(234, 340, 89, 23);
		Mainframe.getContentPane().add(btnAbout);
		
		if(main.logged == true)
		{
			lblProfile.setText(main.Username);
			btnlogIn.setVisible(false);
			btnSignUp.setVisible(false);
			btnLogOut.setVisible(true);
			
			
		}
		else
		{
			lblProfile.setText("");
			
		}

	}
}

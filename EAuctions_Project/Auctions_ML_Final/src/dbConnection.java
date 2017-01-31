import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Locale;

import java.util.Calendar;


public class dbConnection {
	private	static String connectionURL = "jdbc:mysql://localhost/auctions";
	private	static	String userName = "root";
	private	static	String password = "1234";
	public static Connection con = null;
	public static Statement stmt = null;
	public static Statement stmt2 = null;
	public static ResultSet rs = null;
	public static ResultSet rs2 = null;
	
	public static void dbConn(){

	}
	
	public  boolean SignIn (String User, String Password){
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				
				
				 con = DriverManager.getConnection(connectionURL,userName,password);
				 stmt = con.createStatement();
				if (con != null){
					System.out.println("Connection with database established!");
				}
				
				} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}	
		
		String sql = ("SELECT * FROM Users");
		rs = stmt.executeQuery(sql);
		while(rs.next()) { 

	         String user1  = rs.getString("Username");
	         String pass = rs.getString("Password");
	         
	        
	         
	         if(pass.equals(Password) && user1.equals(User))
	         {
	        	
	     		
	        	 main.Name = rs.getString("Name");
	        	 main.Surname = rs.getString("Surname");
	        	 main.Email = rs.getString("Email");
	        	 main.Admin = rs.getInt("Admin");
	        	 main.Username = rs.getString("Username");
	        	 
	        	// System.out.println(main.Name);
	        	// System.out.println(main.Surname);
	        	// System.out.println(main.Email);
	        	// System.out.println(main.Admin);
	        	// System.out.println(main.Username);
	        	 
	        	 return true;
	         }
	        
	        
		}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return false;
	}
	
	public void SignUp( String Username, String Password, String Name, String Surname, String Email)
	{
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				
				
				 con = DriverManager.getConnection(connectionURL,userName,password);
				 stmt = con.createStatement();
				if (con != null){
					System.out.println("Connection with database established!");
				}
				
				} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}	
		
			int Admin = 0;
			String sql = "INSERT INTO `users`(Username,Password,Name,Surname,Email,Admins) VALUE ('"+Username+"','"+Password+"','"+Name+"','"+Surname+"','"+Email+"','"+Admin+"')";
		    
			stmt.executeUpdate(sql);
	        
	        
		}
		 catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public  boolean ChkUsername (String Username){
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				
				
				 con = DriverManager.getConnection(connectionURL,userName,password);
				 stmt = con.createStatement();
				if (con != null){
					System.out.println("Connection with database established!");
				}
				
				} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}	
		
		String sql = ("SELECT Username FROM Users WHERE Username='"+Username+"'");
		rs = stmt.executeQuery(sql);

	         
		if(rs.next()) { 

	         String user  = rs.getString("Username");
	         
	         if(user.equals(Username))
	         {
	        	 //System.out.println("yea");
	        	 return true;
	         }
		}
	        
	        
		}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return false;
	}

	public static  int UpdateUser (String Username,String Password, String Email){
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				
				
				 con = DriverManager.getConnection(connectionURL,userName,password);
				 stmt = con.createStatement();
				if (con != null){
					System.out.println("Connection with database established!");
				}
				
				} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}	
		
		String sql = ("Update Users SET Password ='"+Password+"', Email='"+Email+"'WHERE Username='"+Username+"'");
		int rs =stmt.executeUpdate(sql);
	        return rs ;
	        
		}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return 0;
	}
	

	public void close() {
		// TODO Auto-generated method stub
		con = null;
		stmt = null;
		rs = null;
		
		System.out.println("disconected");
		
		
	}
	
	public  void AuctionsStatus(){
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				
				
				 con = DriverManager.getConnection(connectionURL,userName,password);
				 stmt = con.createStatement();
				if (con != null){
					System.out.println("Connection with database established!");
				}
				
				} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}	
			//----- clearing Lists--------
			 main.AuctionsPaidID.clear();
		 	 main.AuctionsPaidName.clear();
		 	 main.AuctionsNotPaidID.clear(); 
			 main.AuctionsNotPaidName.clear();
		 	 
			String sql = ("SELECT ID,Name,Winner,Paid FROM auctions");
	 		rs = stmt.executeQuery(sql);
	 		System.out.println("Passed");
	 		int Paid=0;
	 		String ID = "";
	 		String Name = "";
	 		while(rs.next())
	 		{
	 			
	 		String Winner  = rs.getString("Winner");
	 		System.out.println(Winner);
	 			if(Winner != null)
	 			{
		         if(Winner.equals(main.Username))
		         {
		        	 ID =String.valueOf(rs.getInt("ID"));
		        	 
		        	Name = rs.getString("Name");
		        	
		        	 Paid = rs.getInt("Paid");
		        			 if(Paid == 1)
		        			 {
		        				 	 main.AuctionsPaidID.add(ID);
		        				 	 main.AuctionsPaidName.add(Name);
		        					
		        				
		        			 }
		        			 else
		        			 {
		        				 	 main.AuctionsNotPaidID.add(ID); 
		        					 main.AuctionsNotPaidName.add(Name);
		        				
		        			 }
		        			 
		        			 
		         }
	 			}
	 		}
	        
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	// Populate Categories
	public void CategoriesPop (){
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				
				
				 con = DriverManager.getConnection(connectionURL,userName,password);
				 stmt = con.createStatement();
				if (con != null){
					System.out.println("Connection with database established!");
				}
				
				} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}	
			main.CategoriesName.clear();
			main.CategoriesID.clear();
		String sql = ("SELECT * FROM Category");
		rs = stmt.executeQuery(sql);
		while(rs.next()) { 

	         String CatID  = String.valueOf(rs.getInt("ID"));
	         String CatName = rs.getString("Name");
	          main.CategoriesName.add(CatName);
	          main.CategoriesID.add(CatID);
	         
	        
		}
		main.SubCategoriesCatID.clear();
		main.SubCategoriesName.clear();
		main.SubCategoriesID.clear();
		sql = ("SELECT * FROM Subcategory");
		rs = stmt.executeQuery(sql);
		while(rs.next()) { 

	         String SubCatID  = String.valueOf(rs.getInt("ID"));
	         String SubCatName = rs.getString("Name");
	         String SubCatCatID = rs.getString("Category_ID");
	          main.SubCategoriesCatID.add(SubCatCatID);
	          main.SubCategoriesName.add(SubCatName);
	          main.SubCategoriesID.add(SubCatID);
	         
	        
	        
		}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	//--------------- Admins-----------
	// Populate AdminList
	public  void AdminList (){
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				
				
				 con = DriverManager.getConnection(connectionURL,userName,password);
				 stmt = con.createStatement();
				if (con != null){
					System.out.println("Connection with database established!");
				}
				
				} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}	
		main.AdminList.clear();
		String sql = ("SELECT Username,Admin FROM Users");
		rs = stmt.executeQuery(sql);

	         
		while(rs.next()) { 
			 	int Admin = rs.getInt("Admin");
			 	String user  = rs.getString("Username");
				if(Admin == 1)
				{
	         
					main.AdminList.add(user);
				}
	         
	       
		}
		}catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
	}
	// Remove Admins
	public  void RemoveAdmin (String Username){
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				
				
				 con = DriverManager.getConnection(connectionURL,userName,password);
				 stmt = con.createStatement();
				if (con != null){
					System.out.println("Connection with database established!");
				}
				
				} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}	
		
		String sql = ("DELETE FROM users WHERE Username = '" + Username + "';");
		 stmt.executeUpdate(sql);
		 System.out.println(Username);
	         
	       
		}catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
	}
	
	// Creates new Admins
	public void CreateAdmin( String Username, String Password)
	{
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				
				
				 con = DriverManager.getConnection(connectionURL,userName,password);
				 stmt = con.createStatement();
				if (con != null){
					System.out.println("Connection with database established!");
				}
				
				} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}	
		
			int admin = 1;
			String sql = "INSERT INTO `users`(Username,Password,Admin) VALUE ('"+Username+"','"+Password+"','"+admin+"')";
		    
			stmt.executeUpdate(sql);
	        
	        
		}
		 catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	//Checking Status of all actions
	public  void AuctionStatus (){
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				
				
				 con = DriverManager.getConnection(connectionURL,userName,password);
				 stmt = con.createStatement();
				if (con != null){
					System.out.println("Connection with database established!");
				}
				
				} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}	
		main.ActiveActionsIDs.clear();
		main.NonActiveActionsIDs.clear();
		String sql = ("SELECT ID,Status FROM auctions");
		rs = stmt.executeQuery(sql);
		String ID = null;
	         
		while(rs.next()) { 
			 	ID = String.valueOf(rs.getInt("ID"));
			 	
			 	String Status  = rs.getString("Status");
				if(Status.equals("Active"))
				{
	         
					main.ActiveActionsIDs.add(ID);
				}
				else
				{
					main.NonActiveActionsIDs.add(ID);
				}
				
		}
		main.AuctionsMaxID = Integer.parseInt(ID)+1;
			
		}catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
	}
	
	//Getting NonActiveAuctionInfo
	public  void GetAuctionInfoNonActive(int ID){
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				
				
				 con = DriverManager.getConnection(connectionURL,userName,password);
				 stmt = con.createStatement();
				if (con != null){
					System.out.println("Connection with database established!");
				}
				
				} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			
			int RealID = Integer.parseInt(main.NonActiveActionsIDs.get(ID-1));
			main.SelectedAuctionID = RealID;
		String sql = ("SELECT Name,Price,Time,Date,Winner,Status FROM auctions WHERE ID='"+RealID+"';");
		rs = stmt.executeQuery(sql);
		if(rs.next()) { 

	         main.SelectedAuctionName  = rs.getString("Name");
	         main.SelectedAuctionStatus  = rs.getString("Status");
	         main.SelectedAuctionWinner = rs.getString("Winner");
	         main.SelectedAuctionPrice = rs.getInt("Price");
	         main.SelectedAuctionTime = rs.getTime("Time");
	         main.SelectedAuctionDate = rs.getString("Date");
	         

		}
	         
	         
		}catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
	}
	
	//Get ActiveAuctionsInfo
	public  void GetAuctionInfoActive(int ID){
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				
				
				 con = DriverManager.getConnection(connectionURL,userName,password);
				 stmt = con.createStatement();
				if (con != null){
					System.out.println("Connection with database established!");
				}
				
				} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			
			int RealID = Integer.parseInt(main.ActiveActionsIDs.get(ID-1));
		String sql = ("SELECT Name,Price,Time,Date,Winner,Status FROM auctions WHERE ID='"+RealID+"';");
		rs = stmt.executeQuery(sql);
		main.SelectedAuctionID = RealID;
		if(rs.next()) { 
			
	         main.SelectedAuctionName  = rs.getString("Name");
	         main.SelectedAuctionStatus  = rs.getString("Status");
	         main.SelectedAuctionWinner = rs.getString("Winner");
	         main.SelectedAuctionPrice = rs.getInt("Price");
	         main.SelectedAuctionTime = rs.getTime("Time");
	         main.SelectedAuctionDate = rs.getString("Date");
	         

		}
	         
	         
		}catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
	}
	
	// Imports New Auction
	public void CreateAuction( int ID ,String Name, String Price,String date, String Time, int Category,String Subcategory , String Seller, String Item, String Image,String Tags)
	{
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				
				
				 con = DriverManager.getConnection(connectionURL,userName,password);
				 stmt = con.createStatement();
				if (con != null){
					System.out.println("Connection with database established!");
				}
				
				} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}	
			int SubcategoryID=0;
			String sql = ("SELECT ID FROM subcategory WHERE Name='"+Subcategory+"';");
			rs = stmt.executeQuery(sql);
			while(rs.next()) { 
				SubcategoryID  = rs.getInt("ID");

				}
			LocalTime t = LocalTime.parse( Time ) ;
			
				String Status = "Active";
				 sql = "INSERT INTO `auctions`(ID,Name,Price,Time,Date,Tags,CategoryID,SubCategoryID,SellerDescription,ItemDescription,Image,Status) VALUE ('"+ID+"','"+Name+"','"+Price+"','"+t+"','"+date+"','"+Tags+"','"+Category+"','"+SubcategoryID+"','"+Seller+"','"+Item+"','"+Image+"','"+Status+"')";
				 stmt.executeUpdate(sql);

	        
	        
		}
		 catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	//Delete Auction
	public  void DeleteActiveAction (int ID){
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				
				
				 con = DriverManager.getConnection(connectionURL,userName,password);
				 stmt = con.createStatement();
				if (con != null){
					System.out.println("Connection with database established!");
				}
				
				} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}	
		
		String sql = ("DELETE FROM auctions WHERE ID = '" + ID + "';");
		 stmt.executeUpdate(sql);         
		 
		}catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
	}
	
	//Pause Auction
		public  void PauseActiveAuction(int ID){
			try {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					
					
					 con = DriverManager.getConnection(connectionURL,userName,password);
					 stmt = con.createStatement();
					if (con != null){
						System.out.println("Connection with database established!");
					}
					
					} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}	
			String Status = "Paused";
			String sql = ("Update auctions SET Status ='"+Status+"' WHERE ID = '" + ID + "';");

			 stmt.executeUpdate(sql);         
			 
			}catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
		}
		//Resume Auction
				public  void ResumeNonActiveAuction(int ID){
					try {
						try {
							Class.forName("com.mysql.jdbc.Driver");
							
							
							
							 con = DriverManager.getConnection(connectionURL,userName,password);
							 stmt = con.createStatement();
							if (con != null){
								System.out.println("Connection with database established!");
							}
							
							} catch (ClassNotFoundException e) {
							
							e.printStackTrace();
						}
						
						String sql = ("SELECT Status FROM auctions WHERE ID='"+ID+"';");
						rs = stmt.executeQuery(sql);
						String Status = "";
						while(rs.next()) {
							Status = rs.getString("Status");
						}
						if(Status.equals("Paused"))
						{
							Status = "Active";
							sql = ("Update auctions SET Status ='"+Status+"' WHERE ID = '" + ID + "';");
							stmt.executeUpdate(sql);
						}
					 
					}catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					
				}
				
				// Create New Categories!
				public void CreateNewCategory( String Name)
				{
					try {
						try {
							Class.forName("com.mysql.jdbc.Driver");
							
							
							
							 con = DriverManager.getConnection(connectionURL,userName,password);
							 stmt = con.createStatement();
							if (con != null){
								System.out.println("Connection with database established!");
							}
							
							} catch (ClassNotFoundException e) {
							
							e.printStackTrace();
						}	
						int ID = main.CategoriesID.size() +1;
						String sql = "INSERT INTO `category`(ID,Name) VALUE ('"+ID+"','"+Name+"')";
					    
						stmt.executeUpdate(sql);
				        
				        
					}
					 catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				//Create new SubCategories!
				public void CreateNewSubCategory( String Name,int CAT_ID, int ID)
				{
					try {
						try {
							Class.forName("com.mysql.jdbc.Driver");
							
							
							
							 con = DriverManager.getConnection(connectionURL,userName,password);
							 stmt = con.createStatement();
							if (con != null){
								System.out.println("Connection with database established!");
							}
							
							} catch (ClassNotFoundException e) {
							
							e.printStackTrace();
						}	

						String sql = "INSERT INTO `subcategory`(Category_ID,ID,Name) VALUE ('"+CAT_ID+"','"+ID+"','"+Name+"')";
					    
						stmt.executeUpdate(sql);
				        
				        
					}
					 catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
				//User Delete his account
				//Delete Auction
				public  void UserDeleteAccount (){
					try {
						try {
							Class.forName("com.mysql.jdbc.Driver");
							
							
							
							 con = DriverManager.getConnection(connectionURL,userName,password);
							 stmt = con.createStatement();
							if (con != null){
								System.out.println("Connection with database established!");
							}
							
							} catch (ClassNotFoundException e) {
							
							e.printStackTrace();
						}	
					
					String sql = ("DELETE FROM users WHERE Username = '" + main.Username + "';");
					 stmt.executeUpdate(sql); 
					 main.Username = "";
					 
					}catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					
				}
				
				//Get User Not Paid
				//Getting NonActiveAuctionInfo
				public  void NotPaidInfo(int ID){
					try {
						try {
							Class.forName("com.mysql.jdbc.Driver");
							
							
							
							 con = DriverManager.getConnection(connectionURL,userName,password);
							 stmt = con.createStatement();
							if (con != null){
								System.out.println("Connection with database established!");
							}
							
							} catch (ClassNotFoundException e) {
							
							e.printStackTrace();
						}
						
						
					String sql = ("SELECT Name,Price,Time,Date,Winner,Status FROM auctions WHERE ID='"+ID+"';");
					rs = stmt.executeQuery(sql);
					if(rs.next()) { 

				         main.SelectedAuctionName  = rs.getString("Name");
				         main.SelectedAuctionStatus  = rs.getString("Status");
				         main.SelectedAuctionWinner = rs.getString("Winner");
				         main.SelectedAuctionPrice = rs.getInt("Price");
				         main.SelectedAuctionTime = rs.getTime("Time");
				         main.SelectedAuctionDate = rs.getString("Date");
				         

					}
				         
				         
					}catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					
				}
				
				// Auction Paid status
				public  void PayAuction(int ID){
					try {
						try {
							Class.forName("com.mysql.jdbc.Driver");
							
							
							
							 con = DriverManager.getConnection(connectionURL,userName,password);
							 stmt = con.createStatement();
							if (con != null){
								System.out.println("Connection with database established!");
							}
							
							} catch (ClassNotFoundException e) {
							
							e.printStackTrace();
						}	
					int Paid = 1;
					String sql = ("Update auctions SET Paid ='"+Paid+"' WHERE ID = '" + ID + "';");

					 stmt.executeUpdate(sql);         
					 
					}catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					
				}
		//Main menu Search with categories
				public void CSsearch(int CategoryID,int SubCategoryID)
				{
					try {
						try {
							Class.forName("com.mysql.jdbc.Driver");
							
							
							
							 con = DriverManager.getConnection(connectionURL,userName,password);
							 stmt = con.createStatement();
							if (con != null){
								System.out.println("Connection with database established!");
							}
							
							} catch (ClassNotFoundException e) {
							
							e.printStackTrace();
						}	
						main.ScName.clear();
						 main.ScID.clear();
						 main.ScPrice.clear();
						 main.ScTime.clear();
						 main.ScDate.clear();
						 main.ScTags.clear();
						 main.ScWinner.clear();
						 main.ScSellerD.clear();
						main.ScItemD.clear();
						String Status ="Active";
						String sql = ("SELECT * FROM auctions WHERE Status='"+Status+"'");
						rs = stmt.executeQuery(sql);
						while(rs.next()) {
							int CatID = rs.getInt("CategoryID");
							int SubID = rs.getInt("SubCategoryID");
							if( CatID == CategoryID && SubID == SubCategoryID)
							{
							String Name = rs.getString("Name");
							String ID  = String.valueOf(rs.getInt("ID"));
							String Price  = String.valueOf(rs.getInt("Price"));
							String Time  = String.valueOf(rs.getTime("Time"));
							String Date  = String.valueOf(rs.getString("Date"));
							String Tags  = rs.getString("Tags");
							String Winner  = rs.getString("Winner");
							String Seller  = rs.getString("SellerDescription");
							String Item  = rs.getString("ItemDescription");
							
							main.ScName.add(Name);
							 main.ScID.add(ID);
							 main.ScPrice.add(Price);
							 main.ScTime.add(Time);
							 main.ScDate.add(Date);
							 main.ScTags.add(Tags);
							 main.ScWinner.add(Winner);
							 main.ScSellerD.add(Seller);
							main.ScItemD.add(Item);
							}
							}
						System.out.println(main.ScName);
						System.out.println(main.ScID);
						System.out.println(main.ScPrice);
						System.out.println(main.ScTime);
						System.out.println( main.ScDate);
						System.out.println( main.ScTags);
						System.out.println(main.ScWinner);
						System.out.println( main.ScSellerD);
						System.out.println(main.ScItemD);
						
						System.out.println("all ok");
				        
				        
					}
					 catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				//Main menu Search with 
				public void Ssearch(String ETag)
				{
					try {
						try {
							Class.forName("com.mysql.jdbc.Driver");
							
							
							
							 con = DriverManager.getConnection(connectionURL,userName,password);
							 stmt = con.createStatement();
							if (con != null){
								System.out.println("Connection with database established!");
							}
							
							} catch (ClassNotFoundException e) {
							
							e.printStackTrace();
						}	
						main.ScName.clear();
						 main.ScID.clear();
						 main.ScPrice.clear();
						 main.ScTime.clear();
						 main.ScDate.clear();
						 main.ScTags.clear();
						 main.ScWinner.clear();
						 main.ScSellerD.clear();
						main.ScItemD.clear();
						String Status ="Active";
						String sql = ("SELECT * FROM auctions WHERE Status='"+Status+"'");
						rs = stmt.executeQuery(sql);
						while(rs.next()) {
							String T  = rs.getString("Tags");
							String N = rs.getString("Name");
							if( T.toLowerCase().contains(ETag) || N.toLowerCase().contains(ETag))
							{
							String Name = rs.getString("Name");
							String ID  = String.valueOf(rs.getInt("ID"));
							String Price  = String.valueOf(rs.getInt("Price"));
							String Time  = String.valueOf(rs.getTime("Time"));
							String Date  = String.valueOf(rs.getString("Date"));
							String Tags  = rs.getString("Tags");
							String Winner  = rs.getString("Winner");
							String Seller  = rs.getString("SellerDescription");
							String Item  = rs.getString("ItemDescription");
							
							main.ScName.add(Name);
							 main.ScID.add(ID);
							 main.ScPrice.add(Price);
							 main.ScTime.add(Time);
							 main.ScDate.add(Date);
							 main.ScTags.add(Tags);
							 main.ScWinner.add(Winner);
							 main.ScSellerD.add(Seller);
							main.ScItemD.add(Item);
							}
							}
						System.out.println(main.ScName);
						System.out.println(main.ScID);
						System.out.println(main.ScPrice);
						System.out.println(main.ScTime);
						System.out.println( main.ScDate);
						System.out.println( main.ScTags);
						System.out.println(main.ScWinner);
						System.out.println( main.ScSellerD);
						System.out.println(main.ScItemD);
						
						System.out.println("all ok");
				        
				        
					}
					 catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				// Check and if Paid more update
				public   boolean Bid(String EPrice, String Bidder, int ID){
					try {
						try {
							Class.forName("com.mysql.jdbc.Driver");
							
							
							
							 con = DriverManager.getConnection(connectionURL,userName,password);
							 stmt = con.createStatement();
							if (con != null){
								System.out.println("Connection with database established!");
							}
							
							} catch (ClassNotFoundException e) {
							
							e.printStackTrace();
						}
						
						String Winner ="";
						int CPrice =0;
						System.out.println(ID);
					String sql = ("SELECT Price,Winner FROM auctions WHERE ID='"+ID+"';");
					rs = stmt.executeQuery(sql);
					while(rs.next()) { 
				         Winner = rs.getString("Winner");
				         CPrice = rs.getInt("Price");
				         
				         System.out.println(Winner);
				         System.out.println(CPrice);
					}
					int NPrice =Integer.parseInt(EPrice);
					if(!Bidder.equals(Winner) && CPrice < NPrice)
					{
						sql = ("SELECT Price,Winner FROM auctions WHERE ID='"+ID+"';");
						rs = stmt.executeQuery(sql);
						sql = ("Update auctions SET Winner ='"+Bidder+"', Price = '"+NPrice+"' WHERE ID = '" + ID + "';");
						stmt.executeUpdate(sql);
						return true;
					}
					
				
				}
				 catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					return false;
				
			}
				// Auction Paid status
				public  void UpdateStatus(){
					try {
						try {
							Class.forName("com.mysql.jdbc.Driver");
							
							
							
							 con = DriverManager.getConnection(connectionURL,userName,password);
							 stmt = con.createStatement();
							if (con != null){
								System.out.println("Connection with database established!");
							}
							
							} catch (ClassNotFoundException e) {
							
							e.printStackTrace();
						}	
						
						String timeStampDate = new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date());
						String timeStampTime = new SimpleDateFormat("HH:mm").format(new java.util.Date());
						
						
						
						
						String [] Date = timeStampDate.split("/");
						String [] Time = timeStampTime.split(":");
						
						int TimeHH = Integer.valueOf(Time[0]);
						int Timemm = Integer.valueOf(Time[1]);
						
						int Datedd = Integer.valueOf(Date[0]);
						int DateMM = Integer.valueOf(Date[1]);
						int DateYY = Integer.valueOf(Date[2]);
						
					

						
						String Status = "Active";
						String NewStatus ="Finished";
						String sql = ("SELECT Time,Date,ID FROM auctions WHERE Status='"+Status+"';");
						rs = stmt.executeQuery(sql);
						
						ArrayList<String> IDtoFinish = new ArrayList<String>();
						while(rs.next())
						{
							
							String CDate = rs.getString("Date");
							String CTime =String.valueOf(rs.getTime("Time"));
							String ID = String.valueOf(rs.getInt("ID"));
							
							
							String [] ChkDate = CDate.split("/");
							String [] ChkTime = CTime.split(":");
							
							int CTimeHH = Integer.valueOf(ChkTime[0]);
							int CTimemm = Integer.valueOf(ChkTime[1]);
							
							int CDatedd = Integer.valueOf(ChkDate[0]);
							int CDateMM = Integer.valueOf(ChkDate[1]);
							int CDateYY = Integer.valueOf(ChkDate[2]);
							
							

							boolean Flag = false;
							
							if(DateYY < CDateYY)
							{
								Flag = true;
								
							}
							else if(DateYY == CDateYY)
							{
								if(DateMM < CDateMM)
								{
									Flag = true;
								}
								else if(DateMM == CDateMM)
								{
									
									if(Datedd < CDatedd)
									{

										if(TimeHH <= CTimeHH)
										{
											Flag = true;
										} else if (Datedd == CDatedd)
										{

											if(Timemm <= CTimemm)
											{

												Flag = true;
											}
										}
									}
								}
							}
							
							if(Flag == false)
							{
								
								IDtoFinish.add(ID);
								
							}
							
								
						} 
						int i=0;
						while(i < IDtoFinish.size())
						{
							int ID = Integer.valueOf(IDtoFinish.get(i));
							sql = ("Update auctions SET Status ='"+NewStatus+"' WHERE ID = '" + ID + "';");
							stmt.executeUpdate(sql);
							i++;
						}
						       
					 
					}catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					
				}
				
}
				
				

import java.sql.Time;
import java.util.ArrayList;

public class main {

	public static boolean ItemsPage = false;
	public static boolean logged = false;
	public static String Username ="";
	public static String Name="";
	public static String Surname="";
	public static String Email="";
	public static int Admin =0;
	
	public static ArrayList<String> AuctionsPaidID = new ArrayList<String>();
	public static ArrayList<String> AuctionsPaidName = new ArrayList<String>();
	public static ArrayList<String> AuctionsNotPaidID = new ArrayList<String>();
	public static ArrayList<String> AuctionsNotPaidName = new ArrayList<String>();

	//Useful for Administration Management
	public static ArrayList<String> SystemAdmins = new ArrayList<String>();
	public static ArrayList<String> ActiveActionsIDs = new ArrayList<String>();
	public static ArrayList<String> NonActiveActionsIDs = new ArrayList<String>();
	public static ArrayList<String> AdminList = new ArrayList<String>();
	
	//Useful for Auction Management
	public static int SelectedAuctionID=0;
	public static String SelectedAuctionName = "";
	public static Time SelectedAuctionTime = null;
	public static String SelectedAuctionDate = "";
	public static String SelectedAuctionWinner = "";
	public static int SelectedAuctionPrice = 0;
	public static String SelectedAuctionStatus = "";
	
	public static int AuctionsMaxID =0;
	
	
	//Categories and SubCategories
	public static ArrayList<String> CategoriesName = new ArrayList<String>();
	public static ArrayList<String> CategoriesID = new ArrayList<String>();
	public static ArrayList<String> SubCategoriesName = new ArrayList<String>();
	public static ArrayList<String> SubCategoriesID = new ArrayList<String>();
	public static ArrayList<String> SubCategoriesCatID = new ArrayList<String>();
	
	//Searched Auctions
	public static ArrayList<String> ScName = new ArrayList<String>();
	public static ArrayList<String> ScID = new ArrayList<String>();
	public static ArrayList<String>	ScPrice = new ArrayList<String>();
	public static ArrayList<String> ScTime = new ArrayList<String>();
	public static ArrayList<String> ScDate = new ArrayList<String>();
	public static ArrayList<String> ScTags = new ArrayList<String>();
	public static ArrayList<String> ScWinner = new ArrayList<String>();
	public static ArrayList<String> ScSellerD = new ArrayList<String>();
	public static ArrayList<String> ScItemD = new ArrayList<String>();
	
	public static boolean Searched = false;
	
	// Selected from Search
	public static String SeName = "";
	public static String SeID = "";
	public static String SePrice = "" ;
	public static String SeTime =  "";
	public static String SeDate =  "";
	public static String SeWinner =  "";
	public static String SeSellerD = "";
	public static String SeItemD =  "";

	public main() {

		
	}

}
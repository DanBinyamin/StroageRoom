package View;

import java.util.ArrayList;
import java.util.List;


import Controller.*;

public  class ScreenMagment 
{
	private static StorageRoomMangment s_StroageRoom = new StorageRoomMangment();
	private static LoginForm s_LoginForm;
	private static MenuForm s_MenuForm = new MenuForm();
	private static SearchForm s_SearchForm = new SearchForm();
	private static EditForm s_EditForm = new EditForm();
	private static NewOrderForm s_NewOrder = new NewOrderForm();
	private static UpdateMenuForm s_UdpateMenu = new UpdateMenuForm();

	
	public static void StartLoginForm()
	{
		s_LoginForm = new LoginForm();
		s_LoginForm.show();
	}
	
	public static boolean IsEmploye(String i_String)
	{
		return s_StroageRoom.IsEmploye(i_String);
	}
	
	public static boolean IsExitsProudct(String i_Name)
	{
		return s_StroageRoom.IsExists(i_Name);
	}
	
	public static void ShowUpdateMenu()
	{
		s_MenuForm.setVisible(false);
		s_UdpateMenu.show();
	}
	
	public static void ShowMenuForm(String i_String)
	{	
		if(s_StroageRoom.IsManger(i_String))
		{
			s_MenuForm.EnableOrder();
		}
		else
		{
			s_MenuForm.DisableOrder();
		}
		
		s_LoginForm.setVisible(false);
		s_MenuForm.show();
	}
	
	public static boolean IsExitsInList(String i_NameOfProudct,String i_NameOfType)
	{
		return s_StroageRoom.CheckProdctExitsInListofProdct(i_NameOfProudct, i_NameOfType);
	}
	
	public static boolean IsExitsEmploye(String i_Number)
	{
		return s_StroageRoom.IsEmploye(i_Number);
	}
	
	public static void ShowSearchForm()
	{
		s_MenuForm.setVisible(false);
		s_SearchForm.show();
	}
	
	public static  void EnableMenu()
	{
		s_MenuForm.setVisible(true);
	}
	
	public static  void EnableSearchForm()
	{
		s_SearchForm.setVisible(true);
	}
	
	public static void ShowEditForm()
	{
		s_MenuForm.setVisible(false);
		s_EditForm.show();
	}
	
	public static void ShowCapacity()
	{
		CapacityForm showCapacityForm = new CapacityForm();
		showCapacityForm.show();
	}
	
	public static void ShowNewOrder()
	{
		s_MenuForm.setVisible(false);
		s_NewOrder.show();
	}
	
	public static void EnableNewOrderForm()
	{
		s_NewOrder.setVisible(true);
	}
	
	public static void ShowOrderForm(String i_String)
	{
		s_NewOrder.setVisible(false);
		OrderForm order = new OrderForm(i_String);
		order.show();
	}
	
	public static void UpdateExitsProudct(String i_Name,int i_Amount)
	{
		s_StroageRoom.UpdateExistProudct(i_Name, i_Amount);
	}
	
	public static void ShowSpacificOrder()
	{
		SpacificOrderForm spacificOrderForm = new SpacificOrderForm();
		spacificOrderForm.show();
	}
	
	public static void ShowSpacificProudct()
	{
		SpacificProudctForm sp = new SpacificProudctForm();
		sp.show();
	}
	
	public static String[][] DataOfCapacity()
	{
		return s_StroageRoom.GetCapcity();
	}
	
	public static String[][] Orders()
	{
		return s_StroageRoom.GetOrders();
	}
	
	public static Order GetOrder(int i_Number)
	{
		return s_StroageRoom.SearchOrder(i_Number);
	}
	
	public static void UpdatesOrder(Order i_Order)
	{
		s_StroageRoom.UpdateStroage(i_Order);
	}
	
	public static Proudct GetProudct(String i_Name)
	{
		return s_StroageRoom.GetProudct(i_Name);
	}
	
	public static int GetNumberOfCurentOrder()
	{
		return s_StroageRoom.GetOrderList().size();
	}
	
	public static ProudctList GetProudctList(String i_String)
	{
		
		if(i_String.equals("Food"))
		{
			return s_StroageRoom.GetFoodList();
		}
		else if(i_String.equals("Drink"))
		{
			return s_StroageRoom.GetDrinkList();
		}
		
		return s_StroageRoom.GetVegtList();	
	}
	
	public static void AddOrderToList(Order i_Order)
	{
		s_StroageRoom.AddOrderToList(i_Order);
	}
	
	public static void AddProudctToList(String i_NameOfProudct,String i_NameOfType)
	{
		s_StroageRoom.AddProdctToListofProdct(i_NameOfProudct, i_NameOfType);
	}
	
	public static void RemoveProudctToList(String i_NameOfProudct,String i_NameOfType)
	{
		s_StroageRoom.RemoveProdctToListofProdct(i_NameOfProudct, i_NameOfType);
	}
	
	public static void AddEmploye(String i_Name,String i_Number,boolean i_IsManger)
	{
		s_StroageRoom.AddEmploye(i_Name, i_Number, i_IsManger);
	}
	
	public static void RemoveEmploye(String i_Number)
	{
		s_StroageRoom.RemoveEmploye(i_Number);
	}
	
	public static String[][] GetProudcts(List<Proudct> i_ProudctStorage)
	{
 		String[][] proudctlist = new String[i_ProudctStorage.size()][3];
 		int i = 0;
 		int j =0;
 		
		for(Proudct proudct : i_ProudctStorage)
		{
			proudctlist[i][j++]=proudct.GetName();
			proudctlist[i][j++]=Integer.toString(proudct.GetAmount());
			proudctlist[i++][j]=Float.toString(proudct.GetPrice()*proudct.GetAmount());
			j=0;
		}
		
		return proudctlist;
	}
	
}

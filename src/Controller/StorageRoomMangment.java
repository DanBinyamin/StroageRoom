package Controller;

import java.util.List;


public class StorageRoomMangment 
{
	private List<Order> m_OrderList; 
	private List<Proudct> m_ProudctStorage;
	private List<Employee> m_Employes;
	private DrinkProudctList m_DrinkList = new DrinkProudctList(); 
	private FoodProudctList m_FoodList = new FoodProudctList();
	private VegetablesProudctList m_VegtList = new VegetablesProudctList();
	
	//C'tor
	public StorageRoomMangment() 
	{
		m_OrderList = OrderSaveSingleton.GetInstace().ReadOrder();
		m_Employes = EmployeeSaveSingleton.GetInstance().ReadEmployes();
		m_ProudctStorage = ProudctSaveSingleton.GetInstace().ReadProudct();
	}
	
	//this method check if the employee is exits 
	public boolean IsEmploye(String i_Employe)
	{
		if (i_Employe.matches("[0-9]+")) 
		{
			for(Employee emp : m_Employes)
			{
				if(emp.GetID().equals(i_Employe))
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	public List<Order> GetOrderList()
	{
		return m_OrderList;
	}
	
	//this method check if the employee is manger
	public boolean IsManger(String i_Employe)
	{
		for(Employee emp : m_Employes)
		{
			if(emp.GetID().equals(i_Employe))
			{
				return emp.GetIsManager();
			}
		}
		
		return false;
	}
	
	public boolean IsExists(String i_Name)
	{
		for(Proudct proudct : m_ProudctStorage)
		{
			if(proudct.GetName().equalsIgnoreCase(i_Name))
			{
				return true;
			}
		} 
		
		return false;
	}
	
	public void UpdateExistProudct(String i_Name,int i_Amount)
	{
		m_ProudctStorage = ProudctSaveSingleton.GetInstace().ReadProudct();
		
		for(Proudct proudct : m_ProudctStorage)
		{
			if(proudct.GetName().equalsIgnoreCase(i_Name))
			{
				proudct.SetAmount(i_Amount);
			}
		}
		
		 ProudctSaveSingleton.GetInstace().WriteProudct(m_ProudctStorage);
	}
	
	public void UpdateStroage(Order i_Order)
	{
		OrderSaveSingleton.GetInstace().WriteOrders(m_OrderList);
		m_ProudctStorage = ProudctSaveSingleton.GetInstace().ReadProudct();
		
		List<Proudct> proudctlist = i_Order.GetProudct();
		
		for (Proudct proudctToInsert : proudctlist)
		{	
			if(IsExists(proudctToInsert.GetName()))
			{
			for (Proudct proudctToUpdate : m_ProudctStorage)
				{
					if(proudctToUpdate.GetName().equalsIgnoreCase(proudctToInsert.GetName()))
					{
						proudctToUpdate.SetAmount(proudctToUpdate.GetAmount()+proudctToInsert.GetAmount());
						break;
					}
					
				}
			}
			else
			{
				m_ProudctStorage.add(proudctToInsert);
			}
		}
		
		 ProudctSaveSingleton.GetInstace().WriteProudct(m_ProudctStorage);
		
	}
	
	public void AddOrderToList(Order i_Order)
	{
		m_OrderList = OrderSaveSingleton.GetInstace().ReadOrder();
		m_OrderList.add(i_Order);
		OrderSaveSingleton.GetInstace().WriteOrders(m_OrderList);
	}
	
	public Proudct GetProudct(String i_Name)
	{
		m_ProudctStorage = ProudctSaveSingleton.GetInstace().ReadProudct();
		for(Proudct proudct : m_ProudctStorage)
		{
			if(proudct.GetName().equalsIgnoreCase(i_Name))
			{
				return proudct;
			}
		}
		
		return null;
	}
	
	
	//this method return the capacity information for the form 
	public String[][] GetCapcity()
	{
		m_ProudctStorage = ProudctSaveSingleton.GetInstace().ReadProudct();
 		String[][] proudctlist = new String[m_ProudctStorage.size()][2];
 		int i = 0;
 		int j =0;
 		
		for(Proudct proudct : m_ProudctStorage)
		{
			proudctlist[i][j++]=proudct.GetName();
			proudctlist[i++][j]=Integer.toString(proudct.GetAmount());
			j=0;
		}
		
		return proudctlist;
	}
	
	//this method return the Order information for the form 
	public String[][] GetOrders()
	{
		m_OrderList = OrderSaveSingleton.GetInstace().ReadOrder();
		
		String[][] proudctlist = new String[m_OrderList.size()][2];
 		int i = 0;
 		int j =0;
 		
		for(Order order : m_OrderList)
		{
			proudctlist[i][j++]= Integer.toString(order.GetOrderID());
			proudctlist[i++][j]=order.GetOrderStatus().toString();
			j=0;
		}
		
		return proudctlist;
	}
	
	public FoodProudctList GetFoodList()
	{
		m_FoodList.SetList(ProudctListSaveSingleton.GetInstance().ReadProudctList("Food"));
		
		return m_FoodList;
	}
	
	public DrinkProudctList GetDrinkList()
	{
		m_DrinkList.SetList(ProudctListSaveSingleton.GetInstance().ReadProudctList("Drink"));
		
		return m_DrinkList;
	}
	
	public VegetablesProudctList GetVegtList()
	{
		m_VegtList.SetList(ProudctListSaveSingleton.GetInstance().ReadProudctList("Vegetables"));
		
		return m_VegtList;
	}
	
	public Order SearchOrder(int i_number)
	{
		m_OrderList = OrderSaveSingleton.GetInstace().ReadOrder();
		
		for(Order order : m_OrderList)
		{
			if(order.GetOrderID() == i_number)
			{
				return order;
			}
		}
		
		return null;
	}
	
	public void AddProdctToListofProdct(String i_NameOfProudct,String i_NameOfTheType)
	{
		if(i_NameOfTheType.contentEquals("Food"))
		{
			m_FoodList.Add(i_NameOfProudct);
		}
		else if(i_NameOfTheType.contentEquals("Drink"))
		{
			m_DrinkList.Add(i_NameOfProudct);
		}
		else if(i_NameOfTheType.contentEquals("Vegetables"))
		{
			m_VegtList.Add(i_NameOfProudct);
		}
	}
	
	public void RemoveProdctToListofProdct(String i_NameOfProudct,String i_NameOfTheType)
	{
		if(i_NameOfTheType.contentEquals("Food"))
		{
			m_FoodList.Remove(i_NameOfProudct);
		}
		else if(i_NameOfTheType.contentEquals("Drink"))
		{
			m_DrinkList.Remove(i_NameOfProudct);
		}
		else if(i_NameOfTheType.contentEquals("Vegetables"))
		{
			m_VegtList.Remove(i_NameOfProudct);
		}
	}
	
	public boolean CheckProdctExitsInListofProdct(String i_NameOfProudct,String i_NameOfTheType)
	{
		if(i_NameOfTheType.contentEquals("Food"))
		{
			return m_FoodList.Exist(i_NameOfProudct);
		}
		else if(i_NameOfTheType.contentEquals("Drink"))
		{
			return m_DrinkList.Exist(i_NameOfProudct);
		}
		else if(i_NameOfTheType.contentEquals("Vegetables"))
		{
			return m_VegtList.Exist(i_NameOfProudct);
		}
		
		return false;
	}
	
	
	public void AddEmploye(String i_Name,String i_Number, boolean i_IsManger)
	{
		m_Employes.add(new Employee(i_Number,i_Name,i_IsManger));
		EmployeeSaveSingleton.GetInstance().WriteEmployes(m_Employes);
	}
	
	public void RemoveEmploye(String i_Number)
	{
		int i = 0;
		
		for(Employee emp : m_Employes)
		{
			if(emp.GetID().equals(i_Number))
			{
				break;
			}
			i++;
		}
		
		m_Employes.remove(i);
		EmployeeSaveSingleton.GetInstance().WriteEmployes(m_Employes);
	}
	
}

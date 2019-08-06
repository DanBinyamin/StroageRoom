package Controller;

import Model.OrderSave;

public class OrderSaveSingleton 
{
	private static OrderSave m_OrderSave;
	
	//Singleton pattern to read/write from csv
	private OrderSaveSingleton()
	{
		
	}
	
	public static OrderSave GetInstace()
	{
		if(m_OrderSave == null)
		{
			m_OrderSave = new OrderSave();
		}
		
		return m_OrderSave;
	}
	
}

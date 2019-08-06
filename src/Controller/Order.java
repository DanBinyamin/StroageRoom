package Controller;

import java.util.List;

//This class in charge of all information about the order
public abstract class Order
{
	protected int m_OrderID = 0;
	protected float m_TotalPrice = 0;
	protected List<Proudct> m_Proudcts;
	protected eStatusOrder m_StatusOrder = eStatusOrder.InProgress;
	protected ProudctList m_ProudctList;
	protected String m_TypeOrder;
	
	public eStatusOrder GetOrderStatus()
	{
		return m_StatusOrder;
	}
	
	public void SetOrderStatus(eStatusOrder i_Status)
	{
		m_StatusOrder = i_Status;
	}
	
	public int GetOrderID()
	{
		return m_OrderID;
	}
	
	public void SetOrderID(int i_OrderID)
	{
		m_OrderID= i_OrderID;
	}
	
	public float GetPrice()
	{
		for(Proudct proudct : m_Proudcts)
		{
			m_TotalPrice += proudct.GetAmount()*proudct.GetPrice(); 
		}
		
		return m_TotalPrice;
	}
	
	public void SetPrice(float i_Price)
	{
		m_TotalPrice = i_Price;
	}
	
	public List<Proudct> GetProudct()
	{
		return m_Proudcts;
	}
	
	public void SetProudct(List<Proudct> i_Proudcts)
	{
		m_Proudcts= i_Proudcts;
	}
	
	public void AddProudct(String i_Name,int i_Amount,float i_Price)
	{
		if(m_ProudctList.Exist(i_Name))
		{
			m_Proudcts.add(new Proudct(i_Name, i_Amount, i_Price));
		}
	}
	
	public String GetType()
	{
		return m_TypeOrder;
	}
}

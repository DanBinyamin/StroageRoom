package Controller;


public class Proudct {
	
	protected String m_Name;
	protected int m_Amount;
	protected float m_Price;
	
	public Proudct(String i_Name, int i_Amount,float i_Price)
	{
		m_Name = i_Name;
		m_Amount = i_Amount;
		m_Price = i_Price;
	}
	
	public void UpdateProudct(Proudct i_ProudctToUpdate)
	{
		m_Amount += i_ProudctToUpdate.m_Amount;
	}
	
	public String GetName()
	{
		return m_Name;
	}
	
	public int GetAmount()
	{
		return m_Amount;
	}
	
	public float GetPrice()
	{
		return m_Price;
	}
	
	public void SetAmount(int i_Amount)
	{
		m_Amount = i_Amount;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof String)
		{
			return this.m_Name.equals(obj);
		}
		
		return false;
	}
	
}

package Controller;

import java.util.List;

public abstract class ProudctList 
{
	protected List<String> m_ProudctList;
	
	public List<String> GetList()
	{
		return m_ProudctList;
	}
	
	public void SetList(List<String> i_List)
	{
		m_ProudctList = i_List;
	}
	
	public boolean IsExits(String i_Name)
	{
		for(String name : m_ProudctList)
		{
			if(name.equals(i_Name))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public String GetProudctFromList(int i_Index)
	{
		return m_ProudctList.get(i_Index);
	}
	
	public boolean Exist(String i_Name)
	{
		for(String var : m_ProudctList)
		{
			if(var.equals(i_Name))
			{
				return true;
			}
		}
		
		return false;		
	}
}



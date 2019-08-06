package Controller;


public class FoodProudctList extends ProudctList 
{
	public FoodProudctList() 
	{
		m_ProudctList = ProudctListSaveSingleton.GetInstance().ReadProudctList("Food");
	}
	
	public void Add(String i_StrToAdd) 
	{
		m_ProudctList = ProudctListSaveSingleton.GetInstance().ReadProudctList("Food");
		m_ProudctList.add(i_StrToAdd);
		ProudctListSaveSingleton.GetInstance().WriteProudcts(m_ProudctList, "Food");
	}

	public void Remove(String i_StrToRemove) 
	{
		ProudctListSaveSingleton.GetInstance().ReadProudctList("Food");
		m_ProudctList.remove(m_ProudctList.indexOf(i_StrToRemove));
		ProudctListSaveSingleton.GetInstance().WriteProudcts(m_ProudctList, "Food");
	}
}

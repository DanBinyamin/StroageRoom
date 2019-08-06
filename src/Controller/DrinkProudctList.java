package Controller;


public class DrinkProudctList extends ProudctList {

	public DrinkProudctList() 
	{
		m_ProudctList = ProudctListSaveSingleton.GetInstance().ReadProudctList("Drink");
	}
	
	public void Add(String i_StrToAdd) 
	{
		m_ProudctList = ProudctListSaveSingleton.GetInstance().ReadProudctList("Drink");
		m_ProudctList.add(i_StrToAdd);
		ProudctListSaveSingleton.GetInstance().WriteProudcts(m_ProudctList, "Drink");
	}

	public void Remove(String i_StrToRemove) 
	{
		m_ProudctList = ProudctListSaveSingleton.GetInstance().ReadProudctList("Drink");
		m_ProudctList.remove(m_ProudctList.indexOf(i_StrToRemove));
		ProudctListSaveSingleton.GetInstance().WriteProudcts(m_ProudctList, "Drink");	
	}
}	


package Controller;



public class VegetablesProudctList extends ProudctList {
	
	public VegetablesProudctList()
	{
		m_ProudctList = ProudctListSaveSingleton.GetInstance().ReadProudctList("Vegetables");
	}
	
	public void Add(String i_StrToAdd) 
	{
		m_ProudctList = ProudctListSaveSingleton.GetInstance().ReadProudctList("Vegetables");
		m_ProudctList.add(i_StrToAdd);
		ProudctListSaveSingleton.GetInstance().WriteProudcts(m_ProudctList, "Vegetables");
		
	}

	public void Remove(String i_StrToRemove) 
	{
		m_ProudctList = ProudctListSaveSingleton.GetInstance().ReadProudctList("Vegetables");
		m_ProudctList.remove(m_ProudctList.indexOf(i_StrToRemove));
		ProudctListSaveSingleton.GetInstance().WriteProudcts(m_ProudctList, "Vegetables");
	}


}

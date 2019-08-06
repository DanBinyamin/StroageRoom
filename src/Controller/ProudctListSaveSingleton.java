package Controller;

import Model.ProudctListSave;

public class ProudctListSaveSingleton 
{
	private static ProudctListSave m_ProudctListSave;
	
	//Singleton pattern to read/write from csv
	private ProudctListSaveSingleton()
	{
		
	}
	
	public static ProudctListSave GetInstance()
	{
		if(m_ProudctListSave == null)
		{
			m_ProudctListSave = new ProudctListSave();
		}
		
		return m_ProudctListSave;
	}
}

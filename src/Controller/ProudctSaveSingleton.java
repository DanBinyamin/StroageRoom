package Controller;

import Model.ProudctSave;

public class ProudctSaveSingleton 
{
	private static ProudctSave m_ProudctSave;
	
	//Singleton pattern to read/write from csv
	private ProudctSaveSingleton()
	{
		
	}
	
	public static ProudctSave GetInstace()
	{
		if(m_ProudctSave == null)
		{
			m_ProudctSave = new ProudctSave();
		}
		
		return m_ProudctSave;
	}

}

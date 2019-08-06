package Controller;

import Model.EmployeeSave;

public class EmployeeSaveSingleton 
{
	private static EmployeeSave m_EmployeSave;

	//Singleton pattern to read/write from csv
	private EmployeeSaveSingleton()
	{
		
	}
	
	public static EmployeeSave GetInstance()
	{
		if(m_EmployeSave == null)
		{
			m_EmployeSave = new EmployeeSave();
		}
		
		return m_EmployeSave;
	}
}

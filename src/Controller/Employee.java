package Controller;

public class Employee
{
	
	private String m_IDNumber;
	private String m_Name;
	private boolean m_IsManager;
	
	public Employee(String i_IDNumber,String i_Name,boolean i_IsManager)
	{
		this.m_IDNumber=i_IDNumber;
		this.m_Name=i_Name;
		this.m_IsManager=i_IsManager;
	}

	public String GetID() {
		return m_IDNumber;
	}

	public String GetName() {
		return m_Name;
	}

	public boolean GetIsManager()
	{
		return m_IsManager;
	}
}

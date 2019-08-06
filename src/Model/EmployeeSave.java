package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import Controller.Employee;

public class EmployeeSave 
{
	private String pathFile = "EmployeeList.csv";

	//This method for to write to csv all the employee
	public void WriteEmployes(List<Employee> i_EmployeStroage)
	{
		FileWriter fileWrite = null;
		try
		{
			fileWrite = new FileWriter(pathFile);
			fileWrite.append("Name,ID,Manger"+System.lineSeparator());
			for(Employee e : i_EmployeStroage)
			{
				fileWrite.append(e.GetName());
				fileWrite.append(",");
				fileWrite.append(e.GetID());
				fileWrite.append(",");
				fileWrite.append(Boolean.toString(e.GetIsManager()));
				fileWrite.append(System.lineSeparator());
			}
			
		}catch (Exception e)
		{
			
		}finally 
		{
			try
			{
				fileWrite.flush();
				fileWrite.close();
			}
			catch(Exception e)
			{
				
			}
		}
	}
	
	//This method for to Read from csv all the employee
	public List<Employee> ReadEmployes()
	{
		BufferedReader reader = null;
		List<Employee> employes = null;
		
		try
		{
			employes = new ArrayList<Employee>();
			String line = "";
			reader = new BufferedReader(new FileReader(pathFile));
			reader.readLine();
			
			while((line = reader.readLine()) != null)
			{
				String[] fields = line.split(",");
				if(fields.length > 0)
				{
					Employee EmployeToInsert = new Employee(fields[1],fields[0],Boolean.parseBoolean(fields[2]));
					employes.add(EmployeToInsert);
				}
				
			}
		
			return employes;
			
		}
		catch (Exception e)
		{
			e.getMessage();
		}
		finally {
			try
			{
				reader.close();
			}
			catch (Exception e)
			{
				e.getMessage();
			}
		}
		
		return employes;
		
	}

}

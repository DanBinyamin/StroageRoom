package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class ProudctListSave 
{
	//this method write all the proudct the can order to csv 
	public void WriteProudcts(List<String> i_ProudctList,String i_NameOfStartedFile)
	{
		String pathFile = i_NameOfStartedFile+"ProudctList.csv";
		
		FileWriter fileWrite = null;
		try
		{
			fileWrite = new FileWriter(pathFile);
			fileWrite.append("Name"+System.lineSeparator());
			for(String s : i_ProudctList)
			{
				fileWrite.append(s);
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
	
	//this method read all the proudct from the csv that can order
	
	public List<String> ReadProudctList(String i_NameOfStartedFile)
	{
		BufferedReader reader = null;
		List<String> foodProudct = null;
		String pathFile = i_NameOfStartedFile+"ProudctList.csv";
		
		try
		{
			foodProudct = new ArrayList<String>();
			String line = "";
			reader = new BufferedReader(new FileReader(pathFile));
			reader.readLine();
			
			while((line = reader.readLine()) != null)
			{
				if(!line.isEmpty())
				{
					foodProudct.add(line);
				}
				
			}
		
			return foodProudct;
			
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
		
		return foodProudct;		
	}
}

package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import Controller.Proudct;

public class ProudctSave 
{
	private String pathFile = "ProudctStroage.csv";
	
	//this method write all the capacity proudct to csv
	public void WriteProudct(List<Proudct> i_ProudctStroage)
	{
		FileWriter fileWrite = null;
		try
		{
			fileWrite = new FileWriter(pathFile);
			fileWrite.append("Name,Amount,Price"+System.lineSeparator());
			for(Proudct p : i_ProudctStroage)
			{
				fileWrite.append(p.GetName());
				fileWrite.append(",");
				fileWrite.append(Integer.toString(p.GetAmount()));
				fileWrite.append(",");
				fileWrite.append(Float.toString(p.GetPrice()));
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
	
	//this method write all the capacity proudct to csv
	public List<Proudct> ReadProudct()
	{
		BufferedReader reader = null;
		List<Proudct> proudcts = null;
		
		try
		{
			proudcts = new ArrayList<Proudct>();
			String line = "";
			reader = new BufferedReader(new FileReader(pathFile));
			reader.readLine();
			
			while((line = reader.readLine()) != null)
			{
				String[] fields = line.split(",");
				if(fields.length > 0)
				{
					Proudct proudctToInsert = new Proudct(fields[0],Integer.parseInt(fields[1]),Float.parseFloat(fields[2]));
					proudcts.add(proudctToInsert);
				}
				
			}
		
			return proudcts;
			
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
		
		return proudcts;
		
	}
}

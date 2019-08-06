package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import Controller.Order;
import Controller.OrderFactory;
import Controller.eStatusOrder;

public class OrderSave
{
	private String pathFile = "OrderList.csv";
	
	//this method need to write all the order to csv
	public void WriteOrders(List<Order> i_OrderStroage)
	{
		FileWriter fileWrite = null;
		try
		{
			fileWrite = new FileWriter(pathFile);
			fileWrite.append("ID,Status,Price,Type"+System.lineSeparator());
			for(Order o : i_OrderStroage)
			{
				fileWrite.append(Integer.toString(o.GetOrderID()));
				fileWrite.append(",");
				fileWrite.append(o.GetOrderStatus().toString());
				fileWrite.append(",");
				fileWrite.append(Float.toString(o.GetPrice()));
				fileWrite.append(",");
				fileWrite.append(o.GetType());
				fileWrite.append(System.lineSeparator());
				
				ProdctOrderSpacificSave.WriteProudct(o.GetProudct(),Integer.toString(o.GetOrderID()));
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
	
	//this method need to read from the csv order
	public List<Order> ReadOrder()
	{
		BufferedReader reader = null;
		List<Order> orders = null;
		
		try
		{
			orders = new ArrayList<Order>();
			String line = "";
			reader = new BufferedReader(new FileReader(pathFile));
			reader.readLine();
			
			while((line = reader.readLine()) != null)
			{
				String[] fields = line.split(",");
				if(fields.length > 0)
				{
					Order orderToInsert = OrderFactory.CreateOrder(fields[3]);
					orderToInsert.SetOrderID(Integer.parseInt(fields[0]));
					if(fields[1].equals("InProgress"))
					{
						orderToInsert.SetOrderStatus(eStatusOrder.InProgress);
					}
					else if(fields[1].equals("Supplied"))
					{
						orderToInsert.SetOrderStatus(eStatusOrder.Supplied);
					}
					else if(fields[1].equals("Delay"))
					{
						orderToInsert.SetOrderStatus(eStatusOrder.Delay);
					}
					orderToInsert.SetPrice(Float.parseFloat(fields[2]));
					
					orderToInsert.SetProudct(ProdctOrderSpacificSave.ReadProudct(fields[0]));
					orders.add(orderToInsert);
				}
				
			}
		
			return orders;
			
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
		
		return orders;
		
	}
}

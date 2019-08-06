package Controller;

public class OrderFactory
{
	//Factory Method create order
	public static Order CreateOrder(String i_OrderType)
	{
		Order order = null; 
		
		if(i_OrderType.equals("Food"))
		{
			order = new FoodOrder();
		}
		else if( i_OrderType.equals("Vegetables"))
		{
			order = new VegetablesOrder();
		}
		else if(i_OrderType.equals("Drink"))
		{
			order = new DrinkOrder();
		}
		
		return order;
	}
}

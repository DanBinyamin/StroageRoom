package Controller;

import java.util.ArrayList;

public class DrinkOrder extends Order
{
	public DrinkOrder()
	{
		m_TypeOrder= "Drink";
		m_Proudcts = new ArrayList<Proudct>();
		m_ProudctList = new DrinkProudctList();
	}
}

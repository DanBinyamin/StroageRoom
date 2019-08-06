package Controller;

import java.util.ArrayList;

public class FoodOrder extends Order
{
	public FoodOrder()
	{
		m_TypeOrder = "Food";
		m_Proudcts = new ArrayList<Proudct>();
		m_ProudctList = new FoodProudctList();
	}
}


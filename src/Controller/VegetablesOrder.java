package Controller;

import java.util.ArrayList;

public class VegetablesOrder extends  Order
{
	public VegetablesOrder()
	{
		m_TypeOrder = "Vegetables";
		m_Proudcts = new ArrayList<Proudct>();
		m_ProudctList = new VegetablesProudctList();
	}

}

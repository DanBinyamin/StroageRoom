package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Controller.DrinkOrder;
import Controller.FoodOrder;
import Controller.Order;
import Controller.OrderFactory;
import Controller.VegetablesOrder;

public class FactoryTest {

	@Test
	public void test() 
	{
		Order order = OrderFactory.CreateOrder("Food");
		assertTrue(order instanceof FoodOrder);
		order = OrderFactory.CreateOrder("Drink");
		assertTrue(order instanceof DrinkOrder);
		order = OrderFactory.CreateOrder("Vegetables");
		assertTrue(order instanceof VegetablesOrder);
	}

}

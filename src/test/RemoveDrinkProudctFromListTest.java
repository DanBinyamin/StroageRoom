package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Controller.DrinkProudctList;


public class RemoveDrinkProudctFromListTest {

	@Test
	public void test() 
	{
		DrinkProudctList drinklist = new DrinkProudctList();
		drinklist.Add("check");
		drinklist.Remove("check");
		assertEquals(false,drinklist.Exist("check"));
	}

}

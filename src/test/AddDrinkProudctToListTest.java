package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Controller.DrinkProudctList;

public class AddDrinkProudctToListTest
{	
	@Test
	public void test() 
	{
		DrinkProudctList drinklist = new DrinkProudctList();
		drinklist.Add("check");
		assertEquals(true,drinklist.Exist("check"));
		drinklist.Remove("check");
	}

}

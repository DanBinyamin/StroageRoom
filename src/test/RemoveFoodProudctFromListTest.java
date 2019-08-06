package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Controller.FoodProudctList;

public class RemoveFoodProudctFromListTest
{
	@Test
	public void test() 
	{
		FoodProudctList foodlist = new FoodProudctList();
		foodlist.Add("check");
		foodlist.Remove("check");
		assertEquals(false,foodlist.Exist("check"));
	}

}

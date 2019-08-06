package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Controller.FoodProudctList;

public class AddFoodProudctToListTest {

	@Test
	public void test() 
	{
		FoodProudctList foodlist = new FoodProudctList();
		foodlist.Add("check");
		assertEquals(true,foodlist.Exist("check"));
		foodlist.Remove("check");
	}

}

package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Controller.FoodProudctList;
import Controller.StorageRoomMangment;

public class FoodProudctListTest {

	@Test
	public void test() 
	{
		StorageRoomMangment sr = new StorageRoomMangment();
		FoodProudctList foodlist = sr.GetFoodList();
		assertTrue(foodlist instanceof FoodProudctList);
	}

}

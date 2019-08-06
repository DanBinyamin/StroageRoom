package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Controller.DrinkProudctList;
import Controller.StorageRoomMangment;

public class DrinkProudctListTest {

	@Test
	public void test()
	{
		StorageRoomMangment sr = new StorageRoomMangment();
		DrinkProudctList drinklist = sr.GetDrinkList();
		assertTrue(drinklist instanceof DrinkProudctList);
	}

}

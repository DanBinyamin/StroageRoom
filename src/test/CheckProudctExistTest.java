package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Controller.StorageRoomMangment;

public class CheckProudctExistTest {

	@Test
	public void test() 
	{
		StorageRoomMangment sr = new StorageRoomMangment();
		assertEquals(true,sr.CheckProdctExitsInListofProdct("Coca Cola", "Drink"));
	}

}

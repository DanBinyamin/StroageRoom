package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Controller.StorageRoomMangment;
import Controller.VegetablesProudctList;

public class VegtProudctListTest {

	@Test
	public void test() 
	{
		StorageRoomMangment sr = new StorageRoomMangment();
		VegetablesProudctList vegtlist = sr.GetVegtList();
		assertTrue(vegtlist instanceof VegetablesProudctList);
	}

}

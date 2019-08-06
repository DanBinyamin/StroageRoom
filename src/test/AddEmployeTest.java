package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Controller.StorageRoomMangment;

public class AddEmployeTest {

	@Test
	public void test()
	{
		StorageRoomMangment sr = new StorageRoomMangment();
		sr.AddEmploye("Check","11",false);
		assertTrue(sr.IsEmploye("11"));
		sr.RemoveEmploye("11");
	}

}

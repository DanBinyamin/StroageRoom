package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Controller.StorageRoomMangment;

public class RemoveEmploye {

	@Test
	public void test()
	{
		StorageRoomMangment sr = new StorageRoomMangment();
		sr.AddEmploye("Check","11",false);
		sr.RemoveEmploye("11");
		assertEquals(false,sr.IsEmploye("11"));
	}

}

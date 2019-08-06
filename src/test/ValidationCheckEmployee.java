package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Controller.StorageRoomMangment;

public class ValidationCheckEmployee {

	@Test
	public void test()
	{
		StorageRoomMangment sr = new StorageRoomMangment();
		assertEquals(false,sr.IsEmploye("@asad231131"));
	}

}

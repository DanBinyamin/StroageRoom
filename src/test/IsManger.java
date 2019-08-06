package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Controller.StorageRoomMangment;

public class IsManger {

	@Test
	public void test() 
	{
		StorageRoomMangment sr = new StorageRoomMangment();
		assertTrue(sr.IsEmploye("304914716"));
	}

}

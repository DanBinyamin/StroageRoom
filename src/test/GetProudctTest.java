package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Controller.StorageRoomMangment;

public class GetProudctTest {

	@Test
	public void test() 
	{
		StorageRoomMangment sr = new StorageRoomMangment();
		assertNull(sr.GetProudct("Not Exist Proudct"));
	}

}

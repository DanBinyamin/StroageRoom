package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Controller.VegetablesProudctList;

public class RemoveVegtProudctFromListTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() 
	{
		VegetablesProudctList vegtlist = new VegetablesProudctList();
		vegtlist.Add("check");
		vegtlist.Remove("check");
		assertEquals(false,vegtlist.Exist("check"));
	}

}

package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Controller.VegetablesProudctList;

public class AddVegtProudctToList {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test()
	{
		VegetablesProudctList vegtlist = new VegetablesProudctList();
		vegtlist.Add("check");
		assertEquals(true,vegtlist.Exist("check"));
		vegtlist.Remove("check");
	}

}

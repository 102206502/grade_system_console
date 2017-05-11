/**-----------------------------------------------------------------------------
 * class TestCheckID
 * 
 * UI aUI
 * 
 * Grades in GradeSystem:
 * 962001044 ­â©v§Ê 87 86 98 88 87
 * 962001051 §õ«Â§Ê 81 98 84 90 93
 * 
 * 
 * case1 :
 * find ID 962001044
 * expected : True
 * 
 * case2 :
 * find ID 962001051
 * expected : True
 * 
 * case3 :
 * find ID 0
 * expected : False
 -----------------------------------------------------------------------------*/
package GradeSystem;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCheckID {
	UI aUI;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		aUI = new UI("Test Mode");
	}

	@After
	public void tearDown() throws Exception {
		aUI = null;
	}

	@Test
	public void testIDExist1() throws NoSuchIDExceptions {
		assertTrue(aUI.checkID("962001044"));
	}
	
	@Test
	public void testIDExist2() throws NoSuchIDExceptions {
		assertTrue(aUI.checkID("962001051"));
	}
	
	@Test(expected = NoSuchIDExceptions.class)
	public void testIDNotFound() throws NoSuchIDExceptions {
		assertFalse(aUI.checkID("932001050"));
	}

}

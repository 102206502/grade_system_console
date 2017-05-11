/**-----------------------------------------------------------------------------
 * class TestContainsID
 * 
 * Grades in GradeSystem:
 * 962001044 ­â©v§Ê 87 86 98 88 87
 * 962001051 §õ«Â§Ê 81 98 84 90 93
 * 
 * case 1: ID 962001044 
 * expected: true
 * 
 * case 2: ID 322001044
 * expected: false
 * 
 ----------------------------------------------------------------------------------*/
package GradeSystem;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestContainsID {
	GradeSystems aGradeSystem;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		aGradeSystem = new GradeSystems();
	}

	@After
	public void tearDown() throws Exception {
		aGradeSystem = null;
	}

	@Test
	public void testContainsID1() throws NoSuchIDExceptions {
		assertTrue(aGradeSystem.containsID("962001044"));
	}

	@Test(expected = NoSuchIDExceptions.class)
	public void testContainsID2() throws NoSuchIDExceptions {
		assertFalse(aGradeSystem.containsID("322001044"));
	}

}

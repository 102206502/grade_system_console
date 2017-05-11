/**-----------------------------------------------------------------------------
 * class TestShowRank
 * 
 * Grades in GradeSystem:
 * 962001044 凌宗廷 87 86 98 88 87
 * 962001051 李威廷 81 98 84 90 93
 * 
 * case: 
 * 962001044 凌宗廷 87 86 98 88 87
 * 962001051 李威廷 81 98 84 90 93
 * 
 * expect:    
 * 李威廷排名第 1
 ----------------------------------------------------------------------------------*/
package GradeSystem;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestShowRank {
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
	public void testShowRank() {
//		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//		System.setOut(new PrintStream(outContent));
		final ByteArrayOutputStream outContent = simulateOutput();
		aGradeSystem.showRank("962001051");
		
		assertEquals("李威廷排名第 1\r\n", outContent.toString());
	}
	
	private ByteArrayOutputStream simulateOutput() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		return outContent;
	}
	
}

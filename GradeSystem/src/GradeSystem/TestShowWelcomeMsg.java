/**-----------------------------------------------------------------------------
 * class TestShowWelcomeMsg
 * 
 * UI aUI
 * GradeSystems aGradeSystem
 * 
 * Grades in GradeSystems:
 * 962001044 ­â©v§Ê 87 86 98 88 87
 * 962001051 §õ«Â§Ê 81 98 84 90 93
 * 
 * case: 
 * showWelcomeMsg("962001044") is called
 * 
 * expect :
 * Welcome ­â©v§Ê
 * -----------------------------------------------------------------------------*/
package GradeSystem;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestShowWelcomeMsg {
	UI aUI;
	GradeSystems aGradeSystem;
	
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
		aGradeSystem = null;
	}

	@Test
	public void testShowWelcomeMsg() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		aUI.showWelcomeMsg("962001044");
		assertEquals("Welcome ­â©v§Ê\n\n", outContent.toString());
	}

}

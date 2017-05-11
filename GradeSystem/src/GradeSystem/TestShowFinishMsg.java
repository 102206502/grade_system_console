/**-----------------------------------------------------------------------------
 * class TestShowFinishMsg
 * 
 * UI aUI
 * 
 * case: 
 * showFinishMsg() is called
 * 
 * expect : 
 * "結束了"
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

public class TestShowFinishMsg {
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
	public void testShowFinishMsg() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		aUI.showFinishMsg();
		assertEquals("結束了\r\n", outContent.toString());
	}
}

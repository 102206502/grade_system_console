/**-----------------------------------------------------------------------------
 * class TestPromptID
 * 
 * UI aUI
 * 
 * case 1:
 * input : Q
 * 
 * expect : 
 * 輸入ID或 Q (結束使用)? 
 * 
 * case 2:
 * input : ID 
 * 
 * expect : call showWelcomeMsg()
 * -----------------------------------------------------------------------------*/
package GradeSystem;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPromptID {
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
	
	private ByteArrayOutputStream simulateOutput() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		return outContent;
	}
	
	@Test
	public void testPromptID1() throws NoSuchCommandExceptions {
		final ByteArrayOutputStream outContent = simulateOutput();
		final ByteArrayInputStream inContent = new ByteArrayInputStream("Q".getBytes());
		System.setIn(inContent);
		aUI.promptID();
		assertEquals("輸入ID或 Q (結束使用)? ", outContent.toString());
	}
	
	@Test
	public void testPromptID2() throws NoSuchCommandExceptions {
		final ByteArrayInputStream inContent = new ByteArrayInputStream("962001044".getBytes());
		System.setIn(inContent);
		
		final ByteArrayOutputStream outContent = simulateOutput();
		aUI.promptID();
		assertEquals("輸入ID或 Q (結束使用)? ", outContent.toString());
		
	}

	@Test(expected = NoSuchCommandExceptions.class)
	public void testPromptID3() throws NoSuchCommandExceptions {
		final ByteArrayInputStream inContent = new ByteArrayInputStream("CCC".getBytes());
		System.setIn(inContent);
		
		final ByteArrayOutputStream outContent = simulateOutput();
		aUI.promptID();
		assertEquals("輸入ID或 Q (結束使用)? ", outContent.toString());
		
	}
	
}

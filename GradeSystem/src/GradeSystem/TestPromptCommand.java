/**-----------------------------------------------------------------------------
 * class TestPromptCommand
 * 
 * UI aUI
 * String ID
 * 
 * ID of grade
 * 962001044 凌宗廷 87 86 98 88 87
 * 
 * case 1:
 * call promptCommand
 * 
 * expected:
 * 輸入指令 1) G 顯示成績 (Grade) 
 * 		 2) R 顯示排名 (Rank) 
 * 		 3) W更新配分 (Weight) 
 *		 4) E 離開選單 (Exit)  
 * 使用者輸入：
 * 
 * case 2:
 * input G
 * 
 * expect : No error
 * 
 * case 3:
 * input R
 * 
 * expect : No error
 * 
 * case 5:
 * input E
 * 
 * expect : No error
 * 
 * case 6:
 * input CCC
 * 
 * expect : NoSuchCommandException
 -----------------------------------------------------------------------------*/
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

public class TestPromptCommand {
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
		aUI.ID = "962001044";
	}

	@After
	public void tearDown() throws Exception {
		aUI = null;
	}
	
	private void simulateInput(String inputStr) {
		final ByteArrayInputStream inContent = new ByteArrayInputStream(inputStr.getBytes());
		System.setIn(inContent);
	}
	
	private ByteArrayOutputStream simulateOutput() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		return outContent;
	}


	@Test
	public void testPromptCommand() throws NoSuchCommandExceptions {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		simulateInput("E");
		aUI.promptCommand();
		assertEquals("\r\n\t輸入指令 "
				+ "1) G 顯示成績 (Grade) \r\n\t     "
				+ "2) R 顯示排名 (Rank) \r\n\t     "
				+ "3) W 更新配分 (Weight) \r\n\t     "
				+ "4) E 離開選單 (Exit)\n"
				+ "使用者輸入： ", outContent.toString());
	}
	
	@Test
	public void testPromptCommand1() throws NoSuchCommandExceptions {
		simulateInput("G");
		aUI.promptCommand();
	}
	
	@Test
	public void testPromptCommand2() throws NoSuchCommandExceptions {
		simulateInput("R");
		aUI.promptCommand();
	}
	
	@Test
	public void testPromptCommand3() throws NoSuchCommandExceptions {
		simulateInput("W\n20\n20\n20\n20\n20\nN");
		aUI.promptCommand();
	}
	
	@Test
	public void testPromptCommand4() throws NoSuchCommandExceptions {
		simulateInput("E");
		aUI.promptCommand();
	}
	
	@Test(expected = NoSuchCommandExceptions.class)
	public void testPromptCommand5() throws NoSuchCommandExceptions {
		simulateInput("CCC");
		aUI.promptCommand();
	}

}

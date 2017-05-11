/**-----------------------------------------------------------------------------
 * class TestUpdateWeights
 * 
 * Grades in GradeSystem:
 * 962001044 凌宗廷 87 86 98 88 87
 * 962001051 李威廷 81 98 84 90 93
 * 
 * default weights:
 * 			   lab1           10%
 *             lab2           10%
 *             lab3           10%
 *             mid-term       30%
 *             final exam     40%
 *             
 * case1:
 * 輸入新配分
 *     lab1           20
 *     lab2           20
 *     lab3           20
 *     mid-term       20
 *     final exam     20
 * 以上正確嗎? Y (Yes)
 * 
 * expected:
 * weights = {0.2f, 0.2f, 0.2f, 0.2f, 0.2f}
 * 
 * case2:
 * 輸入新配分
 *     lab1           20
 *     lab2           20
 *     lab3           20
 *     mid-term       20
 *     final exam     20
 * 以上正確嗎? N (No)
 * 
 * expected:
 * weights = {0.1f, 0.1f, 0.1f, 0.3f, 0.4f}
 ----------------------------------------------------------------------------------*/
package GradeSystem;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestUpdateWeights {
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
	
	private void simulateInput(String inputStr) {
		final InputStream inContent = new ByteArrayInputStream(inputStr.getBytes());
		System.setIn(inContent);
	}
	
	private ByteArrayOutputStream simulateOutput() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		return outContent;
	}

	@Test
	public void testUpdateWeights1() throws NoSuchCommandExceptions {
		//showOldWeights()
		ByteArrayOutputStream outContent = simulateOutput();
		

		simulateInput("20\n20\n20\n20\n20\nY");
		aGradeSystem.updateWeights();
		assertEquals("舊配分\r\n"
				+ "\tlab1\t10%\r\n"
				+ "\tlab2\t10%\r\n"
				+ "\tlab3\t10%\r\n"
				+ "\tmid-term\t30%\r\n"
				+ "\tfinal exam\t40%\r\n"
				+ "輸入新配分\r\n"
				+ "\tlab1\t"
				+ "\tlab2\t"
				+ "\tlab3\t"
				+ "\tmid-term\t"
				+ "\tfinal exam\t"
				+ "請確認新配分\r\n"
				+ "\tlab1\t20%\r\n"
				+ "\tlab2\t20%\r\n"
				+ "\tlab3\t20%\r\n"
				+ "\tmid-term\t20%\r\n"
				+ "\tfinal exam\t20%\r\n"
				+ "以上正確嗎? Y (Yes) 或 N (No)\r\n", outContent.toString());
		
		float[] weightsNew = {0.2f, 0.2f, 0.2f, 0.2f, 0.2f};
		assertArrayEquals(weightsNew, aGradeSystem.weights, 0.0001f);
	}

	@Test
	public void testUpdateWeights2() throws NoSuchCommandExceptions {
		//showOldWeights()
		ByteArrayOutputStream outContent = simulateOutput();

		simulateInput("20\n20\n20\n20\n20\nN");
		aGradeSystem.updateWeights();
		assertEquals("舊配分\r\n"
				+ "\tlab1\t10%\r\n"
				+ "\tlab2\t10%\r\n"
				+ "\tlab3\t10%\r\n"
				+ "\tmid-term\t30%\r\n"
				+ "\tfinal exam\t40%\r\n"
				+ "輸入新配分\r\n"
				+ "\tlab1\t"
				+ "\tlab2\t"
				+ "\tlab3\t"
				+ "\tmid-term\t"
				+ "\tfinal exam\t"
				+ "請確認新配分\r\n"
				+ "\tlab1\t20%\r\n"
				+ "\tlab2\t20%\r\n"
				+ "\tlab3\t20%\r\n"
				+ "\tmid-term\t20%\r\n"
				+ "\tfinal exam\t20%\r\n"
				+ "以上正確嗎? Y (Yes) 或 N (No)\r\n", outContent.toString());
		
		float[] weightsOld = {0.1f, 0.1f, 0.1f, 0.3f, 0.4f};
		assertArrayEquals(weightsOld, aGradeSystem.weights, 0.0001f);
	}

	@Test(expected = NoSuchCommandExceptions.class)
	public void testUpdateWeights3() throws NoSuchCommandExceptions {
		//showOldWeights()

		ByteArrayOutputStream outContent = simulateOutput();
		simulateInput("20\n20\n20\n20\n20\nI");
		aGradeSystem.updateWeights();
		assertEquals("舊配分\r\n"
				+ "\tlab1\t10%\r\n"
				+ "\tlab2\t10%\r\n"
				+ "\tlab3\t10%\r\n"
				+ "\tmid-term\t30%\r\n"
				+ "\tfinal exam\t40%\r\n"
				+ "輸入新配分\r\n"
				+ "\tlab1\t"
				+ "\tlab2\t"
				+ "\tlab3\t"
				+ "\tmid-term\t"
				+ "\tfinal exam\t"
				+ "請確認新配分\r\n"
				+ "\tlab1\t20%\r\n"
				+ "\tlab2\t20%\r\n"
				+ "\tlab3\t20%\r\n"
				+ "\tmid-term\t20%\r\n"
				+ "\tfinal exam\t20%\r\n"
				+ "以上正確嗎? Y (Yes) 或 N (No)\r\n", outContent.toString());
		
		float[] weightsOld = {0.1f, 0.1f, 0.1f, 0.3f, 0.4f};
		assertArrayEquals(weightsOld, aGradeSystem.weights, 0.0001f);
	}
}

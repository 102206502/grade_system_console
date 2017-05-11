/**-----------------------------------------------------------------------------
 * class TestShowGrade
 * 
 * Grades in GradeSystem:
 * 
 * ID        name Lab1 Lab2 Lab3 Mid-term FinalExam
 * 962001044 ­â©v§Ê  87    86   98   88         87
 * 962001051 §õ«Â§Ê   81    98  84   90        93
 * 
 * 
 * case: 
 * 962001051 §õ«Â§Ê 81 98 84 90 93
 * 
 * expected: 
 * §õ«Â§Ê¦¨ÁZ¡Glab1¡G     81¡@
 *         lab2¡G     98¡@
 *         lab3¡G     84¡@
 *         mid-term :  90
 *         final exam¡G93
 *         total grade : 91
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

public class TestShowGrade {
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
	public void testShowGrade() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		aGradeSystem.showGrade("962001051");
		
		assertEquals("\n§õ«Â§Ê¦¨ÁZ:lab1:81\r\n"
				+ "lab2:98\r\n"
				+ "lab3:84\r\n"
				+ "mid-term:90\r\n"
				+ "final exam:93\r\n"
				+ "total grade:91\r\n", outContent.toString());
	}

}

/**-----------------------------------------------------------------------------
 * class TestCalculateTotalGrade
 * 
 * Grades in GradeSystem:
 * ID        Name Lab1 Lab2 Lab3 Midterm FinalExam
 * 962001044 ­â©v§Ê   87   86   98   88      87
 * input Lab1 = 87, Lab2 = 86, Lab3 = 98, Midterm = 88, FinalExam = 87
 * 
 * case 1: 
 * weights = {0.2,0.2,0.2,0.2,0.2}
 * 
 * expected : 
 * totalGrade = 89
 * 
 * case 2: 
 * weights = {0.25,0.1,0.1,0.25,0.3}
 * 
 * expected :
 * totalGrade = 80
 -----------------------------------------------------------------------------*/
package GradeSystem;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCalculateTotalGrade {
	
	Grades agrade;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		agrade = new Grades();
	}

	@After
	public void tearDown() throws Exception {
		agrade = null;
	}
	
	@Test
	public void testCalculateTotalGrade1() {
		float[] weights = {0.2f,0.2f,0.2f,0.2f,0.2f};
		agrade.lab1 = 87;
		agrade.lab2 = 86;
		agrade.lab3 = 98;
		agrade.midTerm = 88;
		agrade.finalExam = 87;
		agrade.calculateTotalGrade(weights);
		
		assertEquals(89, agrade.totalGrade);
	}
	
	@Test
	public void testCalculateTotalGrade2() {
		float[] weights = {0.25f,0.1f,0.1f,0.25f,0.3f};
		agrade.lab1 = 87;
		agrade.lab2 = 86;
		agrade.lab3 = 98;
		agrade.midTerm = 88;
		agrade.finalExam = 92;
		agrade.calculateTotalGrade(weights);
		
		assertEquals(90, agrade.totalGrade);
	}

}

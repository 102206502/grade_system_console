/**-----------------------------------------
 * Nothing to be tested
 * -----------------------------------------*/
package GradeSystem;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestGradeSystems {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGradeSystems() throws FileNotFoundException {
		GradeSystems aGradeSystem = new GradeSystems();
		assertNotNull(aGradeSystem);
	}

}

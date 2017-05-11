/**-------------------------------
 * Nothing to be tested
 ---------------------------------*/
package GradeSystem;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestUI {
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
	}

	@Test
	public void testUI() {
		assertNotNull(aUI);
	}

}

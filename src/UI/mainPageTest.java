package UI;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JTextField;

import org.junit.jupiter.api.Test;

class mainPageTest {

	@Test
	void testMain() {
		/*main*/
	}

	@Test
	void testCheckStudent() {
		/*Database connection*/
	}

	@Test
	void testCheckTeacher() {
		/*Database Connection*/
	}

	@Test
	void testMainPage() {
		mainPage mainpagetest = new mainPage();
		assertNotNull(mainpagetest);
		JTextField username = (JTextField)TestUtils.getChildNamed(mainpagetest, "mainpage");
		assertNotNull(username); // Component found?
	}

}

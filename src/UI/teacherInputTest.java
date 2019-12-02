package UI;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JTextField;

import org.junit.jupiter.api.Test;

class teacherInputTest  {
	teacherInput teacherinputtest = new teacherInput();
	
	@Test
	void testConstructor() {
		assertNotNull(teacherinputtest);
	}
	

	@Test
	void testGetTotalQA() {
		/*Data bse access*/
	}

	@Test
	void testTeacherInput() {
		 JTextField input = (JTextField)TestUtils.getChildNamed(teacherinputtest, "AnswerText");       
		 assertNull(input);
		 /*
		 * input.setText("Helloworld"); input.postActionEvent();
		 * assertEquals("Helloworld" + "?", input.getText());
		 */
	}


}

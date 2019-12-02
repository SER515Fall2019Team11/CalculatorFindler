package UI;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuestionDisplayPanelTest {
	QuestionDisplayPanel qdp = new QuestionDisplayPanel(null, null);

	@Test
	void Constructor() {
		assertNotNull(qdp);

	}
	@Test
	void testQuestionDisplayPanel() {
		/*Test out of scope*/
	}

	@Test
	void testSortbyColumn() {
		Object[][] arr = {
	            {1, 2, 3},
	            {10}
	        };;
		QuestionDisplayPanel.sortbyColumn(arr, 1);
		
	}

}

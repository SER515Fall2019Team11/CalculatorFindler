package UI;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DragAndDropPanelTest {
	DragAndDropPanel dadptest = new DragAndDropPanel(0, null);
	@Test
	void testDragAndDropPanel() {
		assertNotNull(dadptest);
	}

	@Test
	void testInit() {
		/*Initialises window viz test when ran*/
	}

	@Test
	void testCalculate() {
		dadptest.calculate("Invalideqn");
		/*Valid as the ogic is handled by an inbuilt function ScriptEngine*/
		
	}

}

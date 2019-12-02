package UI;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorOperationPanelTest {

	@Test
	void testCalculatorOperationPanel() {
		CalculatorOperationPanel cop = new CalculatorOperationPanel(null, 0);
		assertNotNull(cop);
	}

	@Test
	void testDisabledButton() {
		/*Can be test while running appn as it is a visual element*/
	}

	@Test
	void testInit() {
		/*Initialises Panel*/
	}

}

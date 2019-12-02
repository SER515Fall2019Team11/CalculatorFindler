package UI;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class studentCalculateTest {

	@Test
	void testStudentCalculate() {
		studentCalculate sctest = new studentCalculate(0);
		assertNotNull(sctest);
	}

}

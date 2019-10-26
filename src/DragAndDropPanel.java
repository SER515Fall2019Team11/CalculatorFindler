import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DragAndDropPanel extends JTextArea {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1888406948735963582L;

	/**
	 * Create the panel.
	 */
	public DragAndDropPanel() {
		this.setBorder(BorderFactory.createTitledBorder("Drag & Drop"));
		this.setBackground(new Color(255,255,204));
	}

}

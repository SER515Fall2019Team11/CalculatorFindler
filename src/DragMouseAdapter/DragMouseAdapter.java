package DragMouseAdapter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
//import javax.swing.JComponent;
import javax.swing.TransferHandler;

public class DragMouseAdapter extends MouseAdapter {
	public void mouseDragged(MouseEvent e) {
		JButton button = (JButton)e.getSource();
		TransferHandler handler	 = button.getTransferHandler();
		handler.exportAsDrag(button, e, TransferHandler.COPY);
	}
}

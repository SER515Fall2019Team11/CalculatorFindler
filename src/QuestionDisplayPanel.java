import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class QuestionDisplayPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6591551521649362378L;

	/**
	 * Create the panel.
	 */
	public QuestionDisplayPanel() {
		init();
		//this.setBorder(BorderFactory.createTitledBorder("Show Question"));
	}
	
	private void init() {
		addTable();
	}
	private void addTable() {
		Object [][]data = { {"1", "5+3", "8"},
							{"2", "7*8", "56"},
							{"3", "22+15*8", "144"}};
		
		String []colName = {"No.", "Question", "Answer"};
		JTable table = new JTable(data, colName);
		for(int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(this.getWidth()/12);
		}
		JScrollPane scroll = new JScrollPane(table);
		//scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		table.setFillsViewportHeight(true);
		scroll.setAutoscrolls(true);
		this.add(scroll);
		//this.setPreferredSize(new Dimension(100, 100));
	}

}

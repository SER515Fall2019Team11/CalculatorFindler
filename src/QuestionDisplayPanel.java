import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class QuestionDisplayPanel extends JPanel {
	private JScrollPane scroll;
	private JFrame frame;
	private JTable table;
	/**
	 * 
	 */
	private static final long serialVersionUID = 6591551521649362378L;

	/**
	 * Create the panel.
	 */
	public QuestionDisplayPanel(JFrame frame) {
		this.frame = frame;
		init();
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				TableAutoResize();
				System.out.println(frame.getWidth());
			}
		});
		this.setBorder(BorderFactory.createTitledBorder("Show Question"));
	}
	
	private void init() {
		scroll = new JScrollPane();
		addTable();
		this.setBackground(new Color(255,255,204));
	}
	private void TableAutoResize() {
		table.setPreferredScrollableViewportSize(new Dimension(this.frame.getWidth() / 3, this.frame.getHeight()));
		table.setBackground(new Color(255,255,204));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scroll.setViewportView(table);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	}
	private void addTable() {
		Object [][]data = { {"1", "5+3", "8"},
							{"2", "7*8", "56"},
							{"3", "22+15*8", "144"}};
		
		String []colName = {"No.", "Question", "Answer"};
		table = new JTable(data, colName);
		TableAutoResize();
		this.add(scroll, BorderLayout.CENTER);
	}

}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

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
		//this.setBackground(new Color(255,255,204));
		this.setBackground(Color.cyan);
	}
	private void TableAutoResize() {
		table.setPreferredScrollableViewportSize(new Dimension(this.frame.getWidth() / 3, this.frame.getHeight()));
		//table.setBackground(new Color(255,255,204));
		table.setBackground(Color.cyan);
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
		//table.getTableHeader().setBackground(new Color(255,255,204));
		table.getTableHeader().setBackground(Color.cyan);
		table.getTableHeader().setForeground(Color.BLACK);
		/*
		DefaultTableCellRenderer rendar1 = new DefaultTableCellRenderer();
	    rendar1.setForeground(Color.RED);
	    for(int i = 0; i < table.getColumnCount(); i++) {
	    	table.getColumnModel().getColumn(i).setCellRenderer(rendar1);
	    }*/
		TableAutoResize();
		this.add(scroll, BorderLayout.CENTER);
	}

}

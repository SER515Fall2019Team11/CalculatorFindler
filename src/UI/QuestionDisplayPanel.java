package UI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

import Implementation.ImplementationService;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.Font;

@SuppressWarnings("unused")
public class QuestionDisplayPanel extends JPanel {
	private JScrollPane scroll;
	private JFrame frame;
	private JTable table;
	private final String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
	private String user = "root";
	private String password = "Kuan890618";
	public DragAndDropPanel dPanel;
	public String quesId;
	/**
	 * 
	 */
	private static final long serialVersionUID = 6591551521649362378L;

	/**
	 * Create the panel.
	 */
	public QuestionDisplayPanel(JFrame frame, DragAndDropPanel dragPanel) {
		this.frame = frame;
		dPanel = dragPanel;
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
		table.setPreferredScrollableViewportSize(new Dimension(this.frame.getWidth() / 3 - 10, this.frame.getHeight()));
		//table.setBackground(new Color(255,255,204));
		table.setBackground(Color.cyan);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scroll.setViewportView(table);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	}
	private void addTable() {
		//Object [][]data;

		DatabaseConn db = new DatabaseConn(url, user, password);
		Connection conn = db.getMySqlConnection();		
		if(conn == null) {
			JOptionPane.showMessageDialog(null, "database connection failed");
			return;
		}
		ImplementationService imp = new ImplementationService(conn);
		Object [][]data = imp.getAllQuestion(dPanel.level);
		//System.out.println(data.length);
		/*
		Object [][]dataShow = new Object[data.length][2];
		for (int i = 0; i < data.length; i++) {
			if (data[i][3].equals(Integer.toString(dPanel.level))) {
				dataShow[i][0] = data[i][0];
				dataShow[i][1] = data[i][1];
				
			}
		}*/
		String []colName = {"id", "Question"};
		table = new JTable(data, colName);
		//table.setFont(new Font("Rockwell", Font.PLAIN, 21));
		table.setFillsViewportHeight(true);
		//table.getTableHeader().setBackground(new Color(255,255,204));
		table.getTableHeader().setBackground(Color.cyan);
		table.getTableHeader().setForeground(Color.BLACK);
		TableAutoResize();
		this.add(scroll, BorderLayout.CENTER);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            quesId = table.getValueAt(table.getSelectedRow(), 0).toString();
	            dPanel.result.setText("Selected Question:"+ quesId + "\n" + "Start solving the question!");
	            dPanel.Id = quesId;
	        }
	    });
	}

}

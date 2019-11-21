package UI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Implementation.ImplementationService;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.nio.file.*;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



@SuppressWarnings({ "unused", "serial" })
public class teacherInput extends JFrame {

	private JPanel contentPane;
	private final String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
	private String user = "root";
	private String password = "Kuan890618";

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teacherInput frame = new teacherInput();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	public int getTotalQA() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			ImplementationService imp = new ImplementationService(conn);
			Object [][]data = imp.getAllQuestion();
			return data.length;
		} catch (Exception ex) {
			System.out.println(ex);
			return 0;
		}
	}

	/**
	 * Create the frame.
	 */
	public teacherInput() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextArea answerText = new JTextArea();
		answerText.setFont(new Font("Times New Roman", Font.PLAIN, 45));
		answerText.setTabSize(4);
		
		JTextArea questionText = new JTextArea();
		questionText.setFont(new Font("Times New Roman", Font.PLAIN, 45));
		questionText.setTabSize(4);
		
		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion.setFont(new Font("Rockwell", Font.PLAIN, 25));
		
		JButton btnBack = new JButton("Return");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPage main = new mainPage();
				main.setVisible(true);
				setVisible(false);
			}
		});
			
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					/*Path currentRelativePath = Paths.get("");
					String currentDir = currentRelativePath.toAbsolutePath().toString();
					FileWriter fw=new FileWriter(currentDir + "\\testout.txt",true); 
					fw.write("Question #");
					fw.write(questionNum.getText());
					fw.write("\n");   
					fw.write(questionText.getText());
					fw.write("\nAnswer #"); 
					fw.write(questionNum.getText());
					fw.write("\n");
					fw.write(answerText.getText());
					fw.write("\n");   
					
					fw.close();  */
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(url, user, password);
					int index = getTotalQA();
					String id = Integer.toString(index + 1);
					//System.out.println(id);
					String query = "insert into question values('" + id + "', '" + questionText.getText() + "', '" + answerText.getText() + "','" + "0" + "')";
					Statement statement = conn.createStatement();
					statement.executeUpdate(query);
					
					JOptionPane.showMessageDialog(null, "Successfully added the question");
				} catch(Exception ex) {
					System.out.println(ex);
					JOptionPane.showMessageDialog(null, "Fail added the question");
				}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswer.setFont(new Font("Rockwell", Font.PLAIN, 25));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(questionText, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1322, Short.MAX_VALUE)
						.addComponent(answerText, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1322, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblQuestion, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
							.addGap(1089)
							.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblAnswer, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
							.addGap(1210))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(1199)
							.addComponent(btnSubmit, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(lblQuestion, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
							.addGap(6)))
					.addGap(18)
					.addComponent(questionText, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAnswer, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(answerText, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
					.addGap(9)
					.addComponent(btnSubmit, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

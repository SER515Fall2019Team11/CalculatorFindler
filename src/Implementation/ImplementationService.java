package Implementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/***
 * 
 * @author hzhan193
 * date create - 11/14/2019
 * date modified - 11/19/2019
 */
public class ImplementationService {
	private Connection conn;

	public ImplementationService(Connection conn) {
		this.conn  = conn;
	}

	public Object[][] getAllQuestion(){
		try {
			Object [][]data;
			int row = 0;
			Statement stmt = null;
			ResultSet rs = null;
			String query = "select id, question, answer from question";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			String id = null;
			String question = null;
			String answer = null;
			if(rs.last()) {
				row = rs.getRow();
			}
			rs.beforeFirst();
			data = new Object[row][3];

			while (rs.next()){
				int index = rs.getRow() -1;
				id = rs.getString(1);
				question = rs.getString(2);
				answer = rs.getString(3);
				data[index][0] = id;
				data[index][1] = question;
				data[index][2] = answer;
				System.out.println(id + " " + question + " " + answer);
			}
			stmt.close();
			conn.close();
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Object[][] getAllStudent(){
		try {
			Object [][]data;
			int row = 0;
			Statement stmt = null;
			ResultSet rs = null;
			String query = "select student_id, username, password from student";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			String student_id = null;
			String username = null;
			String password = null;
			if(rs.last()) {
				row = rs.getRow();
			}
			rs.beforeFirst();
			data = new Object[row][3];

			while (rs.next()){
				int index = rs.getRow() -1;
				student_id = rs.getString(1);
				username = rs.getString(2);
				password = rs.getString(3);
				data[index][0] = student_id;
				data[index][1] = username;
				data[index][2] = password;
				System.out.println(student_id + " " + username + " " + password);
			}
			stmt.close();
			conn.close();
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Object[][] getAllTeacher(){
		try {
			Object [][]data;
			int row = 0;
			Statement stmt = null;
			ResultSet rs = null;
			String query = "select teacher_id, username, password from teacher";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			String teacher_id = null;
			String username = null;
			String password = null;
			if(rs.last()) {
				row = rs.getRow();
			}
			rs.beforeFirst();
			data = new Object[row][3];

			while (rs.next()){
				int index = rs.getRow() -1;
				teacher_id = rs.getString(1);
				username = rs.getString(2);
				password = rs.getString(3);
				data[index][0] = teacher_id;
				data[index][1] = username;
				data[index][2] = password;
				System.out.println(teacher_id + " " + username + " " + password);
			}
			stmt.close();
			conn.close();
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

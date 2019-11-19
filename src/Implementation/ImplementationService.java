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
}


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseConn {

	private String connUrl;
	private String username;
	private String password;
	private String driver;
	public DatabaseConn(Properties property) {
		connUrl = property.getProperty("jdbcUrl");
		username   = property.getProperty("jdbcUser");
		password = property.getProperty("jdbcPasswd");
		driver = property.getProperty("jdbcDriver");
	}
	public DatabaseConn(String url, String usrname, String pwd) {
		this.connUrl = url;
		this.username = usrname;
		this.password = pwd;
	}
	@SuppressWarnings("finally")
	public  Connection getMySqlConnection() {

		/* Declare and initialize a sql Connection variable. */
		Connection ret = null;	
		try
		{
			/* Register for jdbc driver class. */
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName(driver);
			/* Get the Connection object. */
			ret = DriverManager.getConnection(connUrl, username , password);
			
			/* Get related meta data for this mysql server to verify db connect successfully.. */
			DatabaseMetaData dbmd = ret.getMetaData();
			
			String dbName = dbmd.getDatabaseProductName();
			
			String dbVersion = dbmd.getDatabaseProductVersion();
			
			String dbUrl = dbmd.getURL();
			
			String userName = dbmd.getUserName();
			
			String driverName = dbmd.getDriverName();
			
			System.out.println("Database Name is " + dbName);
			
			System.out.println("Database Version is " + dbVersion);
			
			System.out.println("Database Connection Url is " + dbUrl);
			
			System.out.println("Database User Name is " + userName);
			
			System.out.println("Database Driver Name is " + driverName);
						
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			return ret;
		}

	}
	public boolean addQuestion(Connection conn, String sql) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			return (stmt.executeUpdate(sql) > 0);
		} catch (Exception sqe) {
			sqe.printStackTrace();
			return false;
		} finally {
			try {
				if (stmt != null) { stmt.close(); }
			} catch (Exception e2) { e2.printStackTrace(); }
			finally {
				try {
					if (conn != null) { conn.close(); }
				} catch (Exception e3) { e3.printStackTrace(); }
			}
		}
	}
	public boolean deleteQuestion(Connection conn, String sql) {
		Statement stmt1 = null;
		Statement stmt2 = null;
		boolean ret = false;
		try {
			conn.setAutoCommit(false);
			//String delete1 = "delete from phoneEntry where phone = '" + phoneNum + "'";
			stmt1 = conn.createStatement();
			if(ret = (stmt1.executeUpdate(sql) > 0)) {
				
				//String delete2 = "delete from phoneBooks where phone = '" + phoneNum + "'";
				stmt2 = conn.createStatement();
				stmt2.executeUpdate(sql);
			}
			conn.commit();
			return ret;
		} catch (Exception sqe) {
			sqe.printStackTrace();
			return false;
		} finally {
			try {
				if (stmt1 != null) { stmt1.close(); }
			} catch (Exception e2) { e2.printStackTrace(); }
			finally {
				try {
					if (conn != null) { conn.close(); }
				} catch (Exception e3) { e3.printStackTrace(); }
			}
		}
	}
}

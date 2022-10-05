package manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionUtil {
	private static JdbcConnectionUtil instance;
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "system";
	private String password = "seok5642";
	
	private JdbcConnectionUtil() {
		
	}
	
	public static JdbcConnectionUtil getInstance() {
		synchronized(JdbcConnectionUtil.class) {
			
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			if(instance == null) {
				instance = new JdbcConnectionUtil();
			}
		}
		return instance;
	}
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user, password);
	}
}
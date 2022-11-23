import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	   
		String BDD = "TP2_DB";
		String url = "jdbc:postgresql://localhost:5432/TP2_DB" + BDD;
		String user = "postgres";
		String passwd = "postgres";
	    private Connection conn;
	    private static DBConnection instance;
 
	   
	    private DBConnection() throws SQLException {
			conn=DriverManager.getConnection(url, user,passwd);
		}

	    
	    public Connection getConn() {
			return conn;
		}
	    public static DBConnection getInstance() throws SQLException {
	    	if(instance == null) {
	    		instance = new DBConnection();
	    	}
	    	return instance;
	    }


		
	
}

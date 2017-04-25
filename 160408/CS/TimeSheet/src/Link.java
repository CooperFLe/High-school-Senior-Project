import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Link {
	
	private Connection server;
	private Statement command;
	public Link()
	{
		try {		
			String ip = "192.168.1.20";
			String port = "3306";
			String db = "test";
			String user = "java";
			String pass = "csiv";
			server = DriverManager.getConnection("jdbc:mysql://" + ip + ":"
					+ port + "/" + db + "?user=" + user + "&password=" + pass +"&useSSL=false");
			command = server.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getServer()
	{
		return server;
	}
	
	public Statement getStatement()
	{
		return command;
	}
}

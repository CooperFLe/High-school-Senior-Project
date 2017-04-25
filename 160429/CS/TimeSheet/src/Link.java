import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Link {
	
	private Connection	server;
	private Statement 	command;
	private String		userDB, name;
	public Link()
	{
		try {		
			String ip = "127.0.0.1";
			String port = "3306";
			String db = "timelog";
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
	
	public void log(String startTime, String endTime)
	{
		try{
			
			command.execute("INSERT INTO " + getUserDB() + " (start, end) values ('" + startTime + "', '" + endTime + " ')");
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public String getUserDB() {
		return "user" + userDB;
	}

	public void getData(String email) {
		try{
			
			ResultSet rs = command.executeQuery("SELECT id,name FROM users WHERE email='" + email + "'");
			if(rs.next())
			{
				userDB = rs.getString(1);
				name = rs.getString(2);
				verifyTable();
			}
			else
			{
				userDB = "error";
				name = "error";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void verifyTable()
	{
		try {
			ResultSet rs = command.executeQuery("show tables where Tables_in_timelog='"+ getUserDB() + "'");
			
			if(!rs.next())
			{
				createTable(getUserDB());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void createTable(String name)
	{
		try {
			command.execute("create table " + name + " (id int unsigned auto_increment not null key, start time not null, end time not null, dt datetime default CURRENT_TIMESTAMP not null)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getName()
	{
		return name;
	}
}

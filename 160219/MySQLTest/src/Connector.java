import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connector 
{
	Connection conn;
	
	public Connector()
	{
		
		Window window = new Window();
		try
		{
			window.output.setText("");
			Popup.setting();
			conn = getConn();
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from class");
			
			while(result.next())
			{
				window.output.append(result.getString("name") + ", " + result.getString("level")+"\n");
			}
		}
		catch(Exception e)
		{
			Popup.errorMessage(e);
		}
		
	}
	
	public Connection getConn()
	{
		try
		{
			return DriverManager.getConnection("jdbc:mysql://" + Data.getIpaddress() + ":3306/" 
											+ Data.getDatabase(),Data.getUsername(),Data.getPassword());		
		}catch(Exception e)
		{
			Popup.errorMessage(e);
		}
		
		
		return null;		
	}

	class Window extends Model
	{

		/**
		 * 
		 */
		private static final long serialVersionUID = -6791503228233798055L;
		
		public Window()
		{
			buttonOne.setText("Settings");
		}
		
		@Override
		public void ButtonOneAction()
		{
			Popup.setting();
		}
		

	}
}


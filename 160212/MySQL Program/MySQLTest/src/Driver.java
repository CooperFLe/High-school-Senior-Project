import java.sql.*;
import java.util.*;

public class Driver {

	public static void main(String[] args) {
		try{
			Connection conn = getConn();
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from class");
			while(result.next())
			{
				System.out.println(result.getString("name") + ", " + result.getString("level"));
			}
		}
		catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
	
	public static Connection getConn()
	{
		Scanner j = new Scanner(System.in);
		System.out.print("Server address[10.111.53.160]: ");
		String serverAddress = j.nextLine();
		System.out.print("Database name [temp]: ");
		String dataBase = j.nextLine();
		System.out.print("Username [java]: ");
		String user = j.nextLine();
		System.out.print("Password [csiv]: ");
		String pass = j.nextLine();
		
		if(serverAddress.equals(""))
			serverAddress = "10.111.53.160";
		if(dataBase.equals(""))
			dataBase = "temp";
		if(user.equals(""))
			user = "java";
		if(pass.equals(""))
			pass = "csiv";
		
		try{
			return DriverManager.getConnection("jdbc:mysql://" + serverAddress + ":3306/" + dataBase,user,pass);		
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
		return null;		
	}
}
public class Data 
{
	private static String ipaddress = "10.111.53.160";
	private static String database 	= "temp";
	private static String username 	= "java";
	private static String password 	= "csiv";
	
	private Data(){}
	
	public static String getIpaddress() {
		return ipaddress;
	}
	public static void setIpaddress(String ipaddress) {
		Data.ipaddress = ipaddress;
	}
	public static String getDatabase() {
		return database;
	}
	public static void setDatabase(String database) {
		Data.database = database;
	}
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		Data.username = username;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		Data.password = password;
	}
	
}

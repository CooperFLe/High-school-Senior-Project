import java.sql.Statement;
import java.util.Scanner;

public class PopulateTable {

	public static void main(String[] args)
	{
		String workers = "Nguyen LHN Carrie CD Phung PT Chau ZD Trang TL Tien TN Lam LBH Quynh QV Vy VD Nancy NL";
		Scanner j = new Scanner(workers);

		try {
			Link server = new Link();
			Statement st = server.getStatement();
			st.execute("DROP TABLE users");
			
			st.execute("CREATE TABLE users (id tinyint unsigned auto_increment key not null, "
					+ "sign varchar(3) not null, email varchar(30) not null, name varchar(20) not null)");
			
			st.execute("INSERT INTO users (name, email, sign) values ('Cooper','cooper@cooperle.com','CFL')");
			st.execute("INSERT INTO users (name, email, sign) values ('Ryan','ryan@ryanle.com','RHL')");
			
			while(j.hasNext())
			{
				String name = j.next();
				String email = name.toLowerCase() + "@winningagency.com";
				String sign = j.next();
				st.execute("INSERT INTO users (name, email, sign) values ('" + name + "','" + email + "','" + sign + "')");
			}
		} catch (Exception e) {e.printStackTrace();}
		j.close();
	}

}

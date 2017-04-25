import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PopulateTable {

	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		String workers = "Nguyen LHN 0 Carrie CD 0 Phung PT 12.50 Chau ZD 7.25 Trang TL 13.25 Tien TN 0 Lam LBH 10.75 Quynh QV 7.25 Vy VD 10.25 Nancy NL 0";
		Scanner j = new Scanner(workers);

		try {
			Link server = new Link();
			Statement st = server.getStatement();
			
			ResultSet r = st.executeQuery("show tables");
			while(r.next())
			{
				st.execute("drop table " + r.getString(1));
				r = st.executeQuery("show tables");
			}
			
			st.execute("CREATE TABLE users (id tinyint unsigned auto_increment key not null, "
					+ "sign varchar(3) not null, email varchar(30) not null, name varchar(20) not null, pay double unsigned not null)");
			
			st.execute("INSERT INTO users (name, email, sign, pay) values ('Cooper','cooper@cooperle.com','CFL','10')");
			st.execute("create table user1 (id int unsigned auto_increment not null key, start time not null, end time not null, dt datetime default CURRENT_TIMESTAMP not null)");								
			
			st.execute("INSERT INTO users (name, email, sign, pay) values ('Ryan','ryan@ryanle.com','RHL','10')");
			st.execute("create table user2 (id int unsigned auto_increment not null key, start time not null, end time not null, dt datetime default CURRENT_TIMESTAMP not null)");								
			
			int num = 3;
			while(j.hasNext())
			{
				String name = j.next();
				String email = name.toLowerCase() + "@winningagency.com";
				String sign = j.next();
				double pay = Double.valueOf(j.next());
				st.execute("INSERT INTO users (name, email, sign, pay) values ('" + name + "','" + email + "','" + sign + "','" + pay + "')");
				st.execute("create table user" + num + " (id int unsigned auto_increment not null key, start time not null, end time not null, dt datetime default CURRENT_TIMESTAMP not null)");								
				num++;
			}
		} catch (Exception e) {e.printStackTrace();}
		j.close();
		
		System.out.println("Done");
	}

}

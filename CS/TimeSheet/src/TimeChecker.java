import java.awt.Font;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TimeChecker
{
	public static void main(String[] args)
	{
		new Payroll();
	}
}

class Payroll extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6911081452299105397L;
	private Link server;
	public Payroll()
	{
		server = new Link();
		
		JTextArea output = new JTextArea(26,30);
		add(output);
		output.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
		output.setFocusable(true);
		output.setEditable(false);
		output.setText(" Employee | Hours | Rate | Earnings ");
		output.append("\n----------|-------|------|----------");
		pack();
		calculateHours(output, 5);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void calculateHours(JTextArea output, int m)
	{
		try{					
			Statement st = server.getStatement();
			ResultSet rs = st.executeQuery("SELECT id FROM users");
			rs.last();
			int max = rs.getInt(1);
			int i = max;
			while(i >= 1)
			{
				ResultSet users = st.executeQuery("SELECT * FROM users WHERE id=" + (max - i + 1));
				if(users.next())
				{//Get user info
						int id = Integer.valueOf(users.getString(1));
						String name = users.getString(4);
						double pay = users.getDouble(5);
						while(name.length() != 10)
						{
							name = name + " ";
						}
						output.append("\n" + name + "|");
				
					ResultSet urs = st.executeQuery("SELECT * FROM user" + id + " ORDER BY dt DESC");
					double hours = 0;
					int mins = 0;
					boolean stop = false;
					while(!stop && urs.next())
					{//Get hours
						int min = 0;
						int hour = 0;
						String start = urs.getString(2);
						String end = urs.getString(3);
						String date = urs.getString(4).substring(0, 10);
						int month = Integer.valueOf(date.substring(5, 7));
//						int day = Integer.valueOf(date.substring(8));
//						String year = date.substring(0,4);
//						System.out.println(start);
//						System.out.println(end);
//						System.out.println(month + "|" + day + "|" + year);
						 if(m != month)
							 stop = true;
						 else
						 {
							 int ehour = Integer.valueOf(end.substring(0, 2));
							 int emin = Integer.valueOf(end.substring(3, 5));
							 int shour = Integer.valueOf(start.substring(0, 2));
							 int smin = Integer.valueOf(start.substring(3, 5));
							 min = emin - smin;
							 hour = ehour - shour;
							 //System.out.println(hour + " " + min);
							 if(min < 0)
							 {
								 hour = hour - 1;
								 min = 60 + min;
							 }
							 //System.out.println(hour + " " + min);
							 
							 hours += hour;
							 mins += min;
						 }
					}
					//Round to half hour
					while(mins > 60)
					{
						hours++;
						mins -= 60;
					}

					 if(mins >= 45)
						 hours = hours + 1;
					 else
						 if(mins >= 15)
							 hours += .5;
					//Print hours
					 String h = hours+"";
					 int spaces = 7 - h.length();
					 while(spaces > 0)
					 {
						 spaces--;
						 output.append(" ");
					 }
					 output.append(h + "|");
					 
					//Get pay
					 if(pay!=0)
					 {
						 String payStr = pay+"";
						 double earnings = hours * pay;
						 String earningsStr = earnings+"";
						 while(payStr.substring(payStr.indexOf(".")).length() < 3)
							 payStr = payStr + "0";
						 spaces = 6 - payStr.length();
						 while(spaces > 0)
						 {
							 spaces--;
							 output.append(" ");
						 }
						 output.append(payStr + "|");

						 if(earningsStr.substring(earningsStr.indexOf(".")).length() < 3)
							 earningsStr = earningsStr + "0";
						 spaces = 10 - (""+earningsStr).length();
						 while(spaces > 0)
						 {
							 spaces--;
							 output.append(" ");
						 }
						 output.append(earningsStr+"");
					 }
					 else
					 {
						 output.append("  N/A |  SALARY  ");
					 }
				}
				i--;
				output.append("\n----------|-------|------|----------");
			}
			
		}catch(Exception e){e.printStackTrace();}
	}	
}


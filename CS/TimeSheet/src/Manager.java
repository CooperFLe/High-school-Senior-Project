import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class Manager {
	
	public static void main(String[] args)
	{
		new ManageGUI(new Link());
	}

}

class ManageGUI extends JFrame
{
	private static final long serialVersionUID = -2733069771433748845L;
	private Link link;
	
	public ManageGUI(Link l)
	{
		link = l;
		setContentPane(new CPanel(link));
		setSize(300,200);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class CPanel extends JPanel
	{
		private static final long serialVersionUID = 2095282989545977405L;
		private Link link;
		private JButton add,remove,edit;
		private JComboBox<String> users;
		public CPanel(Link l)
		{
			link = l;
			setLayout(new MigLayout("fill, wrap 2"));
			users = new JComboBox<String>(link.getUsers());
			add(users,"grow, span 2, align center");
			edit = new JButton("Edit");
				edit.addActionListener(new EditAction());
				add(edit, "grow");
			remove = new JButton("Remove");
				remove.addActionListener(new RemoveAction());
				add(remove, "grow");
			add = new JButton("Add Employee");
				add.addActionListener(new AddAction());
				add(add,"grow,span 2");
		}
		
		public void addUser() {
			//TODO Add user
		}

		public void editUser() {
				//TODO Edit user
		}

		public void removeUser() {
			if(JOptionPane.showConfirmDialog(null, "Are you sure you want to remove " + users.getItemAt(users.getSelectedIndex()) + "?","Remove", JOptionPane.YES_NO_OPTION) == 0)
			{
				
				//link.getData(users.getItemAt(users.getSelectedIndex()).substring(users.getItemAt(users.getSelectedIndex()).indexOf(" - ")));
				try {
					//link.getServer().createStatement().execute("DROP TABLE " + link.getUserDB());
					link.getServer().createStatement().execute("DELETE FROM users where sign='" + users.getItemAt(users.getSelectedIndex()).substring(0,users.getItemAt(users.getSelectedIndex()).indexOf(" - "))+"'");		
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		class AddAction implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addUser();
			}			
		}
		
		class RemoveAction implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				removeUser();
			}			
		}
		
		class EditAction implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				editUser();
			}			
		}
	}
}
